package Models;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


public class Dossier implements Serializable {
    private int nDossier;
    private Patient patient;
    private ArrayList <BilanOrthophonique> BOs;
    private ArrayList <RendezVous> RDVs;
    private List<Fiche_suivi> fichesSuivi;
    //la fiche.
 
    public Dossier(int nDossier, Patient patient) {
        this.nDossier = nDossier;
        this.patient = patient;
        this.BOs = new ArrayList<>();
        this.RDVs = new ArrayList<>();
        this.fichesSuivi = new ArrayList<>();
    }
    
    public void setpatient(Patient patient){
        this.patient=patient;
    }

    

    public int getNDossier() {
        return nDossier;
    }

    public Patient getpatient(){
        return patient;
    }

    public ArrayList <RendezVous> getRDVs(){
        return RDVs;
    }

    public ArrayList <BilanOrthophonique> getBOs(){
        return BOs;
    }
   
    public void afficher(){
        System.out.println(patient.nom);
        
    }

    public String getPatientNom() {
        return patient.getNom();
    }

    public String getPatientPrenom() {
        return patient.getPrenom();
    }

    public List<Fiche_suivi> getFichesSuivi() {
        return fichesSuivi;
    }

    public void addFicheSuivi(Fiche_suivi ficheSuivi) {
        this.fichesSuivi.add(ficheSuivi);
    }

}
