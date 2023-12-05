package org.example;

public abstract class Ouvrage {
    private String dateEmprunt;
    private static int nombreOuvrages = 0; // "... (le numéro (1, 2, 3 …) par ordre de création)"
    private int cote;

    public Ouvrage(String dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
        cote = nombreOuvrages + 1;
        nombreOuvrages++;
    }

    public String getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(String dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public int getCote() {
        return cote;
    }
}
