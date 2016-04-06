package com.mainaud.essai.pattern.builder.report;

import com.mainaud.essai.pattern.builder.api.*;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Affiche les informations utiles sur le vin.
 */
public class Printer implements Closeable {
    private final PrintWriter printer;

    public Printer(PrintWriter printer) {
        this.printer = Objects.requireNonNull(printer);
    }

    public Printer(Writer out) {
        printer = new PrintWriter(Objects.requireNonNull(out));
    }

    @Override
    public void close() throws IOException {
        printer.close();
    }


    public void printVin(Vin vin) {
        printVin(vin, 0);
    }

    void printAppellation(Appellation appellation, int level) {
        String indent = indent(level);
        printer.printf("%1$s%2$s %3$s%n", indent, appellation.getNature(), appellation.getNom());
        printDescription(() -> appellation.getDescription(), level);
        if (appellation.getRégion() != null) {
            printer.printf("%1$sRégion: %2$s", printNomHiérarchique(appellation.getRégion()));
        }
        printListe("Cépages", level, appellation.getCépages(), Cépage::getNom);
        printListe("Couleurs", level, appellation.getCouleurs(), Couleur::name);
        printListe("Effervescences", level, appellation.getEffervescences(), Effervescence::name);
        printListe("Teneurs en sucre", level, appellation.getTeneursEnSucre(), TeneurEnSucre::name);
        printIterable(appellation.getProducteurs(), level + 1, this::printProducteur);
    }

    private String printNomHiérarchique(Région région) {
        if (région.getParent() != null) {
            return printNomHiérarchique(région.getParent()) + " - " + région.getNom();
        }
        return région.getNom();
    }

    void printProducteur(Producteur producteur, int level) {
        String indent = indent(level);
        printer.printf("%1$s%2$s%n", indent, producteur.getNom());
        printDescription(() -> producteur.getDescription(), level);
        printer.printf("%1$sVins%n", indent);

        printIterable(producteur.getVins(), level + 1, this::printVin);
    }

    private <T> void printIterable(Iterable<T> iter, int level, PrintMethod<T> p) {
        Iterator<T> it = iter.iterator();
        if (it.hasNext()) {
            p.print(it.next(), level);
        }
        while (it.hasNext()) {
            printer.printf("%1$s----%n", indent(level));
            p.print(it.next(), level);
        }
    }

    void printVin(Vin vin, int level) {
        String indent = indent(level);
        printer.printf("%1$s%2$s%n", indent, vin.getNom());
        printDescription(() -> vin.getDescription(), level);
        printer.printf("%1$sCaractéristiques: %2$s %3$s %4$s%n", indent, vin.getCouleur(), vin.getEffervescence(), vin.getTeneurEnSucre());
        printListe("Cépages", level, vin.getCépages(), Cépage::getNom);
        printer.printf("%1$sPrix: %2$.2f €%n", indent, vin.getPrix());
    }

    <T> void printListe(String champ, int level, Collection<? extends T> collection, Function<T, String> stringifier) {
        if (collection != null && !collection.isEmpty()) {
            printer.printf("%1$s%2$s: %3$s%n", indent(level), champ, collection.stream().map(stringifier).collect(Collectors.joining(", ")));
        }
    }

    private void printDescription(Supplier<String> getter, int level) {
        String description = getter.get();
        if (description != null) {
            printer.printf("%1$sDescription%n%2$s%n", indent(level), indent(description, level + 1));
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
