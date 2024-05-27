package Controllers;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.Node;

import javafx.stage.Stage;

public class CBienvenue {

    @FXML
    private Button connecter;

    @FXML
    private Button inscrire;

    @FXML
    void connecter(ActionEvent event) {
       try {
            
            Parent connecterRoot = FXMLLoader.load(getClass().getResource("/Fxmlfiles/Connecter.fxml"));
            Scene connecterScene = new Scene(connecterRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            
            stage.setScene(connecterScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void inscrire(ActionEvent event) {
        try {
            
            Parent connecterRoot = FXMLLoader.load(getClass().getResource("/Fxmlfiles/Inscrire.fxml"));
            Scene connecterScene = new Scene(connecterRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            
            stage.setScene(connecterScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
