package com.oc.mastermind.recherche;

import com.oc.mastermind.Config;
import com.oc.mastermind.Menu;
import com.oc.mastermind.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ChallengerRecherche {

    public static Logger logger = LogManager.getLogger();

    /**
     * Méthode mode challenger pour jeu recherche
     * crée un nombre "secret" aléatoire
     * permet à l'utiliateur d'entrer une proposotion
     * compare la proposition utilisateur et le nombre "secret" aléatoire
     */
    public static void algoChalengerRecherche() {

        logger.info("l'utilisateur joue à Recherche +/- en mode challenger");

        /*
         * charge les paramètres de jeu
         */
        Config myConfig = Config.getInstance();

        int longueurDeLaCombinaisonRecherche = myConfig.longueurDeLaCombinaisonRecherche;
        int nbEssaiRecherche = myConfig.nbEssaiRecherche;
        int modeDev = myConfig.modeDev;

        /*
         * exceptions pour les paramètres de jeux
         */
        Utils.exceptionLongueurRecherche(longueurDeLaCombinaisonRecherche);
        Utils.exceptionNbEssais(nbEssaiRecherche);

        /*
         * crée un nombre aléatoire dans un tableau int
         */
        int[] tabSaisieOrdinateur = Utils.initialiseTableauRandom(longueurDeLaCombinaisonRecherche);


        Utils.etoileDecorationPourMaster();
        System.out.println("l'ordinateur a créé un nombre mystère !");
        Utils.etoileDecorationPourMaster();
        System.out.println();

        /*
         * si le mode developpeur est activé
         */
        if (modeDev == 1){
            System.out.println("le code secret de l'ordinateur est : "+Arrays.toString(tabSaisieOrdinateur));
        }


        for (int y =1; y <= nbEssaiRecherche; y++){

            /*
             * demande au joueur de saisir un nombre String
             */
            String saisieUtilisateur = Utils.essaiUtilisateur(longueurDeLaCombinaisonRecherche);

            /*
             * convertie la saisie String utilisateur en un tableau int
             */
            int[] tabSaisieUtilisateur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonRecherche, saisieUtilisateur);

            /*
             * compare les tableaux tabSaisieOrdinateur et tabSaisieUtilisateur
             */
            System.out.println();
            System.out.print("Essai n°"+ y +" Proposition : " + Arrays.toString(tabSaisieUtilisateur) + " | Réponse : ");
            Utils.algoPlusMoins(tabSaisieUtilisateur, tabSaisieOrdinateur);
            System.out.println();
            System.out.println();


            if (y == nbEssaiRecherche && !Arrays.equals(tabSaisieOrdinateur, tabSaisieUtilisateur)) {

                logger.info("le joueur a perdu avec la proposition : "+ Arrays.toString(tabSaisieUtilisateur)+" il fallait trouver : "+ Arrays.toString(tabSaisieOrdinateur));
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                     PERDU !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("Vous n'avez pas trouvé la combinaison secrete");
                System.out.println("La combinaison secrette était : " + Arrays.toString(tabSaisieOrdinateur));
                break;
            }
            if (Arrays.equals(tabSaisieOrdinateur, tabSaisieUtilisateur)) {

                logger.info("le joueur à gagné avec la combinaison "+ Arrays.toString(tabSaisieUtilisateur) +" il fallait trouver la combinaison : "+Arrays.toString(tabSaisieOrdinateur));
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                    GAGNÉ !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("Vous avez trouvé la combinaison secrete !");
                System.out.println("La combinaison été : " + Arrays.toString(tabSaisieOrdinateur));
                break;
            }

            if (y == nbEssaiRecherche - 1) {

                logger.info("le joueur n'a plus qu'un essai");
                Utils.etoileDecoration();
                System.out.println("Attention dernier essai");
                Utils.etoileDecoration();
                System.out.println();
            }
        }
        Utils.etoileDecoration();
        Menu.menuFinRecherchePlusMoins();
    }
}