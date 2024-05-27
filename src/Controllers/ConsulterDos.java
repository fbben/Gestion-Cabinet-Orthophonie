package Controllers;

import Models.Dossier;
import Models.Enfant;
import Models.SessionManager;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConsulterDos {


    private Dossier selectedDossier;

    @FXML
    private Button Bo;

    @FXML
    private TextField adresse;

    @FXML
    private TextField classe;

    @FXML
    private DatePicker date_naissance;

    @FXML
    private Button delete;

    @FXML
    private Button fiche;

    @FXML
    private TextField lieu_naissance;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private Button rdvs;

    @FXML
    private Button save;

    @FXML
    private TextField tlphm;

    @FXML
    private TextField tlphp;

    @FXML
    void Bos(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {
        
        if (selectedDossier != null) {
            SessionManager.getInstance().getCurrentUser().getDossiers().remove(selectedDossier.getNDossier());
            Button deleteButton = (Button) event.getSource();
            Scene scene = deleteButton.getScene();
            Stage stage = (Stage) scene.getWindow();
            stage.close();
        }
        
        


    }

    @FXML
    void fiche(ActionEvent event) {

    }

    @FXML
    void rdsv(ActionEvent event) {

       
       
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/ListeDesRDVs.fxml"));
            Parent root = loader.load();
            Cliste_RDV rdvsController = loader.getController();
            rdvsController.setSelectedDossier(selectedDossier);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @FXML
    void save(ActionEvent event) {
        if (selectedDossier != null) {
            Enfant enfant = (Enfant) selectedDossier.getpatient();
            enfant.setClasse(classe.getText());
            enfant.setadresse(adresse.getText());
            // You can also save the updated dossier to a database or file here if needed
        }

    }

    public void setDossierData(Dossier selectedDossier) {
        this.selectedDossier=selectedDossier;
        Enfant enfant = (Enfant) selectedDossier.getpatient();
        nom.setText(enfant.getNom());
        prenom.setText(enfant.getPrenom());
        adresse.setText(enfant.getAdresse());
        classe.setText(enfant.getClasse());
        lieu_naissance.setText(enfant.getLieuDeNaissance());
        date_naissance.setValue(enfant.getDateDeNaissance());
        tlphm.setText("0712349582");
        tlphp.setText("0566712881");
        

        nom.setDisable(true);
        prenom.setDisable(true);
        date_naissance.setDisable(true);
        lieu_naissance.setDisable(true);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'setDossierData'");
    }

}
