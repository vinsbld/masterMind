package com.oc.mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class Utils {

    public static Logger logger = LogManager.getLogger();

    static Scanner nb = new Scanner(System.in);

    private Utils() {

    }

    /**
     * fonction utilisée pour le mode duel
     * convertie un String en un int
     *
     * @param longueurDelaCombinaison nombre défini dans le fichier config.properties
     * @return nbSecretUtilisateur nombre secret créer par l'utilisateur
     */
    /*tant que la condition n'est pas respectée alors revoi l'utilisateur vers une
       nouvelle saisie en lui indiquant les prérequis d'une saisie valide*/
    public static String essaiUtilisateur(int longueurDelaCombinaison) {

        boolean isUnNombre;
        String nbSecretUtilisateur;

        do {

            Utils.etoileDecorationPourMaster();
            System.out.println("Votre proposition doit comporter " + longueurDelaCombinaison + " chiffres allants de 0 à 9");
            Utils.etoileDecorationPourMaster();
            System.out.print("saisisez votre proposition : ");
            nbSecretUtilisateur = nb.next();
            Utils.etoileDecorationPourMaster();
            System.out.println();
            isUnNombre = nbSecretUtilisateur.matches("[0-9]*");
            logger.info("L'utilisateur a essayé la combinaison : " + nbSecretUtilisateur);

            if (!isUnNombre || nbSecretUtilisateur.length() != longueurDelaCombinaison) {
                logger.warn("Utilisateur a saisie une mauvaise combinaison " + nbSecretUtilisateur + " n'est pas valide, la proposition doit comporter " + longueurDelaCombinaison + " chiffres allants de 0 à 9");
            }
        }

        while (!isUnNombre || nbSecretUtilisateur.length() != longueurDelaCombinaison);
        return nbSecretUtilisateur;
    }


    /**
     * compotement de l'odinateur pour trouver le nombre secret pour le jeu mastermind
     * algorithme mastermind, première boucle indique si un élément est bien placé,
     * la deuxième boucle indique si un élément et présent dans le tableau,
     * la condition != indique que si l'élément est bien placé alors il ne faut pas le prendre en concidèration
     *
     * @param combinaisonSecrete tableau du défenseur
     * @param attaque            tableau de l'attaquant
     */
    public static void algoMaster(int[] combinaisonSecrete, int[] attaque) {
        logger.info("l'odinateur verifie si dans sa combinaison : " + Arrays.toString(attaque) + " un nombre est bien placé ou présent ");
        int present = 0;
        int bienPlace = 0;
        for (int i = 0; i < combinaisonSecrete.length; i++) {
            if (attaque[i] == combinaisonSecrete[i]) {
                bienPlace = bienPlace + 1;
                logger.info("le chiffre " + attaque[i] + " est bien placé");
            } else {
                for (int y = 0; y < combinaisonSecrete.length; y++) {
                    if (attaque[i] == combinaisonSecrete[y] && attaque[y] != combinaisonSecrete[y]) {
                        present = present + 1;
                        logger.info("le chiffre " + attaque[i] + " est présent");
                    }
                }
            }
        }
        System.out.print(present + " présent, ");
        System.out.println(bienPlace + " bien placé");
        logger.info("l'ordinateur a touver " + present + " présent et " + bienPlace + " bien palcé pour sa combinaison " + Arrays.toString(attaque) + " comparer a la défense " + Arrays.toString(combinaisonSecrete));
    }

    /**
     * décoration * pour Maestermind
     */
    public static void etoileDecorationPourMaster() {
        for (int i = 1; i <= 60; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /************************************************************************************/
    /******************************* fonctions config.properties *********************************/


    /**
     * exception lié au fichier config.properties
     *
     * @param nbCaseMaster nombre défini dans le fichier config.properties
     */
    //renvoie un message d'erreur quand le chiffre n'est pas conforme
    public static void exceptionLongueurMaster(int nbCaseMaster) {

        if (nbCaseMaster < 4 || nbCaseMaster > 10) {

            Utils.etoileDecorationPourMaster();
            logger.fatal("le nombre de chiffre utilisable n'est pas conforme ([4 - 10])");
            Utils.etoileDecorationPourMaster();
        }
        return;
    }

    /**
     * exception lié au fichier config.properties
     * la longueur de la combinaison ne doit pas etre inferieure à 3 et suppérieure à 10 "Mastermind"
     *
     * @param longueurDeLaCombinaison nombre défini dans le fichier config.properties
     */
    public static void exceptionLongueurRecherche(int longueurDeLaCombinaison) {

        if (longueurDeLaCombinaison < 1) {
            Utils.etoileDecorationPourMaster();
            logger.fatal("la longueur de la combinaison " + longueurDeLaCombinaison + " n'est pas valide");
            Utils.etoileDecorationPourMaster();
        }
        return;
    }

    /**
     * exception lié fichier config.properties
     * le nombre d'essais ne peut pas être inférieur ou égale à 0
     *
     * @param nbEssai
     */
    public static void exceptionNbEssais(int nbEssai) {

        if (nbEssai <= 0) {
            logger.fatal("le nombre d'essais est inférieur à 0");
        }
        return;
    }

    /**
     * fonction utilisée dans le mode duel
     * convertie un String en int
     *
     * @param longueurDelaCombinaison nombre défini dans le fichier config.properties
     * @param saisieUtilisateur nombre secret saisi par l'utilisateur
     * @return tabNbSecretUtil retourne le nombre saisi par l'utilisateur sous forme de tableau
     */
    /*transforme la saisie utilisateur "String", chaque caractères
    "charAt(j)" est en suite converti en un entier et est placé dan sun tableau de int[]
    cela permet de pouvoir comperer le tableau Random et celui-ci*/
    public static int[] initialiseTableauUtilisateur(int longueurDelaCombinaison, String saisieUtilisateur) {

        logger.info("conversion de la saisie Utilisateur en un tableau int[]");

        int[] tabNbSecretUtil = new int[longueurDelaCombinaison];
        for (int j = 0; j < tabNbSecretUtil.length; j++) {
            int converter = Integer.parseInt(String.valueOf(saisieUtilisateur.charAt(j)));
            tabNbSecretUtil[j] = converter;
        }
        logger.info("le tableau de l'utilisateur est : " + Arrays.toString(tabNbSecretUtil));
        return tabNbSecretUtil;
    }


    /**
     * affiche si le chiffre est bien positionné ou si celui-ci est plus grand ou plus petit
     * si la valeur saisie est inferieur affiche "+"
     * si elle est inférieure affiche "-"
     * si la valeur esy la même affiche "="
     *
     * @param tab1
     * @param tab2
     */
    public static void algoPlusMoins(int[] tab1, int[] tab2) {

        logger.info("l'ordinateur compare les éléments des deux tableaux " + Arrays.toString(tab1) + " et " + Arrays.toString(tab2));

        for (int i = 0; i < tab1.length; i++) {
            if (tab1[i] < tab2[i]) {
                System.out.print("+");
                logger.info("le chiffre " + tab1[i] + " est plus petit que " + tab2[i]);

            } else if (tab1[i] > tab2[i]) {
                System.out.print("-");
                logger.info("le chiffre " + tab1[i] + " est plus grand que " + tab2[i]);

            } else if (tab1[i] == tab2[i]) {
                System.out.print("=");
                logger.info("le chiffre " + tab1[i] + " est identique à " + tab2[i]);

            }
        }
        System.out.println();
    }

    /**
     * créer un nombre random pour le jeu recherche
     *
     * @param longueurDelaCombinaison nombre défini dans le fichier config.properties
     * @return tabSaisieOrdinateur tableau contenant le nombre secret de l'ordinateur
     */
    public static int[] initialiseTableauRandom(int longueurDelaCombinaison) {

        Random nbAleatoire = new Random();
        int[] tabSaisieOrdinateur = new int[longueurDelaCombinaison];
        for (int i = 0; i < tabSaisieOrdinateur.length; i++) {
            tabSaisieOrdinateur[i] = nbAleatoire.nextInt(10);
        }
        logger.info("L'ordinateur a créé un chiffre mystère : " + Arrays.toString(tabSaisieOrdinateur));
        return tabSaisieOrdinateur;
    }

    /**
     * affiche des étoiles
     * décoration * pour menus et recherche +/-
     */
    public static void etoileDecoration() {
        for (int i = 1; i <= 47; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
     * affiche des hastags
     * décoration # pour menus et recherche +/-
     */
    public static void hastagDecoration() {
        for (int i = 1; i <= 47; i++) {
            System.out.print("#");
        }
        System.out.println();
    }

    /**
     * fonction qui demande a l'utilisateur de saisir une proposition
     * tant que celle ci n'est pas un chiffre entre 0 et 9
     * ou que la longueur de la proposition n'est pas identique à la longueur du tableau
     * alors on lui proposaera sans cesse de saisir une valeur valide
     *
     * @param longueurDelaCombinaison
     * @return nbSecretUtilisateur
     */
    public static String saisieUtilisateur(int longueurDelaCombinaison) {

        boolean isUnNombre;
        String nbSecretUtilisateur;

        do {
            Utils.etoileDecorationPourMaster();
            System.out.println("Votre proposition doit comporter " + longueurDelaCombinaison + " chiffres allants de 0 à 9");
            Utils.etoileDecorationPourMaster();
            System.out.println("SAISISSEZ VOTRE CHIFFRE MYSTERE : ");
            nbSecretUtilisateur = nb.next();
            logger.info("le chiffre mystère de l'utilisateur est : " + nbSecretUtilisateur);
            isUnNombre = nbSecretUtilisateur.matches("[0-9]*");
            if (!isUnNombre || nbSecretUtilisateur.length() != longueurDelaCombinaison) {
                logger.warn("Utilisateur a saisie une mauvaise combinaison " + nbSecretUtilisateur + " n'est pas une proposition valide, la proposition doit comporter " + longueurDelaCombinaison + " chiffres allants de 0 à 9");
            }
        } while (!isUnNombre || nbSecretUtilisateur.length() != longueurDelaCombinaison);
        return nbSecretUtilisateur;
    }


    private static int nombreMaxMinRandom(int min, int max) {

        if (min > max) {
            throw new IllegalArgumentException("max doit être infèrieur a min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * compotement de l'odinateur pour trouver le nombre secret pour le jeu recherche
     * si le nombre generé et inferieur ou supereieur à la valeur cible
     * l'ordinateur génére un chiffre entre la valeur [i] et 9 si resultat est +.
     * l'ordinateur génére un chiffre entre la valeur [i] et 0 si resultat est -.
     *
     * @param tabSaisieAttaquant
     * @param tabSaisieDefenseur
     */
    public static void algoComportementRandom(int tabSaisieAttaquant[], int tabSaisieDefenseur[]) {

        logger.info("l'ordinateur compare les éléments des deux tableaux, attaquant : " + Arrays.toString(tabSaisieAttaquant) + " et défenseur : " + Arrays.toString(tabSaisieDefenseur));

        for (int i = 0; i < tabSaisieDefenseur.length; i++) {

            if (tabSaisieAttaquant[i] < tabSaisieDefenseur[i]) {
                logger.info("le chiffre " + tabSaisieAttaquant[i] + " est trop petit");
                tabSaisieAttaquant[i] = nombreMaxMinRandom(tabSaisieAttaquant[i] + 1, 9);
                logger.info("le nouveau chiffre proposé par l'ordinateur est " + tabSaisieAttaquant[i]);
            } else if (tabSaisieAttaquant[i] > tabSaisieDefenseur[i]) {
                logger.info("le chiffre " + tabSaisieAttaquant[i] + " est trop grand");
                tabSaisieAttaquant[i] = nombreMaxMinRandom(0, tabSaisieAttaquant[i] - 1);
                logger.info("le nouveau chiffre proposé par l'ordinateur est " + tabSaisieAttaquant[i]);
            } else {
                tabSaisieAttaquant[i] = tabSaisieAttaquant[i];
                logger.info("le chiffre " + tabSaisieAttaquant[i] + " est à la bonne place");
            }
        }
    }

    /**
     * cette fonction fait des sauts de lignes
     */
    public static void soutPln() {
        for (int i = 1; i < 25; i++) {
            System.out.println();
        }
    }

}