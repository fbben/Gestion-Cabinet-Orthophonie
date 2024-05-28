package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BOs {

    @FXML
    private Button ajouteranamnese;

    @FXML
    private Button ajouterdiagnostic;

    @FXML
    private Button ajouterepreuve;

    @FXML
    private ListView<?> anamneses;

    @FXML
    private TableColumn<?, ?> categorie;

    @FXML
    private TableView<?> diagnostic;

    @FXML
    private TableView<?> epreuves;

    @FXML
    private TableColumn<?, ?> observation;

    @FXML
    private TextField project;

    @FXML
    private Button save;

    @FXML
    private TableColumn<?, ?> score;

    @FXML
    private TableColumn<?, ?> test;

    @FXML
    private TableColumn<?, ?> trouble;

    @FXML
    private TableColumn<?, ?> type;

}
