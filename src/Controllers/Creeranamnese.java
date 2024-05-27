package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Models.Anamnese;
import Models.QAnamnese;
import Models.SessionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Creeranamnese implements Initializable {

    @FXML
    private ListView<QAnamnese> Questions;

    @FXML
    private ChoiceBox<String> ages;

    @FXML
    private Button ajouter;

    @FXML
    private TextField description;

    @FXML
    private Button save;

    @FXML
    private TextField titre;

    private ObservableList<String> agesTypes = FXCollections.observableArrayList(
            "Adulte", "Enfant"
    );

    private ObservableList<QAnamnese> questionsList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ages.setItems(agesTypes);
        questionsList = FXCollections.observableArrayList();
        Questions.setItems(questionsList);
        Questions.setCellFactory(new Callback<ListView<QAnamnese>, ListCell<QAnamnese>>() {
            @Override
            public ListCell<QAnamnese> call(ListView<QAnamnese> param) {
                return new ListCell<QAnamnese>() {
                    @Override
                    protected void updateItem(QAnamnese item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getEnonce());  // Adjust to display relevant information
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });
    }

    @FXML
    void ajouter(ActionEvent event) {
        String selectedType = ages.getValue();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxmlfiles/EnonceQuestion.fxml"));
            Parent root = loader.load();
            EnonceQuestion enoncController = loader.getController();

            if ("Enfant".equals(selectedType)) {
                enoncController.setquestiontype(selectedType);
                System.out.println("yesesss");
            } else if ("Adulte".equals(selectedType)) {
                enoncController.setquestiontype(selectedType);
                System.out.println("noooooo");
            }
            enoncController.setParentController(this);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addQuestion(QAnamnese question) {
        if (questionsList != null) {
            questionsList.add(question);
        } else {
            System.err.println("questionsList is null!");
        }
    }

    @FXML
    void fetch(MouseEvent event) {

    }

    @FXML
    void save(ActionEvent event) {

        String titreText = titre.getText();
        String descriptionText = description.getText();

        if (titreText.isEmpty() || descriptionText.isEmpty()) {
            showAlert("error"," Ajouuter le titre et la description");
        }

        Anamnese anamnese = new Anamnese(titreText, descriptionText);
        anamnese.getquestioAnamneses().addAll(questionsList);
        SessionManager.getInstance().getCurrentUser().addAnamnese(anamnese);
        System.out.println("anamnes added");
        System.out.println("Anamnese saved: " + anamnese);

    }

     private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
