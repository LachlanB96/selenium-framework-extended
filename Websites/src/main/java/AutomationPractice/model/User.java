package AutomationPractice.model;

public class User {

    private static String username = "test@lachlanb.com";
    private static String password = "password";

    public static String getUsername(){
        return User.username;
    }
    public static void setUsername(String newUsername) {
        User.username = newUsername;
    }

    public static String getPassword(){
        return User.password;
    }
    public static void setPassword(String newPassword) {
        User.password = newPassword;
    }
}
