package com.csc4480.demo.service;

import com.csc4480.demo.model.PlantType;
import com.csc4480.demo.repository.PlantTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlantTypeService {

    @Autowired
    private PlantTypeRepository plantTypeRepository;

    public List<PlantType> getAllPlants() {
        return plantTypeRepository.findAll();
    }

    public PlantType getPlantByTypeName(String typeName) {
        return plantTypeRepository.findByPlantTypeName(typeName);
    }

    public void addPlantType(PlantType plantType) {
        plantTypeRepository.save(plantType);
    }

    public void updatePlantType(PlantType plantType) {
        plantTypeRepository.update(plantType);
    }

    public void deletePlantType(String typeName) {
        plantTypeRepository.deleteByTypeName(typeName);
    }
}
