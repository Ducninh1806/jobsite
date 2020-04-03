package com.example.demo.dao;

import com.example.demo.model.SkillSet;

public interface SkillSetDAO extends BaseDAO{

    SkillSet CheckNameIsExist( String name);
}
