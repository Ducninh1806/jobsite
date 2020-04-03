package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class JobCategoryDTO {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Long createdBy;
    private Date createdDate;
}
