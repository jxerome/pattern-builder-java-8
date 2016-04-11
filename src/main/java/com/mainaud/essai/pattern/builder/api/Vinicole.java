package com.mainaud.essai.pattern.builder.api;

import java.util.Collection;
import java.util.Set;

public interface Vinicole {
    String getNom();

    Région getRégion();

    String getDescription();

    int getSuperficie();

    Volume getProductionAnnuelle();

    Collection<Cépage> getCépages();
}
