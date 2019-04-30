package com.namephong.samplecrud;

import com.namephong.samplecrud.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private static final String LIST_ARTICLES_TEMPLATE  =  "/articles/list.ftl";
    private static final String LAYOUT_TEMPLATE  =  "fragments/layout";

    @Autowired
    private ArticleService articleService;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${page_init}")
    public int FIRST_PAGE;
    @Value("${page_size}")
    public int PAGE_SIZE;

    /**
     * Add dynamic component such as menu, category,..
     * @param model
     */
    @ModelAttribute
    private void addAttributes(Model model) {
        model.addAttribute("contextPath", contextPath);
    }

    /**
     * Index page
     *
     */
    @GetMapping({"/", "/article/list"})
    public ModelAndView index(@RequestParam(name = "page", required = false) Integer page) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(LAYOUT_TEMPLATE);
        modelAndView.addObject("CONTENT", LIST_ARTICLES_TEMPLATE);
        page = page == null ? 1 : page;

        articleService.loadLatestArticlesPage(modelAndView, page, PAGE_SIZE);

        return modelAndView;
    }

    /**
     * Delete
     *
     */
    @GetMapping("/article/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        System.out.println(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(LAYOUT_TEMPLATE);
        modelAndView.addObject("CONTENT", LIST_ARTICLES_TEMPLATE);

        articleService.loadLatestArticlesPage(modelAndView, FIRST_PAGE, PAGE_SIZE);

        return modelAndView;
    }

    /**
     * Delete
     *
     */
    @GetMapping("/article/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

        System.out.println(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(LAYOUT_TEMPLATE);
        modelAndView.addObject("CONTENT", LIST_ARTICLES_TEMPLATE);

        articleService.loadLatestArticlesPage(modelAndView, FIRST_PAGE, PAGE_SIZE);

        return modelAndView;
    }




}
