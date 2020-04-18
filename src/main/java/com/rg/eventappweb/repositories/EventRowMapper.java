package com.rg.eventappweb.repositories;

import com.rg.eventappweb.models.Event;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventRowMapper implements RowMapper<Event> {

    @Override
    public Event mapRow(ResultSet rs, int arg1) throws SQLException {
        Event event = new Event();
        event.setId(rs.getString("id"));
        event.setTitle(rs.getString("title"));
        return event;
    }
}
