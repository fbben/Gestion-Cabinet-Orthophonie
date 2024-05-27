package Models;
import java.util.ArrayList;
import java.io.Serializable;

public class Question implements Serializable{
    private String enonce;

    public Question(String ennoce) {
        this.enonce = ennoce;
    }


    public String getEnonce() {
        return enonce;
    }
}



/* ----------------------------------------------------------- */
class QEpreuves extends Question {
    private double score;

    QEpreuves(String ennoce) {
        super(ennoce);
    }

    public double getscore() {
        return score;
    }
}

class QuestionLibre extends QEpreuves {
    private String reponse;

    QuestionLibre(String enonce) {
        super(enonce);
    }
}

class QuestionChoix extends QEpreuves {
    protected ArrayList<String> choix;

    QuestionChoix(String enonce, ArrayList<String> choix) {
        super(enonce);
        this.choix = choix;
    }
}

class QuestionChoixMultiple extends QuestionChoix {
    private ArrayList<Integer> reponsesCorrectes;
    private ArrayList<Integer> reponses;

    QuestionChoixMultiple(String enonce, ArrayList<String> choix, ArrayList<Integer> reponsesCorrectes) {
        super(enonce, choix);
        this.reponsesCorrectes = reponsesCorrectes;
    }

    public int Correction(ArrayList<Integer> reponses, ArrayList<Integer> reponsesCorrectes) {
        if (reponses.equals(reponsesCorrectes) == true)
            return 10;
        else
            return 1;
        // Si l'utilisateur fait une seule erreur, il va etre noter 1 (cela peut être
        // amélioré).
    }

}

class QuestionChoixUnique extends QuestionChoix {
    private int reponseCorrecte;
    private int reponse;

    QuestionChoixUnique(String enonce, ArrayList<String> choix, int reponseCorrecte) {
        super(enonce, choix);
        this.reponseCorrecte = reponseCorrecte;
    }

    public int Correction(int reponse, int reponseCorrecte) {
        if (reponse == reponseCorrecte)
            return 10;
        else
            return 1;
        // Si l'utilisateur fait une seule erreur, il va etre noter 1 (cela peut être amélioré).
    }
}

enum Categorie {
    /* --------------Enfant-------------- */
    structure_familiale,
    dynamique_familiale,
    antécédents_familiaux,
    conditions_natales,
    développement_psychomoteur,
    développement_langagier,
    /* --------------Adulte -------------- */
    caractère_et_comportement,
    Histoire,
    Suivi_Médical,
}