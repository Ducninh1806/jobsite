package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CANDIDATE_SKILLS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateSkills implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "SKILL_SET_ID")
    private Long skillSetId;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

}
