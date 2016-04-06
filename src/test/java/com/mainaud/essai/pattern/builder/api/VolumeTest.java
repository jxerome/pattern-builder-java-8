package com.mainaud.essai.pattern.builder.api;

import com.mainaud.essai.pattern.builder.api.Volume;
import org.testng.annotations.Test;

import static com.mainaud.essai.pattern.builder.api.Volume.Unité.*;
import static org.assertj.core.api.Assertions.assertThat;

public class VolumeTest {
    @Test
    public void deCréeUnLitre() throws Exception {
        Volume unLitre = Volume.de(1.0, L);
        assertThat(unLitre.getValeur()).isEqualTo(1.0);
        assertThat(unLitre.getUnité()).isEqualTo(L);
    }

    @Test
    public void deCréeUnHectoLitre() throws Exception {
        Volume unLitre = Volume.de(15.2, HL);
        assertThat(unLitre.getValeur()).isEqualTo(15.2);
        assertThat(unLitre.getUnité()).isEqualTo(HL);
    }

    @Test
    public void deCréeDeuxBoutielles() throws Exception {
        Volume unLitre = Volume.de(2, BOUTEILLE);
        assertThat(unLitre.getValeur()).isEqualTo(2.0);
        assertThat(unLitre.getUnité()).isEqualTo(BOUTEILLE);
    }

    @Test
    public void convertirEnDoitConvertirQuinzeBouteillesEnOnzeLitres() throws Exception {
        Volume quizeBouteille = Volume.de(15.0, BOUTEILLE).convertirEn(L);
        assertThat(quizeBouteille.getUnité()).isEqualTo(L);
        assertThat(quizeBouteille.getValeur()).isEqualTo(11.25);
    }

    @Test
    public void convertirEnDoitConvertirQuinzeHectolitreEnQuinzeCentLitres() throws Exception {
        Volume quizeBouteille = Volume.de(15.6, HL).convertirEn(L);
        assertThat(quizeBouteille.getUnité()).isEqualTo(L);
        assertThat(quizeBouteille.getValeur()).isEqualTo(1560.0);
    }

    @Test
    public void convertirEnDoitConvertirQuinzeHectolitreEnDeuxMilleQuatrevingtBouteilles() throws Exception {
        Volume quizeBouteille = Volume.de(15.6, HL).convertirEn(BOUTEILLE);
        assertThat(quizeBouteille.getUnité()).isEqualTo(BOUTEILLE);
        assertThat(quizeBouteille.getValeur()).isEqualTo(2080.0);
    }

}