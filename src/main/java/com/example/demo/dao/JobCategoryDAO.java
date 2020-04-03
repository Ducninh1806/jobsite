package com.example.demo.dao;

import com.example.demo.model.JobCategory;

public interface JobCategoryDAO extends BaseDAO{

    JobCategory checkNameJobCategoryIsExist(String name);
}
