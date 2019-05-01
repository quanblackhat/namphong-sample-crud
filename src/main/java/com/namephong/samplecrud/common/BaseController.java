package com.namephong.samplecrud.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {

    @Value("${page_init}")
    public int FIRST_PAGE;
    @Value("${page_size}")
    public int PAGE_SIZE;
    @Value("${server.servlet.context-path}")
    private String contextPath;

    private static final String LAYOUT_TEMPLATE  =  "fragments/layout";

    @ModelAttribute
    public void addAttributes(Model model) {
        //do
    }

    public ModelAndView initModelAndView(String contentTemplate) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(LAYOUT_TEMPLATE);
        modelAndView.addObject("CONTENT", contentTemplate);
        return modelAndView;

    }
}
