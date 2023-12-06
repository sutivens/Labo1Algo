package org.example;

import java.util.*;

public class GestionBibliothequeTab {
    public static void main(String[] args) {
        boolean fin = false;
        BiblioTab bibliotab = new BiblioTab();

        bibliotab.ajouterOuvrage(new Livre("01/01/2023", "Auteur du livre", "Titre du livre", "Éditeur du livre"));
        bibliotab.ajouterOuvrage(new CD("02/02/2023", "Titre du CD", "Auteur du CD"));
        bibliotab.ajouterOuvrage(new Periodique("03/03/2023", "Nom", 1, "Mensuel"));

        while (!fin) {
            String choix = afficherMenu();

            switch (choix) {
                case "1":
                    // Afficher le contenu de la biblio
                    System.out.println("\n" + bibliotab);
                    break;
                case "2":
                    // Rechercher par côte
                    afficherRecherche(bibliotab);
                    break;
                case "3":
                    // Ajouter un ouvrage
                    menuAjouter(bibliotab);
                    break;
                case "4":
                    // Supprimer un ouvrage
                    menuSupprimer(bibliotab);
                    break;
                case "0":
                    // Quitter
                    System.out.println("Merci d'avoir utilisé notre application.");
                    fin = true;
                    break;
                default:
                    System.out.println("Erreur! Choix invalide.");
            }

        }
    }

    public static String afficherMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("BiblioTab");
        System.out.println("1: Afficher");
        System.out.println("2: Rechercher");
        System.out.println("3: Ajouter");
        System.out.println("4: Supprimer");
        System.out.println("0: Quitter");
        System.out.print("Faites votre choix: ");

        return scanner.nextLine();
    }

    public static void afficherRecherche(BiblioTab bibliotab) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Entrez la côte: ");
            int coteSaisi = Integer.parseInt(scanner.nextLine());
            Ouvrage ouvrage = bibliotab.rechercherOuvrage(coteSaisi);
            if (ouvrage != null) {
                System.out.println(ouvrage);
            }
        } catch (Exception e) {
            System.out.println("Erreur! Vous n'avez pas entré un nombre ou chiffres valides.\n");
        }
    }

    public static void menuAjouter(BiblioTab bibliotab) {
        Scanner scanner = new Scanner(System.in);
        Ouvrage ouvrage = null;
        String dateEmprunt, auteur, titre, editeur, nom, periodicite;
        int numero;

        System.out.print("Type d'ouvrage (Livre, CD ou Periodique): ");
        String typeOuvrage = scanner.nextLine();

        if (typeOuvrage.equalsIgnoreCase("Livre")) {
            System.out.print("Auteur: ");
            auteur = scanner.nextLine();
            System.out.print("Titre: ");
            titre = scanner.nextLine();
            System.out.print("Editeur: ");
            editeur = scanner.nextLine();
            ouvrage = new Livre("N/A", auteur, titre, editeur);
        } else if (typeOuvrage.equalsIgnoreCase("CD")) {
            System.out.print("Titre: ");
            titre = scanner.nextLine();
            System.out.print("Auteur: ");
            auteur = scanner.nextLine();
            ouvrage = new CD("N/A", titre, auteur);
        } else if (typeOuvrage.equalsIgnoreCase("Periodique")) {
            System.out.print("Nom: ");
            nom = scanner.nextLine();
            System.out.print("Numéro: ");
            try {
                numero = Integer.parseInt(scanner.nextLine());
                System.out.print("Periodicité (Hebdomadaire, Mensuel ou Annuel): ");
                periodicite = scanner.nextLine();
                if (periodicite.equalsIgnoreCase("Hebdomadaire") || periodicite.equalsIgnoreCase("Mensuel") || periodicite.equalsIgnoreCase("Annuel")) {
                    ouvrage = new Periodique("N/A", nom, numero, periodicite);
                } else {
                    System.out.println("Erreur! Vous n'avez pas saisi une periodicité valide.\n");
                }
            } catch (Exception e) {
                System.out.println("Erreur! Vous n'avez pas entré un nombre ou chiffres valides.\n");
            }
        } else {
            System.out.println("Erreur! Type d'ouvrage saisi invalide.\n");
        }

        if (ouvrage != null) {
            bibliotab.ajouterOuvrage(ouvrage);
            System.out.println("Ouvrage ajouté!\n");
        }
    }

    public static void menuSupprimer(BiblioTab biblioTab) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Veuillez saisir la côte de l'ouvrage à supprimer: ");
        try {
            int coteSaisi = Integer.parseInt(scanner.nextLine());
            biblioTab.supprimerOuvrage(coteSaisi);
        } catch (Exception e) {
            System.out.println("Erreur! Vous n'avez pas entré un nombre ou chiffres valides.\n");
        }
    }
}
