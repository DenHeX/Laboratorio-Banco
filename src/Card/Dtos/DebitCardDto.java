package Card.Dtos;

import Account.Account;
import Card.DebitCard;

public class DebitCardDto extends DebitCard {

    private Account account;
    private String number;

    public DebitCardDto(Account account, String number, boolean active) {
        super(account, number, active);
    }

    public Account getAccount() {
        return account;
    }
}
