package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Models.Anamnese;
import Models.Dossier;
import Models.SessionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class Anamneses_exictant implements Initializable {

    @FXML
    private ListView<Anamnese> liste_anamneses;

    @FXML
    private Button suivant;

    private BOs Controller;


    
    public void setUserData(BOs controller) {
        suivant.getScene().getWindow().setUserData(controller);
    }

    @FXML
    void suivant(ActionEvent event) {

        Anamnese selectedAnamnese = liste_anamneses.getSelectionModel().getSelectedItem();
        
        if (selectedAnamnese != null) {
            BOs controller = (BOs) suivant.getScene().getWindow().getUserData();
            if (controller != null) {
                controller.addSelectedAnamnese(selectedAnamnese);
                System.out.println("ok");
            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Anamnese> anamneses = FXCollections.observableArrayList(SessionManager.getInstance().getCurrentUser().getAnamneses());
        liste_anamneses.setItems(anamneses);
        liste_anamneses.setCellFactory(param -> new ListCell<Anamnese>() {
            @Override
            protected void updateItem(Anamnese item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText("Anamnese"); 
                }
            }
        });
    }


    public void setController(BOs controller) {
        this.Controller = controller;
    }


    private Dossier selectedDossier;
    public void setSelectedDossier(Dossier selectedDossier) {
        this.selectedDossier=selectedDossier;
    }

}
