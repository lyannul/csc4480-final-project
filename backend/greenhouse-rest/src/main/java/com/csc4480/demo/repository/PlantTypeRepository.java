package com.csc4480.demo.repository;

import com.csc4480.demo.model.Plant;
import com.csc4480.demo.model.PlantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PlantTypeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PlantType> findAll() {
        String sql = "SELECT * FROM PLANT_TYPE";
        return jdbcTemplate.query(sql, new PlantTypeRowMapper());
    }

    public PlantType findByPlantTypeName(String typeName) {
        String sql = "SELECT * FROM PLANT_TYPE WHERE TYPENAME = ?";
        Object[] args = new Object[] { typeName };
        RowMapper<PlantType> rowMapper = new PlantTypeRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, args);
    }

    public List<PlantType> findByLocation(int locationId) {
        String sql = "SELECT * FROM PLANT_TYPE WHERE LOCATIONID = ?";
        Object[] args = new Object[] { locationId };
        RowMapper<PlantType> rowMapper = new PlantTypeRowMapper();
        return jdbcTemplate.query(sql, rowMapper, args);
    }

    public void save(PlantType plantType) {
        String sql = "INSERT INTO PLANT_TYPE(TYPENAME, DESCRIPTION, PRICE, COLOR, LOCATIONID, WATERNEEDS, SOILTYPE) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Object[] args = { plantType.getTypeName(), plantType.getDescription(), plantType.getPrice(),
            plantType.getColor(), plantType.getLocationID(), plantType.getWaterNeeds(), plantType.getSoilType() };
        jdbcTemplate.update(sql, args);
    }

    public void update(PlantType plantType) {
        String sql = "UPDATE PLANT_TYPE SET DESCRIPTION = ?, PRICE = ?, COLOR = ?, LOCATIONID = ?, WATERNEEDS = ?, SOILTYPE = ? " +
                "WHERE TYPENAME = ?";
        Object[] args = {plantType.getDescription(), plantType.getPrice(), plantType.getColor(),
                plantType.getLocationID(), plantType.getSoilType(), plantType.getWaterNeeds(), plantType.getTypeName() };
        jdbcTemplate.update(sql, args);
    }

    public void deleteByTypeName(String typeName) {
        String sql = "DELETE FROM PLANT_TYPE WHERE TYPENAME = ?";
        Object[] args = { typeName };
        jdbcTemplate.update(sql, args);
    }

    public static class PlantTypeRowMapper implements RowMapper<PlantType> {
        @Override
        public PlantType mapRow(ResultSet rs, int rowNum) throws SQLException {
            PlantType plantType = new PlantType();
            plantType.setTypeName(rs.getString("TypeName"));
            plantType.setDescription(rs.getString("Description"));
            plantType.setSoilType(rs.getString("SoilType"));
            plantType.setLocationID(rs.getInt("LocationID"));
            plantType.setColor(rs.getString("Color"));
            plantType.setPrice(rs.getInt("Price"));
            plantType.setWaterNeeds(rs.getString("WaterNeeds"));

            return plantType;
        }
    }
}

