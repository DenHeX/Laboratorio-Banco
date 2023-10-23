/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;

import Account.Account;
import Card.Card;
import Person.Customer;
import Person.User;
import Transaction.Transaction;
import java.sql.Date;

/**
 *
 * @author ´Felipe Chacón
 */
public class Bank {
    
    public void crearUsuario(String id, String nombre, String username, String password){
        FactoryUser userFactory = new FactoryUser();
        User u1 = new User(id,nombre,username,password);
        //DaoUser du = new DaoUser;
        //du.create(u1);
        System.out.println("Se creo un usuario");
    }
    
    public void crearCliente(String id, String name, Date dateOfBirth, String phone, String email, String address){
        FactoryCustomer customerFactory = new FactoryCustomer();
        Customer c1 = new Customer(id, name, dateOfBirth, phone, email, address);
        System.out.println("Se creo un cliente");
    }
    
    public void crearCuenta(int type, String number, double balance, double creditLimit, double interestRate, Account account){
        FactoryAccount fc = new FactoryAccount();
       // Account a1 = fc.factory(id, balance, customer, type);
        //DaoAccount da = new DaoAccount;
        //da.create(a1);
        System.out.println("Se creo una cuenta");
       
    }
    
    public void crearTarjeta(int type, String number, double balance, double creditLimit, double interestRate, Account account){
        FactoryCard cardFactory = new FactoryCard();
       // Card cd1 = new Card(type, number, balance, creditLimit, interestRate, account);
        System.out.println("Se creo una tarjeta");
    }
    
    public void crearTransaccion(double amount, Account source, Account destination, int type){
        FactoryTransaction transactionFactory = new FactoryTransaction();
       // Transaction t1 = new Transaction(amount, source, destination, type);
        System.out.println("Se creo una transaccion");
    }
    
    Bank bank = new Bank();
    
   // bank.crearCliente();
   // bank.crearCuenta();
   // bank.crearTarjeta();
   // bank.crearTransaccion();
}