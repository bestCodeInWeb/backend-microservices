package com.sn.resourceserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profile")
@Getter
@Setter
@NoArgsConstructor
public class Profile {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "looking_for_a_job")
    private boolean lookingForAJob;

    @Column(name = "looking_for_a_job_description")
    private String lookingForAJobDescription;

    @Column(name = "full_name")
    private String fullName;

    @Embedded
    private Contact contact;

    @Embedded
    private Photo photos;
}
