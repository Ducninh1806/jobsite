package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CompanyDetailDTO {

    private Long id;
    private String companyName;
    private String businessPhone;
    private String website;
    private String companyImage;
    private String description;
    private Long userId;
    private Long locationId;
    private String address;
}
