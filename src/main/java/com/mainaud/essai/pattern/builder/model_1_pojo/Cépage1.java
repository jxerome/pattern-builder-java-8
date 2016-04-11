package com.mainaud.essai.pattern.builder.model_1_pojo;

import com.mainaud.essai.pattern.builder.api.Cépage;


public class Cépage1 implements Cépage {
    private String nom;
    private String description;

    @Override
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
