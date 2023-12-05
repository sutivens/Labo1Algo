package org.example;

public class ListeChainee {
    private Noeud tete;
    private Noeud queue;
    private int cptNoeuds;

    //Constructeur par défaut
    public ListeChainee() {
        this.tete = null;
        this.queue = null;
        this.cptNoeuds = 0;
    }
    //Constructeur avec paramètre
    public ListeChainee(Noeud tete, Noeud queue, int cptNoeuds) {
        this.tete = tete;
        this.queue = queue;
        this.cptNoeuds = cptNoeuds;
    }
    //Constructeur de copie
    public ListeChainee(ListeChainee descripteur) {
        this.tete = descripteur.tete;
        this.queue = descripteur.queue;
        this.cptNoeuds = descripteur.cptNoeuds;
    }
    //Méthode pour obtenir la tête
    public Noeud getTete() {
        return tete;
    }
    //Méthode pour obtenir la queue
    public Noeud getQueue() {
        return queue;
    }
    //Méthode pour obtenir le nombre de noeuds
    public int getCptNoeuds() {
        return cptNoeuds;
    }
    //Méthode pour modifier la tête
    public void setTete(Noeud tete) {
        this.tete = tete;
    }
    //Méthode pour modifier la queue
    public void setQueue(Noeud queue) {
        this.queue = queue;
    }
    //Méthode pour modifier le nombre de noeuds
    public void setCptNoeuds(int cptNoeuds) {
        this.cptNoeuds = cptNoeuds;
    }
    //Méthode pour ajouter un noeud à la fin de la liste
    public void ajouterFin(Ouvrage contenu) {
        Noeud noeud = new Noeud(contenu, null, null);
        if (this.tete == null) {
            this.tete = noeud;
            this.queue = noeud;
        } else {
            this.queue.setSuiv(noeud);
            noeud.setPrec(this.queue);
            this.queue = noeud;
        }
        this.cptNoeuds++;
    }
    //Méthode pour ajouter un noeud au début de la liste
    public void ajouterDebut(Ouvrage contenu) {
        Noeud noeud = new Noeud(contenu, null, null);
        if (this.tete == null) {
            this.tete = noeud;
            this.queue = noeud;
        } else {
            this.tete.setPrec(noeud);
            noeud.setSuiv(this.tete);
            this.tete = noeud;
        }
        this.cptNoeuds++;
    }
    //Méthode pour ajouter un noeud à une position donnée
    public void ajouterPosition(Ouvrage contenu, int position) {
        Noeud noeud = new Noeud(contenu, null, null);
        if (position == 0) {
            ajouterDebut(contenu);
        } else if (position == this.cptNoeuds) {
            ajouterFin(contenu);
        } else if (position > 0 && position < this.cptNoeuds) {
            Noeud tmp = this.tete;
            // Trouver où est le  noeud à la place position
            // tmp va référencer ce noeud
            for (int i = 0; i < position; i++) { // Instruction baromètre
                tmp = tmp.getSuiv();
            }
            // Insérer le nouveau noeud à cette position référencée par tmp
            noeud.setSuiv(tmp);
            noeud.setPrec(tmp.getPrec());
            tmp.getPrec().setSuiv(noeud);
            tmp.setPrec(noeud);
            this.cptNoeuds++;
        } else {
            System.out.println("Position invalide");
        }

    }

    public void supprimerDebut() {
        if (this.tete == null) {
            System.out.println("Liste vide");
        } else if (this.tete == this.queue) {
            this.tete = null;
            this.queue = null;
            this.cptNoeuds--;
        } else {
            this.tete = this.tete.getSuiv();
            this.tete.setPrec(null);
            this.cptNoeuds--;
        }
    }

    public void supprimerFin() {
        if (this.tete == null) {
            System.out.println("Liste vide");
        } else if (this.tete == this.queue) {
            this.tete = null;
            this.queue = null;
            this.cptNoeuds--;
        } else {
            this.queue = this.queue.getPrec();
            this.queue.setSuiv(null);
            this.cptNoeuds--;
        }
    }

    //Méthode pour supprimer un noeud à une position donnée
    public void supprimerPosition(int position) {
        if (position == 0) {
            supprimerDebut();
        } else if (position == this.cptNoeuds - 1) {
            supprimerFin();
        } else if (position > 0 && position < this.cptNoeuds - 1) {
            Noeud tmp = this.tete;
            // Trouver où est le  noeud à la place position
            // tmp va référencer ce noeud
            for (int i = 0; i < position; i++) {
                tmp = tmp.getSuiv();
            }
            // Supprimer le noeud à cette position référencée par tmp
            tmp.getPrec().setSuiv(tmp.getSuiv());
            tmp.getSuiv().setPrec(tmp.getPrec());
            this.cptNoeuds--;
        } else {
            System.out.println("Position invalide");
        }
    }
    //Méthode pour afficher la liste
    public void afficher() {
        Noeud tmp = this.tete;
        while (tmp != null) {
            System.out.println(tmp.getContenu().toString());
            tmp = tmp.getSuiv();
        }
    }
    //Méthode pour afficher la liste en sens inverse
    public void afficherInverse() {
        Noeud tmp = this.queue;
        while (tmp != null) {
            System.out.println(tmp.getContenu().toString());
            tmp = tmp.getPrec();
        }
    }

    //Méthode pour rechercher un Ouvrage par la cote
    public Ouvrage rechercherOuvrage(int cote) {
        Noeud tmp = this.tete;
        for (int i = 0; i < cptNoeuds; i++) {
           if (tmp.getContenu().getCote() == cote){
               return tmp.getContenu();
           } else {
               tmp = tmp.getSuiv();
           }
        }
        return null;
    }

    public void supprimerOuvrage(int cote) {
        Noeud tmp = this.tete;

        while (tmp != null) {
            if (tmp.getContenu().getCote() == cote) {
                if (tmp == this.tete) {
                    supprimerDebut();
                } else if (tmp == this.queue) {
                    supprimerFin();
                } else {
                    tmp.getPrec().setSuiv(tmp.getSuiv());
                    tmp.getSuiv().setPrec(tmp.getPrec());
                    this.cptNoeuds--;
                }
                return;
            }
            tmp = tmp.getSuiv();
        }
        System.out.println("Erreur! Ouvrage introuvable.");
    }

}
