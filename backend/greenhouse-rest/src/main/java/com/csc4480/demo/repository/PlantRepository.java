package com.csc4480.demo.repository;

import com.csc4480.demo.model.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PlantRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Plant> findAll() {
        String sql = "SELECT * FROM PLANT";
        return jdbcTemplate.query(sql, new PlantRowMapper());
    }

    public Plant findByPlantID(int plantID) {
        String sql = "SELECT * FROM PLANT WHERE PlantID = ?";
        Object[] args = new Object[] { plantID };
        RowMapper<Plant> rowMapper = new PlantRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, args);
    }

    public Plant findByLocation(int plantID) {
        String sql = "SELECT * FROM PLANT WHERE PlantID = ?";
        Object[] args = new Object[] { plantID };
        RowMapper<Plant> rowMapper = new PlantRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, args);
    }

    public void save(Plant plant) {
        String sql = "INSERT INTO PLANT(PLANTID, CUSTOMERID, PLANTTYPE, HEIGHT, HYDRATED, SUNLIGHTSTATUS) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        Object[] args = { plant.getPlantID(), plant.getCustomerID(), plant.getPlantType(),
                plant.getHeight(), plant.getHydrated(), plant.getSunlightStatus() };
        jdbcTemplate.update(sql, args);
    }

    public void update(Plant plant) {
        String sql = "UPDATE PLANT SET CUSTOMERID = ?, PLANTTYPE = ?, HEIGHT = ?, HYDRATED = ?, SUNLIGHTSTATUS = ? " +
                "WHERE PLANTID = ?";
        Object[] args = { plant.getCustomerID(), plant.getPlantType(), plant.getHeight(), plant.getHydrated(),
                plant.getSunlightStatus(), plant.getPlantID()};
        jdbcTemplate.update(sql, args);
    }

    public void deleteById(int employeeId) {
        String sql = "DELETE FROM EMPLOYEE WHERE EmployeeID = ?";
        Object[] args = { employeeId };
        jdbcTemplate.update(sql, args);
    }

    private static class PlantRowMapper implements RowMapper<Plant> {
        @Override
        public Plant mapRow(ResultSet rs, int rowNum) throws SQLException {
            Plant plant = new Plant();
            plant.setPlantID(rs.getInt("PlantID"));
            plant.setPlantType(rs.getString("PlantType"));
            plant.setCustomerID(rs.getInt("CustomerID"));
            plant.setHeight(rs.getInt("Height"));
            plant.setHydrated(rs.getInt("Hydrated"));
            plant.setSunlightStatus(rs.getInt("SunlightStatus"));
            return plant;
        }
    }
}
