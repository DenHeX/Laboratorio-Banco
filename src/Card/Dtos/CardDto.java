package Card.Dtos;

public abstract class CardDto {

    private String number;
    private boolean active;

    public String getNumber() {
        return number;
    }

    public boolean isActive() {
        return active;
    }

    public CardDto(String number) {
        this.number = number;
        this.active = true;
    }

}
