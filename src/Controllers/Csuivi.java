package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Models.Consultation;
import Models.Enfant;
import Models.Orthophoniste;
import Models.SessionManager;
import Models.Suivi;

import java.time.LocalDate;
import java.time.LocalTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Csuivi implements Initializable {

    @FXML
    private TextField date;

    @FXML
    private ChoiceBox<String> déroulement;

    private LocalDate dateRDV;
    String observation;
    int heureRDV;
    int minutesRDV;

    @FXML
    private TextField nbdossier;

    @FXML
    private Button retour;

    @FXML
    private Button valider;

    @FXML
    private Spinner<Integer> heure;

    @FXML
    private Spinner<Integer> minutes;

    public void initData(LocalDate selectedDate, String selectedobservation, int heure, int minutes) {
        this.dateRDV = selectedDate;
        this.observation = selectedobservation;
        this.heureRDV = heure;
        this.minutesRDV = minutes;
    }

    private ObservableList<String> déroulementTypes = FXCollections.observableArrayList(
            "En ligne", "Préseniel");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        déroulement.setItems(déroulementTypes);
        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 4, 0);
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);

        // valueFactory.setValue(null);
        heure.setValueFactory(valueFactory1);
        minutes.setValueFactory(valueFactory2);

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

    @FXML
    void valider(ActionEvent event) {
        String selectedType = déroulement.getValue();
        String numdossier = nbdossier.getText();
        // String duree = date.getText();
        // if (!duree.matches("\\d+")) {
        // showAlert("Error", "Please enter numeric characters for duree.");
        // return; // Exit the method if duree contains non-numeric characters
        // }
        LocalDate Rdv = this.dateRDV;
        String observation = this.observation;

        System.out.println("numdossier: " + numdossier);

        // System.out.println("Durée: " + duree);

        System.out.println("Rdv: " + Rdv);
        System.out.println("observation: " + observation);

        Orthophoniste currentUser = SessionManager.getInstance().getCurrentUser();
        currentUser.getDossiers();

        if (heure.getValue() != 1 || minutes.getValue() != 00) {
            showAlert("Error", "La durée doit être de 1 heure .");
            return; // Exit the method if the duration is incorrect
        }
        try {

            boolean a;
            if ("En ligne".equals(selectedType)) {
                a = true;
            } else {
                a = false;
            }

            LocalTime skl = LocalTime.of(heureRDV, minutesRDV); // For example, 9:00 AM
            Suivi newRDV = new Suivi(dateRDV, skl, observation, Integer.parseInt(numdossier), a);
            System.out.println("New RDVsuivi created: " + newRDV);

            if (currentUser.Cheuvauchement(newRDV)) {
                showAlert("Error", "Le nouveau rendez-vous chevauche un rendez-vous existant.");
                return;
            }

            currentUser = SessionManager.getInstance().getCurrentUser();
            currentUser.getDossiers().get(Integer.parseInt(numdossier)).getRDVs().add(newRDV);
            System.out.println(currentUser.getDossiers());
            System.out.println(currentUser.getDossiers().get(Integer.parseInt(numdossier)).getRDVs().get(1));
            System.out.println(currentUser.getDossiers().get(1).getpatient().getNom());

            showAlert("RDV", "Rendez_vous crée avec succée.");
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Informations invalides..");
        }

    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
