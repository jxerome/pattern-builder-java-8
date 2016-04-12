package com.mainaud.essai.pattern.builder.model_1_pojo;

import com.mainaud.essai.pattern.builder.api.*;
import com.mainaud.essai.pattern.builder.model.Couleur;
import com.mainaud.essai.pattern.builder.model.Effervescence;
import com.mainaud.essai.pattern.builder.model.TeneurEnSucre;

import java.util.Collection;

public class Vin implements VinLec {
    private String nom;

    private String description;

    private double prix;

    private Couleur couleur;

    private Effervescence effervescence;

    private TeneurEnSucre teneurEnSucre;

    private Collection<Cépage> cépages;

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
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    @Override
    public Effervescence getEffervescence() {
        return effervescence;
    }

    public void setEffervescence(Effervescence effervescence) {
        this.effervescence = effervescence;
    }

    @Override
    public TeneurEnSucre getTeneurEnSucre() {
        return teneurEnSucre;
    }

    public void setTeneurEnSucre(TeneurEnSucre teneurEnSucre) {
        this.teneurEnSucre = teneurEnSucre;
    }

    @Override
    public Collection<Cépage> getCépages() {
        return cépages;
    }

    public void setCépages(Collection<Cépage> cépages) {
        this.cépages = cépages;
    }
}
