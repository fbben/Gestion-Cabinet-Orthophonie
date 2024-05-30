package Controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreerTestC implements Initializable {

    @FXML
    private TextField Capacite;

    @FXML
    private TextField NomTest;

    @FXML
    private Button Suivant;

    @FXML
    private ChoiceBox<String> Type;

    @FXML
    void Suivant(ActionEvent event) {

        String Capacite = this.Capacite.getText();
        String NomTest = this.NomTest.getText();
        String selectedType = this.Type.getValue();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/EnonceExercice.fxml"));
            Parent root = loader.load();

            // Get the controller of the new scene
            // Main mainPageController = loader.getController();

            // mainPageController.setUserData(user); // Pass the user data to the new scene

            // Cdossiers cdos = loader.getController();
            // cdos.setUserData(user);

            Stage stage = (Stage) Suivant.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    

    }

    private ObservableList<String> TestType = FXCollections.observableArrayList(
            "Exercice", "Questionnaire");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Type.setItems(TestType);
    }

}
