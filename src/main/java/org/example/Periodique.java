package org.example;

public class Periodique extends Ouvrage {
    private String nom;
    private int numero;
    private String periodicite;

    public Periodique(String dateEmprunt, String nom, int numero, String periodicite) {
        super(dateEmprunt);
        this.nom = nom;
        this.numero = numero;
        this.periodicite = periodicite;
    }

    public String toString() {
        return "\nPÉRIODIQUE: "
                + "\nNom: " + this.nom
                + "\nNuméro: " + this.numero
                + "\nPeriodicité: " + this.periodicite
                + "\nDate d'emprunt: " + super.getDateEmprunt()
                + "\nCôte: " + getCote()
                + "\n";
    }
}
