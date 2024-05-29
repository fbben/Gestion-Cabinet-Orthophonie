package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Models.Anamnese;
import Models.BilanOrthophonique;
import Models.Dossier;
import Models.Fiche_suivi;
import Models.QAnamnese;
import Models.SessionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BOs implements Initializable{

    @FXML
    private Button ajouteranamnese;

    @FXML
    private Button ajouterdiagnostic;

    @FXML
    private Button ajouterepreuve;

    @FXML
    private ListView<Anamnese> anamneses;

    @FXML
    private TableColumn<?, ?> categorie;

    @FXML
    private TableView<?> diagnostic;

    @FXML
    private TableView<?> epreuves;

    @FXML
    private TableColumn<?, ?> observation;

    @FXML
    private TextField project;

    @FXML
    private Button save;

    @FXML
    private TableColumn<?, ?> score;

    @FXML
    private TableColumn<?, ?> test;

    @FXML
    private TableColumn<?, ?> trouble;

    @FXML
    private TableColumn<?, ?> type;

    private Dossier selectedDossier;

    public void setSelectedDossier(Dossier selectedDossier) {
        this.selectedDossier = selectedDossier;
    }

    

    public void addSelectedAnamnese(Anamnese anamnese) {
        anamneses.getItems().add(anamnese);
        System.out.println("heeeeeeeeeeeere"+anamnese);
        if (selectedDossier != null) {
            anamneses.getItems().add(anamnese);
            BilanOrthophonique bilan= new BilanOrthophonique(selectedDossier.getpatient());
            selectedDossier.getBOs().add(bilan);

            selectedDossier.getBOs().get(0).setAnamnese(anamnese);
        }if (selectedDossier != null && selectedDossier.getBOs() != null) {
            if (selectedDossier.getBOs().isEmpty()) {
                BilanOrthophonique bilan = new BilanOrthophonique(selectedDossier.getpatient());
                selectedDossier.getBOs().add(bilan);
            }
            selectedDossier.getBOs().get(0).setAnamnese(anamnese);
        }
    }
    
     

    @FXML
    void ajouteranamnese(ActionEvent event){
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/Anamneses_exictant.fxml"));
                Parent root = loader.load();

                Anamneses_exictant anamnesesController = loader.getController();
                anamnesesController.setSelectedDossier(selectedDossier);



                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    

    private void loadAnamneses() {
    if (selectedDossier != null && !selectedDossier.getBOs().isEmpty()) {
        List<Anamnese> anamneseList = (List<Anamnese>) selectedDossier.getBOs().get(0).getAnamnese();
        ObservableList<Anamnese> observableAnamneseList = FXCollections.observableArrayList(anamneseList);
        anamneses.setItems(observableAnamneseList);
    }
}



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadAnamneses();
    }

}
