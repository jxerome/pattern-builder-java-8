package com.mainaud.essai.pattern.builder.api;

import com.mainaud.essai.pattern.builder.model.Couleur;
import com.mainaud.essai.pattern.builder.model.Effervescence;
import com.mainaud.essai.pattern.builder.model.TeneurEnSucre;

import java.util.Collection;

public interface VinLec {
    String getNom();

    String getDescription();

    ProducteurLec getProducteur();

    double getPrix();

    Couleur getCouleur();

    Effervescence getEffervescence();

    TeneurEnSucre getTeneurEnSucre();

    Collection<? extends CépageLec> getCépages();
}
