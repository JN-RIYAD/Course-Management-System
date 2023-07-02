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
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping({"/list"})
    public ModelAndView getAllCourses() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/course/list-courses");

        //List<Course> courseList = courseRepository.findAll();

        List<Course> courseList = courseService.findAllCourses();

        mav.addObject("courses", courseList);
        return mav;
    }

    @GetMapping("/addForm")
    public ModelAndView addForm() {

        ModelAndView mav = new ModelAndView("/course/add-course-form");

        Course course = new Course();

        mav.addObject("course", course);

        return mav;
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long courseId) {

        ModelAndView modelAndView = new ModelAndView("course/update-course-form");

        Course course = courseRepository.findById(courseId).get();

        modelAndView.addObject("course", course);

        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Course course) {

        courseRepository.save(course);

        return "redirect:/course/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Course course) {

        courseRepository.save(course);

        return "redirect:/course/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam Long courseId) {

        courseRepository.deleteById(courseId);

        return "redirect:/course/list";
    }


}
