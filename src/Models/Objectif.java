package Models;

public class Objectif{
    private String objectif;
    private String term;
    private int note;


    public Objectif(String objectif, int note, String term) {
        this.objectif = objectif;
        this.note = note;
        this.term = term;
    }

    public String getObjectif() {
        return objectif;
    }

    public int getNote() {
        return note;
    }

    public String getTerm() {
        return term;
    }


}