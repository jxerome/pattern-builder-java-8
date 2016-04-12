package com.mainaud.essai.pattern.builder.model_1_pojo;

import com.mainaud.essai.pattern.builder.api.*;
import com.mainaud.essai.pattern.builder.model.Couleur;
import com.mainaud.essai.pattern.builder.model.Effervescence;
import com.mainaud.essai.pattern.builder.model.Volume;
import com.mainaud.essai.pattern.builder.report.Afficheur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static com.mainaud.essai.pattern.builder.model.Couleur.BLANC;
import static com.mainaud.essai.pattern.builder.model.Couleur.ROSÉ;
import static com.mainaud.essai.pattern.builder.model.Couleur.ROUGE;
import static com.mainaud.essai.pattern.builder.model.Effervescence.MOUSSEUX;
import static com.mainaud.essai.pattern.builder.model.Effervescence.PÉTILLANT;
import static com.mainaud.essai.pattern.builder.model.Effervescence.TRANQUILLE;
import static com.mainaud.essai.pattern.builder.model.NatureAppellation.AOC;
import static com.mainaud.essai.pattern.builder.model.TeneurEnSucre.BRUT;
import static com.mainaud.essai.pattern.builder.model.TeneurEnSucre.SEC;
import static com.mainaud.essai.pattern.builder.model.Volume.Unité.HL;

/**
 * Main avec implantation à base de POJOs.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Cépage chenin = new Cépage();
        chenin.setNom("chenin");
        chenin.setDescription("Cépage phare de la Vallée de la Loire, le chenin, aussi appelé pinot de la Loire (pineau). \n" +
            "Il serait originaire de l’Anjou où il aurait été cultivé par les moines de l’Abbaye de Saint-Maur située entre \n" +
            "Angers et Saumur dès le 6ème siècle.");
        Cépage cabernetFranc = new Cépage();
        cabernetFranc.setNom("cabernet franc");
        Cépage cabernetSauvignon = new Cépage();
        cabernetSauvignon.setNom("cabernet sauvignon");

        Vin vigneauClosRougemont = new Vin();
        vigneauClosRougemont.setNom("Clos de Rougemont");
        vigneauClosRougemont.setDescription("C'est sur ce site exceptionnel que Saint Martin planta les premiers pieds de vignes au 4ème siècle. \n" +
            "Le chenin est donc ici dans le berceau de l'appellation Vouvray.");
        vigneauClosRougemont.setCouleur(BLANC);
        vigneauClosRougemont.setEffervescence(TRANQUILLE);
        vigneauClosRougemont.setTeneurEnSucre(SEC);
        vigneauClosRougemont.setCépages(Arrays.asList(chenin));
        vigneauClosRougemont.setPrix(7.5);

        Vin vigneauPétillant = new Vin();
        vigneauPétillant.setNom("Pétillant");
        vigneauPétillant.setDescription("Ce vin est en quelque sorte l'ancêtre parmi les fines bulles de Vouvray, car il est produit depuis le 19ème siècle.\n" +
            "Récolté sur des jeunes vignes, on lui réserve souvent les meilleures cuvées destinées aux effervescents en \n" +
            "utilisant des sucres résiduels naturels pour son élaboration.");
        vigneauPétillant.setCouleur(BLANC);
        vigneauPétillant.setEffervescence(PÉTILLANT);
        vigneauPétillant.setTeneurEnSucre(BRUT);
        vigneauPétillant.setCépages(Arrays.asList(chenin));
        vigneauPétillant.setPrix(11.30);

        Producteur vigeauChevreau = new Producteur();
        vigeauChevreau.setNom("Vigneau-Chevreau");
        vigeauChevreau.setDescription("Depuis sa fondation en 1875, le domaine situé au cœur de l'appellation Vouvray s'est agrandi à travers \n" +
            "cinq générations, passant de 5 à 33 hectares. Grâce à sa structure familiale, il lui a été possible \n" +
            "de transmettre toute l'expérience de la culture de la vigne, et de la vinification.");
        vigeauChevreau.setVins(Arrays.asList(vigneauClosRougemont, vigneauPétillant));

        Vin rouletièreSec = new Vin();
        rouletièreSec.setNom("Domaine de la Rouletière Sec");
        rouletièreSec.setDescription("J'aime bien\nce vin.");
        rouletièreSec.setCouleur(BLANC);
        rouletièreSec.setEffervescence(TRANQUILLE);
        rouletièreSec.setTeneurEnSucre(SEC);
        rouletièreSec.setCépages(Arrays.asList(chenin));
        rouletièreSec.setPrix(8.0);

        Producteur producteur = new Producteur();
        producteur.setNom("Domaine de la Rouletière");
        producteur.setDescription("Établi à Parçay-Meslay au nord-ouest de l'appellation vouvray, Jean-Marc Gilet conduit depuis 2001 \n" +
                "ce domaine de 17ha de vignes réparties dans divers terroirs. Il s'attache à vinifier séparément \n" +
                "les différentes parcelles qu'il cultive. «Élaborer des vins d'âme et de plaisir nés d'efforts \n" +
                "perpétuels et du cœur», telle est sa devise.");
        producteur.setVins(Arrays.asList(rouletièreSec));

        Appellation aocVouvray = new Appellation();
        aocVouvray.setNom("Vouvray");
        aocVouvray.setDescription("L'AOC Vouvray est issue de la sous-région Touraine. Le vignoble est implanté sur la rive droite de la Loire,\n" +
                "des environs de Tours jusqu'à Noisay, ce qui représente environ 2 200 hectares.");
        aocVouvray.setNature(AOC);
        aocVouvray.setCouleurs(new HashSet<Couleur>() {{ add(BLANC);  }});
        aocVouvray.setCépages(Arrays.asList(chenin));
        aocVouvray.setEffervescences(new HashSet<Effervescence>() {{
            add(TRANQUILLE);
            add(PÉTILLANT);
            add(MOUSSEUX);
        }});
        aocVouvray.setSuperficie(2200);
        aocVouvray.setProductionAnnuelle(Volume.de(117_000, HL));
        aocVouvray.setProducteurs(Arrays.asList(vigeauChevreau, producteur));


        Vin closNoyer = new Vin();
        closNoyer.setNom("Clos du Noyer");
        closNoyer.setDescription("Le bouquet, intense et cohérent, évoque les fruits noirs soulignés d'un trait de réglisse frais. \n" +
            "Au palais, la douceur domine au sein d'une matière ample, et les tanins présents sans excès portent une longue finale \n" +
            "chaleureuse et fruitée. N'hésitez pas à utiliser les épices dans vos plats pour faire honneur à cette bouteille, \n" +
            "mais plutôt après deux à trois ans de garde.");
        closNoyer.setCouleur(ROUGE);
        closNoyer.setPrix(13.6);


        Producteur domaineGrosBois = new Producteur();
        domaineGrosBois.setNom("Domaine Grosbois");
        domaineGrosBois.setDescription("Propriété Familiale, le vignoble Grosbois est situé au lieu dit « Le Pressoir » à Panzoult \n" +
            "dans l'appellation Chinon au cœur du Val de Loire entre forêt et rivière.");
        domaineGrosBois.setVins(Arrays.asList(closNoyer));


        Vin croixBoissée = new Vin();
        croixBoissée.setNom("La Croix Boissée");
        croixBoissée.setDescription("Ce Chinon composé à 100% de cabernet franc est issu d'un coteau calcaire de tuffeau blanc \n" +
            "modelé par une forte érosion et d'une petite parcelle de vignes âgées de 10 à 40 ans.");
        croixBoissée.setCouleur(ROUGE);
        croixBoissée.setPrix(20.96);


        Producteur domaineBernardBaudry = new Producteur();
        domaineBernardBaudry.setNom("Bernard Baudry");
        domaineBernardBaudry.setDescription("Situé à Cravant les coteaux sur l'appellation Chinon, ce domaine en cours de \n" +
            "conversion au mode d'agriculture biologique, cultive 30 hectares de vignes");
        domaineBernardBaudry.setVins(Arrays.asList(croixBoissée));


        Appellation aocChinon = new Appellation();
        aocChinon.setNom("Chinon");
        aocChinon.setDescription("L'AOC Chinon voit son aire d'appellation se situer à 40km au sud-est de Tours, elle appartient donc à la \n" +
                "sous-région Touraine. Le climat, océanique à l'ouest, est de forte influence continentale à l'est.");
        aocChinon.setNature(AOC);
        aocChinon.setCouleurs(new HashSet<Couleur>() {{ add(ROUGE); add(BLANC); add(ROSÉ); }});
        aocChinon.setCépages(Arrays.asList(chenin));
        aocChinon.setEffervescences(new HashSet<Effervescence>() {{ add(TRANQUILLE); }});
        aocChinon.setSuperficie(2350);
        aocChinon.setProductionAnnuelle(Volume.de(112_000, HL));
        aocChinon.setProducteurs(Arrays.asList(domaineGrosBois, domaineBernardBaudry));

        Région touraine = new Région();
        touraine.setNom("Touraine");
        touraine.setDescription("La sous-région Touraine appartient à la région Vallée de la Loire. Elle a la particularité d'avoir \n" +
            "une aire viticole fréquemment redéfinie et par conséquent un climat et des sols variables. Tout ceci, en plus de \n" +
            "la diversité des encépagements et des modes de vinification, donne des vins souvent originaux.");
        touraine.setAppellations(Arrays.asList(aocVouvray, aocChinon));
        touraine.setCépages(Arrays.asList());
        touraine.setSuperficie(13_000);
        touraine.setProductionAnnuelle(Volume.de(700_000, HL));

        aocVouvray.setRégion(touraine);
        aocChinon.setRégion(touraine);

        Région valléeLoire = new Région();
        valléeLoire.setNom("Vallée de Loire");
        valléeLoire.setDescription("Déjà présent dans la Vallée de Loire à l’époque gallo-romaine, le vin représente un véritable modèle \n" +
            "historique et culturel favorisé ensuite par l’impulsion des grandes abbayes au Ve siècle. Il est partie intégrante \n" +
            "de la culture du « bien vivre » qui s’est développée dans la région.");
        valléeLoire.setSousRégions(Arrays.asList(touraine));

        touraine.setRégion(valléeLoire);

        try (Afficheur afficheur = new Afficheur(System.out)) {
            afficheur.printRégion(valléeLoire);
        }
    }
}
