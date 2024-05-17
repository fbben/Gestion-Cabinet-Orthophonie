class BilanOrthophonique {
    private Patient patient;
    private Anamnese anamnese;
    private Epreuve[] epreuves;
    private Diagnostic[] diagnostics;
    private String projetTherapeutique;

    BilanOrthophonique(Patient patient, Anamnese anamnese, Epreuve[] epreuves, Diagnostic[] diagnostics,
        String projetTherapeutique) {
        this.patient = patient;
        this.anamnese = anamnese;
        this.epreuves = epreuves;
        this.diagnostics = diagnostics;
        this.projetTherapeutique = projetTherapeutique;
    }
    BilanOrthophonique(Patient patient, Epreuve[] epreuves, Diagnostic[] diagnostics,
        String projetTherapeutique) {
        this.patient = patient;
        this.epreuves = epreuves;
        this.diagnostics = diagnostics;
        this.projetTherapeutique = projetTherapeutique;
    }

}