package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "USER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_IMAGE")
    private String userImage;

    @Column(name = "IS_ACTIVE")
    private Boolean active= Boolean.FALSE;

    @Column(name = "IS_LOCKED")
    private Boolean locked = Boolean.FALSE;

    @Column(name = "RECEIVE_NOTIFY")
    private Boolean receiveNotify = Boolean.FALSE;

    @Column(name = "USER_TYPE_ID")
    private Long userTypeId;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "LANG_KEY")
    private String langKey;

    @Column(name = "ACTIVE_KEY")
    private String activeKey;

    @Column(name = "RESET_KEY")
    private String resetKey;

}
