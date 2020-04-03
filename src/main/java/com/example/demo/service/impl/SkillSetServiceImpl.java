package com.example.demo.service.impl;


import com.example.demo.dao.impl.SkillSetDaoImpl;
import com.example.demo.dto.SkillSetDTO;
import com.example.demo.dto.SkillSetDetailDTO;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.LogicException;
import com.example.demo.model.SkillSet;
import com.example.demo.service.SkillSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SkillSetServiceImpl implements SkillSetService {

    private static final Logger logger = LoggerFactory.getLogger(SkillSetServiceImpl.class);

    @Autowired
    private SkillSetDaoImpl skillSetDao;


    @Override
    public void addSkillSet(SkillSetDTO skillSetDTO) throws LogicException {
        logger.info("Service info add SkillSet :{}", skillSetDTO);

        SkillSet skillSetByName = skillSetDao.CheckNameIsExist(skillSetDTO.getName());
        if (skillSetByName != null ){
            throw new LogicException(ErrorCode.NAME_EXISTED);
        }
        SkillSet skillSet = new SkillSet();
        skillSet.setName(skillSetDTO.getName());
        skillSet.setCreatedDate(skillSetDTO.getCreatedDate());
        skillSet.setCreatedBy(skillSetDTO.getCreatedBy());
        skillSetDao.save(skillSet);
    }

    @Override
    public void updateSkillSet(SkillSetDTO skillSetDTO) throws LogicException {
        logger.info("Service info update SkillSet :{}", skillSetDTO);

        Optional<SkillSet> skillSetId = skillSetDao.findById(skillSetDTO.getId(),SkillSet.class);
        if (!skillSetId.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }

        SkillSet skillSet = skillSetId.get();
        skillSet.setName(skillSetDTO.getName());
        skillSet.setCreatedDate(skillSetDTO.getCreatedDate());
        skillSet.setCreatedBy(skillSetDTO.getCreatedBy());
        skillSetDao.update(skillSet);
    }

    @Override
    public void deleteSkillSet(Long skillId) throws LogicException {
        logger.info("Service info delete skillSet :{}", skillId);
        Optional<SkillSet> skillSet = skillSetDao.findById(skillId, SkillSet.class);
        if (!skillSet.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }
        skillSetDao.delete(skillSet.get());
    }

    @Override
    public SkillSetDetailDTO getSkillSetById(Long skillId) throws LogicException {
        logger.info("Service info get skillSet by Id :{}", skillId);

        Optional<SkillSet> skillSetById = skillSetDao.findById(skillId,SkillSet.class);
        if (!skillSetById.isPresent()){
            throw new LogicException(ErrorCode.RECORD_NOT_EXISTED);
        }
        SkillSet skillSet = skillSetById.get();
        SkillSetDetailDTO skillSetDetailDTO = new SkillSetDetailDTO();
        skillSetDetailDTO.setId(skillSet.getId());
        skillSetDetailDTO.setName(skillSet.getName());
        skillSetDetailDTO.setCreatedDate(skillSet.getCreatedDate());
        skillSetDetailDTO.setCreatedBy(skillSet.getCreatedBy());
        return skillSetDetailDTO;
    }
}
