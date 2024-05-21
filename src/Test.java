import java.util.ArrayList;

class Test {
    protected String nom;
    protected String capacite;
    protected String conclusion;

    Test(String nom, String capacite) {
        this.nom = nom;
        this.capacite = capacite;
    }
}

class TQuestionnaires extends Test {
    private ArrayList<QEpreuves> questions;

    TQuestionnaires(String nom, String capacite, ArrayList<QEpreuves> questions) {
        super(nom, capacite);
        this.questions = questions;
    }
}

class TExercice extends Test {
    private ArrayList<Exercice> questions;

    TExercice(String nom, String capacite, ArrayList<Exercice> questions) {
        super(nom, capacite);
        this.questions = questions;
    }

}
