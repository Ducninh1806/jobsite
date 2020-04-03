package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "JOB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "JOB_DESCRIPTION")
    private String description;

    @Column(name = "LOCATION_ID")
    private Long locationId;

    @Column(name = "JOB_CATEGORY_ID")
    private Long jobCategoryId;

    @Column(name = "USER_ID", updatable = false)
    private Long userId;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "IS_ACTIVE")
    private Boolean active;

    @Column(name = "SALARY_FROM")
    private Double salaryFrom;

    @Column(name = "SALARY_TO")
    private Double salaryTo;

    @Column(name = "job_type_id")
    private Integer jobTypeId;

}
