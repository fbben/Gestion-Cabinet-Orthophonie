package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Models.Fiche_suivi;
import Models.Objectif;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;

public class objectifs implements Initializable {

    @FXML
    private Button ajouter;

    @FXML
    private Button modifier;

    @FXML
    private TreeTableColumn<Objectif, String> nom;

    @FXML
    private TreeTableColumn<Objectif, Integer> note;

    @FXML
    private TreeTableView<Objectif> objectif;

    @FXML
    private Button save;

    @FXML
    private TreeTableColumn<Objectif, String> term;

    private TreeItem<Objectif> root;

    private fiches_suivi fichesSuiviController;

    public void setFichesSuiviController(fiches_suivi controller) {
        this.fichesSuiviController = controller;
    }

    @FXML
    void ajouter(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/Objectif.fxml"));
            Parent root = loader.load();
            ajouter_objectif controller = loader.getController();
            controller.setObjectifsController(this);

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

    }

    @FXML
    void save(ActionEvent event) {

        if (fichesSuiviController != null) {
            Fiche_suivi newFiche = new Fiche_suivi("fiche ");
            for (TreeItem<Objectif> item : root.getChildren()) {
                newFiche.addObjectif(item.getValue());
            }
            fichesSuiviController.addFiche(newFiche);
        }
    }

    public void addObjectif(Objectif obj) {
        root.getChildren().add(new TreeItem<>(obj));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nom.setCellValueFactory(new TreeItemPropertyValueFactory<>("objectif"));
        note.setCellValueFactory(new TreeItemPropertyValueFactory<>("note"));
        term.setCellValueFactory(new TreeItemPropertyValueFactory<>("term"));

        root = new TreeItem<>(new Objectif("Root", 0, "Root"));
        objectif.setRoot(root);
        objectif.setShowRoot(false);
    }

}
