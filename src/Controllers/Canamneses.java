package Controllers;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Models.Anamnese;
import Models.Orthophoniste;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Canamneses implements Initializable {

    @FXML
    private Button Anamneses;

    @FXML
    private Button Dossiers;

    @FXML
    private Button Rendez_vous;

    @FXML
    private Button Tests;

    @FXML
    private TableView<Anamnese> anamneses;

    @FXML
    private Button creer;

    @FXML
    private Button deconnect;

    @FXML
    private TableColumn<Anamnese, String> description;

    @FXML
    private Button modifier;

    @FXML
    private Button parametres;

    @FXML
    private TextField search;

    @FXML
    private Button searchbutton;

    @FXML
    private Button stat;

    @FXML
    private TableColumn<Anamnese, String> titre;

    @FXML
    private Label user;

    public void setUserData(Orthophoniste userr) {
        user.setText( "Dr." + userr.getNom());
    }

    @FXML
    void Anamneses(ActionEvent event) {

    }

    @FXML
    void Dossiers(ActionEvent event) {
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/Dossier.fxml"));
                Parent root = loader.load();

                // Get the controller of the new scene
                Cdossiers Cdos=loader.getController();
                Cdos.setUserData(SessionManager.getInstance().getCurrentUser());

                Stage stage = (Stage) Dossiers.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void Rendez_vous(ActionEvent event) {

    }

    @FXML
    void Tests(ActionEvent event) {

    }

    @FXML
    void creer(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxmlfiles/CreerAnamnese.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("CreerAnamnese RDV");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            Orthophoniste currentUser = SessionManager.getInstance().getCurrentUser();
            loadAnamneses(currentUser);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void déconnecter(ActionEvent event) {

    }

    @FXML
    void modifier(ActionEvent event) {

        Anamnese selectedAnamnese = anamneses.getSelectionModel().getSelectedItem();
        if (selectedAnamnese != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/ModifierAnamnese.fxml"));
                Parent root = loader.load();

                modifierAnamnese modifierController = loader.getController();
                modifierController.setAnamnese(selectedAnamnese);
                modifierController.setParentController(this);

                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Modifier Anamnese");
                stage.setScene(new Scene(root));
                stage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No Anamnese selected!");
        }

    }

    @FXML
    void parametres(ActionEvent event) {

    }

    @FXML
    void stat(ActionEvent event) {

    }
    private ObservableList<Anamnese> anamnesesList;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Orthophoniste currentUser = SessionManager.getInstance().getCurrentUser();
        setUserData(currentUser);
        initializeTableColumns();
        loadAnamneses(currentUser);
    }

    private void initializeTableColumns() {
        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
    }
    private void loadAnamneses(Orthophoniste user) {
        List<Anamnese> anamneses = user.getAnamneses();
        if (anamneses == null) {
            System.out.println("No anamneses found for the user!");
        } else {
            for (Anamnese anamnese : anamneses) {
                System.out.println("Loaded anamnese: " + anamnese.getTitre() + " - " + anamnese.getDescription());
            }
        }
        anamnesesList = FXCollections.observableArrayList(anamneses);
        this.anamneses.setItems(anamnesesList);
    }

}
