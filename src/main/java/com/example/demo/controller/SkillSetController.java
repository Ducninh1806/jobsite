package com.example.demo.controller;

import com.example.demo.dto.SkillSetDTO;
import com.example.demo.dto.SkillSetDetailDTO;
import com.example.demo.exception.LogicException;
import com.example.demo.service.impl.SkillSetServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skill")
public class SkillSetController {

    private SkillSetServiceImpl skillSetService;

    public SkillSetController(SkillSetServiceImpl skillSetService) {
        this.skillSetService = skillSetService;
    }

    @PostMapping
    public ResponseEntity<SkillSetDTO> addSkillSet (@RequestBody SkillSetDTO skillSetDTO) throws LogicException {
        skillSetService.addSkillSet(skillSetDTO);
        return new ResponseEntity<>(skillSetDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SkillSetDTO> editSkillSet(@RequestBody SkillSetDTO skillSetDTO) throws LogicException {
        skillSetService.updateSkillSet(skillSetDTO);
        return new ResponseEntity<>(skillSetDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SkillSetDTO> deleteSkillSet(@PathVariable Long id) throws LogicException {
        skillSetService.deleteSkillSet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillSetDetailDTO> getSkillSetById(@PathVariable Long id) throws LogicException {
        SkillSetDetailDTO skillSetDetailDTO = skillSetService.getSkillSetById(id);
        return new ResponseEntity<>(skillSetDetailDTO, HttpStatus.OK);
    }
}
