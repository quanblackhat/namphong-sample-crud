package com.namephong.samplecrud.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {

    @GetMapping({"/page-not-found", "/404"})
    public ModelAndView pageNotFound() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/404");
        return modelAndView;
    }
}
