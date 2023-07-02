package com.cms.services;

import com.cms.entity.Course;
import com.cms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAllCourses() {

        List<Course> courseList = courseRepository.findAll();

        Course newCourse = new Course();
        newCourse.setCourseTitle("Testing");
        newCourse.setCourseCredit(2);
        newCourse.setCourseCode("CSE 103");

        courseList.add(newCourse);

        return courseList;
    }
}
