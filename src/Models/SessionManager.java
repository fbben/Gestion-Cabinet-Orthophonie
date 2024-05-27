package Models;

public class SessionManager {

    private static SessionManager instance;
    private Orthophoniste currentUser;

    private SessionManager() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Orthophoniste getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Orthophoniste user) {
        this.currentUser = user;
    }
}
