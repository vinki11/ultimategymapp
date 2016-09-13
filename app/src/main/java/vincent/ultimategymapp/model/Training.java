package vincent.ultimategymapp.model;

import java.io.Serializable;

/**
 * Created by Vincent on 2016-09-06.
 */
public class Training implements Serializable {

    private final static long NO_ID_YET = -1;

    private long id = NO_ID_YET;
    private String nom;
    private long nb_semaine, actif;
    public boolean selected = false;

    public Training() {

    }

    public Training(long id, String nom, long nb_semaine, long actif) {
        this.id = id;
        this.nom = nom;
        this.nb_semaine = nb_semaine;
        this.actif = actif;
    }

    //Getters et setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getNb_semaine() {
        return nb_semaine;
    }

    public void setNb_semaine(long nb_semaine) {
        this.nb_semaine = nb_semaine;
    }

    public long getActif() {
        return actif;
    }

    public void setActif(long actif) {
        this.actif = actif;
    }
}
