package Models;
import java.util.ArrayList;
import java.io.Serializable;


public class Exercice implements Serializable{
    protected String consigne;
    protected String material;
    protected ArrayList<Double> score;

    public Exercice(String consigne, String material) {
        this.consigne = consigne;
        this.material = material;
        this.score = new ArrayList<>();
    }

    public double CalculerScoreMoyen() {
        double somme = 0;
        for (double note : score) {
            somme = +note;
        }
        return (somme / score.size());
    }

    public double getScoreMoyen() {
        return CalculerScoreMoyen();
    }
} 