package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "USER_PROFILE_STATUS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileStatus implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IS_EMAIL_SENT")
    private Boolean emailSent;

    @Column(name = "IS_SMS_SENT")
    private Boolean smsSent;

    @Column(name = "PASSWORD_RESET_GUID")
    private String passwordResetGuid;

    @Column(name = "PASSWORD_RESET_EXPIRY_GUID")
    private String passwordResetExpiryGuid;

    @Column(name = "Created_Date")
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "USER_ID")
    private Long userId;




}
