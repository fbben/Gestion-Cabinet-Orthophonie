package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;

public class Catelier implements Initializable {

    @FXML
    private Spinner<Integer> heure;

    @FXML
    private Spinner<Integer> minutes;

    @FXML
    private TextField dossiers;

    @FXML
    private TextField duree;

    @FXML
    private Button retour;

    @FXML
    private TextField thématique;

    @FXML
    private Button valider;

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

    }

    public void initialize(URL location, ResourceBundle resources) {
        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 4, 0);
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);

        // valueFactory.setValue(null);
        heure.setValueFactory(valueFactory1);
        minutes.setValueFactory(valueFactory2);

    }

}
