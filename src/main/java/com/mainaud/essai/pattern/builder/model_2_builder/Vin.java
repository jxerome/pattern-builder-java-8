package com.mainaud.essai.pattern.builder.model_2_builder;

import com.mainaud.essai.pattern.builder.api.VinLec;
import com.mainaud.essai.pattern.builder.model.Couleur;
import com.mainaud.essai.pattern.builder.model.Effervescence;
import com.mainaud.essai.pattern.builder.model.TeneurEnSucre;

import java.util.*;

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

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final Vin vin = new Vin();

        public Vin build() {
            Objects.requireNonNull(vin.nom);

            vin.cépages = Collections.unmodifiableList(vin.cépages);

            return vin;
        }

        public Builder setNom(String nom) {
            vin.nom = nom;
            return this;
        }

        public Builder setDescription(String description) {
            vin.description = description;
            return this;
        }

        public Builder setProducteur(Producteur producteur) {
            vin.producteur = producteur;
            return this;
        }

        public Builder setPrix(double prix) {
            vin.prix = prix;
            return this;
        }

        public Builder setCouleur(Couleur couleur) {
            vin.couleur = couleur;
            return this;
        }

        public Builder setEffervescence(Effervescence effervescence) {
            vin.effervescence = effervescence;
            return this;
        }

        public Builder setTeneurEnSucre(TeneurEnSucre teneurEnSucre) {
            vin.teneurEnSucre = teneurEnSucre;
            return this;
        }

        public Builder addCépage(Cépage cépages) {
            vin.cépages.add(cépages);
            return this;
        }
    }
}
