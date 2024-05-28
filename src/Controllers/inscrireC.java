package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Models.UserManager;

import java.io.IOException;

import Models.Orthophoniste;

public class inscrireC {

    @FXML
    private TextField Nom;

    @FXML
    private TextField Prenom;

    @FXML
    private TextField adresse;

    @FXML
    private Button inscrire;

    @FXML
    private Button retour;

    @FXML
    private TextField mail;

    @FXML
    private PasswordField motdepasse;

    @FXML
    private TextField nTLph;

    @FXML
    void retour(ActionEvent event) {

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
    void inscrire(ActionEvent event) {
        String nom = Nom.getText();
        String prenom = Prenom.getText();
        String adresse = this.adresse.getText();
        String email = mail.getText();
        String motDePasse = motdepasse.getText();
        String nTlph = this.nTLph.getText();

        if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || email.isEmpty() || motDePasse.isEmpty()
                || nTlph.isEmpty()) {
            showAlert("Error", "Tous les champs sont obligatoires.");
            return;
        }
        if (!validateNumericInput(nTlph, "nTlph")) {
            return; // Sortie de la méthode si tlphm ou tlphp ne contient pas des caractères
                    // numériques
        }

        // Orthophoniste newUser = new
        // Orthophoniste(nom,prenom,adresse,nTlph,email,motDePasse);
        Orthophoniste newUser = new Orthophoniste(nom, motDePasse);

        boolean isAdded = UserManager.getInstance().addUser(newUser);

        if (isAdded) {
            showAlert("réussie", "Inscription réussie!");
            // Clear the fields or redirect to login
        } else {
            showAlert("Error", "Utilisateur exicte! .");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean validateNumericInput(String input, String fieldName) {
        if (!input.matches("\\d+")) {
            showAlert("Error", "Merci de saisir uniquement des chiffres pour " + fieldName + ".");
            return false;
        }
        return true;
    }
}
