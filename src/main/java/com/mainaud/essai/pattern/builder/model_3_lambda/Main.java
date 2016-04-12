package com.mainaud.essai.pattern.builder.model_3_lambda;

import com.mainaud.essai.pattern.builder.model.Volume;
import com.mainaud.essai.pattern.builder.report.Afficheur;

import java.io.IOException;

import static com.mainaud.essai.pattern.builder.model.Couleur.*;
import static com.mainaud.essai.pattern.builder.model.Effervescence.*;
import static com.mainaud.essai.pattern.builder.model.NatureAppellation.AOC;
import static com.mainaud.essai.pattern.builder.model.TeneurEnSucre.BRUT;
import static com.mainaud.essai.pattern.builder.model.TeneurEnSucre.SEC;
import static com.mainaud.essai.pattern.builder.model.Volume.Unité.HL;

/**
 * Main avec implantation à base de POJOs.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Cépage chenin = new Cépage("chenin", "Cépage phare de la Vallée de la Loire, le chenin, aussi appelé pinot de la Loire (pineau). iL serait originaire de l’Anjou où il aurait été cultivé par les moines de l’Abbaye de Saint-Maur située entre Angers et Saumur dès le 6ème siècle.");
        Cépage cabernetFranc = new Cépage("cabernet franc", "Le cabernet franc est l’un des plus anciens cépages rouge du bordelais. Le Libournais est son terroir de prédilection.");
        Cépage cabernetSauvignon = new Cépage("cabernet sauvignon", "Le cabernet-sauvignon est un des cépages phares de Bordeaux. C’est un grand cépage rouge tant par sa superficie d’encépagement (2ème cépage le plus planté) que par sa qualité.");

        Région valléeLoire = Région.of(valléeDeLoire -> valléeDeLoire
            .setNom("Vallée de Loire")
            .setDescription("Déjà présent dans la Vallée de Loire à l’époque gallo-romaine, le vin représente un véritable modèle \n" +
                "historique et culturel favorisé ensuite par l’impulsion des grandes abbayes au Ve siècle. Il est partie intégrante \n" +
                "de la culture du « bien vivre » qui s’est développée dans la région.")

            .addSousRégion(touraine -> touraine
                .setNom("Touraine")
                .setDescription("La sous-région  appartient à la région Vallée de la Loire. Elle a la particularité d'avoir \n" +
                    "une aire viticole fréquemment redéfinie et par conséquent un climat et des sols variables. Tout ceci, en plus de \n" +
                    "la diversité des encépagements et des modes de vinification, donne des vins souvent originaux.")

                .addCépage(chenin)
                .addCépage(cabernetFranc)
                .addCépage(cabernetSauvignon)
                .setSuperficie(13_000)
                .setProductionAnnuelle(Volume.de(700_000, HL))

                .addAppellation(vouvray -> vouvray
                    .setNom("Vouvray")
                    .setDescription("L'AOC Vouvray est issue de la sous-région Touraine. Le vignoble est implanté sur la rive droite de la Loire,\n" +
                        "des environs de Tours jusqu'à Noisay, ce qui représente environ 2 200 hectares.")
                    .setNature(AOC)
                    .addCouleur(BLANC)
                    .addCépage(chenin)
                    .addEffervescence(TRANQUILLE)
                    .addEffervescence(PÉTILLANT)
                    .addEffervescence(MOUSSEUX)
                    .setSuperficie(2200)
                    .setProductionAnnuelle(Volume.de(117_000, HL))

                    .addProducteur(vigneauChevreau -> vigneauChevreau
                        .setNom("Vigneau-Chevreau")
                        .setDescription("Depuis sa fondation en 1875, le domaine situé au cœur de l'appellation Vouvray s'est agrandi à travers \n" +
                            "cinq générations, passant de 5 à 33 hectares. Grâce à sa structure familiale, il lui a été possible \n" +
                            "de transmettre toute l'expérience de la culture de la vigne, et de la vinification.")

                        .addVin(closRougemont -> closRougemont
                            .setNom("Clos de Rougemont")
                            .setDescription("C'est sur ce site exceptionnel que Saint Martin planta les premiers pieds de vignes au 4ème siècle. \n" +
                                "Le chenin est donc ici dans le berceau de l'appellation Vouvray.")
                            .setCouleur(BLANC)
                            .setEffervescence(TRANQUILLE)
                            .setTeneurEnSucre(SEC)
                            .addCépage(chenin)
                            .setPrix(7.5)
                        )
                        .addVin(pétillant -> pétillant
                            .setNom("Pétillant")
                            .setDescription("Ce vin est en quelque sorte l'ancêtre parmi les fines bulles de Vouvray, car il est produit depuis le 19ème siècle.\n" +
                                "Récolté sur des jeunes vignes, on lui réserve souvent les meilleures cuvées destinées aux effervescents en \n" +
                                "utilisant des sucres résiduels naturels pour son élaboration.")
                            .setCouleur(BLANC)
                            .setEffervescence(PÉTILLANT)
                            .setTeneurEnSucre(BRUT)
                            .addCépage(chenin)
                            .setPrix(11.30)
                        )
                    )
                    .addProducteur(domaineRouletière -> domaineRouletière
                        .setNom("Domaine de la Rouletière")
                        .setDescription("Établi à Parçay-Meslay au nord-ouest de l'appellation vouvray, Jean-Marc Gilet conduit depuis 2001 \n" +
                            "ce domaine de 17ha de vignes réparties dans divers terroirs. Il s'attache à vinifier séparément \n" +
                            "les différentes parcelles qu'il cultive. «Élaborer des vins d'âme et de plaisir nés d'efforts \n" +
                            "perpétuels et du cœur», telle est sa devise.")

                        .addVin(sec -> sec
                            .setNom("Domaine de la Rouletière Sec")
                            .setDescription("J'aime bien\nce vin.")
                            .setCouleur(BLANC)
                            .setEffervescence(TRANQUILLE)
                            .setTeneurEnSucre(SEC)
                            .addCépage(chenin)
                            .setPrix(8.0)
                        )
                    )
                )
                .addAppellation(chinon -> chinon
                    .setNature(AOC)
                    .setNom("Chinon")
                    .setDescription("L'AOC Chinon voit son aire d'appellation se situer à 40km au sud-est de Tours, elle appartient donc à la \n" +
                        "sous-région Touraine. Le climat, océanique à l'ouest, est de forte influence continentale à l'est.")

                    .addCouleur(ROUGE)
                    .addCouleur(BLANC)
                    .addCouleur(ROSÉ)
                    .addCépage(cabernetFranc)
                    .addCépage(cabernetSauvignon)
                    .addEffervescence(TRANQUILLE)
                    .setSuperficie(2350)
                    .setProductionAnnuelle(Volume.de(112_000, HL))

                    .addProducteur(domaineGroisbois -> domaineGroisbois
                        .setNom("Domaine Grosbois")
                        .setDescription("Propriété Familiale, le vignoble Grosbois est situé au lieu dit « Le Pressoir » à Panzoult \n" +
                            "dans l'appellation Chinon au cœur du Val de Loire entre forêt et rivière.")

                        .addVin(closNoyer -> closNoyer
                            .setNom("Clos du Noyer")
                            .setDescription("Le bouquet, intense et cohérent, évoque les fruits noirs soulignés d'un trait de réglisse frais. \n" +
                                "Au palais, la douceur domine au sein d'une matière ample, et les tanins présents sans excès portent une longue finale \n" +
                                "chaleureuse et fruitée. N'hésitez pas à utiliser les épices dans vos plats pour faire honneur à cette bouteille, \n" +
                                "mais plutôt après deux à trois ans de garde.")
                            .setCouleur(ROUGE)
                            .setPrix(13.6)
                        )
                    )
                    .addProducteur(bernardBaudry -> bernardBaudry
                        .setNom("Bernard Baudry")
                        .setDescription("Situé à Cravant les coteaux sur l'appellation Chinon, ce domaine en cours de \n" +
                            "conversion au mode d'agriculture biologique, cultive 30 hectares de vignes")

                        .addVin(croixBoissée -> croixBoissée
                            .setNom("La Croix Boissée")
                            .setDescription("Ce Chinon composé à 100% de cabernet franc est issu d'un coteau calcaire de tuffeau blanc \n" +
                                "modelé par une forte érosion et d'une petite parcelle de vignes âgées de 10 à 40 ans.")
                            .setCouleur(ROUGE)
                            .setPrix(20.96)
                        )
                    )
                )
            )
        );

        try (Afficheur afficheur = new Afficheur(System.out)) {
            afficheur.printRégion(valléeLoire);
        }
    }
}
