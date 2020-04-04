package com.example.demo.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CANDIDATE_JOB_APPLIED")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateJobApplied implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "JOB_ID")
    private Long jobId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "APPLY_DATE", updatable = false)
    @CreationTimestamp
    private Data applyDate;

}
