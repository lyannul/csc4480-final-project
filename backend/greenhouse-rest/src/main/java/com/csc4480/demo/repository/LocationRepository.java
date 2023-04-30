package com.csc4480.demo.repository;

import com.csc4480.demo.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LocationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Location getById(int id) {
        String query = "SELECT * FROM LOCATION WHERE LocationID = ?";
        return jdbcTemplate.queryForObject(query, new LocationMapper(), id);
    }

    public List<Location> getAll() {
        String query = "SELECT * FROM LOCATION";
        return jdbcTemplate.query(query, new LocationMapper());
    }

    public void create(Location location) {
        String query = "INSERT INTO LOCATION (LocationID, LocationSector, Humidity, Temperature) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query, location.getLocationID(), location.getLocationSector(), location.getHumidity(), location.getTemperature());
    }

    public void update(Location location) {
        String query = "UPDATE LOCATION SET LocationSector = ?, Humidity = ?, Temperature = ? WHERE LocationID = ?";
        jdbcTemplate.update(query, location.getLocationSector(), location.getHumidity(), location.getTemperature(), location.getLocationID());
    }

    public void delete(int id) {
        String query = "DELETE FROM LOCATION WHERE LocationID = ?";
        jdbcTemplate.update(query, id);
    }

    private static class LocationMapper implements RowMapper<Location> {
        @Override
        public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
            Location location = new Location();
            location.setLocationID(rs.getInt("LocationID"));
            location.setLocationSector(rs.getString("LocationSector"));
            location.setHumidity(rs.getInt("Humidity"));
            location.setTemperature(rs.getInt("Temperature"));
            return location;
        }
    }
}
