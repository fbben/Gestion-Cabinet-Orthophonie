abstract class Patient {
    protected String nom;
    protected String prenom;
    protected String dateDeNaissance;
    protected String lieuDeNaissance;
    protected String adresse;

    Patient(String nom, String prenom, String dateDeNaissance, String lieuDeNaissance, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.lieuDeNaissance = lieuDeNaissance;
        this.adresse = adresse;

    }
}

class Enfant extends Patient {

    private String classe;
    private int[] nTlph;

    Enfant(String nom, String prenom, String dateDeNaissance, String lieuDeNaissance, String adresse, String classe,
            int[] nTlph) {
        super(nom, prenom, dateDeNaissance, lieuDeNaissance, adresse);
        this.classe = classe;
        this.nTlph = nTlph;
    }
}

class Adulte extends Patient {

    private String diplome;
    private String profession;

    Adulte(String nom, String prenom, String dateDeNaissance, String lieuDeNaissance, String adresse,
            String diplome, String profession) {
        super(nom, prenom, dateDeNaissance, lieuDeNaissance, adresse);
        this.diplome = diplome;
        this.profession = profession;
    }
}
