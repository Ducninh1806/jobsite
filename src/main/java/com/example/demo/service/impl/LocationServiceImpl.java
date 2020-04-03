package com.example.demo.service.impl;

import com.example.demo.dao.impl.LocationDaoImpl;
import com.example.demo.dto.LocationDTO;
import com.example.demo.dto.LocationDetailDTO;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.LogicException;
import com.example.demo.model.Location;
import com.example.demo.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    private static final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);
    private LocationDaoImpl locationDao;

    public LocationServiceImpl(LocationDaoImpl locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public void addLocation(LocationDTO locationDTO) throws LogicException {
        logger.info("Service info about add Location :{}", locationDTO);

        Location locationId = locationDao.checkLocationIsExist(locationDTO.getLocationName());
        if (locationId != null){
            throw new LogicException(ErrorCode.NAME_EXISTED);
        }
        Location location = new Location();
        location.setLocationName(locationDTO.getLocationName());
        location.setLocationCode(locationDTO.getLocationCode());
        location.setParentId(locationDTO.getParentId());
        location.setImageUrl(locationDTO.getImageUrl());
        location.setCreatedDate(locationDTO.getCreatedDate());
        location.setCreatedBy(locationDTO.getCreatedBy());

        locationDao.save(location);
    }

    @Override
    public void updateLocation(LocationDTO locationDTO) throws LogicException {
        logger.info("Service info about update Location :{}", locationDTO);

        Optional<Location> locationId = locationDao.findById(locationDTO.getId(), Location.class);
        if (!locationId.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }
        Location location = locationId.get();

        location.setLocationName(locationDTO.getLocationName());
        location.setLocationCode(locationDTO.getLocationCode());
        location.setParentId(locationDTO.getParentId());
        location.setImageUrl(locationDTO.getImageUrl());
        location.setCreatedDate(locationDTO.getCreatedDate());
        location.setCreatedBy(locationDTO.getCreatedBy());

        locationDao.update(location);
    }

    @Override
    public void deleteLocation(Long id) throws LogicException {
        logger.info("Service info about delete Location :{}", id);

        Optional<Location> location = locationDao.findById(id, Location.class);
        if (!location.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }

        locationDao.delete(location.get());
    }

    @Override
    public LocationDetailDTO getLocationDetail(Long id) throws LogicException {
        logger.info("Service info about get Location detail :{}", id);
        Optional<Location> locationById = locationDao.findById(id, Location.class);
        if (!locationById.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }
        LocationDetailDTO locationDetailDTO = new LocationDetailDTO();
        Location location = locationById.get();

        locationDetailDTO.setId(location.getId());
        locationDetailDTO.setLocationCode(location.getLocationCode());
        locationDetailDTO.setLocationName(location.getLocationName());
        locationDetailDTO.setImageUrl(location.getImageUrl());
        locationDetailDTO.setParentId(location.getParentId());
        locationDetailDTO.setCreatedDate(location.getCreatedDate());
        locationDetailDTO.setCreatedBy(location.getCreatedBy());

        return locationDetailDTO;
    }
}
