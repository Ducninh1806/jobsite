package com.example.demo.dao.impl;

import com.example.demo.dao.JobCategoryDAO;
import com.example.demo.model.JobCategory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobCategoryDaoImpl extends AbstractBaseDAO implements JobCategoryDAO {

    private final static Logger logger = LoggerFactory.getLogger(JobCategoryDaoImpl.class);

    @Override
    public JobCategory checkNameJobCategoryIsExist(String name) {
        String hql = "FROM JobCategory jc WHERE jc.name = :p_name";
        Query<JobCategory> query = getSession().createQuery(hql);
        query.setParameter("p_name", name);
        List<JobCategory> jobCategories = query.list();
        return jobCategories.isEmpty() ? null : jobCategories.get(0);
    }
}
