package org.example;

public class BiblioTab extends Bibliotheque {
    private Ouvrage[] listeOuvrages;
    private int idx = 0; // Nombre d'objets présent dans le tableau
    private final int DIM = 20;

    public BiblioTab() {
        this.listeOuvrages = new Ouvrage[DIM];
    }

    public void ajouterOuvrage(Ouvrage ouvrage) {
        if (idx >= DIM) {
            System.out.println("Erreur! Le tableau est rempli.\n");
        } else {
            listeOuvrages[idx] = ouvrage;
            idx++;
        }
    }

    public Ouvrage rechercherOuvrage(int cote) {
        for (int i = 0; i < listeOuvrages.length; i++) {
            if (listeOuvrages[i] != null && listeOuvrages[i].getCote() == cote) {
                return listeOuvrages[i];
            }
        }
        System.out.println("Erreur! Ouvrage introuvable.\n");
        return null;
    }

    public void supprimerOuvrage(int cote) {
        try {
            Ouvrage ouvrage = rechercherOuvrage(cote); // Si on ne trouve pas d'ouvrages, ça retourne null, alors il faut prévenir l'extraction du côte lorsque l'objet en question est nul, sinon ça génère une exception
            if (ouvrage != null) {
                int idxPourSupprimer = ouvrage.getCote();

                // Le for loop ne s'exécute pas si la ligne précédente génère une exception
                for (int i = idxPourSupprimer; i < listeOuvrages.length - 1; i++) {
                    listeOuvrages[i] = listeOuvrages[i + 1];
                }
                idx--;
            }
        } catch (Exception e) {
            System.out.println("Erreur! Vous n'avez pas entré un nombre ou chiffres valides.\n");
        }
    }

    public String toString() {
        String message = "Nombre d'ouvrages: " + idx + "\n";

        for (int i = 0; i < listeOuvrages.length; i++) {
            if (listeOuvrages[i] != null) {
                message += listeOuvrages[i].toString();
            }
        }
        return message;
    }
}
