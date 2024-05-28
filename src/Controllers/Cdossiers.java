package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import Models.Adulte;
import Models.Dossier;
import Models.Enfant;
import Models.Orthophoniste;
import Models.SessionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class Cdossiers implements Initializable {

    @FXML
    private Button Anamneses;

    @FXML
    private Button Dossiers;

    @FXML
    private Button Rendez_vous;

    @FXML
    private Button Tests;

    @FXML
    private Button consulter;

    @FXML
    private Button cree;

    @FXML
    private Button deconnect;

    @FXML
    private TableView<Dossier> dossiersTable;

    @FXML
    private TableColumn<Dossier, Integer> ndossier;

    @FXML
    private TableColumn<Dossier, String> nom;

    @FXML
    private Button parametres;

    @FXML
    private TableColumn<Dossier, String> prenom;

    @FXML
    private TextField search;

    @FXML
    private Button searchbutton;

    @FXML
    private Button stat;

    @FXML
    private Label user;

    public void setUserData(Orthophoniste userr) {
        user.setText("Dr." + userr.getNom());
    }

    @FXML
    void Anamneses(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/Anamnese.fxml"));
            Parent root = loader.load();

            // Get the controller of the new scene
            Canamneses Cdos = loader.getController();
            Cdos.setUserData(SessionManager.getInstance().getCurrentUser());

            Stage stage = (Stage) Anamneses.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void Dossiers(ActionEvent event) {

    }

    @FXML
    void Rendez_vous(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/Main.fxml"));
            Parent root = loader.load();

            // Get the controller of the new scene
            Main main = loader.getController();
            main.setUserData(SessionManager.getInstance().getCurrentUser());

            Stage stage = (Stage) Rendez_vous.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void Tests(ActionEvent event) {

    }

    @FXML
    void consulter(ActionEvent event) {

        System.out.println("you clicked me");
        Dossier selectedDossier = dossiersTable.getSelectionModel().getSelectedItem();
        if (selectedDossier.getpatient() instanceof Enfant) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/ConsulterDossierEnfant.fxml"));
                Parent root = loader.load();

                // Get the controller of the new scene
                ConsulterDos detailController = loader.getController();
                detailController.setDossierData(selectedDossier);

                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Ajouter RDV");
                stage.setScene(new Scene(root));
                stage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (selectedDossier.getpatient() instanceof Adulte) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/ConsulterDossierAdulte.fxml"));
                Parent root = loader.load();

                // Get the controller of the new scene
                ConsulterDosAdulte detailController = loader.getController();
                detailController.setDossierData(selectedDossier);

                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Ajouter RDV");
                stage.setScene(new Scene(root));
                stage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void creeDossier(ActionEvent event) {

    }

    @FXML
    void deconnect(ActionEvent event) {

        try {
            Parent ajouterRDVRoot = FXMLLoader.load(getClass().getResource("/Fxmlfiles/Bienvenue.fxml"));
            Scene ajouterRDVScene = new Scene(ajouterRDVRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(ajouterRDVScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void parametres(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void stat(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Orthophoniste currentUser = SessionManager.getInstance().getCurrentUser();
        setUserData(currentUser);
        initializeTableColumns();
        loadDossiers(currentUser);
    }

    private void initializeTableColumns() {
        ndossier.setCellValueFactory(new PropertyValueFactory<>("nDossier"));
        nom.setCellValueFactory(new PropertyValueFactory<>("patientNom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("patientPrenom"));
    }

    private void loadDossiers(Orthophoniste user) {
        List<Dossier> dossiers = user.getDossiersList();
        ObservableList<Dossier> dossiersList = FXCollections.observableArrayList(dossiers);
        dossiersTable.setItems(dossiersList);
    }

}
