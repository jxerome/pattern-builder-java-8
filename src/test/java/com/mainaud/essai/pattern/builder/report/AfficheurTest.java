package com.mainaud.essai.pattern.builder.report;

import com.mainaud.essai.pattern.builder.api.CépageLec;
import com.mainaud.essai.pattern.builder.model_1_pojo.Cépage;
import com.mainaud.essai.pattern.builder.model_1_pojo.Producteur;
import com.mainaud.essai.pattern.builder.model_1_pojo.Vin;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;

import static com.mainaud.essai.pattern.builder.model.Couleur.BLANC;
import static com.mainaud.essai.pattern.builder.model.Effervescence.MOUSSEUX;
import static com.mainaud.essai.pattern.builder.model.Effervescence.TRANQUILLE;
import static com.mainaud.essai.pattern.builder.model.TeneurEnSucre.BRUT;
import static com.mainaud.essai.pattern.builder.model.TeneurEnSucre.SEC;
import static org.assertj.core.api.Assertions.assertThat;

public class AfficheurTest {
    private StringWriter sw = new StringWriter();
    private Afficheur afficheur = new Afficheur(sw);

    @BeforeMethod
    public void init() {
        sw.getBuffer().setLength(0);
    }


    @Test
    public void printProducteurShouldPrintProducteur() {
        Cépage chenin = new Cépage();
        chenin.setNom("Chenin");

        Vin vin = new Vin();
        vin.setNom("Domaine de la Rouletière Sec");
        vin.setDescription("J'aime bien\nce vin.");
        vin.setCouleur(BLANC);
        vin.setEffervescence(TRANQUILLE);
        vin.setTeneurEnSucre(SEC);
        vin.setCépages(new ArrayList<Cépage>() {{
            add(chenin);
        }});
        vin.setPrix(55.0);

        Vin vin2 = new Vin();
        vin2.setNom("Vigneau-Chevreau");
        vin2.setDescription("J'adore !\nce vin.");
        vin2.setCouleur(BLANC);
        vin2.setEffervescence(MOUSSEUX);
        vin2.setTeneurEnSucre(BRUT);
        vin2.setCépages(new ArrayList<Cépage>() {{
            add(chenin);
        }});
        vin2.setPrix(38.5);

        Producteur producteur = new Producteur();
        producteur.setNom("Productions réunies");
        producteur.setDescription("Un bon producteur");
        producteur.setVins(Arrays.asList(vin, vin2));

        afficheur.printProducteur(producteur, 1);

        assertThat(sw.toString()).isEqualTo(
                "    PRODUCTIONS RÉUNIES\n" +
                    "        Description:\n" +
                    "            Un bon producteur\n" +
                    "        Vins:\n" +
                    "            DOMAINE DE LA ROULETIÈRE SEC\n" +
                    "                Description:\n" +
                    "                    J'aime bien\n" +
                    "                    ce vin.\n" +
                    "                Caractéristiques: BLANC, TRANQUILLE, SEC\n" +
                    "                Cépages: Chenin\n" +
                    "                Prix: 55,00 €\n" +
                    "            ----\n" +
                    "            VIGNEAU-CHEVREAU\n" +
                    "                Description:\n" +
                    "                    J'adore !\n" +
                    "                    ce vin.\n" +
                    "                Caractéristiques: BLANC, MOUSSEUX, BRUT\n" +
                    "                Cépages: Chenin\n" +
                    "                Prix: 38,50 €\n"
        );
    }

    @Test
    public void printVinShouldPrintVin() {
        Cépage chenin = new Cépage();
        chenin.setNom("Chenin");

        Vin vin = new Vin();
        vin.setNom("Domaine de la Rouletière Sec");
        vin.setDescription("J'aime bien\nce vin.");
        vin.setCouleur(BLANC);
        vin.setEffervescence(TRANQUILLE);
        vin.setTeneurEnSucre(SEC);
        vin.setCépages(new ArrayList<Cépage>() {{
            add(chenin);
        }});
        vin.setPrix(55.0);
        afficheur.printVin(vin, 3);

        assertThat(sw.toString()).isEqualTo(
                "            DOMAINE DE LA ROULETIÈRE SEC\n" +
                    "                Description:\n" +
                    "                    J'aime bien\n" +
                    "                    ce vin.\n" +
                    "                Caractéristiques: BLANC, TRANQUILLE, SEC\n" +
                    "                Cépages: Chenin\n" +
                    "                Prix: 55,00 €\n");
    }
}
