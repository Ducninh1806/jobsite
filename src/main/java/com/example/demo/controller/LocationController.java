package com.example.demo.controller;

import com.example.demo.dto.LocationDTO;
import com.example.demo.dto.LocationDetailDTO;
import com.example.demo.exception.LogicException;
import com.example.demo.service.impl.LocationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {

    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);
    private LocationServiceImpl locationService;


    public LocationController(LocationServiceImpl locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<LocationDTO> addLocation (@RequestBody LocationDTO locationDTO) throws LogicException {
        logger.info("Controller about add Location :{}", locationDTO);

        locationService.addLocation(locationDTO);
        return new ResponseEntity<>(locationDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LocationDTO> updateLocation (@RequestBody LocationDTO locationDTO) throws LogicException {
        logger.info("Controller about update Location :{}", locationDTO);

        locationService.updateLocation(locationDTO);
        return new ResponseEntity<>(locationDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLocation (@PathVariable Long id) throws LogicException {
        logger.info("Controller about delete Location :{}", id);

        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDetailDTO> getLocationDetail (@PathVariable Long id) throws LogicException {
        logger.info("Controller about get Location detail :{}", id);

        LocationDetailDTO locationDetailDTO= locationService.getLocationDetail(id);
        return new ResponseEntity<>(locationDetailDTO, HttpStatus.OK);
    }
}
