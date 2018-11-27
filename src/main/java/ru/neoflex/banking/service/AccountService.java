package ru.neoflex.banking.service;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import ru.neoflex.banking.dao.AccountDao;
import ru.neoflex.banking.dao.Impl.AccountDaoImpl;
import ru.neoflex.banking.model.Account;

import java.util.List;

@Service
@Slf4j
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public void createAccount(String username, String accCode) {
        try {
            String accNumber = RandomStringUtils.randomNumeric(10);
            double amount = 0.0;
            Account account = new Account(username, accCode, amount, accNumber);
            accountDao.createAccount(account);
            log.info("create account : [{}]", account);
        } catch (DuplicateKeyException e) {
            createAccount(username, accCode);
        }

    }

    public void updateAccount(String accountNumber, double amount) {
        accountDao.updateAccount(accountNumber, amount);
    }

    public void deleteAccount(String accountNumber) {
        accountDao.deleteAccount(accountNumber);
    }

    public List<Account> getAccounts(String userName) {
        return accountDao.getUserAccounts(userName);
    }

    public Account getAccount(String accountNumber) {
        return accountDao.getAccount(accountNumber);
    }
}
