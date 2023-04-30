package com.csc4480.demo.service;

import com.csc4480.demo.model.Location;
import com.csc4480.demo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.getAll();
    }

    public Location getLocationById(int locationId) {
        return locationRepository.getById(locationId);
    }

    public void createLocation(Location location) {
        locationRepository.create(location);
    }

    public void updateLocation(Location location) {
        locationRepository.update(location);
    }

    public void deleteLocation(int locationId) {
        locationRepository.delete(locationId);
    }
}

