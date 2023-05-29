package com.cms.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "name_bn", length = 50, nullable = false)
    private String nameBn;

    @Column(name = "roll", length = 50, nullable = false, unique = true)
    private Long roll;

    @Column(name = "batch", length = 50, nullable = false)
    private Integer batch;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "mobile", length = 50, nullable = false, unique = true)
    private String mobile;

    @Column(name = "session", length = 50, nullable = false)
    private String session;

    @Column(name = "semester", length = 50, nullable = false)
    private String semester;

    @Column(name = "cgpa", length = 50, nullable = false)
    private Double cgpa;


}
