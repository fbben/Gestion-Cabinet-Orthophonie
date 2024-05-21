import java.util.ArrayList;

class Exercice {
    protected String consigne;
    protected String material;
    protected ArrayList<Double> score;

    public Exercice(String consigne, String material, ArrayList<Double> score) {
        this.consigne = consigne;
        this.material = material;
        this.score = score;
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
