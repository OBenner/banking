package ru.neoflex.banking.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.neoflex.banking.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;


    public  class UserRowMapper implements RowMapper
    {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUsername(rs.getString(1));
            user.setPhone(rs.getString(2));
            user.setEmail(rs.getString(3));
            return user;
        }

    }

