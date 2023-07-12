package com.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstPageController {
    @GetMapping({"/"})
    public ModelAndView index() {

        ModelAndView mav = new ModelAndView("/firstPage");

        return mav;
    }
}
