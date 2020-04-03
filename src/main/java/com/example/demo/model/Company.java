package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMPANY_INFO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "BUSINESS_PHONE")
    private String businessPhone;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "COMPANY_IMAGE")
    private String companyImage;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "LOCATION_ID")
    private Long locationId;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "VERIFY")
    private Boolean verify;








}
