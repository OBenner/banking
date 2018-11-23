package ru.neoflex.banking.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.neoflex.banking.model.User;

@Repository
public class UserDao {


    @Autowired
    @Qualifier("queryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;



    @Transactional(readOnly = true)
    public User findUserByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        try {
            return (User) jdbcTemplate.queryForObject(
                    "select  users.username, users.phone, users.email from users  where users.username = ?", new Object[] { name }, new UserRowMapper());
        } catch (EmptyResultDataAccessException notFound) {
            return null;
        }
    }



}
