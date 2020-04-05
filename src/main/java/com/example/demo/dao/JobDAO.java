package com.example.demo.dao;

import com.example.demo.model.Job;
import com.example.demo.model.SkillsForJob;

import java.io.Serializable;

public interface JobDAO extends Serializable, BaseDAO {

    Job CheckNameIsExist(String title);

    void addSkillToJob(SkillsForJob skillsJob);
}
