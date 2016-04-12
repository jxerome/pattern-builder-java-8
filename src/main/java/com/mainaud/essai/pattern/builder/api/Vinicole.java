package com.mainaud.essai.pattern.builder.api;

import com.mainaud.essai.pattern.builder.model.Volume;

import java.util.Collection;

public interface Vinicole {
    String getNom();

    RégionLec getRégion();

    String getDescription();

    int getSuperficie();

    Volume getProductionAnnuelle();

    Collection<? extends CépageLec> getCépages();
}
