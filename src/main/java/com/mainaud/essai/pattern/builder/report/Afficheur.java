package com.mainaud.essai.pattern.builder.report;

import com.mainaud.essai.pattern.builder.api.*;
import com.mainaud.essai.pattern.builder.model.Couleur;
import com.mainaud.essai.pattern.builder.model.Effervescence;
import com.mainaud.essai.pattern.builder.model.TeneurEnSucre;
import com.mainaud.essai.pattern.builder.model_1_pojo.Appellation;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Affiche les informations utiles sur le vin.
 */
public class Afficheur implements Closeable {
    private final PrintWriter printer;

    public Afficheur(OutputStream out) {
        this(new OutputStreamWriter(out));
    }

    public Afficheur(PrintWriter printer) {
        this.printer = Objects.requireNonNull(printer);
    }

    public Afficheur(Writer out) {
        this(new PrintWriter(Objects.requireNonNull(out)));
    }

    @Override
    public void close() throws IOException {
        printer.close();
    }

    public void printRégion(RégionLec région) {
        printRégion(région, 0);
    }

    void printRégion(RégionLec région, int level) {
        printNom(région.getNom(), level);
        ++level;
        printVinicole(région, level);
        printCollection("Appelations", level, région.getAppellations(), this::printAppellation);
        printCollection("Sous-régions", level, région.getSousRégions(), this::printRégion);
    }


    void printVinicole(Vinicole vinicole, int level) {
        printDescription(vinicole.getDescription(), level);
        if (vinicole.getRégion() != null) {
            printer.printf("%1$sRégion: %2$s", getNomHiérarchique(vinicole.getRégion()));
        }
        String indent = indent(level);
        if (vinicole.getSuperficie() != 0) {
            printer.printf("%1$sSuperficie: %2$,d ha%n", indent, vinicole.getSuperficie());
        }
        if (vinicole.getProductionAnnuelle() != null) {
            printer.printf("%1$sProduction: %2$s%n", indent, vinicole.getProductionAnnuelle());
        }
        printInlineListe("Cépages", level, vinicole.getCépages(), CépageLec::getNom);

    }

    public void printAppellation(Appellation appellation) {
        printAppellation(appellation, 0);
    }

    void printAppellation(AppellationLec appellationLec, int level) {
        printNom(appellationLec.getNature().name() + " " + appellationLec.getNom(), level);
        ++level;

        printVinicole(appellationLec, level);
        printInlineListe("Couleurs", level, appellationLec.getCouleurs(), Couleur::name);
        printInlineListe("Effervescences", level, appellationLec.getEffervescences(), Effervescence::name);
        printInlineListe("Teneurs en sucre", level, appellationLec.getTeneursEnSucre(), TeneurEnSucre::name);
        printCollection("Producteurs", level, appellationLec.getProducteurs(), this::printProducteur);
    }

    private String getNomHiérarchique(RégionLec région) {
        if (région.getRégion() != null) {
            return getNomHiérarchique(région.getRégion()) + " - " + région.getNom();
        }
        return région.getNom();
    }

    public void printProducteur(ProducteurLec producteur) {
        printProducteur(producteur, 0);
    }

    void printProducteur(ProducteurLec producteur, int level) {
        printNom(producteur.getNom(), level);
        ++level;
        printDescription(producteur.getDescription(), level);
        printCollection("Vins", level, producteur.getVins(), this::printVin);
    }

    void printVin(VinLec vin, int level) {
        printNom(vin.getNom(), level);
        level = level + 1;
        printDescription(vin.getDescription(), level);
        printInlineListe("Caractéristiques",
            level,
            Stream.of(vin.getCouleur(), vin.getEffervescence(), vin.getTeneurEnSucre())
                .filter(Objects::nonNull)
                .collect(Collectors.toList()),
            s -> s.name()
        );
        printInlineListe("Cépages", level, vin.getCépages(), CépageLec::getNom);
        printer.printf("%1$sPrix: %2$.2f €%n", indent(level), vin.getPrix());
    }

    private void printNom(String nom, int level) {
        printer.printf("%1$s%2$s%n", indent(level), nom.toUpperCase());
    }


    <T> void printCollection(String champ, int level, Collection<? extends T> collection, PrintMethod<T> p) {
        if (collection != null && !collection.isEmpty()) {
            printer.printf("%1$s%2$s:%n", indent(level), champ);
            Iterator<? extends T> it = collection.iterator();
            if (it.hasNext()) {
                p.print(it.next(), level + 1);
            }
            while (it.hasNext()) {
                printer.printf("%1$s----%n", indent(level + 1));
                p.print(it.next(), level + 1);
            }
        }
    }

    private <T> void printInlineListe(String champ, int level, Collection<? extends T> collection, Function<T, String> stringifier) {
        if (collection != null && !collection.isEmpty()) {
            printer.printf("%1$s%2$s: %3$s%n", indent(level), champ, collection.stream().map(stringifier).collect(Collectors.joining(", ")));
        }
    }


    private void printDescription(String description, int level) {
        if (description != null) {
            printer.printf("%1$sDescription:%n%2$s%n", indent(level), indent(description, level + 1));
        }
    }

    private String indent(int level) {
        if (level == 0) {
            return "";
        }
        return Stream.generate(() -> "    ").limit(level).collect(Collectors.joining());
    }

    private String indent(String text, int level) {
        if (text == null) {
            return "";
        }
        if (level == 0) {
            return text;
        }
        String indent = indent(level);
        return Stream.of(text.split("\r?\n")).collect(Collectors.joining("\n" + indent, indent, ""));
    }

    @FunctionalInterface
    private static interface PrintMethod<T> {
        void print(T t, int level);
    }
}
