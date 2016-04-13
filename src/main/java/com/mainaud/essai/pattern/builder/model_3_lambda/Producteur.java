package com.mainaud.essai.pattern.builder.model_3_lambda;

import com.mainaud.essai.pattern.builder.api.ProducteurLec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public final class Producteur implements ProducteurLec {
    private String nom;
    private String description;
    private Appellation appellation;
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
    public Appellation getAppellation() {
        return appellation;
    }

    @Override
    public List<Vin> getVins() {
        return vins;
    }


    public static Producteur create(Consumer<Builder> factory) {
        Builder builder = new Builder();
        factory.accept(builder);
        return builder.build();
    }

    public static final class Builder {
        private Producteur producteur = new Producteur();

        private Builder() {
        }

        private Producteur build() {
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

        public Builder setAppellation(Appellation appellation) {
            producteur.appellation = appellation;
            return this;
        }

        public Builder addVin(Consumer<Vin.Builder> vin) {
            producteur.vins.add(Vin.create(vin.andThen(v -> v.setProducteur(producteur))));
            return this;
        }
    }
}
