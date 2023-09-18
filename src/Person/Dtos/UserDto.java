package Person.Dtos;

public class UserDto extends PersonDto{
    private String username;
    private int password;

    public UserDto(String username, int password, String id, String name) {
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
}


