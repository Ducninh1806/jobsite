package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "MASTER_DATA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE_GROUP")
    private String codeGroup;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PARENT_CODE")
    private String parentCode;

    @Column(name = "DISPLAY_ORDER")
    private Long displayOrder;

    @Column(name = "IS_SECRET")
    private Boolean Secret;
}
