package com.mainaud.essai.pattern.builder.api;

import java.util.Collection;

/**
 * Région viticole.
 */
public interface Région extends Vinicole {
    Région getParent();

    Collection<Région> getSousRégions();

    Collection<Appellation> getAppelation();
}
