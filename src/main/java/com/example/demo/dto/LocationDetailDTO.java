package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class LocationDetailDTO {

    private Long id;
    private String locationCode;
    private String locationName;
    private String imageUrl;
    private Long parentId;
    private Date createdDate;
    private Long createdBy;
}
