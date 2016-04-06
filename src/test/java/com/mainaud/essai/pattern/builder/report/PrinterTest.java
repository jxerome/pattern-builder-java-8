package com.mainaud.essai.pattern.builder.report;

import com.mainaud.essai.pattern.builder.api.Cépage;
import com.mainaud.essai.pattern.builder.model_1_pojo.CépagePojo;
import com.mainaud.essai.pattern.builder.model_1_pojo.ProducteurPojo;
import com.mainaud.essai.pattern.builder.model_1_pojo.VinPojo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;

import static com.mainaud.essai.pattern.builder.api.Couleur.BLANC;
import static com.mainaud.essai.pattern.builder.api.Effervescence.MOUSSEUX;
import static com.mainaud.essai.pattern.builder.api.Effervescence.TRANQUILLE;
import static com.mainaud.essai.pattern.builder.api.TeneurEnSucre.BRUT;
import static com.mainaud.essai.pattern.builder.api.TeneurEnSucre.SEC;
import static org.assertj.core.api.Assertions.assertThat;

public class PrinterTest {
    private StringWriter sw = new StringWriter();
    private Printer printer = new Printer(sw);

    @BeforeMethod
    public void init() {
        sw.getBuffer().setLength(0);
    }


    @Test
    public void printProducteurShouldPrintProducteur() {
        CépagePojo chenin = new CépagePojo();
        chenin.setNom("Chenin");

        VinPojo vin = new VinPojo();
        vin.setNom("Domaine de la Rouletière Sec");
        vin.setDescription("J'aime bien\nce vin.");
        vin.setCouleur(BLANC);
        vin.setEffervescence(TRANQUILLE);
        vin.setTeneurEnSucre(SEC);
        vin.setCépages(new ArrayList<Cépage>() {{
            add(chenin);
        }});
        vin.setPrix(55.0);

        VinPojo vin2 = new VinPojo();
        vin2.setNom("Vigneau-Chevreau");
        vin2.setDescription("J'adore !\nce vin.");
        vin2.setCouleur(BLANC);
        vin2.setEffervescence(MOUSSEUX);
        vin2.setTeneurEnSucre(BRUT);
        vin2.setCépages(new ArrayList<Cépage>() {{
            add(chenin);
        }});
        vin2.setPrix(38.5);

        ProducteurPojo producteur = new ProducteurPojo();
        producteur.setNom("Productions réunies");
        producteur.setDescription("Un bon producteur");
        producteur.setVins(Arrays.asList(vin, vin2));

        printer.printProducteur(producteur, 1);

        assertThat(sw.toString()).isEqualTo(
                "    Productions réunies\n" +
                        "    Description\n" +
                        "        Un bon producteur\n" +
                        "    Vins\n" +
                        "        Domaine de la Rouletière Sec\n" +
                        "        Description\n" +
                        "            J'aime bien\n" +
                        "            ce vin.\n" +
                        "        Caractéristiques: BLANC TRANQUILLE SEC\n" +
                        "        Cépages: Chenin\n" +
                        "        Prix: 55,00 €\n" +
                        "        ----\n" +
                        "        Vigneau-Chevreau\n" +
                        "        Description\n" +
                        "            J'adore !\n" +
                        "            ce vin.\n" +
                        "        Caractéristiques: BLANC MOUSSEUX BRUT\n" +
                        "        Cépages: Chenin\n" +
                        "        Prix: 38,50 €\n"
        );
    }

    @Test
    public void printVinShouldPrintVin() {
        CépagePojo chenin = new CépagePojo();
        chenin.setNom("Chenin");

        VinPojo vin = new VinPojo();
        vin.setNom("Domaine de la Rouletière Sec");
        vin.setDescription("J'aime bien\nce vin.");
        vin.setCouleur(BLANC);
        vin.setEffervescence(TRANQUILLE);
        vin.setTeneurEnSucre(SEC);
        vin.setCépages(new ArrayList<Cépage>() {{
            add(chenin);
        }});
        vin.setPrix(55.0);
        printer.printVin(vin, 3);

        assertThat(sw.toString()).isEqualTo(
                "            Domaine de la Rouletière Sec\n" +
                        "            Description\n" +
                        "                J'aime bien\n" +
                        "                ce vin.\n" +
                        "            Caractéristiques: BLANC TRANQUILLE SEC\n" +
                        "            Cépages: Chenin\n" +
                        "            Prix: 55,00 €\n");
    }
}