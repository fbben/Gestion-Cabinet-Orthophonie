public class Orthophoniste {
    private String nom;
    private String Prenom;
    private String adress;
    private String nTlph;
    private String email;
    private String motDePasse;

    public void CreeCompte(String nom, String Prenom, String adress, String nTlph, String email, String motDePasse) {
        this.nom = nom;
        this.Prenom = Prenom;
        this.adress = adress;
        this.nTlph = nTlph;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public void Connecter() {
    }

    public void Deconnecter() {
    }

}
