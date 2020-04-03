package com.example.demo.service;

import com.example.demo.dto.SkillSetDTO;
import com.example.demo.dto.SkillSetDetailDTO;
import com.example.demo.exception.LogicException;

public interface SkillSetService {

    void addSkillSet(SkillSetDTO skillSetDTO) throws LogicException;

    void updateSkillSet(SkillSetDTO skillSetDTO) throws LogicException;

    void deleteSkillSet(Long skillId) throws LogicException;

    SkillSetDetailDTO getSkillSetById(Long skillId) throws LogicException;




}
