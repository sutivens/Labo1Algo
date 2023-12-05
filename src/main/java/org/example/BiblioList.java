package org.example;

import java.util.LinkedList;

public class BiblioList extends Bibliotheque {
    private LinkedList<Ouvrage> listeOuvrages;

    public BiblioList() {
        this.listeOuvrages = new LinkedList<>();
    }

    public void ajouterOuvrage(Ouvrage ouvrage) {
        listeOuvrages.add(ouvrage);
    }

    public Ouvrage rechercherOuvrage(int cote) {
        for (int i = 0; i < listeOuvrages.size(); i++) {
            Ouvrage ouvrage = listeOuvrages.get(i);
            if (ouvrage != null && ouvrage.getCote() == cote) {
                return ouvrage;
            }
        }
        System.out.println("Ouvrage introuvable");
        return null;
    }

    public void supprimerOuvrage(int cote) {
        try {
            Ouvrage ouvrage = rechercherOuvrage(cote);
            if (ouvrage != null) {
                listeOuvrages.remove(ouvrage);
            }
        } catch (Exception e) {
            System.out.println("saisi non valide");
        }
    }

    public String toString() {
        String message = "Nombre d'ouvrages: " + listeOuvrages.size();

        for (int i = 0; i < listeOuvrages.size(); i++) {
            Ouvrage ouvrage = listeOuvrages.get(i);
            if (ouvrage != null) {
                message += ouvrage.toString();
            }
        }
        return message;
    }
}