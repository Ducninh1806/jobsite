package com.example.demo.service.impl;

import com.example.demo.dao.impl.CompanyDaoImpl;
import com.example.demo.dto.CompanyDTO;
import com.example.demo.dto.CompanyDetailDTO;
import com.example.demo.dto.LocationDTO;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.LogicException;
import com.example.demo.model.Company;
import com.example.demo.model.Location;
import com.example.demo.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

    private CompanyDaoImpl companyDao;

    public CompanyServiceImpl(CompanyDaoImpl companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public void addCompany(CompanyDTO companyDTO) throws LogicException {
        logger.info("Service info about add Company :{}", companyDTO);

        Company companyById = companyDao.checkNameCompanyIsExist(companyDTO.getCompanyName());
        if (companyById != null){
            throw new LogicException(ErrorCode.NAME_EXISTED);
        }
        Company company = new Company();

        databaseWithDTO(company,companyDTO);
        company.setVerify(Boolean.FALSE);

        companyDao.save(company);
    }

    @Override
    public void updateCompany(CompanyDTO companyDTO) throws LogicException {
        logger.info("Service info about update Company :{}", companyDTO);

        Optional<Company> companyById;
        companyById = companyDao.findById(companyDTO.getId(),Company.class);
        if (!companyById.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }
        Company company = companyById.get();

        databaseWithDTO(company,companyDTO);
        company.setVerify(Boolean.FALSE);

        companyDao.update(company);
    }

    @Override
    public void deleteCompany(Long id) throws LogicException {
        logger.info("Service info about delete Company :{}", id);

        Optional<Company> companyById;
        companyById = companyDao.findById(id,Company.class);
        if (!companyById.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }
        companyDao.delete(companyById.get());
    }

    @Override
    public CompanyDetailDTO getCompanyById(Long id) throws LogicException {
        logger.info("Service info about get Company Detail :{}", id);

        Optional<Company> companyById;
        companyById = companyDao.findById(id,Company.class);
        if (!companyById.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }

        CompanyDetailDTO companyDetailDTO = new CompanyDetailDTO();
        Company company = companyById.get();

        companyDetailDTO.setId(company.getId());
        companyDetailDTO.setCompanyName(company.getCompanyName());
        companyDetailDTO.setBusinessPhone(company.getBusinessPhone());
        companyDetailDTO.setAddress(company.getAddress());
        companyDetailDTO.setCompanyImage(company.getCompanyImage());
        companyDetailDTO.setDescription(company.getDescription());
        companyDetailDTO.setLocationId(company.getLocationId());
        companyDetailDTO.setWebsite(company.getWebsite());
        companyDetailDTO.setUserId(company.getUserId());

        return companyDetailDTO;
    }

    public void databaseWithDTO (Company company, CompanyDTO companyDTO){
        company.setCompanyName(companyDTO.getCompanyName());
        company.setAddress(companyDTO.getAddress());
        company.setDescription(companyDTO.getDescription());
        company.setBusinessPhone(companyDTO.getBusinessPhone());
        company.setCompanyImage(companyDTO.getCompanyImage());
        company.setLocationId(companyDTO.getLocationId());
        company.setUserId(companyDTO.getUserId());
        company.setWebsite(companyDTO.getWebsite());
    }
}
