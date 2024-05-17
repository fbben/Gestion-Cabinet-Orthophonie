abstract class RendezVous {
    protected double date;
    protected double heure;
    protected TypeRendezVous type;
    protected double duree;
    protected String observation;

    RendezVous(double date, double heure, TypeRendezVous type, double duree, String observation) {
        this.date = date;
        this.heure = heure;
        this.type = type;
        this.duree = duree;
        this.observation = observation;
    }
    
    
}

class Consultation extends RendezVous {
    private Patient patient;

    Consultation(double date, double heure, TypeRendezVous type, String observation, Patient patient) {
        super(date, heure, TypeRendezVous.Consultation, 1.5, observation);
        this.patient = patient;
    }

}

class Suivi extends RendezVous {
    private int nDossier;
    private boolean deroulement; // Presentiel: 0. En-ligne: 1.

    Suivi(double date, double heure, TypeRendezVous type, String observation, int nDossier, boolean deroulement) {
        super(date, heure, TypeRendezVous.Suivi, 1, observation);
        this.nDossier = nDossier;
        this.deroulement = deroulement;
    }

}

class Atelier extends RendezVous {
    private int[] listePatients; //Les numeros de dossiers des patients.
    private String thematique;

    Atelier(double date, double heure, TypeRendezVous type, String observation, int[] listePatients,
            String thematique) {
        super(date, heure, TypeRendezVous.Atelier, 1, observation);
        this.listePatients = listePatients;
        this.thematique = thematique;
    }
}

enum TypeRendezVous {
    Consultation,
    Suivi,
    Atelier,
}
