package Models;
import java.io.Serializable;
import java.time.LocalDate;

public abstract class Patient implements Serializable {
    protected String nom;
    protected String prenom;
    protected LocalDate dateDeNaissance;
    protected String lieuDeNaissance;
    protected String adresse;



    
    Patient(String nom, String prenom, LocalDate dateDeNaissance, String lieuDeNaissance, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.lieuDeNaissance = lieuDeNaissance;
        this.adresse = adresse;

    }


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }
    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }
    public String getLieuDeNaissance() {
        return lieuDeNaissance;
    }
    public void setadresse(String text) {
        this.adresse=text;
     }

}



