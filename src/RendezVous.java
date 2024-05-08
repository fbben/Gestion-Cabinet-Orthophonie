abstract class RendezVous {
    protected double date;
    protected double heure;
    protected TypeRendezVous type;
    protected double duree;

    RendezVous(double date, double heure, TypeRendezVous type, double duree) {
        this.date = date;
        this.heure = heure;
        this.type = type;
        this.duree = duree;
    }
}

class Consultation extends RendezVous {
    private Patient patient;

    Consultation(double date, double heure, TypeRendezVous type, double duree, Patient patient) {
        super(date, heure, TypeRendezVous.Consultation, duree);
        this.patient = patient;
    }

}

class Suivi extends RendezVous {
    private int nDossier;
    private boolean type; // Presentiel: 0. En-ligne: 1.

    Suivi(double date, double heure, TypeRendezVous type, double duree, int nDossier, boolean type) {
        super(date, heure, TypeRendezVous.Suivi, duree);
        this.nDossier = nDossier;
        this.type = type;
    }

}

class Atelier extends RendezVous {
    private Patient[] listePatients;
    private String theme;

   Atelier (double date, double heure, TypeRendezVous type, double duree, Patient listePatients, String theme){
   super(date, heure, TypeRendezVous.Atelier, duree);
   this.listePatients = listePatients;
   this.theme = theme;
   }
}

enum TypeRendezVous {
    Consultation,
    Suivi,
    Atelier,
}
