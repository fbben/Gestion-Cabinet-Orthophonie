package Models;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class RendezVous implements Serializable{
    protected LocalDate date;
    protected LocalTime heure;
    protected TypeRendezVous type;
    protected double duree;
    protected String observation;

    RendezVous(LocalDate date, LocalTime heure, TypeRendezVous type, double duree, String observation) {
        this.date = date;
        this.heure = heure;
        this.type = type;
        this.duree = duree;
        this.observation = observation;
    }

    public LocalDate getDate() {
        return date;
    }
    public String getObservation() {
        return observation;
    }
    public TypeRendezVous getType() {
        return type;
    }
 
    public double getDuree() {
        return duree;
    }

    public LocalTime getHeure() {
        return heure;
    }
    
}





class Atelier extends RendezVous {
    private int[] listePatients; //Les numeros de dossiers des patients.
    private String thematique;

    Atelier(LocalDate date, LocalTime heure, TypeRendezVous type, String observation, int[] listePatients,
            String thematique) {
        super(date, heure, TypeRendezVous.Atelier, 1, observation);
        this.listePatients = listePatients;
        this.thematique = thematique;
    }
}


