package Controllers;

import java.io.IOException;

import Models.Orthophoniste;
import Models.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main {

    @FXML
    private Button AjouterRDV;

    @FXML
    private Button Anamneses;

    @FXML
    private Button Dossiers;

    @FXML
    private Button Rendez_vous;

    @FXML
    private Button Tests;

    @FXML
    private Button deconnect;

    @FXML
    private Button parametres;

    @FXML
    private Button stat;

    @FXML
    private Label user;
    
    public void setUserData(Orthophoniste userr) {
        user.setText( "Dr." + userr.getNom());
    }

    @FXML
    void AjouterRDV(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxmlfiles/AjouterRDV.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Ajouter RDV");
            stage.setScene(new Scene(root));
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }

    @FXML
    void Anamneses(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/Anamnese.fxml"));
            Parent root = loader.load();

            // Get the controller of the new scene
            Canamneses Cdos=loader.getController();
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
    void deconnect(ActionEvent event) {

    }

    @FXML
    void parametres(ActionEvent event) {

    }

    @FXML
    void stat(ActionEvent event) {

    }

}
