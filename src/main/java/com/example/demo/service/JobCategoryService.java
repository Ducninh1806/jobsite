package com.example.demo.service;

import com.example.demo.dto.JobCategoryDTO;
import com.example.demo.dto.JobCategoryDetailDTO;
import com.example.demo.dto.JobDetailDTO;
import com.example.demo.exception.LogicException;

public interface JobCategoryService {

    void addJobCategory(JobCategoryDTO jobCategoryDTO) throws LogicException;

    void updateJobCategory(JobCategoryDTO jobCategoryDTO) throws LogicException;

    void deleteJobCategory(Long id) throws LogicException;

    JobCategoryDetailDTO getJobCategoryDetail(Long id) throws LogicException;

}
