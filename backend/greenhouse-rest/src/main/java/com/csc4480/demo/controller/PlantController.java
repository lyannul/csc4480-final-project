package com.csc4480.demo.controller;

import com.csc4480.demo.model.Plant;
import com.csc4480.demo.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping("/{plantId}")
    public Plant getPlantById(@PathVariable int plantId) {
        return plantService.getPlantById(plantId);
    }

    @PostMapping
    public void addPlant(@RequestBody Plant plant) {
        plantService.addPlant(plant);
    }

    @PutMapping("/{plantId}")
    public void updatePlant(@RequestBody Plant plant, @PathVariable int plantId) {
        plant.setPlantID(plantId);
        plantService.updatePlant(plant);
    }

    @DeleteMapping("/{plantId}")
    public void deletePlant(@PathVariable int plantId) {
        plantService.deletePlant(plantId);
    }
}

