/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaction.Dtos;

import Account.Account;
import java.util.Date;

/**
 *
 * @author rsand
 */
public class WithdrawalDto extends TransactionDto {

    public WithdrawalDto(double amount, Account source, Date date) {
        super(amount, source, date);
    }

}
