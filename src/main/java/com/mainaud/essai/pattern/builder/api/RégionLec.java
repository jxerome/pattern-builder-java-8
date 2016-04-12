package com.mainaud.essai.pattern.builder.api;

import java.util.Collection;

/**
 * RégionLec viticole.
 */
public interface RégionLec extends Vinicole {
    Collection<? extends RégionLec> getSousRégions();

    Collection<? extends AppellationLec> getAppellations();
}
