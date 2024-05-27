package Controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import Models.Adulte;
import Models.Consultation;
import Models.Enfant;
import Models.Orthophoniste;
import Models.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Cadulte implements Initializable{

    @FXML
    private TextField adresse;

    @FXML
    private DatePicker date;

    @FXML
    private TextField diplome;

    

    @FXML
    private TextField lieu_naissance;

    @FXML
    private TextField nom;

    @FXML
    private Spinner<Integer> heure;

    @FXML
    private Spinner<Integer> minutes;


    @FXML
    private TextField prenom;

    @FXML
    private TextField profession;

    @FXML
    private Button retour;

    @FXML
    private TextField tlph;

    @FXML
    private Button valider;

    private LocalDate dateRDV;
    String observation;
    int heureRDV;
    int minutesRDV;

    public void initData(LocalDate selectedDate, String selectedobservation,int heure,int minutes) {
        this.dateRDV = selectedDate;
        this.observation = selectedobservation;
        this.heureRDV=heure;
        this.minutesRDV=minutes;
    }
    

    @FXML
    void Duree(ActionEvent event) {

    }

    @FXML
    void Valider(ActionEvent event) {

        String nom = this.nom.getText();
        String prenom = this.prenom.getText();


        

        if (!nom.matches("[a-zA-Z]+") || !prenom.matches("[a-zA-Z]+")) {
            showAlert("Error", "Please enter alphabetic characters for nom and prenom.");
            return; // Exit the method if either nom or prenom contains non-alphabetic characters
        }
    
        // Check if duree contains only numeric characters
        


        




        LocalDate date_naissance = this.date.getValue();
        String adresse = this.adresse.getText();
        String Prof = this.profession.getText();
        String diplome = this.diplome.getText();
        
        
        String lieu_naissance = this.lieu_naissance.getText();
        String nTlph = this.tlph.getText();

        LocalDate Rdv = this.dateRDV;
        String observation = this.observation;

        if (!validateInput(nom, "nom") || !validateInput(prenom, "prenom") || date_naissance == null ||
        !validateInput(adresse, "adresse") || !validateInput(Prof, "profession") ||
        !validateInput(lieu_naissance, "lieu de naissance")
        ) {
        return; // Exit the method if any input is invalid
         }
         if (!validateNumericInput(nTlph, "nulTlph") ) {
            return; // Sortie de la méthode si tlphm ou tlphp ne contient pas des caractères numériques
        }

        System.out.println("Nom: " + nom);
        System.out.println("Prenom: " + prenom);
        System.out.println("Date de naissance: " + date_naissance);
        System.out.println("Adresse: " + adresse);
        System.out.println("Prof: " + Prof);
        System.out.println("diplome: " + diplome);

        System.out.println("Lieu de naissance: " + lieu_naissance);
        System.out.println("Téléphone: " + nTlph);
        System.out.println("Rdv: " + Rdv);
        System.out.println("observation: " + observation);
        Orthophoniste currentUser = SessionManager.getInstance().getCurrentUser();
        currentUser.getDossiers();

    
        try {
            
            Adulte newPatient = new Adulte(nom, prenom, date_naissance, lieu_naissance, adresse, diplome, Prof,nTlph);
            System.out.println("New patient created: " + newPatient);
         
            LocalTime skl = LocalTime.of(9, 0); // For example, 9:00 AM
            Consultation newRDV = new Consultation(dateRDV,skl, observation, newPatient);
            System.out.println("New RDV created: " + newRDV);

            
             
            currentUser = SessionManager.getInstance().getCurrentUser();
            currentUser.creerDossier(newPatient,newRDV);
            System.out.println(currentUser.getDossiers());

            

           
            showAlert("RDV", "IRendez_vous cree.");
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Invalid informations.");
        }

       


    }

    @FXML
    void retour(ActionEvent event) {
         try {
            Parent ajouterRDVRoot = FXMLLoader.load(getClass().getResource("/Fxmlfiles/AjouterRDV.fxml"));
            Scene ajouterRDVScene = new Scene(ajouterRDVRoot);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(ajouterRDVScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

     private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void initialize(URL location, ResourceBundle resources) {
        SpinnerValueFactory<Integer> valueFactory1 =new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 4, 0);
        SpinnerValueFactory<Integer> valueFactory2 =new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);

        //valueFactory.setValue(null);
           heure.setValueFactory(valueFactory1);
           minutes.setValueFactory(valueFactory2);
        
    }
   
    private boolean validateInput(String input, String fieldName) {
        if (input.isEmpty()) {
            showAlert("Error", "Please enter a value for " + fieldName + ".");
            return false;
        }
        return true;
    }

    private boolean validateNumericInput(String input, String fieldName) {
        if (!input.matches("\\d+")) {
            showAlert("Error", "Please enter numeric characters for " + fieldName + ".");
            return false;
        }
        return true;
    }
    
}
