package Controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.ResourceBundle;

import Models.*;
import javafx.scene.Node;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Cenfant implements Initializable {

    @FXML
    private TextField adresse;

    @FXML
    private TextField classe;

    @FXML
    private DatePicker date;

    @FXML
    private TextField lieu_naissance;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private Button retour;

    @FXML
    private Spinner<Integer> heure;

    @FXML
    private TextField tlphm;

    @FXML
    private Spinner<Integer> minutes;

    @FXML
    private TextField tlphp;

    @FXML
    private Button valider;

    private LocalDate dateRDV;
    String observation;
    int heureRDV;
    int minutesRDV;

    public void initData(LocalDate selectedDate, String selectedobservation, int heure, int minutes) {
        this.dateRDV = selectedDate;
        this.observation = selectedobservation;
        this.heureRDV = heure;
        this.minutesRDV = minutes;
    }

    @FXML
    void Duree(ActionEvent event) {

    }

    @FXML
    void Valider(ActionEvent event) {

        System.out.println("here1");
        String nom = this.nom.getText();
        String prenom = this.prenom.getText();
        String tlphm = this.tlphm.getText();
        String tlphp = this.tlphm.getText();

        if (!nom.matches("[a-zA-Z]+") || !prenom.matches("[a-zA-Z]+")) {
            showAlert("Error", "Veuillez saisir des caractères alphabétiques pour le nom et le prénom.");
            return; // Exit the method if either nom or prenom contains non-alphabetic characters
        }

        LocalDate date_naissance = this.date.getValue();
        String adresse = this.adresse.getText();
        String classe = this.classe.getText();

        String lieu_naissance = this.lieu_naissance.getText();

        LocalDate Rdv = this.dateRDV;
        String observation = this.observation;

        if (!validateInput(nom, "nom") || !validateInput(prenom, "prenom") || date_naissance == null ||
                !validateInput(adresse, "adresse") || !validateInput(classe, "classe") ||
                !validateInput(lieu_naissance, "lieu de naissance")) {
            return; // Exit the method if any input is invalid
        }
        if (!validateNumericInput(tlphm, "tlphm") || !validateNumericInput(tlphp, "tlphp")) {
            return; // Sortie de la méthode si tlphm ou tlphp ne contient pas des caractères
                    // numériques
        }

        if (heure.getValue() != 2 || minutes.getValue() != 30) {
            showAlert("Error", "La durée doit être de 2 heure et 30 minutes.");
            return; // Exit the method if the duration is incorrect
        }
        System.out.println("Nom: " + nom);
        System.out.println("Prenom: " + prenom);
        System.out.println("Date de naissance: " + date_naissance);
        System.out.println("Adresse: " + adresse);
        System.out.println("Classe: " + classe);

        System.out.println("Lieu de naissance: " + lieu_naissance);

        System.out.println("Rdv: " + Rdv);
        System.out.println("observation: " + observation);
        Orthophoniste currentUser = SessionManager.getInstance().getCurrentUser();
        currentUser.getDossiers();

        try {

            String[] combinedArray = { "078212", "0912812" };
            Enfant newPatient = new Enfant(nom, prenom, date_naissance, lieu_naissance, adresse, classe, combinedArray);
            System.out.println("New patient created: " + newPatient);

            LocalTime skl = LocalTime.of(heureRDV, minutesRDV); // For example, 9:00 AM
            Consultation newRDV = new Consultation(dateRDV, skl, observation, newPatient);
            System.out.println("New RDV created: " + newRDV);

            if (currentUser.Cheuvauchement(newRDV)) {
                showAlert("Error", "Le nouveau rendez-vous chevauche un rendez-vous existant.");
                return;
            }

            currentUser = SessionManager.getInstance().getCurrentUser();
            currentUser.creerDossier(newPatient, newRDV);
            System.out.println(currentUser.getDossiers());

            showAlert("RDV", "Votre rendez-vous a été enregistré avec succès.");
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Informations invalides.");
        }

    }

    @FXML
    void retour(ActionEvent event) {
        try {
            Parent ajouterRDVRoot = FXMLLoader.load(getClass().getResource("/Fxmlfiles/AjouterRDV.fxml"));
            Scene ajouterRDVScene = new Scene(ajouterRDVRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(ajouterRDVScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 4, 0);
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);

        // valueFactory.setValue(null);
        heure.setValueFactory(valueFactory1);
        minutes.setValueFactory(valueFactory2);

    }

    private boolean validateInput(String input, String fieldName) {
        if (input.isEmpty()) {
            showAlert("Error", "Un champ est obligatoire. Veuillez saisir une valeur pour " + fieldName + ".");
            return false;
        }
        return true;
    }

    private boolean validateNumericInput(String input, String fieldName) {
        if (!input.matches("\\d+")) {
            showAlert("Error", "Veuillez saisir des caractères numériques pour" + fieldName + ".");
            return false;
        }
        return true;
    }

}
