package com.csc4480.demo.controller;

import com.csc4480.demo.model.NumberOf;
import com.csc4480.demo.service.NumberOfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/number_of")
public class NumberOfController {

    @Autowired
    private NumberOfService numberOfService;

    @GetMapping("/numberof")
    public List<NumberOf> getAllNumberOf() {
        return numberOfService.getAllNumberOf();
    }

    @GetMapping("/numberof/{plantType}/{locationId}")
    public ResponseEntity<NumberOf> getNumberOf(@PathVariable String plantType, @PathVariable int locationId) {
        NumberOf numberOf = numberOfService.getNumberOfByTypeLocation(plantType, locationId);
        if (numberOf == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(numberOf, HttpStatus.OK);
        }
    }

    @PostMapping("/numberof")
    public ResponseEntity<NumberOf> addNumberOf(@RequestBody NumberOf numberOf) {
        NumberOf addedNumberOf = numberOfService.addNumberOf(numberOf);
        return new ResponseEntity<>(addedNumberOf, HttpStatus.CREATED);
    }

    @DeleteMapping("/numberof/{plantType}/{locationId}")
    public ResponseEntity<Void> deleteNumberOf(@PathVariable String plantType, @PathVariable int locationId) {
        numberOfService.deleteNumberOf(plantType, locationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}