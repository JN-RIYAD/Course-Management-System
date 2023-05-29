package com.cms.controller;

import com.cms.entity.Course;
import com.cms.entity.Student;
import com.cms.repository.CourseRepository;
import com.cms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;

    @GetMapping({"/list", "/"})
    public ModelAndView getAllStudent() {

        ModelAndView mav = new ModelAndView("/student/list-student-form");

        mav.addObject("students", studentRepository.findAll());

        return mav;
    }
    @GetMapping("/addForm")
    public ModelAndView addForm() {

        ModelAndView mav = new ModelAndView("/student/add-student-form");

        Student student = new Student();

        mav.addObject("student", student);

        return mav;
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long studentId) {

        ModelAndView modelAndView = new ModelAndView("/student/update-student-form");

        Student student = studentRepository.findById(studentId).get();

        modelAndView.addObject("student", student);

        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student) {

        studentRepository.save(student);

        return "redirect:/student/list";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute Student student) {

        studentRepository.save(student);

        return "redirect:/student/list";
    }



    @GetMapping("/delete")
    public String delete(@RequestParam Long studentId) {

        studentRepository.deleteById(studentId);

        return "redirect:/student/list";
    }

}
