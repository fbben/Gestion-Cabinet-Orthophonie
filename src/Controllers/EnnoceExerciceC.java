package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Models.*;
import Models.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EnnoceExerciceC {

    @FXML
    private TextField Consigne;

    @FXML
    private TextField Material;

    @FXML
    private Button Sauvegarder;

    @FXML
    void save(ActionEvent event){

        String Consigne = this.Consigne.getText();
        String Material = this.Material.getText();

        if (Consigne.isEmpty() || Material.isEmpty()) {
            showAlert("error", " Ajouter les informations");
        }

        Exercice exercice = new Exercice(Consigne, Material);
        SessionManager.getInstance().getCurrentUser().getExercice().add(exercice);
        System.out.println("exercice added");
        System.out.println("Anamnese saved: " + exercice);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();


    }


      private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
