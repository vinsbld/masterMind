package com.oc.mastermind;


import com.oc.mastermind.mastermind.ChallengerMaster;
import com.oc.mastermind.mastermind.DefenseurMaster;
import com.oc.mastermind.mastermind.DuelMaster;
import com.oc.mastermind.recherche.ChallengerRecherche;
import com.oc.mastermind.recherche.DefenseurRecherche;
import com.oc.mastermind.recherche.DuelRecherche;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * ceci est la Class Menu
 * on y retrouve tous les menus et sous menus des jeux
 */

public class Menu {

    static Scanner nb = new Scanner(System.in);
    
    public static Logger logger = LogManager.getLogger();

    /**
     * la methode MenuDemarrer est la méthode du Menu principal
     * permet à l'utilisateur de faire le choix entre deux jeux :
     * Recherche ou Mastermind
     */
    
    static void menuDemarrer() {

        Utils.etoileDecoration();
        System.out.println();
        System.out.println("*              MASTER MIND                    *");
        System.out.println();
        Utils.etoileDecoration();
        System.out.println("*          CHOISISSEZ VOTRE JEUX              *");
        Utils.etoileDecoration();
        System.out.println();
        System.out.println("* 1. Recherche +/-                            *");
        System.out.println("* 2. Mastermind                               *");
        System.out.println();
        Utils.etoileDecoration();
        System.out.print("* Pour choisir un jeu entrer 1 ou 2 : ");
        String saisieUtilisateurJeux = nb.nextLine();

        Utils.etoileDecoration();
        if (saisieUtilisateurJeux.equals("1")) {
            Utils.soutPln();
            menuModeDeJeuRecherchePlusMoins();
            logger.info("l'utilisateur a saisi : "+ saisieUtilisateurJeux +" l'utilisateur a choisi de jouer au jeu Recherche +/-");

        } else if (saisieUtilisateurJeux.equals("2")) {
            Utils.soutPln();
            menuModeDeJeuMaster();
            logger.info("l'utilisateur a saisi : "+ saisieUtilisateurJeux +" l'utilisateur a choisi de jouer au jeu Mastermind");

        } else {
            Utils.soutPln();
            Menu.menuDemarrer();
            logger.warn(saisieUtilisateurJeux +" n'est pas un choix valide, l'utilisateur retourne au menu principal");
        }
    }

    /**
     * Cette methode permet de choisir le mode de jeu pour le jeu Recherche
     * l'utilisateur a le choix entre trois modes :
     * Challenger, Défenseur et Duel
     */

   public static void menuModeDeJeuRecherchePlusMoins() {

        Utils.etoileDecoration();
        System.out.println("*         CHOISISSEZ UN MODE DE JEUX          *");
        Utils.etoileDecoration();
        System.out.println();
        System.out.println("1. Challenger");
        System.out.println("Le joueur joue contre l'ordinateur");
        System.out.println();
        System.out.println("2. Défenseur");
        System.out.println("L'ordinateur joue contre le joueur");
        System.out.println();
        System.out.println("3. Duel");
        System.out.println("Le joueur et l'ordinateur jouent à tour de rôle");
        System.out.println();
        Utils.etoileDecoration();
        System.out.println("Pour choisir un Mode entrer 1, 2 ou 3 : ");

        String saisieUtilisateurMode = nb.nextLine();

        if (saisieUtilisateurMode.equals("1")) {
            Utils.soutPln();
            ChallengerRecherche.algoChalengerRecherche();
            logger.info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Recherche +/- en mode challenger");


        }
        else if (saisieUtilisateurMode.equals("2")) {
            Utils.soutPln();
            DefenseurRecherche.algoDefenseurRecherche();
            logger.info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Recherche +/- en mode défenseur");
        }
        else if (saisieUtilisateurMode.equals("3")) {
            Utils.soutPln();
            DuelRecherche.algoDuelRecherche();
            logger.info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Recherche +/- en mode duel");
        }
        else {
            Utils.soutPln();
            Menu.menuModeDeJeuRecherchePlusMoins();
            logger.warn(saisieUtilisateurMode +" n'est pas un choix valide, l'utilisateur retourne au menu principal");

        }
    }

    /**
     * Cette methode permet de choisir le mode de jeu pour le jeu Mastermind
     * l'utilisateur a le choix entre trois modes :
     * Challenger, Défenseur et Duel
     */

   public static void menuModeDeJeuMaster() {

        Utils.soutPln();
        Utils.etoileDecoration();
        System.out.println("*         CHOISISSEZ UN MODE DE JEUX          *");
        Utils.etoileDecoration();
        System.out.println();
        System.out.println("1. Challenger");
        System.out.println("Le joueur joue contre l'ordinateur");
        System.out.println();
        System.out.println("2. Défenseur");
        System.out.println("L'ordinateur joue contre le joueur");
        System.out.println();
        System.out.println("3. Duel");
        System.out.println("Le joueur et l'ordinateur jouent à tour de rôle");
        System.out.println();
        Utils.etoileDecoration();
        System.out.println("Pour choisir un Mode entrer 1, 2 ou 3 : ");

        String saisieUtilisateurMode = nb.nextLine();

        if (saisieUtilisateurMode.equals("1")) {
            Utils.soutPln();
            ChallengerMaster.algoChallengerMaster();
            logger.info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Mastermind en mode challenger");

        }
        else if (saisieUtilisateurMode.equals("2")) {
            Utils.soutPln();
            DefenseurMaster.algoDefenseurMaster();
            logger.info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Mastermind en mode défenseur");

        }
        else if (saisieUtilisateurMode.equals("3")) {
            Utils.soutPln();
            DuelMaster.algoDuelMaster();
            logger.info("l'utilisateur veut jouer à Mastermind en mode duel");

        }
        else {
            Utils.soutPln();
            Menu.menuModeDeJeuMaster();
            logger.warn(saisieUtilisateurMode +" n'est pas un choix valide, l'utilisateur retourne au menu choix du mode de jeu");
        }
    }

    /**
     * Une fois le jeu terminé,
     * Cette methode permet à l'utilisateur de choisir si :
     * il veut rejouer au même jeu ou revenir au menu principal
     * si il choisi de rejouer au même jeu, il a alors le choix entre les modes de jeu
     * Challenger, Défenseur et Duel
     * ou bien propose au joueur de mettre fin au jeu
     */

   public static void menuFinRecherchePlusMoins() {

        Utils.hastagDecoration();
        System.out.println();
        System.out.println("Pour rejouer au même jeu tapez : 1");
        System.out.println();
        System.out.println("Pour revenir au menu principal tapez : 2");
        System.out.println();
        System.out.println("Pour quitter tapez : 3");
        System.out.println();
        Utils.etoileDecoration();
        System.out.println("Pour choisir un Mode entrer 1, 2 ou 3 : ");

        String sasisieUtilisateur = nb.nextLine();


        if (sasisieUtilisateur.equals("1")) {
            Utils.soutPln();
            Menu.menuModeDeJeuRecherchePlusMoins();
            logger.info("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur a choisi de rejouer au jeu Recherche +/-");


        } else if (sasisieUtilisateur.equals("2")) {
            Utils.soutPln();
            Menu.menuDemarrer();
            logger.info("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur a choisi de revenir au menu principal");


        } else if (sasisieUtilisateur.equals("3")) {
            Utils.hastagDecoration();
            System.out.println("                      FIN");
            Utils.hastagDecoration();
            logger.info("l'utilisateur a saisi "+ sasisieUtilisateur +"l'utilisateur a mis fin au jeu");


        } else {
            Utils.soutPln();
            Menu.menuFinRecherchePlusMoins();
            logger.warn(sasisieUtilisateur +" n'est pas un choix valide, l'utilisateur retourne au menu choix du mode de jeu");
        }
    }

    /**
     * Une fois le jeu terminé,
     * Cette methode permet à l'utilisateur de choisir si :
     * il veut rejouer au même jeu ou revenir au menu principal
     * si il choisi de rejouer au même jeu, il a alors le choix entre les modes de jeu
     * Challenger, Défenseur et Duel
     * ou bien propose au joueur de mettre fin au jeu
     */
   public static void menuFinMaster() {

        Utils.hastagDecoration();
        System.out.println();
        System.out.println("Pour rejouer au même jeu tapez : 1");
        System.out.println();
        System.out.println("Pour revenir au menu principal tapez : 2");
        System.out.println();
        System.out.println("Pour quitter tapez : 3");
        System.out.println();
        Utils.etoileDecoration();
        System.out.println("Pour choisir un Mode entrer 1, 2 ou 3 : ");

        String sasisieUtilisateur = nb.nextLine();


        if (sasisieUtilisateur.equals("1")) {
            Utils.soutPln();
            Menu.menuModeDeJeuMaster();
            logger.info("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur a choisi de rejouer au jeu Mastermind");


        } else if (sasisieUtilisateur.equals("2")) {
            Utils.soutPln();
            Menu.menuDemarrer();
            logger.info("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur a choisi de revenir au menu principal");


        } else if (sasisieUtilisateur.equals("3")) {
            Utils.hastagDecoration();
            System.out.println("                      FIN");
            Utils.hastagDecoration();
            logger.info("l'utilisateur a saisi "+ sasisieUtilisateur +"l'utilisateur a mis fin au jeu");


        } else {
            Utils.soutPln();
            Menu.menuFinMaster();
            logger.warn(sasisieUtilisateur +" n'est pas un choix valide, l'utilisateur retourne au menu choix du mode de jeu");
        }
    }

}