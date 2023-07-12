package com.cms.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "teacher_name", length = 50, nullable = false)
    private String teacherName;

    @Column(name = "teacher_email", length = 30, nullable = false, unique = true)
    private String teacherEmail;

    @Column(name = "teacher_tid", nullable = false, unique = true)
    private Integer teacherTid;

}