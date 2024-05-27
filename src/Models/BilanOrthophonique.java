package Models;
import java.util.ArrayList;
import java.io.Serializable;


class BilanOrthophonique implements Serializable{
    private Patient patient;
    private Anamnese anamnese;
    private ArrayList<Epreuve> epreuves;
    private ArrayList<Diagnostic> diagnostics;
    private String projetTherapeutique;

    BilanOrthophonique(Patient patient) {
        this.patient = patient;
        this.epreuves = new ArrayList<>();
        this.diagnostics = new ArrayList<>();
        
    }
   

    public void setpatient(Patient patient){
        this.patient=patient;
    }
    public void setanamnese(Anamnese anamnese){
        this.anamnese=anamnese;
    }
    public ArrayList<Epreuve> getepreuves(){
       return epreuves;
    }
    public ArrayList<Diagnostic> getDiagnostic(){
        return diagnostics;
    }

    public void setprojetTherapeutique(String projetTherapeutique){
        this.projetTherapeutique=projetTherapeutique;
     }

    
    

}