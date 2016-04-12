package com.mainaud.essai.pattern.builder.model_2_builder;

import com.mainaud.essai.pattern.builder.api.ProducteurLec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Producteur implements ProducteurLec {
    private String nom;
    private String description;
    private List<Vin> vins = new ArrayList<>();

    private Producteur() {
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
    public List<Vin> getVins() {
        return vins;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Producteur producteur = new Producteur();


        public Producteur build() {
            Objects.requireNonNull(producteur.nom);
            producteur.vins = Collections.unmodifiableList(producteur.vins);
            return producteur;
        }

        public Builder setNom(String nom) {
            producteur.nom = nom;
            return this;
        }

        public Builder setDescription(String description) {
            producteur.description = description;
            return this;
        }

        public Builder addVin(Vin vin) {
            producteur.vins.add(vin);
            return this;
        }
    }
}
