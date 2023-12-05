package org.example;

public class CD extends Ouvrage {
    private String titre;
    private String auteur;

    public CD(String dateEmprunt, String titre, String auteur) {
        super(dateEmprunt);
        this.titre = titre;
        this.auteur = auteur;
    }

    public String toString() {
        return "\nCD: "
                + "\nTitre: " + this.titre
                + "\nAuteur: " + this.auteur
                + "\nDate d'emprunt: " + super.getDateEmprunt()
                + "\nCôte: " + getCote()
                + "\n";
    }
}
