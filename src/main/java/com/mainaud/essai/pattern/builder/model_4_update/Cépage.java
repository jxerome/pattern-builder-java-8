package com.mainaud.essai.pattern.builder.model_4_update;

import com.mainaud.essai.pattern.builder.api.CépageLec;

import java.util.Objects;


public final class Cépage implements CépageLec {
    private final String nom;
    private final String description;

    private Cépage(String nom, String description) {
        this.nom = Objects.requireNonNull(nom);
        this.description = description;
    }

    public static Cépage withDescription(String nom, String description) {
        return new Cépage(nom, description);
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
