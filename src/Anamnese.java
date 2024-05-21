import java.util.ArrayList;

abstract class Anamnese {
    private String titre;
    private String description;
    private ArrayList<QAnamnese> questions;

    Anamnese(String titre, String description, ArrayList<QAnamnese> questions) {
        this.titre = titre;
        this.description = description;
        this.questions = questions;
    }

}
