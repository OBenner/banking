package ru.neoflex.banking.dao.Impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.neoflex.banking.dao.AccountDao;
import ru.neoflex.banking.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Repository
public class AccountDaoImpl implements AccountDao {


    @Autowired
    @Qualifier("queryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public Account getAccount(String accountNumber) {
        String sql = "select * from accounts where accountNumber = ?";
        try {
            return (Account) jdbcTemplate.queryForObject(sql, new Object[]{accountNumber}, new BeanPropertyRowMapper(Account.class));

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Account> getUserAccounts(String userName) {
        String sql = "SELECT * FROM accounts WHERE userName = ?";
        return jdbcTemplate.query(sql, new Object[]{userName}, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet rs, int rownumber) throws SQLException {
                Account account = new Account();
                account.setUserName(rs.getString(1));
                account.setAccCode(rs.getString(2));
                account.setAccountNumber(rs.getString(3));
                account.setAmount(rs.getDouble(4));

                log.info(account.toString());
                return account;
            }
        });

    }

    public void createAccount(Account account) {
        String sql = "INSERT INTO accounts (username,code,accountNumber,amount) VALUES(?,?,?,?)";

        jdbcTemplate.update(sql, new Object[]{account.getUserName(), account.getAccCode(), account.getAccountNumber(), account.getAmount()});

        log.info("create account : {}", account.getAccountNumber());
    }

    public void updateAccount(String accauntNumber, double amount) {
        String sql = "UPDATE accounts set amount = ? WHERE accauntNumber = ?";
        jdbcTemplate.update(sql, amount, accauntNumber);
        log.info("update account : {}", accauntNumber);
    }


    public void deleteAccount(String accauntNumber) {
        String deleteStatement = "DELETE FROM accounts WHERE accauntNumber=?";
        try {
            jdbcTemplate.update(deleteStatement, accauntNumber);
        } catch (RuntimeException runtimeException) {
            log.info(String.valueOf(runtimeException));
            throw runtimeException;

        }
    }
}
