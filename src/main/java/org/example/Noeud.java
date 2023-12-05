package org.example;

public class Noeud {
    private Ouvrage contenu; // Type spécifique à Ouvrage
    private Noeud suivant;     // Référence au prochain noeud
    private Noeud prec;     // Référence au précédent noeud

    // Constructeur par défaut
    public Noeud() {
        this.contenu = null;
        this.suivant = null;
        this.prec = null;
    }

    // Constructeur avec paramètre
    public Noeud(Ouvrage contenu, Noeud suivant, Noeud prec) {
        this.contenu = contenu;
        this.suivant = suivant;
        this.prec = prec;
    }

    // Constructeur de copie
    public Noeud(Noeud noeud) {
        this.contenu = noeud.contenu;
        this.suivant = noeud.suivant;
        this.prec = noeud.prec;
    }

    // Méthode pour obtenir le contenu
    public Ouvrage getContenu() {
        return contenu;
    }

    // Méthode pour obtenir le noeud suivant
    public Noeud getSuiv() {
        return suivant;
    }

    // Méthode pour obtenir le noeud précédent
    public Noeud getPrec() {
        return prec;
    }

    // Méthode pour modifier le contenu
    public void setContenu(Ouvrage contenu) {
        this.contenu = contenu;
    }

    // Méthode pour modifier le noeud suivant
    public void setSuiv(Noeud suivant) {
        this.suivant = suivant;
    }

    // Méthode pour modifier le noeud précédent
    public void setPrec(Noeud prec) {
        this.prec = prec;
    }

    // Méthode pour afficher le contenu
    public String toString() {
        return this.contenu.toString();
    }
}