package Models;



import java.util.HashMap;
import java.util.Map;


public class UserManager {
    private static UserManager instance;
    private Map<String, Orthophoniste> users;

    private UserManager() {
        users = new HashMap<>();
        // Populate the user map with some example users
        // In a real application, you would retrieve users from a database or another data source
        Orthophoniste user1 = new Orthophoniste("Fares","lz");
        Orthophoniste user2 = new Orthophoniste("Grine","maz");
        users.put(user1.getNom(), user1);
        users.put(user2.getNom(), user2);
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public boolean authenticateUser(String username, String password) {
        Orthophoniste user = users.get(username);
        return user != null && user.getMotDePasse().equals(password);
    }

    public boolean addUser(Orthophoniste user) {
        if (users.containsKey(user.getNom())) {
            return false; // User already exists
        }
        users.put(user.getNom(), user);
        // Save users to storage if necessary
        return true;
    }
    public Orthophoniste getUserByUsername(String username) {
        return users.get(username);
    }

    // Other methods for user management can be added here, such as retrieving users by username, etc.
}
