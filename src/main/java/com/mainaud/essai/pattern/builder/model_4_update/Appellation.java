package com.mainaud.essai.pattern.builder.model_4_update;

import com.mainaud.essai.pattern.builder.api.AppellationLec;
import com.mainaud.essai.pattern.builder.model.*;

import java.util.*;
import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;

public final class Appellation implements AppellationLec {
    private String nom;
    private String description;
    private NatureAppellation nature;
    private Région région;
    private List<Producteur> producteurs;
    private int superficie;
    private Volume productionAnnuelle;
    private Set<Couleur> couleurs;
    private Set<TeneurEnSucre> teneursEnSucre;
    private Set<Effervescence> effervescences;
    private List<Cépage> cépages;

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

    public Appellation update(Consumer<Builder> factory) {
        Builder builder = new Builder(this);
        factory.accept(builder);
        return builder.build();
    }

    public static Appellation create(Consumer<Builder> factory) {
        Builder builder = new Builder();
        factory.accept(builder);
        return builder.build();
    }

    public static final class Builder {
        private Appellation appellation = new Appellation();
        private ListBuilder<Producteur> producteurs;
        private SetBuilder<Couleur> couleurs;
        private SetBuilder<TeneurEnSucre> teneursEnSucre;
        private SetBuilder<Effervescence> effervescences;
        private ListBuilder<Cépage> cépages;

        private Builder() {
            producteurs = ListBuilder.of();
            cépages = ListBuilder.of();
            couleurs = SetBuilder.of();
            teneursEnSucre = SetBuilder.of();
            effervescences = SetBuilder.of();

        }

        private Builder(Appellation oldAppellation) {
            this.appellation.nom = oldAppellation.nom;
            this.appellation.description = oldAppellation.description;
            this.appellation.nature = oldAppellation.nature;
            this.appellation.région = oldAppellation.région;
            this.appellation.superficie = oldAppellation.superficie;
            this.appellation.productionAnnuelle = oldAppellation.productionAnnuelle;
            producteurs = ListBuilder.of(oldAppellation.producteurs);
            cépages = ListBuilder.of(oldAppellation.cépages);
            couleurs = SetBuilder.of(oldAppellation.couleurs);
            teneursEnSucre = SetBuilder.of(oldAppellation.teneursEnSucre);
            effervescences = SetBuilder.of(oldAppellation.effervescences);
        }

        private Appellation build() {
            requireNonNull(appellation.nom);

            appellation.producteurs = producteurs.build();
            appellation.couleurs = couleurs.build();
            appellation.teneursEnSucre = teneursEnSucre.build();
            appellation.effervescences = effervescences.build();
            appellation.cépages = cépages.build();

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

        public Builder addProducteur(Consumer<Producteur.Builder> producteur) {
            producteurs.add(Producteur.create(producteur.andThen(p -> p.setAppellation(appellation))));
            return this;
        }

        public Builder updateProducteurs(Consumer<ListBuilder<Producteur>> factory) {
            factory.accept(producteurs);
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
            couleurs.add(couleur);
            return this;
        }

        public Builder updateCouleurs(Consumer<SetBuilder<Couleur>> factory) {
            factory.accept(couleurs);
            return this;
        }

        public Builder addTeneurEnSucre(TeneurEnSucre teneurEnSucre) {
            teneursEnSucre.add(teneurEnSucre);
            return this;
        }

        public Builder updateTeneursEnSucre(Consumer<SetBuilder<TeneurEnSucre>> factory) {
            factory.accept(teneursEnSucre);
            return this;
        }


        public Builder addEffervescence(Effervescence effervescence) {
            effervescences.add(effervescence);
            return this;
        }

        public Builder updateEffervescences(Consumer<SetBuilder<Effervescence>> factory) {
            factory.accept(effervescences);
            return this;
        }


        public Builder addCépage(Cépage cépage) {
            cépages.add(cépage);
            return this;
        }

        public Builder updateCépages(Consumer<ListBuilder<Cépage>> factory) {
            factory.accept(cépages);
            return this;
        }
    }
}
