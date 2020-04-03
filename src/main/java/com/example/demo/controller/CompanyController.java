package com.example.demo.controller;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.dto.CompanyDetailDTO;
import com.example.demo.exception.LogicException;
import com.example.demo.service.impl.CompanyServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
    private CompanyServiceImpl companyService;

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> addCompany(@RequestBody CompanyDTO companyDTO) throws LogicException {
        logger.info("Controller about add Company :{}", companyDTO);

        companyService.addCompany(companyDTO);
        return new ResponseEntity<>(companyDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CompanyDTO> updateCompany(@RequestBody CompanyDTO companyDTO) throws LogicException {
        logger.info("Controller about update Company :{}", companyDTO);

        companyService.updateCompany(companyDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id) throws LogicException {
        logger.info("Controller about delete Company :{}", id);
        companyService.deleteCompany(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDetailDTO> getCompanyDetail (@PathVariable Long id) throws LogicException {
        logger.info("Controller about get Company detail :{}", id);
        CompanyDetailDTO companyDetailDTO = companyService.getCompanyById(id);
        return new ResponseEntity<>(companyDetailDTO, HttpStatus.OK);
    }




}
