package Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AjouterRDV implements Initializable{

    @FXML
    private ChoiceBox<String> ages;

    @FXML
    private DatePicker date;

    @FXML
    private Button suivant;

    @FXML
    private TextField text;

    @FXML
    private ChoiceBox<String> typesRDV;
    
    private ObservableList<String> appointmentTypes = FXCollections.observableArrayList(
            "Consultaion", "Suivi", "Atelier" 
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typesRDV.setItems(appointmentTypes);
        ages.setItems(agesTypes);
         
        SpinnerValueFactory<Integer> valueFactory1 =new SpinnerValueFactory.IntegerSpinnerValueFactory(8, 17, 8);
        SpinnerValueFactory<Integer> valueFactory2 =new SpinnerValueFactory.IntegerSpinnerValueFactory(00, 59, 00);

         
           heure.setValueFactory(valueFactory1);
           minutes.setValueFactory(valueFactory2);
        


        typesRDV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if ("Consultaion".equals(newValue)) {
                    // Enable ages ChoiceBox if the selected item is "Consultaion"
                    ages.setDisable(false);
                } else {
                    // Otherwise, disable ages ChoiceBox
                    ages.setDisable(true);
                }
            }



        });
    }
    private ObservableList<String> agesTypes = FXCollections.observableArrayList(
            "Adulte", "Enfant" 
    );

    @FXML
    private Spinner<Integer> heure;

    @FXML
    private Spinner<Integer> minutes;

    @FXML
    void Date(ActionEvent event) {

    }

    @FXML
    void Text(ActionEvent event) {

    }

    @FXML
    void fetch(MouseEvent event) {

    }

    @FXML
    void suivant(ActionEvent event) {
        String selectedType = typesRDV.getValue();
        String selectedAge = ages.getValue();
        LocalDate selectedDate = date.getValue();
        String selectedobservation= text.getText();
        int selectedheure =heure.getValue();
        int selectedminutes =minutes.getValue();
        
        if (selectedDate == null || selectedDate.isBefore(LocalDate.now())) {
            // Display an alert
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Date");
            alert.setHeaderText(null);
            if (selectedDate == null) {
                alert.setContentText("Please select a date.");
            } else {
                alert.setContentText("The selected date cannot be before today's date.");
            }
            alert.showAndWait();
            return; // Prevent further execution
        }
    
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
    
            if ("Consultaion".equals(selectedType) && "Enfant".equals(selectedAge)) {
                root = loader.load(getClass().getResource("/Fxmlfiles/Consultation_enfant.fxml").openStream());
                Cenfant controller = loader.getController();
                controller.initData(selectedDate, selectedobservation,selectedheure,selectedminutes);
                
            } else if ("Consultaion".equals(selectedType) && "Adulte".equals(selectedAge)) {
                root = loader.load(getClass().getResource("/Fxmlfiles/Consultation_adulte.fxml").openStream());
                Cadulte controller = loader.getController();
                controller.initData(selectedDate, selectedobservation,selectedheure,selectedminutes);
            }else if ("Atelier".equals(selectedType)) {
                // Load the AjouterRDV scene
                root = FXMLLoader.load(getClass().getResource("/Fxmlfiles/Atelier.fxml"));
            } else if ("Suivi".equals(selectedType)) {
                // Load the AjouterRDV scene
                root = loader.load(getClass().getResource("/Fxmlfiles/Suivi.fxml").openStream());
                Csuivi controller = loader.getController();
                controller.initData(selectedDate, selectedobservation,selectedheure,selectedminutes);
            }
    
            // Get a reference to the current stage
            Stage stage = (Stage) suivant.getScene().getWindow();
    
            // Update the scene with the new content
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

}
