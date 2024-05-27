import Exceptions.ExceptionUserDoesNotExist;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Fxmlfiles/Bienvenue.fxml"));
        primaryStage.setTitle("Orthophoniste Login");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}




























// public class Main {
//     private static final Logger logger = Logger.getLogger(Main.class.getName());

//     public static void main(String[] args) {
        

//         // String nom = "GRINE";
//         // Orthophoniste utilisateur = new Orthophoniste(nom);
//         // try {   
//         //     UserManager userManager = UserManager.getInstance();
//         //     userManager.setUser(utilisateur);
//         //     App.initiateInstance(utilisateur);
//         //     logger.info("User " + nom + " successfully initialized.");

//         // } catch (ExceptionUserDoesNotExist e) {
//         //     System.out.println("THIS ERROR SHOULD NEVER HAPPEN");
//         // }

//         // try {
//         //     //we'll try to authentic the user
//         //     utilisateur = UserManager.getInstance().Authentify("GRINE");
//         //     App.initiateInstance(utilisateur);
//         //     logger.info("User " + nom + " successfully authenticated.");


//         //     //once authenticated, we'll show the main view
//         //     //MainView.getInstance().show();
//         // } catch (ExceptionUserDoesNotExist e) {
//         //     //id the user is not found, we'll show a pop up asking him to create a user or not
//         //     System.out.println("USER DOESN't EXIST");
//         // }
        
//         // ArrayList<String> options = new ArrayList<>(Arrays.asList("op a", "op b"));
//         // ArrayList<Integer> correctAnswers = new ArrayList<>(Arrays.asList(1));
       
//         // ArrayList<Integer> reponses = new ArrayList<>(Arrays.asList(1));
//         // reponses.add(4);
          
//         // Patient p =new Adulte("AA", "ALAZ", "20/2020", "ici", "llza", "rien", "rien");
//         // Patient p2 =new Adulte("BB", "ALAZ", "20/2020", "ici", "llza", "rien", "rien");

//         // RendezVous rdv= new Consultation(12/12/2022, 22,"motif", p);

//         // Dossier dossier = new Dossier(1, p);
//         // Dossier dossier2 = new Dossier(2, p2);

//         // utilisateur.addDossier(dossier);
//         // utilisateur.addDossier(dossier2);


//         // utilisateur.ajouterRDV(1, rdv);

//         // try {
//         //     UserManager.getInstance().setUser(utilisateur);
//         //     logger.info("User " + nom + " serialized successfully.");
//         // } catch (ExceptionUserDoesNotExist e) {
//         //     System.out.println("Error occurred during serialization.");
//         // }
        
//         // dossier.afficher();
//         // dossier2.afficher();

//         // QAnamnese anamnese= new QAnamnese("Anemnese", Categorie.Histoire);
//         // QuestionChoixMultiple questionQuestionChoixMultiple = new QuestionChoixMultiple("c'est quoi ", options, correctAnswers);
//         // Exercice exercice = new Exercice("Consigne", "cube");

//         // Anamnese anamnese_test = new Anamnese("anamanese1", "vise à");
//         // anamnese_test.getquestioAnamneses().add(anamnese);
//         // TExercice exercice_test = new TExercice("test exercice", "vise la ...");
//         // exercice_test.getexercices().add(exercice);
//         // TQuestionnaires questionnaires_test = new TQuestionnaires("nom", "nom");
//         // questionnaires_test.getquestions().add(questionQuestionChoixMultiple);
        

        

        






        

        

//     }

// }
