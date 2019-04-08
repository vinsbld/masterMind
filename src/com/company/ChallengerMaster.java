package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ChallengerMaster {
    static Scanner nb = new Scanner(System.in);

    static void algoChalengerMaster() {

        int longueurDeLaCombaison = 3;
        int nbEssai = 4;
        int nbChiffre = Integer.parseInt(System.getProperty("nb_chiffre"));

        if (nbChiffre < 4 || nbChiffre > 10) {
            //logger.warn("le nombre de chiffre utilisable n'est pas conforme ([4-10])")
            return;
        }

        //creer un nombre aléatoire entre 0 et 9 et place ses chiffres dans un tableau
        Random nbAleatoire = new Random();
        int[] tabSaisieOrdinateur = new int[longueurDeLaCombaison];
        for (int i = 0; i < tabSaisieOrdinateur.length; i++) {
            tabSaisieOrdinateur[i] = nbAleatoire.nextInt(9 + 1);
        }
        //System.out.print(Arrays.toString(tabSaisieOrdinateur));

        for (int y = nbEssai; y >= 0; y--) {

            Utils.etoileDecorationPourMaster();
            System.out.println("Entrez votre proposition : ");
            String saisieUtilisateur = nb.next();

            /*tant que la saisiUtilisateur n'est pas un nombre entre 0 et 9
            envoie un message d'erreur
             */
            boolean isUnNombre = saisieUtilisateur.matches("[0-9]*");

            while (!isUnNombre) {
                Utils.etoileDecorationPourMaster();
                System.out.println("Vous n'avez pas saisi un nombre !");
                y++;
                Utils.etoileDecorationPourMaster();
                System.out.println("Entrez votre proposition : ");
                saisieUtilisateur = nb.next();
                isUnNombre = saisieUtilisateur.matches("[0-9]*");
            }
            Utils.etoileDecorationPourMaster();
            /*
            converti la saisie utilisateur String en un tableau integer
            pour pouvoir comparer le tableau random et la saisiUtilisateur
             */
            int[] tabSaisieUtilisateur = new int[longueurDeLaCombaison];
            for (int i = 0; i < tabSaisieUtilisateur.length; i++) {
                int converter = Integer.parseInt(String.valueOf(saisieUtilisateur.charAt(i)));
                tabSaisieUtilisateur[i] = converter;
            }

            /*tant que la proposition n'est pas de la bonne taille envoie ce message d'erreur,
             y++ fait en sorte que chaque mauvaise saisie n'est pas compté comme un essai
            */
            if (saisieUtilisateur.length() < tabSaisieOrdinateur.length || saisieUtilisateur.length() > tabSaisieOrdinateur.length) {
                System.out.println("Votre proposition doit comporter " + longueurDeLaCombaison + " chiffres.");
                y++;
            }
            if (saisieUtilisateur.length() == tabSaisieOrdinateur.length) {
                System.out.print("Proposition : " + Arrays.toString(tabSaisieUtilisateur) + " | Réponse : ");
                Utils.algoMaster(tabSaisieOrdinateur, tabSaisieUtilisateur);
            }

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