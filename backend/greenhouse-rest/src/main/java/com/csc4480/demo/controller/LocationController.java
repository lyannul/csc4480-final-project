package com.csc4480.demo.controller;

import com.csc4480.demo.model.Location;
import com.csc4480.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    // Get all locations
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    // Get location by ID
    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable("id") int id) {
        Location location = locationService.getLocationById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    // Create a new location
    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        locationService.createLocation(location);
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }

    // Update an existing location
    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@RequestBody Location location) {
        locationService.updateLocation(location);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    // Delete a location by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Location> deleteLocation(@PathVariable("id") int id) {
        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

