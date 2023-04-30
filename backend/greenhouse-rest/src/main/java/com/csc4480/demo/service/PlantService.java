package com.csc4480.demo.service;

import com.csc4480.demo.model.Plant;
import com.csc4480.demo.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    public Plant getPlantById(int plantId) {
        return plantRepository.findByPlantID(plantId);
    }

    public void addPlant(Plant plant) {
        plantRepository.save(plant);
    }

    public void updatePlant(Plant plant) {
        plantRepository.save(plant);
    }

    public void deletePlant(int plantId) {
        plantRepository.deleteById(plantId);
    }
}

