package com.mainaud.essai.pattern.builder.model_1_pojo;

import com.mainaud.essai.pattern.builder.api.ProducteurLec;

import java.util.List;

public class Producteur implements ProducteurLec {
    private String nom;
    private String description;
    private Appellation appellation;
    private List<Vin> vins;

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

    @Override
    public Appellation getAppellation() {
        return appellation;
    }

    public void setAppellation(Appellation appellation) {
        this.appellation = appellation;
    }

    @Override
    public List<Vin> getVins() {
        return vins;
    }

    public void setVins(List<Vin> vins) {
        this.vins = vins;
    }
}
