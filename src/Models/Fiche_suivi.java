package Models;
import java.io.Serializable;
import java.util.*;


public class Fiche_suivi implements Serializable {
    
    private LinkedList<Objectif> objectifs;
    
}



class Objectif{
    private String nom;
    private String type;
    private int note;

}
