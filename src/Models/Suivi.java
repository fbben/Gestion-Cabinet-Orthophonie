package Models;
import java.time.LocalDate;
import java.time.LocalTime;

public class Suivi extends RendezVous {
    private int nDossier;
    private boolean deroulement; // Presentiel: 0. En-ligne: 1.

    public Suivi(LocalDate date, LocalTime heure, String observation, int nDossier, boolean deroulement) {
        super(date, heure, TypeRendezVous.Suivi, 1, observation);
        this.nDossier = nDossier;
        this.deroulement = deroulement;
    }


    public int getnDossier() {
        return nDossier;
    }

}