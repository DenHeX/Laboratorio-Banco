package Transaction.Dtos;

import Account.Account;
import java.util.Date;

public class DepositDto extends TransactionDto {

    public DepositDto(double amount, Account source, Date date) {
        super(amount, source, date);
    }
}