package Person;

public class User extends Person {

    private String username;
    private int password;

    public User(String id, String name, String username, String password) {
        super(id, name);
        this.username = username;
        this.password = encrypt(password);
    }

    public User(String id, String name, String username, int password) {
        super(id, name);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = encrypt(password);
    }

    private int encrypt(String password) {
        return password.hashCode();
    }
}


