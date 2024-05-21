public class Diagnostic {
    private String nomTrouble;
    private CategorieTrouble categorie;

    Diagnostic(String nomTrouble, CategorieTrouble categorie) {
        this.nomTrouble = nomTrouble;
        this.categorie = categorie;
    }
}

enum CategorieTrouble {
    déglutition,
    neuro_développementau,
    cognitifs,
}
