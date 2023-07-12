package com.cms.controller;

import com.cms.entity.Teacher;
import com.cms.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @GetMapping("/teacher/list")
    public ModelAndView getTeacherList() {

        ModelAndView mav = new ModelAndView();

        mav.setViewName("/TeacherHtmlFolder/list-of-teachers");

        List<Teacher> teacherList = teacherService.findAllTeachers();

        mav.addObject("teachers", teacherList);

        return mav;
    }
//
//    @GetMapping("/teacher/addForm")
//    public ModelAndView addForm() {
//
//        ModelAndView mav = new ModelAndView();
//
//        mav.setViewName("/TeacherHtmlFolder/add-teacher-form");
//
//        Teacher teacher = new Teacher();
//
//        mav.addObject("teacher", teacher);
//
//        return mav;
//    }
//
//    @GetMapping("/teacher/showUpdateForm")
//    public ModelAndView showUpdateForm(@RequestParam Long teacherId) {
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.setViewName("teacherHtmlFolder/update-teacher-form");
//
//        Teacher teacher = teacherService.findTeacherById(teacherId);
//
//        modelAndView.addObject("teacher", teacher);
//
//        return modelAndView;
//    }
//
//    @PostMapping("/teacher/save")
//    public String save(@ModelAttribute Teacher teacher) {
//
//
//        teacherService.saveTeacher(teacher);
//
//        return "redirect:/teacher/list";
//    }
//
//    @PostMapping("/teacher/update")
//    public String update(@ModelAttribute Teacher teacher) {
//
//        teacherService.updateTeacher(teacher);
//
//        return "redirect:/teacher/list";
//    }
//
//
//    @GetMapping("/delete")
//    public String delete(@RequestParam Long teacherId) {
//
//        teacherService.deleteTeacher(teacherId);
//
//
//        return "redirect:/teacher/list";
//    }
}
