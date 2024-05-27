package Controllers;

import java.io.IOException;

import Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConsulterDosAdulte {

    @FXML
    private Button Bo;

    @FXML
    private TextField adresse;

    @FXML
    private DatePicker date_naissance;

    @FXML
    private Button delete;

    @FXML
    private TextField diplome;

    @FXML
    private Button fiche;

    @FXML
    private TextField lieu_naissance;

    @FXML
    private TextField nom;

    @FXML
    private TextField ntlph;

    @FXML
    private TextField prenom;

    @FXML
    private TextField profession;

    @FXML
    private Button rdvs;

    @FXML
    private Button save;

    private Dossier selectedDossier;

    @FXML
    void Bos(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

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
           Adulte enfant = (Adulte) selectedDossier.getpatient();
            enfant.setProfession(profession.getText());
            enfant.setnTlph(ntlph.getText());
            enfant.setadresse(adresse.getText());
        }

    }

    public void setDossierData(Dossier selectedDossier) {
        this.selectedDossier=selectedDossier;
        Adulte enfant = (Adulte) selectedDossier.getpatient();
        nom.setText(enfant.getNom());
        prenom.setText(enfant.getPrenom());
        adresse.setText(enfant.getAdresse());
        profession.setText(enfant.getProfession());
        lieu_naissance.setText(enfant.getLieuDeNaissance());
        date_naissance.setValue(enfant.getDateDeNaissance());
        ntlph.setText(enfant.getnTlph());
        diplome.setText(enfant.getDiplome());
        

        nom.setDisable(true);
        prenom.setDisable(true);
        date_naissance.setDisable(true);
        lieu_naissance.setDisable(true);
        diplome.setDisable(true);
    }

}
