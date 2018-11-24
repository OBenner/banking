package ru.neoflex.banking.dao;

import org.springframework.stereotype.Repository;
import ru.neoflex.banking.model.Account;

import java.util.List;


public interface AccountDao {
    Account getAccount(String accountNumber);

    List<Account> getUserAccounts(String userName);

    void updateAccount(String accauntNumber, double amount);

    void createAccount(Account account);

    void deleteAccount(String accauntNumber);

}
