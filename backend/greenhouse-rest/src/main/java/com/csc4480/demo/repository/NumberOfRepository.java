package com.csc4480.demo.repository;

import com.csc4480.demo.model.NumberOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NumberOfRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<NumberOf> findAll() {
        String sql = "SELECT * FROM NUMBER_OF";
        return jdbcTemplate.query(sql, new NumberOfRowMapper());
    }

    public NumberOf findByTypeLocation(String plantType, int locationId) {
        String sql = "SELECT * FROM NUMBER_OF WHERE PlantType = ? AND LOCATIONID = ?";
        return (NumberOf) jdbcTemplate.query(sql, new NumberOfRowMapper(), plantType, locationId);
    }

    public List<NumberOf> findByPlantType(String plantType) {
        String sql = "SELECT * FROM NUMBER_OF WHERE PlantType = ?";
        return jdbcTemplate.query(sql, new NumberOfRowMapper(), plantType);
    }

    public List<NumberOf> findByLocationId(int locationId) {
        String sql = "SELECT * FROM NUMBER_OF WHERE LocationID = ?";
        return jdbcTemplate.query(sql, new NumberOfRowMapper(), locationId);
    }

    public NumberOf save(NumberOf numberOf) {
        String sql = "INSERT INTO NUMBER_OF (PlantType, LocationID, Quantity) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, numberOf.getPlantType(), numberOf.getLocationID(), numberOf.getQuantity());
        return numberOf;
    }

    public void update(NumberOf numberOf) {
        String sql = "UPDATE NUMBER_OF SET Quantity = ? WHERE PlantType = ? AND LocationID = ?";
        jdbcTemplate.update(sql, numberOf.getQuantity(), numberOf.getPlantType(), numberOf.getLocationID());
    }

    public void delete(String plantType, int locationId) {
        String sql = "DELETE FROM NUMBER_OF WHERE PlantType = ? AND LocationID = ?";
        jdbcTemplate.update(sql, plantType, locationId);
    }

    private static class NumberOfRowMapper implements RowMapper<NumberOf> {
        @Override
        public NumberOf mapRow(ResultSet rs, int rowNum) throws SQLException {
            NumberOf numberOf = new NumberOf();
            numberOf.setLocationID(rs.getInt("LocationID"));
            numberOf.setPlantType(rs.getString("PlantType"));
            numberOf.setQuantity(rs.getInt("Quantity"));
            return numberOf;
        }
    }
}

