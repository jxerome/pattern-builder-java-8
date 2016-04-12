package com.mainaud.essai.pattern.builder.api;

import com.mainaud.essai.pattern.builder.model.Couleur;
import com.mainaud.essai.pattern.builder.model.Effervescence;
import com.mainaud.essai.pattern.builder.model.NatureAppellation;
import com.mainaud.essai.pattern.builder.model.TeneurEnSucre;

import java.util.Collection;
import java.util.List;

/**
 * Une appellation.
 */
public interface AppellationLec extends Vinicole {
    NatureAppellation getNature();

    List<? extends ProducteurLec> getProducteurs();

    Collection<Couleur> getCouleurs();

    Collection<Effervescence> getEffervescences();

    Collection<TeneurEnSucre> getTeneursEnSucre();
}
