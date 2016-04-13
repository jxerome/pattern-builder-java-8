package com.mainaud.essai.pattern.builder.model_2_builder;

import com.mainaud.essai.pattern.builder.api.RégionLec;
import com.mainaud.essai.pattern.builder.model.Volume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Région implements RégionLec {
    private String nom;
    private String description;
    private Région région;
    private int superficie;
    private Volume productionAnnuelle;
    private List<Cépage> cépages = new ArrayList<>();
    private List<Région> sousRégions = new ArrayList<>();
    private List<Appellation> appellations = new ArrayList<>();

    private Région() {
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public RégionLec getRégion() {
        return région;
    }

    @Override
    public List<Région> getSousRégions() {
        return sousRégions;
    }

    @Override
    public List<Appellation> getAppellations() {
        return appellations;
    }

    @Override
    public int getSuperficie() {
        return superficie;
    }

    @Override
    public Volume getProductionAnnuelle() {
        return productionAnnuelle;
    }

    @Override
    public List<Cépage> getCépages() {
        return cépages;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Région région = new Région();

        private Builder() {
        }

        public Région build() {
            Objects.requireNonNull(région.nom);

            région.cépages = Collections.unmodifiableList(région.cépages);
            région.sousRégions = Collections.unmodifiableList(région.sousRégions);
            région.appellations = Collections.unmodifiableList(région.appellations);

            return région;
        }

        public Builder setNom(String nom) {
            région.nom = nom;
            return this;
        }

        public Builder setDescription(String description) {
            région.description = description;
            return this;
        }

        public Builder setRégion(Région région) {
            région.région = région;
            return this;
        }

        public Builder addSousRégion(Région sousRégion) {
            région.sousRégions.add(sousRégion);
            return this;
        }

        public Builder addAppellation(Appellation appellation) {
            région.appellations.add(appellation);
            return this;
        }

        public Builder setSuperficie(int superficie) {
            région.superficie = superficie;
            return this;
        }

        public Builder setProductionAnnuelle(Volume productionAnnuelle) {
            région.productionAnnuelle = productionAnnuelle;
            return this;
        }

        public Builder addCépage(Cépage cépage) {
            région.cépages.add(cépage);
            return this;
        }
    }
}
