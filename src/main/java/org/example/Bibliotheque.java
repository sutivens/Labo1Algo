package org.example;

public abstract class Bibliotheque {

    public abstract void ajouterOuvrage(Ouvrage ouvrage);
    public abstract Ouvrage rechercherOuvrage(int cote);
    public abstract void supprimerOuvrage(int cote);
    public abstract String toString();
}
