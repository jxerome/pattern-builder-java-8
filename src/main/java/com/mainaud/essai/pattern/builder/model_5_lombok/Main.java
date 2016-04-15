package com.mainaud.essai.pattern.builder.model_5_lombok;

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


        Région valléeLoire = Région.builder()
            .nom("Vallée de Loire")
            .description("Déjà présent dans la Vallée de Loire à l’époque gallo-romaine, le vin représente un véritable modèle \n" +
                "historique et culturel favorisé ensuite par l’impulsion des grandes abbayes au Ve siècle. Il est partie intégrante \n" +
                "de la culture du « bien vivre » qui s’est développée dans la région.")
            .sousRégion(
                Région.builder()
                    .nom("Touraine")
                    .description("La sous-région  appartient à la région Vallée de la Loire. Elle a la particularité d'avoir \n" +
                        "une aire viticole fréquemment redéfinie et par conséquent un climat et des sols variables. Tout ceci, en plus de \n" +
                        "la diversité des encépagements et des modes de vinification, donne des vins souvent originaux.")
                    .cépage(chenin)
                    .cépage(cabernetFranc)
                    .cépage(cabernetSauvignon)
                    .superficie(13_000)
                    .productionAnnuelle(Volume.de(700_000, HL))
                    .appellation(
                        Appellation.builder()
                            .nom("Vouvray")
                            .description("L'AOC Vouvray est issue de la sous-région Touraine. Le vignoble est implanté sur la rive droite de la Loire,\n" +
                                "des environs de Tours jusqu'à Noisay, ce qui représente environ 2 200 hectares.")
                            .nature(AOC)
                            .couleur(BLANC)
                            .cépage(chenin)
                            .effervescence(TRANQUILLE)
                            .effervescence(PÉTILLANT)
                            .effervescence(MOUSSEUX)
                            .superficie(2200)
                            .productionAnnuelle(Volume.de(117_000, HL))
                            .producteur(
                                Producteur.builder()
                                    .nom("Vigneau-Chevreau")
                                    .description("Depuis sa fondation en 1875, le domaine situé au cœur de l'appellation Vouvray s'est agrandi à travers \n" +
                                        "cinq générations, passant de 5 à 33 hectares. Grâce à sa structure familiale, il lui a été possible \n" +
                                        "de transmettre toute l'expérience de la culture de la vigne, et de la vinification.")
                                    .vin(
                                        Vin.builder()
                                            .nom("Clos de Rougemont")
                                            .description("C'est sur ce site exceptionnel que Saint Martin planta les premiers pieds de vignes au 4ème siècle. \n" +
                                                "Le chenin est donc ici dans le berceau de l'appellation Vouvray.")
                                            .couleur(BLANC)
                                            .effervescence(TRANQUILLE)
                                            .teneurEnSucre(SEC)
                                            .cépage(chenin)
                                            .prix(7.5)
                                            .build()
                                    )
                                    .vin(
                                        Vin.builder()
                                            .nom("Pétillant")
                                            .description("Ce vin est en quelque sorte l'ancêtre parmi les fines bulles de Vouvray, car il est produit depuis le 19ème siècle.\n" +
                                                "Récolté sur des jeunes vignes, on lui réserve souvent les meilleures cuvées destinées aux effervescents en \n" +
                                                "utilisant des sucres résiduels naturels pour son élaboration.")
                                            .couleur(BLANC)
                                            .effervescence(PÉTILLANT)
                                            .teneurEnSucre(BRUT)
                                            .cépage(chenin)
                                            .prix(11.30)
                                            .build()
                                    )
                                    .build()
                            )
                            .producteur(
                                Producteur.builder()
                                    .nom("Domaine de la Rouletière")
                                    .description("Établi à Parçay-Meslay au nord-ouest de l'appellation vouvray, Jean-Marc Gilet conduit depuis 2001 \n" +
                                        "ce domaine de 17ha de vignes réparties dans divers terroirs. Il s'attache à vinifier séparément \n" +
                                        "les différentes parcelles qu'il cultive. «Élaborer des vins d'âme et de plaisir nés d'efforts \n" +
                                        "perpétuels et du cœur», telle est sa devise.")
                                    .vin(
                                        Vin.builder()
                                            .nom("Domaine de la Rouletière Sec")
                                            .description("J'aime bien\nce vin.")
                                            .couleur(BLANC)
                                            .effervescence(TRANQUILLE)
                                            .teneurEnSucre(SEC)
                                            .cépage(chenin)
                                            .prix(8.0)
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .appellation(
                        Appellation.builder()
                            .nom("Chinon")
                            .description("L'AOC Chinon voit son aire d'appellation se situer à 40km au sud-est de Tours, elle appartient donc à la \n" +
                                "sous-région Touraine. Le climat, océanique à l'ouest, est de forte influence continentale à l'est.")
                            .nature(AOC)
                            .couleur(ROUGE)
                            .couleur(BLANC)
                            .couleur(ROSÉ)
                            .cépage(cabernetFranc)
                            .cépage(cabernetSauvignon)
                            .effervescence(TRANQUILLE)
                            .superficie(2350)
                            .productionAnnuelle(Volume.de(112_000, HL))
                            .producteur(
                                Producteur.builder()
                                    .nom("Domaine Grosbois")
                                    .description("Propriété Familiale, le vignoble Grosbois est situé au lieu dit « Le Pressoir » à Panzoult \n" +
                                        "dans l'appellation Chinon au cœur du Val de Loire entre forêt et rivière.")
                                    .vin(
                                        Vin.builder()
                                            .nom("Clos du Noyer")
                                            .description("Le bouquet, intense et cohérent, évoque les fruits noirs soulignés d'un trait de réglisse frais. \n" +
                                                "Au palais, la douceur domine au sein d'une matière ample, et les tanins présents sans excès portent une longue finale \n" +
                                                "chaleureuse et fruitée. N'hésitez pas à utiliser les épices dans vos plats pour faire honneur à cette bouteille, \n" +
                                                "mais plutôt après deux à trois ans de garde.")
                                            .couleur(ROUGE)
                                            .prix(13.6)
                                            .build()
                                    )
                                    .build()
                            )
                            .producteur(
                                Producteur.builder()
                                    .nom("Bernard Baudry")
                                    .description("Situé à Cravant les coteaux sur l'appellation Chinon, ce domaine en cours de \n" +
                                        "conversion au mode d'agriculture biologique, cultive 30 hectares de vignes")
                                    .vin(
                                        Vin.builder()
                                        .nom("La Croix Boissée")
                                        .description("Ce Chinon composé à 100% de cabernet franc est issu d'un coteau calcaire de tuffeau blanc \n" +
                                            "modelé par une forte érosion et d'une petite parcelle de vignes âgées de 10 à 40 ans.")
                                        .couleur(ROUGE)
                                        .prix(20.96)
                                        .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build())
            .build();

//        try (Afficheur afficheur = new Afficheur(System.out)) {
//            afficheur.printRégion(valléeLoire);
//        }
    }
}
