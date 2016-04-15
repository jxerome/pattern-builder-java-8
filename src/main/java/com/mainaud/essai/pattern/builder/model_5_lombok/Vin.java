package com.mainaud.essai.pattern.builder.model_5_lombok;

import com.mainaud.essai.pattern.builder.model.Couleur;
import com.mainaud.essai.pattern.builder.model.Effervescence;
import com.mainaud.essai.pattern.builder.model.TeneurEnSucre;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public final class Vin {
    private String nom;
    private String description;
    private Producteur producteur;
    private double prix;
    private Couleur couleur;
    private Effervescence effervescence;
    private TeneurEnSucre teneurEnSucre;
    @Singular
    private List<Cépage> cépages = new ArrayList<>();

}
