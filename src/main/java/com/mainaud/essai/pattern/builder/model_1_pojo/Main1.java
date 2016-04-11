package com.mainaud.essai.pattern.builder.model_1_pojo;

import com.mainaud.essai.pattern.builder.api.*;
import com.mainaud.essai.pattern.builder.report.Printer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static com.mainaud.essai.pattern.builder.api.Couleur.BLANC;
import static com.mainaud.essai.pattern.builder.api.Couleur.ROSÉ;
import static com.mainaud.essai.pattern.builder.api.Couleur.ROUGE;
import static com.mainaud.essai.pattern.builder.api.Effervescence.MOUSSEUX;
import static com.mainaud.essai.pattern.builder.api.Effervescence.PÉTILLANT;
import static com.mainaud.essai.pattern.builder.api.Effervescence.TRANQUILLE;
import static com.mainaud.essai.pattern.builder.api.NatureAppellation.AOC;
import static com.mainaud.essai.pattern.builder.api.TeneurEnSucre.BRUT;
import static com.mainaud.essai.pattern.builder.api.TeneurEnSucre.SEC;
import static com.mainaud.essai.pattern.builder.api.Volume.Unité.HL;

/**
 * Main avec implantation à base de POJOs.
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        Cépage1 chenin = new Cépage1();
        chenin.setNom("Chenin");
        Cépage1 pineauLoire = new Cépage1();
        pineauLoire.setNom("Pineau de la Loire");
        Cépage1 cabernetFranc = new Cépage1();
        cabernetFranc.setNom("Cabernet franc");
        Cépage1 cabernetSauvignon = new Cépage1();
        cabernetSauvignon.setNom("Cabernet sauvignon");

        Vin1 vigneauClosRougemont = new Vin1();
        vigneauClosRougemont.setNom("Clos de Rougemont");
        vigneauClosRougemont.setDescription("C’est sur ce site exceptionnel que Saint Martin planta les premiers pieds de vignes au 4ème siècle. \n" +
            "Le chenin est donc ici dans le berceau de l’appellation Vouvray.");
        vigneauClosRougemont.setCouleur(BLANC);
        vigneauClosRougemont.setEffervescence(TRANQUILLE);
        vigneauClosRougemont.setTeneurEnSucre(SEC);
        vigneauClosRougemont.setCépages(new ArrayList<Cépage>() {{
            add(chenin);
        }});
        vigneauClosRougemont.setPrix(7.5);

        Vin1 vigneauPétillant = new Vin1();
        vigneauPétillant.setNom("Pétillant");
        vigneauPétillant.setDescription("Ce vin est en quelque sorte l’ancêtre parmi les fines bulles de Vouvray, car il est produit depuis le 19ème siècle.\n" +
            "Récolté sur des jeunes vignes, on lui réserve souvent les meilleures cuvées destinées aux effervescents en \n" +
            "utilisant des sucres résiduels naturels pour son élaboration.");
        vigneauPétillant.setCouleur(BLANC);
        vigneauPétillant.setEffervescence(PÉTILLANT);
        vigneauPétillant.setTeneurEnSucre(BRUT);
        vigneauPétillant.setCépages(new ArrayList<Cépage>() {{
            add(chenin);
        }});
        vigneauPétillant.setPrix(11.30);

        Producteur1 vigeauChevreau = new Producteur1();
        vigeauChevreau.setNom("Vigneau-Chevreau");
        vigeauChevreau.setDescription("Depuis sa fondation en 1875, le domaine situé au cœur de l’appellation Vouvray s’est agrandi à travers \n" +
            "cinq générations, passant de 5 à 33 hectares. Grâce à sa structure familiale, il lui a été possible \n" +
            "de transmettre toute l’expérience de la culture de la vigne, et de la vinification.");
        vigeauChevreau.setVins(Arrays.asList(vigneauClosRougemont, vigneauPétillant));

        Vin1 rouletièreSec = new Vin1();
        rouletièreSec.setNom("Domaine de la Rouletière Sec");
        rouletièreSec.setDescription("J'aime bien\nce vin.");
        rouletièreSec.setCouleur(BLANC);
        rouletièreSec.setEffervescence(TRANQUILLE);
        rouletièreSec.setTeneurEnSucre(SEC);
        rouletièreSec.setCépages(new ArrayList<Cépage>() {{
            add(chenin);
        }});
        rouletièreSec.setPrix(8.0);

        Producteur1 producteur = new Producteur1();
        producteur.setNom("Domaine de la Rouletière");
        producteur.setDescription("Établi à Parçay-Meslay au nord-ouest de l'appellation vouvray, Jean-Marc Gilet conduit depuis 2001 \n" +
                "ce domaine de 17ha de vignes réparties dans divers terroirs. Il s'attache à vinifier séparément \n" +
                "les différentes parcelles qu'il cultive. «Élaborer des vins d'âme et de plaisir nés d'efforts \n" +
                "perpétuels et du cœur», telle est sa devise.");
        producteur.setVins(Arrays.asList(rouletièreSec));

        Appellation1 aocVouvray = new Appellation1();
        aocVouvray.setNom("Vouvray");
        aocVouvray.setDescription("L'AOC Vouvray est issue de la sous-région Touraine. Le vignoble est implanté sur la rive droite de la Loire,\n" +
                "des environs de Tours jusqu’à Noisay, ce qui représente environ 2 200 hectares.");
        aocVouvray.setNature(AOC);
        aocVouvray.setCouleurs(new HashSet<Couleur>() {{ add(BLANC);  }});
        aocVouvray.setCépages(Arrays.asList(chenin, pineauLoire));
        aocVouvray.setEffervescences(new HashSet<Effervescence>() {{
            add(TRANQUILLE);
            add(PÉTILLANT);
            add(MOUSSEUX);
        }});
        aocVouvray.setSuperficie(2200);
        aocVouvray.setProductionAnnuelle(Volume.de(117_000, HL));
        aocVouvray.setProducteurs(Arrays.asList(vigeauChevreau, producteur));


        Vin1 closNoyer = new Vin1();
        closNoyer.setNom("Clos du Noyer");
        closNoyer.setDescription("Le bouquet, intense et cohérent, évoque les fruits noirs soulignés d'un trait de réglisse frais. \n" +
            "Au palais, la douceur domine au sein d'une matière ample, et les tanins présents sans excès portent une longue finale \n" +
            "chaleureuse et fruitée. N'hésitez pas à utiliser les épices dans vos plats pour faire honneur à cette bouteille, \n" +
            "mais plutôt après deux à trois ans de garde.");
        closNoyer.setCouleur(ROUGE);
        closNoyer.setPrix(13.6);


        Producteur1 domaineGrosBois = new Producteur1();
        domaineGrosBois.setNom("Domaine Grosbois");
        domaineGrosBois.setDescription("Propriété Familiale, le vignoble Grosbois est situé au lieu dit « Le Pressoir » à Panzoult \n" +
            "dans l'appellation Chinon au cœur du Val de Loire entre forêt et rivière.");
        domaineGrosBois.setVins(Arrays.asList(closNoyer));


        Vin1 croixBoissée = new Vin1();
        closNoyer.setNom("La Croix Boissée");
        closNoyer.setDescription("Ce Chinon composé à 100% de cabernet franc est issu d’un coteau calcaire de tuffeau blanc \n" +
            "modelé par une forte érosion et d’une petite parcelle de vignes âgées de 10 à 40 ans.");
        closNoyer.setCouleur(ROUGE);
        closNoyer.setPrix(13.6);


        Producteur1 domaineBernardBaudry = new Producteur1();
        domaineBernardBaudry.setNom("Bernard Baudry");
        domaineBernardBaudry.setDescription("");
        domaineBernardBaudry.setVins(Arrays.asList(closNoyer));


        Appellation1 aocChinon = new Appellation1();
        aocChinon.setNom("Chinon");
        aocChinon.setDescription("L'AOC Chinon voit son aire d’appellation se situer à 40km au sud-est de Tours, elle appartient donc à la \n" +
                "sous-région Touraine. Le climat, océanique à l’ouest, est de forte influence continentale à l’est.");
        aocChinon.setNature(AOC);
        aocChinon.setCouleurs(new HashSet<Couleur>() {{ add(ROUGE); add(BLANC); add(ROSÉ); }});
        aocChinon.setCépages(Arrays.asList(chenin));
        aocChinon.setEffervescences(new HashSet<Effervescence>() {{ add(TRANQUILLE); }});
        aocChinon.setSuperficie(2350);
        aocChinon.setProductionAnnuelle(Volume.de(112_000, HL));
        aocChinon.setProducteurs(Arrays.asList(domaineGrosBois, domaineBernardBaudry));

        Région1 tourainne = new Région1();


        try (Printer printer = new Printer(System.out)) {
            printer.printAppellation(aocVouvray);
            printer.printAppellation(aocChinon);
        }
    }
}
