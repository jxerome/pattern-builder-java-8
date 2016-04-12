package com.mainaud.essai.pattern.builder.api;

import java.util.List;

public interface ProducteurLec {
    String getNom();

    List<? extends VinLec> getVins();

    String getDescription();

    AppellationLec getAppellation();
}
