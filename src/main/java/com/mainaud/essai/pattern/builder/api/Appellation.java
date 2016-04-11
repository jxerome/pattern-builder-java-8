package com.mainaud.essai.pattern.builder.api;

import java.util.Collection;
import java.util.List;

/**
 * Une appellation.
 */
public interface Appellation extends Vinicole {
    NatureAppellation getNature();

    Région getRégion();

    List<Producteur> getProducteurs();

    Collection<Couleur> getCouleurs();

    Collection<Effervescence> getEffervescences();

    Collection<TeneurEnSucre> getTeneursEnSucre();
}
