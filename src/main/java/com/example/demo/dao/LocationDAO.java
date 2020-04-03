package com.example.demo.dao;

import com.example.demo.model.Location;

public interface LocationDAO extends BaseDAO {

    Location checkLocationIsExist(String name);
}
