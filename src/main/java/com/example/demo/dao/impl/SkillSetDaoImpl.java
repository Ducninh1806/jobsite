package com.example.demo.dao.impl;

import com.example.demo.dao.SkillSetDAO;
import com.example.demo.model.SkillSet;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkillSetDaoImpl extends AbstractBaseDAO implements SkillSetDAO {

    private static final long serialVersionUID = 6086269742818995787L;
    private static final Logger logger = LoggerFactory.getLogger(JobDaoImpl.class);


    @Override
    public SkillSet CheckNameIsExist(String name) {
        String sql = "FROM SkillSet ss WHERE ss.name = :p_name";
        Query<SkillSet> query = getSession().createQuery(sql);
        query.setParameter("p_name", name);
        List<SkillSet> skillSet = query.list();
        return skillSet.isEmpty() ? null : skillSet.get(0);
    }
}
