package com.mainaud.essai.pattern.builder.model_4_update;

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


    public  Producteur update(Consumer<Builder> factory) {
        Builder builder = new Builder(this);
        factory.accept(builder);
        return builder.build();
    }

    public static Producteur create(Consumer<Builder> factory) {
        Builder builder = new Builder();
        factory.accept(builder);
        return builder.build();
    }

    public static final class Builder {
        private Producteur producteur = new Producteur();
        private ListBuilder<Vin> vins;

        public Builder() {
            vins = ListBuilder.of();
        }

        public Builder(Producteur oldProducteur) {
            producteur.nom = oldProducteur.nom;
            producteur.description = oldProducteur.description;
            producteur.appellation = oldProducteur.appellation;
            vins = ListBuilder.of(oldProducteur.vins);
        }

        private Producteur build() {
            Objects.requireNonNull(producteur.nom);
            producteur.vins = vins.build();
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
            vins.add(Vin.create(vin.andThen(v -> v.setProducteur(producteur))));
            return this;
        }

        public Builder updateVins(Consumer<ListBuilder<Vin>> factory) {
            factory.accept(vins);
            return this;
        }
    }
}
