package com.company;

import org.apache.log4j.Logger;

import java.util.Arrays;


public class ChallengerMaster {

    static void algoChallengerMaster() {

        Logger.getLogger(ChallengerRecherche.class).info("l'utilisateur joue à mastermind en mode challenger");

        int longueurDeLaCombinaisonMaster = Config.longueurDeLaCombinaisonMaster;
        int nbEssaiMaster = Config.nbEssaiMaster;
        int nbChiffreAleatoireMaster = Config.nbChiffreAleatoireMaster;

        Utils.exceptionLongueur(longueurDeLaCombinaisonMaster);
        Utils.exceptionNbEssais(nbEssaiMaster);
        Utils.exceptionNbAleatoireMaster(nbChiffreAleatoireMaster);

        int[] tabSaisieOrdinateur = Utils.initialiseTableauRandomMaster(longueurDeLaCombinaisonMaster, nbChiffreAleatoireMaster);

        for (int y = nbEssaiMaster; y >= 0; y--) {

            String saisieUtilisateur = Utils.essaiUtilisateurMaster(longueurDeLaCombinaisonMaster, nbChiffreAleatoireMaster);

            int[] tabSaisieUtilisateur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonMaster, saisieUtilisateur);

            if (y == 1) {

                System.out.println();
                Utils.etoileDecorationPourMaster();
                System.out.println("Attention dernier essai");
                Utils.etoileDecorationPourMaster();
                System.out.println();
            }
            if (y == 0) {

                Utils.etoileDecorationPourMaster();
                System.out.println();
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                     PERDU !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("vous n'avez pas trouver la combinaison secrete");
                System.out.println("La combinaison secrette était : " + Arrays.toString(tabSaisieOrdinateur));
                break;
            }
            if (Arrays.equals(tabSaisieOrdinateur, tabSaisieUtilisateur)) {

                Utils.etoileDecorationPourMaster();
                System.out.println();
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                    GAGNÉ !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("Vous avez trouver la combinaison secrete !");
                System.out.println("La combinaison été : " + Arrays.toString(tabSaisieOrdinateur));
                break;
            }
        }
        Utils.etoileDecoration();
        Menu.menuFinMaster();
    }
}