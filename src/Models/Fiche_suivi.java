package Models;
import java.io.Serializable;
import java.util.*;


public class Fiche_suivi implements Serializable {
    
    private String title;
    private List<Objectif> objectifs;

    public Fiche_suivi(String title) {
        this.title = title;
        this.objectifs = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Objectif> getObjectifs() {
        return objectifs;
    }

    public void addObjectif(Objectif objectif) {
        objectifs.add(objectif);
    }
    
}




