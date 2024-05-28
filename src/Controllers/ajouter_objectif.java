package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Models.Objectif;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ajouter_objectif implements Initializable {

    @FXML
    private Spinner<Integer> note;

    @FXML
    private TextField objectif;

    @FXML
    private Button save;

    @FXML
    private ChoiceBox<String> terms;

    @FXML
    void save(ActionEvent event) {

        String objectifText = objectif.getText();
        int noteValue = note.getValue();
        String termValue = terms.getValue();

        if (objectifText != null && !objectifText.isEmpty() && termValue != null && !termValue.isEmpty()) {
            Objectif newObjectif = new Objectif(objectifText, noteValue, termValue);
            if (objectifsController != null) {
                objectifsController.addObjectif(newObjectif);
            }
            // Close the current window after saving
            ((Stage) save.getScene().getWindow()).close();
        }

    }

    private objectifs objectifsController;

    public void setObjectifsController(objectifs controller) {
        this.objectifsController = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        note.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1));
        terms.setItems(FXCollections.observableArrayList("Court", "Moyen", "Long"));
    }

}
