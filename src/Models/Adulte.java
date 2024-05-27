package Models;
import java.time.LocalDate;

public class Adulte extends Patient {

    private String diplome;
    private String profession;
    private String nTlph;

    public Adulte(String nom, String prenom, LocalDate dateDeNaissance, String lieuDeNaissance, String adresse,
            String diplome, String profession,String ntlphz) {
        super(nom, prenom, dateDeNaissance, lieuDeNaissance, adresse);
        this.diplome = diplome;
        this.profession = profession;
        this.nTlph=ntlphz;
    }


    public String getProfession() {
        return profession;
    }
    public String getnTlph() {
        return nTlph;
    }
    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public void setnTlph(String nTlph) {
        this.nTlph = nTlph;
    }
    
}
