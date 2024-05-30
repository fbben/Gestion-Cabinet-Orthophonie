package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Models.Orthophoniste;
import Models.SessionManager;
import Models.Test;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TestC implements Initializable {

    @FXML
    private Button Anamneses;

    @FXML
    private TableColumn<Test, String> Capacite;

    @FXML
    private Button CreerTest;

    @FXML
    private Button modifier;

    @FXML
    private Button Dossiers;

    @FXML
    private TableColumn<Test, String> Nom;

    @FXML
    private Button Rendez_vous;

    @FXML
    private Button Tests;

    @FXML
    private TableView<Test> TestsTable;

    @FXML
    private TableColumn<Test, String> Type;

    @FXML
    private Button parametres;

    @FXML
    private Button stat;

    @FXML
    private Label user;

    public void setUserData(Orthophoniste userr) {
        user.setText("Dr." + userr.getNom());
    }

    @FXML
    void Anamneses(ActionEvent event) {

    }

    @FXML
    void CreerTest(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/CreerTest.fxml"));
            Parent root = loader.load();

           
            // objectifs controller = loader.getController();
            // controller.setFichesSuiviController(this);

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

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/Questionnaire.fxml"));
            Parent root = loader.load();

           
            // objectifs controller = loader.getController();
            // controller.setFichesSuiviController(this);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
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
    void parametres(ActionEvent event) {

    }

    @FXML
    void stat(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
    }

}
