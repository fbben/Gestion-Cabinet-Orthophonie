import java.util.ArrayList;

abstract class Anamnese {
    private String titre;
    private String description;
    private ArrayList<QuestionAnamnese> questions;

    Anamnese(String titre, String description, ArrayList<QuestionAnamnese> questions) {
        this.titre = titre;
        this.description = description;
        this.questions = questions;
    }

}

class Question {
    private String ennonce;
    Question(String ennoce) {
        this.ennonce = ennonce;
    }
}

class QAdulte extends QuestionAnamnese {
    private boolean categorie; // 0: histoire, 1: suivi médical.

    QAdulte(String ennoce, boolean categorie) {
        super(ennoce);
        this.categorie = categorie;
    }
}

class QEnfant extends QuestionAnamnese {
    private CategorieEnfant categorie;

    QEnfant(String ennoce, CategorieEnfant categorie) {
        super(ennoce);
        this.categorie = categorie;
    }
}

enum CategorieEnfant {
    structure_familiale,
    dynamique_familiale,
    antécédents_familiaux,
    conditions_natales,
    développement_psychomoteur,
    développement_langagier,
    caractère_et_comportement,
}