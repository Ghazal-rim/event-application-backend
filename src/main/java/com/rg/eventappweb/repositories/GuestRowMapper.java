package com.rg.eventappweb.repositories;

import com.rg.eventappweb.models.Guest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestRowMapper implements RowMapper<Guest> {


    @Override
    public Guest mapRow(ResultSet resultSet, int i) throws SQLException {
        Guest guest = new Guest();
        guest.setId(resultSet.getString("id"));
        guest.setEmail(resultSet.getString("email"));
        return guest;
    }
}
