package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class SkillSetDetailDTO {

    private Long id;

    private String name;

    private Date createdDate;

    private Long createdBy;
}
