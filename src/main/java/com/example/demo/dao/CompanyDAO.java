package com.example.demo.dao;

import com.example.demo.model.Company;

public interface CompanyDAO {

    Company checkNameCompanyIsExist(String name);
}
