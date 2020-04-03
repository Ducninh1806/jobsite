package com.example.demo.dao.impl;

import com.example.demo.dao.CompanyDAO;
import com.example.demo.model.Company;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDaoImpl extends AbstractBaseDAO implements CompanyDAO {

    @Override
    public Company checkNameCompanyIsExist(String name) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FROM Company WHERE company_name = :p_name");
        Query<Company> query = getSession().createQuery(stringBuilder.toString());
        query.setParameter("p_name", name);
        List<Company> companies = query.list();

        return companies.isEmpty() ? null : companies.get(0);
    }
}
