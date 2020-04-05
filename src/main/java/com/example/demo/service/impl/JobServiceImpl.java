package com.example.demo.service.impl;

import com.example.demo.dao.impl.JobDaoImpl;
import com.example.demo.dao.impl.SkillSetDaoImpl;
import com.example.demo.dto.JobDTO;
import com.example.demo.dto.JobDetailDTO;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.LogicException;
import com.example.demo.model.Job;
import com.example.demo.model.SkillSet;
import com.example.demo.model.SkillsForJob;
import com.example.demo.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JobServiceImpl implements JobService {

    private JobDaoImpl jobDAO;

    private SkillSetDaoImpl skillSetDao;

    private static final Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);

    public JobServiceImpl(JobDaoImpl jobDAO, SkillSetDaoImpl skillSetDao) {
        this.jobDAO = jobDAO;
        this.skillSetDao = skillSetDao;
    }

    @Override
    public void addJob(JobDTO jobDTO) throws LogicException {
        logger.info("Service info add Job :{}", jobDTO);
        Job jobDB = jobDAO.CheckNameIsExist(jobDTO.getTitle());
        if (jobDB != null ){
            throw new LogicException(ErrorCode.NAME_EXISTED);
        }
        Job job  = new Job();
        linkJobWithJobDTO(job, jobDTO);
        job.setActive(Boolean.FALSE);
        jobDAO.save(job);

        List<SkillSet> skillSets = jobDTO.getSkills();
        ArrayList<Long> skillID = new ArrayList<>();
        for (SkillSet skillSet: skillSets){
            SkillSet isSkillExist = skillSetDao.CheckNameIsExist(skillSet.getName());
            if (isSkillExist == null){
                skillSet.setCreatedDate(new Date());
                skillSet.setCreatedBy(job.getUserId());
                skillSetDao.save(skillSet);
                skillID.add(skillSet.getId());
            }else {
                skillID.add(isSkillExist.getId());
            }
        }

        for (Long skill : skillID){
            addSkillForJob(skill, job);
        }
    }

    @Override
    public void updateJob(JobDTO jobDTO) throws LogicException {
        logger.info("Service info update Job :{}", jobDTO);
        Optional<Job> jobDB = jobDAO.findById(jobDTO.getId(), Job.class);
        if (!jobDB.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }
        Job job = jobDB.get();

        linkJobWithJobDTO(job, jobDTO);
        jobDAO.update(job);
    }

    @Override
    public void delete(Long id)throws LogicException {
        logger.info("Service info delete Job :{}", id);

        Optional<Job> jobDB = jobDAO.findById(id, Job.class);
        if (!jobDB.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }
        jobDAO.delete(jobDB.get());
    }

    @Override
    public JobDetailDTO getJob(Long jobId) throws LogicException {
        logger.info("Service info delete Job :{}", jobId);

        Optional<Job> jobById = jobDAO.findById(jobId, Job.class);
        if (!jobById.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }
        JobDetailDTO jobDetailDTO = new JobDetailDTO();
        Job job = jobById.get();
        linkJobDetailDTOWithJob(jobDetailDTO, job);

        return jobDetailDTO;
    }

    public void linkJobWithJobDTO (Job job, JobDTO jobDTO){
        job.setTitle(jobDTO.getTitle());
        job.setDescription(jobDTO.getDescription());
        job.setJobCategoryId(jobDTO.getJobCategoryId());
        job.setLocationId(jobDTO.getLocationId());
        job.setStartDate(jobDTO.getStartDate());
        job.setEndDate(jobDTO.getEndDate());
        job.setSalaryFrom(jobDTO.getSalaryFrom());
        job.setSalaryTo(jobDTO.getSalaryTo());
        job.setUserId(jobDTO.getUserId());
        job.setJobTypeId(jobDTO.getJobTypeId());
    }

    public void linkJobDetailDTOWithJob(JobDetailDTO jobDetailDTO, Job job){
        jobDetailDTO.setId(job.getId());
        jobDetailDTO.setTitle(job.getTitle());
        jobDetailDTO.setDescription(job.getDescription());
        jobDetailDTO.setJobCategoryId(job.getJobCategoryId());
        jobDetailDTO.setLocationId(job.getLocationId());
        jobDetailDTO.setJobTypeId(job.getJobTypeId());
        jobDetailDTO.setStartDate(job.getStartDate());
        jobDetailDTO.setEndDate(job.getEndDate());
        jobDetailDTO.setSalaryFrom(job.getSalaryFrom());
        jobDetailDTO.setSalaryTo(job.getSalaryTo());
        jobDetailDTO.setUserId(job.getUserId());
        jobDetailDTO.setActive(job.getActive());
    }

    public void addSkillForJob(Long skill, Job job){
        SkillsForJob skillsForJob = new SkillsForJob();

        skillsForJob.setJobId(job.getId());
        skillsForJob.setSkillSetId(skill);
        skillsForJob.setCreatedDate(new Date());
        skillsForJob.setCreatedBy(job.getUserId());
        jobDAO.addSkillToJob(skillsForJob);
    }
}
