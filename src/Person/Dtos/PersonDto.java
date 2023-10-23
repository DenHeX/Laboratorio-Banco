package Person.Dtos;

public abstract class PersonDto  {
    private String id;
    private String name;

    public PersonDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
