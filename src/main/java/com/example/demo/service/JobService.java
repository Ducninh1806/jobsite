package com.example.demo.service;

import com.example.demo.dto.JobDTO;
import com.example.demo.dto.JobDetailDTO;
import com.example.demo.exception.LogicException;

public interface JobService {

    void addJob(JobDTO jobDTO) throws LogicException;

    void updateJob (JobDTO jobDTO) throws LogicException;

    void delete(Long id) throws LogicException;

    JobDetailDTO getJob(Long jobId) throws LogicException;
}
