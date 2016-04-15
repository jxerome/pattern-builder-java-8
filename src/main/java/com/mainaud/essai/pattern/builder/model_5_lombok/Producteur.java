package com.mainaud.essai.pattern.builder.model_5_lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Builder
@Getter
public final class Producteur {
    private String nom;
    private String description;
    private Appellation appellation;
    @Singular
    private List<Vin> vins;

}
