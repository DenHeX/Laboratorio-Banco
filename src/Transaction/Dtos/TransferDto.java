/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaction.Dtos;

import Account.Account;
import java.util.Date;

public class TransferDto extends TransactionDto {
    private Account destination;

    public TransferDto(double amount, Account source, Account destination, Date date) {
        super(amount, source, date);
        this.destination = destination;
    }

    public Account getDestination() {
        return destination;
    }
}
