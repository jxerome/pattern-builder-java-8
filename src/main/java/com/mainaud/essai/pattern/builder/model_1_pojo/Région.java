package com.mainaud.essai.pattern.builder.model_1_pojo;

import com.mainaud.essai.pattern.builder.api.CépageLec;
import com.mainaud.essai.pattern.builder.api.RégionLec;
import com.mainaud.essai.pattern.builder.model.Volume;

import java.util.List;

public class Région implements RégionLec {
    private String nom;
    private String description;
    private Région région;
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

    @Override
    public RégionLec getRégion() {
        return région;
    }

    public void setRégion(Région région) {
        this.région = région;
    }

    @Override
    public List<Région> getSousRégions() {
        return sousRégions;
    }

    public void setSousRégions(List<Région> sousRégions) {
        this.sousRégions = sousRégions;
    }

    @Override
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
