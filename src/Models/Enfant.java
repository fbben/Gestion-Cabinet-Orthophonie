package Models;

import java.time.LocalDate;

public class Enfant extends Patient  {

    private String classe;
    private String[] nTlph;

    public Enfant(String nom, String prenom, LocalDate dateDeNaissance, String lieuDeNaissance, String adresse, String classe,
    String[] nTlph) {
        super(nom, prenom, dateDeNaissance, lieuDeNaissance, adresse);
        this.classe = classe;
        this.nTlph = nTlph;
    }


    public String getClasse() {
        return classe;
    }
    public String[] getnTlph() {
        return nTlph;
    }


    public void setClasse(String text) {
        this.classe=text;
    }


    
}