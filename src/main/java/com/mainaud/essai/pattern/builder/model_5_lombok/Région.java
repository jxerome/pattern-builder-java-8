package com.mainaud.essai.pattern.builder.model_5_lombok;

import com.mainaud.essai.pattern.builder.api.RégionLec;
import com.mainaud.essai.pattern.builder.api.Vinicole;
import com.mainaud.essai.pattern.builder.model.Volume;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Builder
@Getter
public final class Région {
    private String nom;
    private String description;
    private Région région;
    private int superficie;
    private Volume productionAnnuelle;
    @Singular
    private List<Cépage> cépages = new ArrayList<>();
    @Singular
    private List<Région> sousRégions = new ArrayList<>();
    @Singular
    private List<Appellation> appellations = new ArrayList<>();

}
