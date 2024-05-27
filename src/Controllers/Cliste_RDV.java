package Controllers;

import Models.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.converter.LocalTimeStringConverter;

public class Cliste_RDV {

    Dossier selecteddossier;

    @FXML
    private TableView<RendezVous> Rendez_vous;

    @FXML
    private TableColumn<RendezVous, String> date;

    @FXML
    private TableColumn<RendezVous, String> observation;

    @FXML
    private TableColumn<RendezVous, String> rdvs;

    @FXML
    private Button retour;

    @FXML
    void retour(ActionEvent event) {
        Stage stage = (Stage) retour.getScene().getWindow();
        // Close the stage
        stage.close();
    }

    @FXML
    void sort(ActionEvent event) {

    }

    public void setSelectedDossier(Dossier selectedDossierr) {
        this.selecteddossier= selectedDossierr;
        populateRDVsTableView(selecteddossier);
    }

    private void populateRDVsTableView(Dossier dossier) {
        
        ObservableList<RendezVous> rdvsList = FXCollections.observableArrayList(dossier.getRDVs());
        Rendez_vous.setItems(rdvsList);
        
        date.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
        observation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getObservation()));
        rdvs.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType().toString()));
    }

}
