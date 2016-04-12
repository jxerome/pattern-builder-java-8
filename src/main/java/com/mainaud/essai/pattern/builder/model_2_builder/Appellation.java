package com.mainaud.essai.pattern.builder.model_2_builder;

import com.mainaud.essai.pattern.builder.api.AppellationLec;
import com.mainaud.essai.pattern.builder.model.*;

import java.util.*;

import static java.util.Objects.requireNonNull;

public final class Appellation implements AppellationLec {
    private String nom;
    private String description;
    private NatureAppellation nature;
    private Région région;
    private List<Producteur> producteurs = new ArrayList<>();
    private int superficie;
    private Volume productionAnnuelle;
    private Set<Couleur> couleurs = new HashSet<>();
    private Set<TeneurEnSucre> teneursEnSucre = new HashSet<>();
    private Set<Effervescence> effervescences = new HashSet<>();
    private List<Cépage> cépages = new ArrayList<>();

    private Appellation() {
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public NatureAppellation getNature() {
        return nature;
    }

    @Override
    public Région getRégion() {
        return région;
    }

    @Override
    public List<Producteur> getProducteurs() {
        return producteurs;
    }

    @Override
    public int getSuperficie() {
        return superficie;
    }

    @Override
    public Volume getProductionAnnuelle() {
        return productionAnnuelle;
    }

    @Override
    public Set<Couleur> getCouleurs() {
        return couleurs;
    }

    @Override
    public Set<TeneurEnSucre> getTeneursEnSucre() {
        return teneursEnSucre;
    }

    @Override
    public Set<Effervescence> getEffervescences() {
        return effervescences;
    }

    @Override
    public List<Cépage> getCépages() {
        return cépages;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Appellation appellation = new Appellation();

        public Appellation build() {
            requireNonNull(appellation.nom);

            appellation.producteurs = Collections.unmodifiableList(appellation.producteurs);
            appellation.couleurs = Collections.unmodifiableSet(appellation.couleurs);
            appellation.teneursEnSucre = Collections.unmodifiableSet(appellation.teneursEnSucre);
            appellation.effervescences = Collections.unmodifiableSet(appellation.effervescences);
            appellation.cépages = Collections.unmodifiableList(appellation.cépages);

            return appellation;
        }

        public Builder setNom(String nom) {
            appellation.nom = nom;
            return this;
        }

        public Builder setDescription(String description) {
            appellation.description = description;
            return this;
        }

        public Builder setNature(NatureAppellation nature) {
            appellation.nature = nature;
            return this;
        }

        public Builder setRégion(Région région) {
            appellation.région = région;
            return this;
        }

        public Builder addProducteur(Producteur producteur) {
            appellation.producteurs.add(producteur);
            return this;
        }

        public Builder setSuperficie(int superficie) {
            appellation.superficie = superficie;
            return this;
        }

        public Builder setProductionAnnuelle(Volume productionAnnuelle) {
            appellation.productionAnnuelle = productionAnnuelle;
            return this;
        }

        public Builder addCouleur(Couleur couleur) {
            appellation.couleurs.add(couleur);
            return this;
        }

        public Builder addTeneurEnSucre(TeneurEnSucre teneurEnSucre) {
            appellation.teneursEnSucre.add(teneurEnSucre);
            return this;
        }

        public Builder addEffervescence(Effervescence effervescence) {
            appellation.effervescences.add(effervescence);
            return this;
        }

        public Builder addCépage(Cépage cépage) {
            appellation.cépages.add(cépage);
            return this;
        }
    }
}
