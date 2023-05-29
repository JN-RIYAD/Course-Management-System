package com.cms.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "course_title", length = 50, nullable = false, unique = true)
    private String courseTitle;

    @Column(name = "course_code", length = 10, nullable = false, unique = true)
    private String courseCode;

    @Column(name = "course_credit", nullable = false)
    private Integer courseCredit;

}
