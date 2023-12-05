package org.example;

public class Livre extends Ouvrage {
    private String auteur;
    private String titre;
    private String editeur;

    public Livre(String dateEmprunt, String auteur, String titre, String editeur) {
        super(dateEmprunt);
        this.auteur = auteur;
        this.titre = titre;
        this.editeur = editeur;
    }

    public String toString() {
        return "\nLIVRE: "
                + "\nAuteur: " + this.auteur
                + "\nTitre: " + this.titre
                + "\nÉditeur: " + this.editeur
                + "\nDate d'emprunt: " + super.getDateEmprunt()
                + "\nCôte: " + getCote()
                + "\n";
    }
}
