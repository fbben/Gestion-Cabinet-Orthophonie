import java.util.ArrayList;

class Epreuve {
    protected String observation;
    protected Test test;
}

class Test {
    protected String nom;
    protected String capacite;
}

class TQuestionnaires extends Test {
    private ArrayList<QuestionEpreuve> questions;
}

class TExercices extends Test {
    private ArrayList<QuestionEpreuve> questions;

}
