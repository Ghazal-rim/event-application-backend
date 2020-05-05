package com.rg.eventappweb.repositories;

import com.rg.eventappweb.models.Event;
import com.rg.eventappweb.models.Guest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("GUEST_JDBC")
public class JDBGuestRepository implements GuestRepository {

    private NamedParameterJdbcTemplate template;

    public JDBGuestRepository (NamedParameterJdbcTemplate template){
        this.template = template;
    }



    @Override
    public void save(Guest guest) {
        final String sql = "insert into guest(id, email) values(:id,:email)";
        System.out.println("DAO: " + guest);
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", guest.getId())
                .addValue("email", guest.getEmail());


        template.update(sql,param);
    }

    @Override
    public Guest findById(String id) {
        String sql = "select * from guest where id= :id";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);
        return  template.queryForObject(sql , param, new GuestRowMapper());
    }

    @Override

        public List<Guest> findAll() {
            return template.query("select * from guest", new GuestRowMapper());
        }

}
