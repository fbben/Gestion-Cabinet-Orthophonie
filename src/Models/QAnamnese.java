package Models;

public class QAnamnese extends Question {
    private String categorie;
    private String reponse;

    public QAnamnese(String ennoce, String categorie) {
        super(ennoce);
        this.categorie = categorie;
    }
  
}