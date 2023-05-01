package com.csc4480.demo.controller;

import com.csc4480.demo.model.PlantType;
import com.csc4480.demo.service.PlantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plant_types")
public class PlantTypeController {

    @Autowired
    private PlantTypeService plantTypeService;

    @GetMapping
    public List<PlantType> getAllPlants() {
        return plantTypeService.getAllPlants();
    }

    @GetMapping("/{typeName}")
    public PlantType getPlantByTypeName(@PathVariable String typeName) {
        return plantTypeService.getPlantByTypeName(typeName);
    }

    @PostMapping
    public void addPlant(@RequestBody PlantType plantType) {
        plantTypeService.addPlantType(plantType);
    }

    @PutMapping("/{typeName}")
    public void updatePlant(@RequestBody PlantType plantType, @PathVariable String typeName) {
        PlantType p = plantTypeService.getPlantByTypeName(typeName);
        // update the plant object with new values
        p.setTypeName(plantType.getTypeName());
        p.setPrice(plantType.getPrice());
        p.setLocationID(plantType.getLocationID());
        p.setSoilType(plantType.getSoilType());
        p.setColor(plantType.getColor());
        p.setDescription(plantType.getDescription());
        p.setWaterNeeds(plantType.getWaterNeeds());

        plantTypeService.updatePlantType(p);
    }

    @DeleteMapping("/{typeName}")
    public void deletePlant(@PathVariable String typeName) {
        plantTypeService.deletePlantType(typeName);
    }
}

