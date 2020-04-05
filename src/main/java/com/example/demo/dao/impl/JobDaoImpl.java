package com.example.demo.dao.impl;

import com.example.demo.dao.JobDAO;
import com.example.demo.model.Job;
import com.example.demo.model.SkillsForJob;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JobDaoImpl extends AbstractBaseDAO implements JobDAO {

    private static final long serialVersionUID = 6086269742818995787L;
    private static final Logger logger = LoggerFactory.getLogger(JobDaoImpl.class);


    @Override
    public Job CheckNameIsExist(String title) {
        logger.info("Dao get title :{}", title);

        Session currentSession = getSession();
        Query query = currentSession.createQuery(" From Job j Where j.title = :p_title");
        query.setParameter("p_title", title);

        List<Job> jobs = (List<Job>) query.list();
        return jobs.isEmpty() ? null : jobs.get(0);
    }

    @Override
    public void addSkillToJob(SkillsForJob skillsJob) {
        Session currentSession = getSession();
        Query query = currentSession.createQuery("FROM SkillsForJob sj WHERE sj.jobId = :p_jobId AND sj.skillSetId = :p_skillSetId");
        query.setParameter("p_jobId", skillsJob.getJobId());
        query.setParameter("p_skillSetId", skillsJob.getSkillSetId());
        if (query.list().isEmpty()){
            currentSession.save(skillsJob);
        }
    }
}
