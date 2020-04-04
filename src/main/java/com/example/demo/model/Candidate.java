package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CANDIDATE_INFO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candidate implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EDUCATION")
    private String education;

    @Column(name = "EXPERIENCE")
    private String experience;

    @Column(name = "RESUME")
    private String resume;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "LOCATION_ID")
    private Long locationId;

}
