package com.cms.controller;

import com.cms.entity.Course;
import com.cms.repository.CourseRepository;
import com.cms.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping({"/course/list"})
    public ModelAndView getAllCourses() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/CourseHtmlFolder/list-courses");

        //List<Course> courseList = courseRepository.findAll();

        List<Course> courseList = courseService.findAllCourses();

        mav.addObject("courses", courseList);
        return mav;
    }

    @GetMapping("/course/addForm")
    public ModelAndView addForm() {

        ModelAndView mav = new ModelAndView();

        mav.setViewName("/CourseHtmlFolder/add-course-form");

        Course course = new Course();

        mav.addObject("course", course);

        return mav;
    }

    @GetMapping("/course/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long courseId) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("CourseHtmlFolder/update-course-form");

        //Course course = courseRepository.findById(courseId).get();

        Course course = courseService.findCourseById(courseId);

       modelAndView.addObject("course", course);

        return modelAndView;
    }

    @PostMapping("/course/save")
    public String save(@ModelAttribute Course course) {


        courseService.saveCourse(course);

        return "redirect:/course/list";
    }

    @PostMapping("/course/update")
    public String update(@ModelAttribute Course course) {

        courseService.updateCourse(course);
        //courseRepository.save(course);

        return "redirect:/course/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam Long courseId) {

        courseService.deleteCourse(courseId);
        //courseRepository.deleteById(courseId);

        return "redirect:/course/list";
    }


}
