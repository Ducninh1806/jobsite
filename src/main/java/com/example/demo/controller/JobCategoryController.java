package com.example.demo.controller;

import com.example.demo.dto.JobCategoryDTO;
import com.example.demo.dto.JobCategoryDetailDTO;
import com.example.demo.exception.LogicException;
import com.example.demo.service.impl.JobCategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class JobCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(JobCategoryController.class);

    private JobCategoryServiceImpl jobCategoryService;

    public JobCategoryController(JobCategoryServiceImpl jobCategoryService) {
        this.jobCategoryService = jobCategoryService;
    }

    @PostMapping
    public ResponseEntity<JobCategoryDTO> addJobCategory (@RequestBody JobCategoryDTO jobCategoryDTO) throws LogicException {
        logger.info("Controller info about add JobCategory :{}", jobCategoryDTO);

        jobCategoryService.addJobCategory(jobCategoryDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<JobCategoryDTO> editJobCateogry(@RequestBody JobCategoryDTO jobCategoryDTO) throws LogicException {
        logger.info("Controller info about update JobCategory :{}", jobCategoryDTO);

        jobCategoryService.updateJobCategory(jobCategoryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJobCategory (@PathVariable Long id) throws LogicException {
        logger.info("Controller info about delete JobCategory :{}", id);

        jobCategoryService.deleteJobCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobCategoryDetailDTO> getJobCategoryDetail(@PathVariable Long id) throws LogicException {
        logger.info("Controller info about get JobCategory detail :{}", id);

        JobCategoryDetailDTO jobCategoryDetailDTO = jobCategoryService.getJobCategoryDetail(id);
        return new ResponseEntity<>(jobCategoryDetailDTO, HttpStatus.OK);
    }

}
