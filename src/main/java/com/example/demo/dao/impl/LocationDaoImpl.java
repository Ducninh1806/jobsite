package com.example.demo.dao.impl;

import com.example.demo.dao.LocationDAO;
import com.example.demo.model.Location;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class LocationDaoImpl extends AbstractBaseDAO implements LocationDAO {

    private static final Logger logger = LoggerFactory.getLogger(LocationDaoImpl.class);

    @Override
    public Location checkLocationIsExist(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FROM Location");
        stringBuilder.append(" WHERE location_name = :p_name");
        Query<Location> query = getSession().createQuery(stringBuilder.toString());

//        String hql = "from Location where location_name = :p_name";
//        Query<Location> query = getSession().createQuery(hql);
        query.setParameter("p_name", name);
        List<Location> location = query.list();
//
        return location.isEmpty() ? null : location.get(0);

//        String hql = "FROM Location WHERE location_name = :p_name";
//        Query<Location> query = getSession().createQuery(hql,Location.class);
//        query.setParameter("p_name", name);
//        List<Location> locations = query.list();
//        return CollectionUtils.isEmpty(locations) ? null : locations.get(0);
    }
}
