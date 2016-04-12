package com.mainaud.essai.pattern.builder.model_2_builder;

import com.mainaud.essai.pattern.builder.api.CépageLec;

import java.util.Objects;


public final class Cépage implements CépageLec {
    private final String nom;
    private final String description;

    public Cépage(String nom, String description) {
        this.nom = Objects.requireNonNull(nom);
        this.description = description;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
