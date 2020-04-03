package com.example.demo.service;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.dto.CompanyDetailDTO;
import com.example.demo.exception.LogicException;

public interface CompanyService {

    void addCompany (CompanyDTO companyDTO) throws LogicException;

    void updateCompany (CompanyDTO companyDTO) throws LogicException;

    void deleteCompany(Long id) throws LogicException;

    CompanyDetailDTO getCompanyById (Long id) throws LogicException;
}
