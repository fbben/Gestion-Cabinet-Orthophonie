package Models;

import Exceptions.*;

public class App {



    public static App instance = null;

    private App(Orthophoniste utilisateur) {
        this.utilisateur = utilisateur;
    }

    public static App initiateInstance(Orthophoniste utilisateur) {
        if (instance == null) {
            instance = new App(utilisateur);
            return instance;
        }
        else return instance;
    }

    public static App getInstance() {
        return instance;
    }

    private  Orthophoniste utilisateur;

    public static boolean isAlphaNumeric(String string) {
        // Renvoies vrai si string est alphanumérique
        return string != null && string.matches("^[a-zA-Z0-9]*$");
    }

    public void controleDeSaisie(String saisie) throws ExceptionSaisieInvalide {
        // Cette methode permets de controler les inputes en verifiant si c'est blank , vide et que c'est bien alphanumérique
        if (saisie.isEmpty() || saisie.isBlank() ){throw new ExceptionSaisieInvalide("ERREUR : Champ vide");}
        else if ( !isAlphaNumeric(saisie)) {throw new ExceptionSaisieInvalide("ERREUR : Le nom d'utilisateur ne doit contenir que des caractéres alphanumériques.");}
    }



    

}
