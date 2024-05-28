package Controllers;

import java.io.IOException;

import Models.Anamnese;
import Models.QAnamnese;
import Models.Question;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class modifierAnamnese {

    private Anamnese anamnese;
    private Canamneses parentController;

    @FXML
    private Button ajouter;

    @FXML
    private Button delete;

    @FXML
    private TextField description;

    @FXML
    private Button modifier;

    @FXML
    private ListView<QAnamnese> questions;

    @FXML
    private Button save;

    @FXML
    private Button supprimer;

    @FXML
    private TextField titre;

    @FXML
    void ajouter(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/EnonceQuestion.fxml"));
            Parent root = loader.load();
            EnonceQuestion enoncController = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void modifier(ActionEvent event) {

    }

    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
        titre.setText(anamnese.getTitre());
        description.setText(anamnese.getDescription());

        questions.setItems(FXCollections.observableArrayList(anamnese.getquestioAnamneses()));

        questions.setCellFactory(param -> new ListCell<QAnamnese>() {
            @Override
            protected void updateItem(QAnamnese item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getEnonce());
                }
            }
        });
    }

    public void setParentController(Canamneses parentController) {
        this.parentController = parentController;
    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void supprimer(ActionEvent event) {

    }

}
