package net.majri.ebankingbackend.services;

import net.majri.ebankingbackend.entities.BankAccount;
import net.majri.ebankingbackend.entities.CurrentAccount;
import net.majri.ebankingbackend.entities.Customer;
import net.majri.ebankingbackend.entities.SavingAccount;
import net.majri.ebankingbackend.exceptions.BankAccountNotFoundException;
import net.majri.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<Customer> listCustomers();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId,double amount, String description);
    void credit(String accountId,double amount, String description);
    void transfert(String accountIdSource,String accountIdDestination,double amount);
}
