package com.mainaud.essai.pattern.builder.model_1_pojo;

import com.mainaud.essai.pattern.builder.api.*;

import java.util.List;
import java.util.Set;

public class Appellation1 implements Appellation {
    private String nom;
    private String description;
    private NatureAppellation nature;
    private Région région;
    private List<Producteur> producteurs;
    private int superficie;
    private Volume productionAnnuelle;
    private Set<Couleur> couleurs;
    private Set<TeneurEnSucre> teneursEnSucre;
    private Set<Effervescence> effervescences;
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
    public NatureAppellation getNature() {
        return nature;
    }

    public void setNature(NatureAppellation nature) {
        this.nature = nature;
    }

    @Override
    public Région getRégion() {
        return région;
    }

    public void setRégion(Région région) {
        this.région = région;
    }

    @Override
    public List<Producteur> getProducteurs() {
        return producteurs;
    }

    public void setProducteurs(List<Producteur> producteurs) {
        this.producteurs = producteurs;
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
    public Set<Couleur> getCouleurs() {
        return couleurs;
    }

    public void setCouleurs(Set<Couleur> couleurs) {
        this.couleurs = couleurs;
    }

    @Override
    public Set<TeneurEnSucre> getTeneursEnSucre() {
        return teneursEnSucre;
    }

    public void setTeneursEnSucre(Set<TeneurEnSucre> teneursEnSucre) {
        this.teneursEnSucre = teneursEnSucre;
    }

    @Override
    public Set<Effervescence> getEffervescences() {
        return effervescences;
    }

    public void setEffervescences(Set<Effervescence> effervescences) {
        this.effervescences = effervescences;
    }

    @Override
    public List<Cépage> getCépages() {
        return cépages;
    }

    public void setCépages(List<Cépage> cépages) {
        this.cépages = cépages;
    }
}
