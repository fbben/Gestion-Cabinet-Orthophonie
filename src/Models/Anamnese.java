package Models;
import java.util.ArrayList;
import java.io.Serializable;

public class Anamnese implements Serializable{
    private String titre;
    private String description;
    private ArrayList<QAnamnese> questions;

    public Anamnese(String titre, String description) {
        this.titre = titre;
        this.description = description;
        this.questions = new ArrayList<>();
    }
   
   

    public ArrayList<QAnamnese> getquestioAnamneses(){
        return questions;
    }



    public String getTitre() {
        return titre;
    }



  public String getDescription() {
      return description;
  }

}
