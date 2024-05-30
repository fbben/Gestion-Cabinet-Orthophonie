package Models;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;




public class Orthophoniste implements Serializable{
    private String nom;
    private String Prenom;
    private String adress;
    private String nTlph;
    private String email;
    private String motDePasse;

    private List<Exercice> exercice;
    private Map<Integer, Dossier> dossiers;
    private ArrayList<Anamnese> Anamneses;

    public List<Exercice> getExercice() {
        return exercice;
    }

    
    public ArrayList<Anamnese> getAnamneses() {
        return Anamneses;
    }

    public void addAnamnese(Anamnese anamnese) {
        this.Anamneses.add(anamnese);
    }





    //private static final long serialVersionUID = 1L;
    private int lastDossierId = 0;

    

    public Orthophoniste(String nom, String Prenom, String adress, String nTlph, String mail, String motDePasse) {
        this.nom = nom;
        this.Prenom = Prenom;
        this.adress = adress;
        this.nTlph = nTlph;
        this.email = mail;
        this.motDePasse = motDePasse;
        this.dossiers = new HashMap<>();
        this.Anamneses = new ArrayList<>();
        this.exercice = new ArrayList<>();

    }
    public Orthophoniste(String nom,String motDePasse) {
        this.nom = nom;
        this.motDePasse=motDePasse;
        this.dossiers = new HashMap<>();
        this.Anamneses = new ArrayList<>();
        this.exercice = new ArrayList<>();


    }

    
   
    public String getNom() {
        
        return nom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void addDossier(Dossier dossier) {
        this.dossiers.put(dossier.getNDossier(), dossier);
    }

    



    public void ajouterRDV(int dossierId, RendezVous rdv) {
        if (Cheuvauchement(rdv)) {
            System.out.println("The new RDV overlaps with an existing RDV.");
            return;
        }

        Dossier dossier = dossiers.get(dossierId);
        if (dossier != null) {
            dossier.getRDVs().add(rdv);
        } else {
            System.out.println("Dossier with ID " + dossierId + " not found.");
        }
    }

    public Map<Integer, Dossier> getDossiers() {
        return dossiers;
    }

    public List<Dossier> getDossiersList() {
        return new ArrayList<>(dossiers.values());
    }

    public void creerDossier(Patient patient, RendezVous RDV) {
        if (Cheuvauchement(RDV)) {
            System.out.println("The new RDV overlaps with an existing RDV.");
            return;
        }

        int nextDossierId = lastDossierId + 1; // Calculate the next dossier ID
        if (!dossiers.containsKey(nextDossierId)) {
            Dossier newDossier = new Dossier(nextDossierId, patient);
            newDossier.getRDVs().add(RDV);
            dossiers.put(nextDossierId, newDossier);
            lastDossierId = nextDossierId; // Update the last assigned dossier ID
        } else {
            // If the calculated ID is already in use, find the next available ID
            while (dossiers.containsKey(nextDossierId)) {
                nextDossierId++;
            }
            Dossier newDossier = new Dossier(nextDossierId, patient);
            newDossier.getRDVs().add(RDV);
            dossiers.put(nextDossierId, newDossier);
            lastDossierId = nextDossierId; // Update the last assigned dossier ID
        }
    }

    public boolean Cheuvauchement(RendezVous newRDV) {
        for (Dossier dossier : dossiers.values()) {
            for (RendezVous existingRDV : dossier.getRDVs()) {
                if (newRDV.getDate().equals(existingRDV.getDate()) && 
                    newRDV.getHeure().equals(existingRDV.getHeure())) {
                    //System.out.println("truuuuuuue");
                    return true;
                
                }
            }
        }
        return false;
    }

    
}

