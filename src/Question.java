class Question {
    private String enonce;

    Question(String ennoce) {
        this.enonce = enonce;
    }
}

class QAnamnese extends Question {
    private Categorie categorie;
    private String reponse;

    QAnamnese(String ennoce, Categorie categorie) {
        super(ennoce);
        this.categorie = categorie;
    }
}

/* ----------------------------------------------------------- */
class QEpreuves extends Question {
    private int note;

    QEpreuves(String ennoce, int note) {
        super(ennoce);
        this.note = note;
    }
}

class QuestionLibre extends QEpreuves {
    private String reponse;

    QuestionLibre(String enonce, int note) {
        super(enonce, note);
    }
}

class QuestionChoix extends QEpreuves {
    protected String[] choix;

    QuestionChoix(String enonce, int note, String[] choix) {
        super(enonce, note);
        this.choix = choix;
    }
}

class QuestionChoixMultiple extends QuestionChoix {
    private int[] reponsesCorrectes;
    private int[] reponses;

    QuestionChoixMultiple(String enonce, int note, String[] choix, int[] reponsesCorrectes) {
        super(enonce, note, choix);
        this.reponsesCorrectes = reponsesCorrectes;
    }
}

class QuestionChoixUnique extends QuestionChoix {
    private int reponseCorrecte;
    private int reponse;

    QuestionChoixUnique(String enonce, int note, String[] choix, int reponseCorrecte) {
        super(enonce, note, choix);
        this.reponseCorrecte = reponseCorrecte;
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