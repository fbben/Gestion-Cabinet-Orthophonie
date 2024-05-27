package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Models.UserManager;
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
    private TextField mail;

    @FXML
    private PasswordField motdepasse;

    @FXML
    private TextField nTLph;

    @FXML
    void inscrire(ActionEvent event) {
        String nom = Nom.getText();
        String prenom = Prenom.getText();
        String adresse = this.adresse.getText();
        String email = mail.getText();
        String motDePasse = motdepasse.getText();
        String nTlph = this.nTLph.getText();

        if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || email.isEmpty() || motDePasse.isEmpty() || nTlph.isEmpty()) {
            showAlert("Error", "All fields are required.");
            return;
        }

       
        Orthophoniste newUser = new Orthophoniste(nom,prenom,adresse,nTlph,email,motDePasse);

        boolean isAdded = UserManager.getInstance().addUser(newUser);

        if (isAdded) {
            showAlert("Success", "Registration successful!");
            // Clear the fields or redirect to login
        } else {
            showAlert("Error", "User already exists.");
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
