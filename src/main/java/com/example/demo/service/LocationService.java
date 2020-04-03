package com.example.demo.service;

import com.example.demo.dto.LocationDTO;
import com.example.demo.dto.LocationDetailDTO;
import com.example.demo.exception.LogicException;

public interface LocationService {

    void addLocation (LocationDTO locationDTO) throws LogicException;

    void updateLocation (LocationDTO locationDTO) throws LogicException;

    void deleteLocation (Long id) throws LogicException;

    LocationDetailDTO getLocationDetail (Long id) throws LogicException;
}
