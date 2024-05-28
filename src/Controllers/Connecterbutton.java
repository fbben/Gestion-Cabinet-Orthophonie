package Controllers;

import java.io.IOException;

import Models.Orthophoniste;
import Models.SessionManager;
import Models.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Connecterbutton {

    @FXML
    private Button Connecter;

    @FXML
    private PasswordField motpasse;

    @FXML
    private TextField nom;

    @FXML
    void Connecter(ActionEvent event) {
        String username = nom.getText();
        String password = motpasse.getText();

        boolean isAuthenticated = UserManager.getInstance().authenticateUser(username, password);

        if (isAuthenticated) {
            Orthophoniste user = UserManager.getInstance().getUserByUsername(username);
            SessionManager.getInstance().setCurrentUser(user); // Set the current user in SessionManager

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/Main.fxml"));
                Parent root = loader.load();

                // Get the controller of the new scene
                Main mainPageController = loader.getController();

                mainPageController.setUserData(user); // Pass the user data to the new scene

                // Cdossiers cdos = loader.getController();
                // cdos.setUserData(user);

                Stage stage = (Stage) Connecter.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showAlert("Échec de l'authentification", "Nom d'utilisateur ou mot de passe invalide.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
