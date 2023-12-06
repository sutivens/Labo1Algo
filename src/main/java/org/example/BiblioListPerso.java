package org.example;

public class BiblioListPerso extends Bibliotheque {
    private ListeChainee listeOuvrages;

    public BiblioListPerso() {
        this.listeOuvrages = new ListeChainee();
    }

    public void ajouterOuvrage(Ouvrage ouvrage) {
        listeOuvrages.ajouterFin(ouvrage);
    }

    public Ouvrage rechercherOuvrage(int cote) {
        return listeOuvrages.rechercherOuvrage(cote);
    }


    public void supprimerOuvrage(int cote) {
        try {
            Ouvrage ouvrage = rechercherOuvrage(cote);
            if (ouvrage != null) {
                listeOuvrages.supprimerOuvrage(cote);
                System.out.println("Supprimé!\n");
            } else {
                System.out.println("Erreur! Ouvrage introuvable.\n");
            }
        } catch (Exception e) {
            System.out.println("Saisi non valide");
        }
    }

    public String toString() {
        String message = "Nombre d'ouvrages: " + listeOuvrages.getCptNoeuds() + "\n";

        Noeud tmp = listeOuvrages.getTete();
        while (tmp != null) {
            message += tmp.getContenu().toString() + "\n";
            tmp = tmp.getSuiv();
        }
        return message;
    }

}
