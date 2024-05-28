package Controllers;

import java.io.IOException;

import Models.Dossier;
import Models.Fiche_suivi;
import Models.Objectif;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;

public class fiches_suivi {

    @FXML
    private Button ajouter;

    @FXML
    private ListView<Fiche_suivi> fiches;

    @FXML
    private Button modifier;

    private Fiche_suivi selectedFiche;

    private Dossier selectedDossier;

    public void setSelectedDossier(Dossier selectedDossier) {
        this.selectedDossier = selectedDossier;
        // Load the existing fiches_suivi for the selected dossier
        fiches.getItems().setAll(selectedDossier.getFichesSuivi());
    }

    @FXML
    void ajouter(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/ListeDesObjectifs.fxml"));
            Parent root = loader.load();

            // Pass the fiches_suivi controller to Objectifs controller
            objectifs controller = loader.getController();
            controller.setFichesSuiviController(this);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void modifier(ActionEvent event) {
        Fiche_suivi selectedFiche = fiches.getSelectionModel().getSelectedItem();
        if (selectedFiche != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/ListeDesObjectifs.fxml"));
                Parent root = loader.load();

                // Pass the selected Fiche_suivi to the Objectifs controller
                objectifs controller = loader.getController();
                controller.setFichesSuiviController(this);

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void addFiche(Fiche_suivi fiche) {
        fiches.getItems().add(fiche);
        if (selectedDossier != null) {
            selectedDossier.addFicheSuivi(fiche);
        }
    }

    public void addObjectifToSelectedFiche(Objectif objectif) {
        if (selectedFiche != null) {
            selectedFiche.addObjectif(objectif);
        }
    }

    @FXML
    public void initialize() {
        // Set the custom cell factory to use FicheSuiviListCell
        fiches.setCellFactory(
                (Callback<ListView<Fiche_suivi>, ListCell<Fiche_suivi>>) new Callback<ListView<Fiche_suivi>, ListCell<Fiche_suivi>>() {
                    @Override
                    public ListCell<Fiche_suivi> call(ListView<Fiche_suivi> listView) {
                        return new ListCell<Fiche_suivi>() {
                            @Override
                            protected void updateItem(Fiche_suivi item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty || item == null) {
                                    setText(null);
                                } else {
                                    setText("fiche"); // Display the description or any other relevant information
                                }
                            }
                        };
                    }
                });
    }

}
