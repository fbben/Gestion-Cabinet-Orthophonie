package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class EnonceQuestion implements Initializable {

    @FXML
    private ChoiceBox<String> categorie;

    @FXML
    private TextField enonce;

    @FXML
    private Button save;

    private String selectedtype;
    private Creeranamnese parentController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categorie.setItems(categoriestypes);
    }

    private ObservableList<String> categoriestypes = FXCollections.observableArrayList(

    );

    ;

    @FXML
    void save(ActionEvent event) {
        String enonceText = enonce.getText();
        String selectedCategory = categorie.getValue();

        if (enonceText != null && !enonceText.isEmpty() && selectedCategory != null) {
            QAnamnese question = new QAnamnese(enonceText, selectedCategory);
            System.out.println("question created");
            parentController.addQuestion(question);
            // closeStage();
        } else {
            // Handle validation error (e.g., show an alert)
        }

    }

    public void setquestiontype(String selectedTypee) {
        this.selectedtype = selectedTypee;
        initializeCategorie();
    }

    private void initializeCategorie() {
        if ("Enfant".equals(selectedtype)) {
            System.out.println("yessss");
            categoriestypes = FXCollections.observableArrayList(
                    "structure_familiale",
                    "dynamique_familiale",
                    "antécédents_familiaux",
                    "conditions_natales",
                    "développement_psychomoteur",
                    "développement_langagier");
        } else if ("Adulte".equals(selectedtype)) {
            System.out.println("noooooo");
            categoriestypes = FXCollections.observableArrayList(
                    "caractère_et_comportement",
                    "Histoire",
                    "Suivi_Médical");
        }
        categorie.setItems(categoriestypes);
    }

    public void setParentController(Creeranamnese parentController) {
        this.parentController = parentController;
    }

}
