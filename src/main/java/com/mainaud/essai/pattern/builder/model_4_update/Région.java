package com.mainaud.essai.pattern.builder.model_4_update;

import com.mainaud.essai.pattern.builder.api.RégionLec;
import com.mainaud.essai.pattern.builder.model.Volume;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public final class Région implements RégionLec {
    private String nom;
    private String description;
    private Région région;
    private int superficie;
    private Volume productionAnnuelle;
    private List<Cépage> cépages;
    private List<Région> sousRégions;
    private List<Appellation> appellations;

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

    public Région update(Consumer<Builder> factory) {
        Builder builder = new Builder(this);
        factory.accept(builder);
        return builder.build();
    }

    public static Région create(Consumer<Builder> factory) {
        Builder builder = new Builder();
        factory.accept(builder);
        return builder.build();
    }

    public static final class Builder {
        private Région région = new Région();
        private ListBuilder<Cépage> cépages;
        private ListBuilder<Région> sousRégions;
        private ListBuilder<Appellation> appellations;

        public Builder() {
            cépages = ListBuilder.of();
            sousRégions = ListBuilder.of();
            appellations = ListBuilder.of();
        }

        public Builder(Région oldRégion) {
            this.région.nom = oldRégion.nom;
            this.région.description = oldRégion.description;
            this.région.région = oldRégion.région;
            this.région.superficie = oldRégion.superficie;
            this.région.productionAnnuelle = oldRégion.productionAnnuelle;
            cépages = ListBuilder.of(oldRégion.cépages);
            sousRégions = ListBuilder.of(oldRégion.sousRégions);
            appellations = ListBuilder.of(oldRégion.appellations);
        }


        private Région build() {
            Objects.requireNonNull(région.nom);

            région.cépages = cépages.build();
            région.sousRégions = sousRégions.build();
            région.appellations = appellations.build();

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

        public Builder setRégion(Région parent) {
            région.région = parent;
            return this;
        }

        public Builder addSousRégion(Consumer<Builder> sousRégion) {
            sousRégions.add(Région.create(sousRégion.andThen(b -> b.setRégion(région))));
            return this;
        }

        public Builder updateSousRégions(Consumer<ListBuilder<Région>> factory) {
            factory.accept(sousRégions);
            return this;
        }


        public Builder addAppellation(Consumer<Appellation.Builder> appellation) {
            appellations.add(Appellation.create(appellation.andThen(a -> a.setRégion(région))));
            return this;
        }

        public Builder updateAppellations(Consumer<ListBuilder<Appellation>> factory) {
            factory.accept(appellations);
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
            cépages.add(cépage);
            return this;
        }

        public Builder updateCépages(Consumer<ListBuilder<Cépage>> factory) {
            factory.accept(cépages);
            return this;
        }

    }
}
