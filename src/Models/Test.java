package Models;
import java.util.ArrayList;

public class Test {
    protected String nom;
    protected String capacite;
    protected double scoreTotal;
    protected String conclusion;

    public Test(String nom, String capacite) {
        this.nom = nom;
        this.capacite = capacite;
    }

    public void SetScoreTotal(double scoreTotal) {
        this.scoreTotal = scoreTotal;
    }
}

class TQuestionnaires extends Test {
    private ArrayList<QEpreuves> questions;

    TQuestionnaires(String nom, String capacite) {
        super(nom, capacite);
        this.questions = new ArrayList<>();
    }

    public double CalculerScoreTotal() {
        double somme = 0;
        for (QEpreuves question : questions) {
            somme = question.getscore();
        }
        return (somme);
    }

    public ArrayList<QEpreuves> getquestions(){
        return questions;
    }
}

class TExercice extends Test {
    private ArrayList<Exercice> exercices;

    TExercice(String nom, String capacite) {
        super(nom, capacite);
        this.exercices = new ArrayList<>();
        
    }

    public double CalculerScoreTotal() {
        double somme = 0;
        for (Exercice exercice : exercices) {
            somme = exercice.getScoreMoyen();
        }
        return (somme);
    }
   

    public ArrayList<Exercice> getexercices(){
        return exercices;
    }

}
