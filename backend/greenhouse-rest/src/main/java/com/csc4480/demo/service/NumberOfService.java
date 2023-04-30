package com.csc4480.demo.service;

import com.csc4480.demo.model.NumberOf;
import com.csc4480.demo.repository.NumberOfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberOfService {

    @Autowired
    private NumberOfRepository numberOfRepository;

    public NumberOf getNumberOfByTypeLocation(String plantType, int locationId) {
        return numberOfRepository.findByTypeLocation(plantType, locationId);
    }

    public List<NumberOf> getAllNumberOf() {
        return numberOfRepository.findAll();
    }

    public NumberOf addNumberOf(NumberOf numberOf) {
        return numberOfRepository.save(numberOf);
    }

    public void deleteNumberOf(String plantType, int locationId) {
        numberOfRepository.delete(plantType, locationId);
    }

}