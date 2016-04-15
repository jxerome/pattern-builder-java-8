package com.mainaud.essai.pattern.builder.model_5_lombok;

import com.mainaud.essai.pattern.builder.model.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Builder
@Getter
public final class Appellation {
    private String nom;
    private String description;
    private NatureAppellation nature;
    private Région région;
    @Singular
    private List<Producteur> producteurs = new ArrayList<>();
    private int superficie;
    private Volume productionAnnuelle;
    @Singular
    private Set<Couleur> couleurs = new HashSet<>();
    @Singular("teneurEnSucre")
    private Set<TeneurEnSucre> teneursEnSucre = new HashSet<>();
    @Singular
    private Set<Effervescence> effervescences = new HashSet<>();
    @Singular
    private List<Cépage> cépages = new ArrayList<>();

}
