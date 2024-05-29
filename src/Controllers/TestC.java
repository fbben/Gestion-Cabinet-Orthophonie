package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Models.Orthophoniste;
import Models.SessionManager;
import Models.Test;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TestC {

    @FXML
    private Button Anamneses;

    @FXML
    private TableColumn<Test, String> Capacite;

    @FXML
    private Button CreerTest;

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

    }

    @FXML
    void Dossiers(ActionEvent event) {

    }

    @FXML
    void Rendez_vous(ActionEvent event) {

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

}
