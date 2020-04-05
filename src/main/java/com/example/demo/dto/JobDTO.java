package com.example.demo.dto;

import com.example.demo.model.SkillSet;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class JobDTO {

    private Long id;
    private String title;
    private String description;
    private Long locationId;
    private Long jobCategoryId;
    private Long userId;
    private Date startDate;
    private Date endDate;
    private Double salaryFrom;
    private Double salaryTo;
    private Integer jobTypeId;

    private List<SkillSet> skills;

}
