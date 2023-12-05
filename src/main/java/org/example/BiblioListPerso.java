package org.example;

public class BiblioListPerso extends Bibliotheque {
    private ListeChainee listeOuvrages;

    public BiblioListPerso() {
        this.listeOuvrages = new ListeChainee();
    }

    public void ajouterOuvrage(Ouvrage ouvrage) {
        listeOuvrages.ajouterFin(ouvrage);
        System.out.println("Ouvrage ajouté!\n");
    }

    public Ouvrage rechercherOuvrage(int cote) {
        Ouvrage ouvrage = listeOuvrages.rechercherOuvrage(cote);

        if (ouvrage != null) {
            System.out.println(listeOuvrages.toString());
        }
        return ouvrage;
    }


    public void supprimerOuvrage(int cote) {
        try {
            Ouvrage ouvrage = rechercherOuvrage(cote);
            if (ouvrage != null) {
                listeOuvrages.supprimerPosition(cote);
            }
        } catch (Exception e) {
            System.out.println("saisi non valide");
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
