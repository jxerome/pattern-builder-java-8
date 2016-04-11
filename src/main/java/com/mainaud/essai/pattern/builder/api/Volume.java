package com.mainaud.essai.pattern.builder.api;

public final class Volume {
    public static enum Unité {
        L(1.0, "l"),
        HL(100.0, "hl"),
        BOUTEILLE(0.75, "btl.");

        private final double coef;
        private final String symbole;

        private Unité(double coef, String symbole) {
            this.coef = coef;
            this.symbole = symbole;
        }
    }

    private final double valeur;
    private final Unité unité;

    private Volume(double valeur, Unité unité) {
        this.valeur = valeur;
        this.unité = unité;
    }

    public static Volume de(double v, Unité u) {
        return new Volume(v, u);
    }

    public Volume convertirEn(Unité u) {
        return new Volume(valeur * unité.coef / u.coef, u);
    }

    public double getValeur() {
        return valeur;
    }

    public Unité getUnité() {
        return unité;
    }

    @Override
    public String toString() {
        return String.format("%,.0f %s", valeur, unité);
    }
}
