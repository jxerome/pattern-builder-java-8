package com.mainaud.essai.pattern.builder.api;

import java.util.List;

public interface Producteur {
    String getNom();

    List<Vin> getVins();

    String getDescription();
}
