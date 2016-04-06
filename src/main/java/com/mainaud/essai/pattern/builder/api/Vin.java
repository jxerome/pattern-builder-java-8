package com.mainaud.essai.pattern.builder.api;

import java.util.Collection;
import java.util.Set;

public interface Vin {
    String getNom();

    String getDescription();

    double getPrix();

    Couleur getCouleur();

    Effervescence getEffervescence();

    TeneurEnSucre getTeneurEnSucre();

    Collection<Cépage> getCépages();
}
