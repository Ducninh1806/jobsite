package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LOCATION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    @Size(max = 10)
    @Column(name = "LOCATION_CODE")
    private String locationCode;

    @NotEmpty
    @Size(max = 100)
    @Column(name = "LOCATION_NAME")
    private String locationName;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "parent_id")
    private Long parentId;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

    @Column(name = "CREATED_BY", updatable = false)
    private Long createdBy;

}
