package com.example.demo.service.impl;

import com.example.demo.dao.impl.JobCategoryDaoImpl;
import com.example.demo.dto.JobCategoryDTO;
import com.example.demo.dto.JobCategoryDetailDTO;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.LogicException;
import com.example.demo.model.JobCategory;
import com.example.demo.service.JobCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class JobCategoryServiceImpl implements JobCategoryService {

    private static final Logger logger = LoggerFactory.getLogger(JobCategoryServiceImpl.class);
    private JobCategoryDaoImpl jobCategoryDao;

    public JobCategoryServiceImpl(JobCategoryDaoImpl jobCategoryDao) {
        this.jobCategoryDao = jobCategoryDao;
    }

    @Override
    public void addJobCategory(JobCategoryDTO jobCategoryDTO) throws LogicException {
        logger.info("Service info about add JobCategory :{}", jobCategoryDTO);

        JobCategory jobCategoryCheck = jobCategoryDao.checkNameJobCategoryIsExist(jobCategoryDTO.getName());
        if (jobCategoryCheck != null ){
            throw new LogicException(ErrorCode.NAME_EXISTED);
        }

        JobCategory jobCategory = new JobCategory();

        jobCategory.setName(jobCategoryDTO.getName());
        jobCategory.setDescription(jobCategoryDTO.getDescription());
        jobCategory.setCreatedDate(jobCategoryDTO.getCreatedDate());
        jobCategory.setCreatedBy(jobCategoryDTO.getCreatedBy());
        jobCategory.setImageUrl(jobCategoryDTO.getImageUrl());

        jobCategoryDao.save(jobCategory);
    }

    @Override
    public void updateJobCategory(JobCategoryDTO jobCategoryDTO) throws LogicException {
        logger.info("Service info about update JobCategory :{}", jobCategoryDTO);

        Optional<JobCategory> jobCategoryId = jobCategoryDao.findById(jobCategoryDTO.getId(),JobCategory.class);
        if (!jobCategoryId.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }
        JobCategory jobCategory = jobCategoryId.get();
        jobCategory.setName(jobCategoryDTO.getName());
        jobCategory.setDescription(jobCategoryDTO.getDescription());
        jobCategory.setCreatedDate(jobCategoryDTO.getCreatedDate());
        jobCategory.setCreatedBy(jobCategoryDTO.getCreatedBy());
        jobCategory.setImageUrl(jobCategoryDTO.getImageUrl());
        jobCategoryDao.update(jobCategory);

    }

    @Override
    public void deleteJobCategory(Long id) throws LogicException {
        logger.info("Service info about delete JobCategory :{}", id);

        Optional<JobCategory> jobCategory = jobCategoryDao.findById(id,JobCategory.class);
        if (!jobCategory.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }
        jobCategoryDao.delete(jobCategory.get());

    }

    @Override
    public JobCategoryDetailDTO getJobCategoryDetail(Long id) throws LogicException {
        logger.info("Service info about delete JobCategory :{}", id);

        Optional<JobCategory> jobCategoryId = jobCategoryDao.findById(id, JobCategory.class);
        if (!jobCategoryId.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }
        JobCategoryDetailDTO jobCategoryDetailDTO = new JobCategoryDetailDTO();
        JobCategory jobCategory = jobCategoryId.get();
        jobCategoryDetailDTO.setId(jobCategory.getId());
        jobCategoryDetailDTO.setName(jobCategory.getName());
        jobCategoryDetailDTO.setDescription(jobCategory.getDescription());
        jobCategoryDetailDTO.setImageUrl(jobCategory.getImageUrl());
        jobCategoryDetailDTO.setCreatedDate(jobCategory.getCreatedDate());
        jobCategoryDetailDTO.setCreatedBy(jobCategory.getCreatedBy());
        return jobCategoryDetailDTO;
    }
}
