package com.mainaud.essai.pattern.builder.model_4_update;

import com.mainaud.essai.pattern.builder.api.VinLec;
import com.mainaud.essai.pattern.builder.model.Couleur;
import com.mainaud.essai.pattern.builder.model.Effervescence;
import com.mainaud.essai.pattern.builder.model.TeneurEnSucre;

import java.util.*;
import java.util.function.Consumer;

public final class Vin implements VinLec {
    private String nom;
    private String description;
    private Producteur producteur;
    private double prix;
    private Couleur couleur;
    private Effervescence effervescence;
    private TeneurEnSucre teneurEnSucre;
    private List<Cépage> cépages = new ArrayList<>();

    private Vin() {
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
    public Producteur getProducteur() {
        return producteur;
    }

    @Override
    public double getPrix() {
        return prix;
    }

    @Override
    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public Effervescence getEffervescence() {
        return effervescence;
    }

    @Override
    public TeneurEnSucre getTeneurEnSucre() {
        return teneurEnSucre;
    }

    @Override
    public Collection<Cépage> getCépages() {
        return cépages;
    }

    public Vin update(Consumer<Builder> factory) {
        Builder builder = new Builder(this);
        factory.accept(builder);
        return builder.build();
    }

    public static Vin create(Consumer<Builder> factory) {
        Builder builder = new Builder();
        factory.accept(builder);
        return builder.build();
    }

    public static final class Builder {
        private Vin newVin = new Vin();
        private ListBuilder<Cépage> cépages;

        private Builder() {
            cépages = ListBuilder.of();
        }

        private Builder(Vin oldVin) {
            newVin.nom = oldVin.nom;
            newVin.description = oldVin.description;
            newVin.producteur = oldVin.producteur;
            newVin.prix = oldVin.prix;
            newVin.couleur = oldVin.couleur;
            newVin.effervescence = oldVin.effervescence;
            newVin.teneurEnSucre = oldVin.teneurEnSucre;
            cépages = ListBuilder.of(oldVin.cépages);
        }


        private Vin build() {
            Objects.requireNonNull(newVin.nom);
            newVin.cépages = cépages.build();
            return newVin;
        }

        public Builder setNom(String nom) {
            newVin.nom = nom;
            return this;
        }

        public Builder setDescription(String description) {
            newVin.description = description;
            return this;
        }

        public Builder setProducteur(Producteur producteur) {
            newVin.producteur = producteur;
            return this;
        }

        public Builder setPrix(double prix) {
            newVin.prix = prix;
            return this;
        }

        public Builder setCouleur(Couleur couleur) {
            newVin.couleur = couleur;
            return this;
        }

        public Builder setEffervescence(Effervescence effervescence) {
            newVin.effervescence = effervescence;
            return this;
        }

        public Builder setTeneurEnSucre(TeneurEnSucre teneurEnSucre) {
            newVin.teneurEnSucre = teneurEnSucre;
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
