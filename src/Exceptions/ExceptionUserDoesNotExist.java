package Exceptions;

public class ExceptionUserDoesNotExist extends Exception{
    public ExceptionUserDoesNotExist() {
        super("ERREUR : Cet utilisateur n'existe pas");
    }

    public ExceptionUserDoesNotExist(String message) {
        super(message);
    }
}
