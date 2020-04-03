package com.example.demo.controller;

import com.example.demo.dto.JobDTO;
import com.example.demo.dto.JobDetailDTO;
import com.example.demo.exception.LogicException;
import com.example.demo.service.impl.JobServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobServiceImpl jobService;

    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    @PostMapping
    public ResponseEntity<JobDTO> addJob (@RequestBody JobDTO jobDTO) throws LogicException {
        logger.info("Rest request to add new Job :{}", jobDTO);

        jobService.addJob(jobDTO);
        return new ResponseEntity<>(jobDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<JobDTO> editJob(@RequestBody JobDTO jobDTO) throws LogicException {
        jobService.updateJob(jobDTO);
        return new ResponseEntity<>(jobDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable Long id) throws LogicException {
        jobService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDetailDTO> getJob(@PathVariable Long id) throws LogicException {
        JobDetailDTO jobDetailDTO= jobService.getJob(id);
        return new ResponseEntity<>(jobDetailDTO,HttpStatus.OK);
    }
}
