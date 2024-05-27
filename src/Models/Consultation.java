package Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consultation extends RendezVous {
    private Patient patient;

    public Consultation(LocalDate date, LocalTime heure, String observation, Patient patient) {
        super(date, heure, TypeRendezVous.Consultation, 1.5, observation);
        this.patient = patient;
    }

}