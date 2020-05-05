package com.rg.eventappweb.repositories;

import com.rg.eventappweb.models.Event;
import com.rg.eventappweb.models.Guest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EVENT_JDBC")
public class JDBCEventRepository implements EventRepository {

    private final NamedParameterJdbcTemplate template;

    public JDBCEventRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override


    public void save(Event event) {
        final String sql = "insert into event(id, title) values(:id,:title)";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", event.getId())
                .addValue("title", event.getTitle());


        template.update(sql, param);
    }


    @Override
    public void update(Event event) {
        final String sql = " insert into guest (id, email) values(:id, :email)";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", event.getId())
                .addValue("title", event.getTitle());
        template.update(sql, param);

    }

    @Override
    public List<Event> findAll() {
        return template.query("select * from event", new EventRowMapper());
    }

    @Override
    public Event findById(String id) {
        String sql = "select * from event where id=:id";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);
        Event event  = template.queryForObject(sql, param, new EventRowMapper());
        event.setGuests(loadGuests(id));
        return event;
    }

    @Override
    public void addGuest(String eventId, String guestId) {
        final String sql = "insert into event_guest(event_id, guest_id) values(:eventId,:guestId)";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("eventId", eventId)
                .addValue("guestId", guestId);
        template.update(sql, param);
    }


    private List<Guest> loadGuests(String eventId){

        String sql = "select * from guest where guest.id in ( select guest_id from event_guest where event_id = :id)";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", eventId);
        return template.query(sql, param, new GuestRowMapper());
    }
}
