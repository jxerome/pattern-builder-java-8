package com.mainaud.essai.pattern.builder.model_1_pojo;

import com.mainaud.essai.pattern.builder.api.*;

import java.util.List;
import java.util.Set;

public class Région1 implements Région {
    private String nom;
    private String description;
    private NatureAppellation nature;
    private Région parent;
    private List<Région> sousRégions;
    private List<Appellation> appellations;
    private int superficie;
    private Volume productionAnnuelle;
    private List<Cépage> cépages;



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

    public NatureAppellation getNature() {
        return nature;
    }

    public void setNature(NatureAppellation nature) {
        this.nature = nature;
    }

    @Override
    public Région getParent() {
        return parent;
    }

    public void setParent(Région parent) {
        this.parent = parent;
    }

    @Override
    public List<Région> getSousRégions() {
        return sousRégions;
    }

    public void setSousRégions(List<Région> sousRégions) {
        this.sousRégions = sousRégions;
    }

    public List<Appellation> getAppellations() {
        return appellations;
    }

    public void setAppellations(List<Appellation> appellations) {
        this.appellations = appellations;
    }

    @Override
    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    @Override
    public Volume getProductionAnnuelle() {
        return productionAnnuelle;
    }

    public void setProductionAnnuelle(Volume productionAnnuelle) {
        this.productionAnnuelle = productionAnnuelle;
    }

    @Override
    public List<Cépage> getCépages() {
        return cépages;
    }

    public void setCépages(List<Cépage> cépages) {
        this.cépages = cépages;
    }
}
