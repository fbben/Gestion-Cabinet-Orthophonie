package Controllers;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Questionnaire implements Initializable {

    @FXML
    private TextField Choix;

    @FXML
    private Label Reponse;

    @FXML
    private TextField Enonce;

    @FXML
    private Spinner<?> ReponseCorrecte;

    @FXML
    private TextField ReponsesCorrectes;

    @FXML
    private Button Retour;

    @FXML
    private Button Sauvegarder;

    @FXML
    private ChoiceBox<String> TypeQuestionnaire;

    @FXML
    void Choix(ActionEvent event) {

    }

    @FXML
    void Enonce(ActionEvent event) {

    }

    @FXML
    void ReponseCorrecte(MouseEvent event) {

    }

    @FXML
    void ReponsesCorrectes(ActionEvent event) {

    }

    @FXML
    void Retour(ActionEvent event) {

    }

    @FXML
    void Sauvegarder(ActionEvent event) {

          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          stage.close();



    }

   private ObservableList<String> TestTypez = FXCollections.observableArrayList(
            "QCM", "QCU" ,"Question a réponse libre");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TypeQuestionnaire.setItems(TestTypez);

        TypeQuestionnaire.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if ("Question a réponse libre".equals(newValue)) {
                    // Enable ages ChoiceBox if the selected item is "Consultaion"
                    ReponseCorrecte.setVisible(false);
                    ReponsesCorrectes.setVisible(false);
                    Reponse.setVisible(false);
                    Choix.setVisible(false);
                } else if ("QCM".equals(newValue)) {
                    
                    ReponseCorrecte.setVisible(false);
                    Reponse.setVisible(false);
                   
                } else if ("QCU".equals(newValue)){

                    ReponsesCorrectes.setVisible(false);


                }
            }

        });
    }

}
