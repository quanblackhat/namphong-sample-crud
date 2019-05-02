package com.namephong.samplecrud;

import com.namephong.samplecrud.common.BaseController;
import com.namephong.samplecrud.models.Article;
import com.namephong.samplecrud.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MainController extends BaseController {

    private static final String LIST_ARTICLES_TEMPLATE  =  "/articles/list.ftl";
    private static final String ADD_ARTICLES_TEMPLATE  =  "/articles/add-edit.ftl";


    @Autowired
    private ArticleService articleService;

    /**
     * Index page
     */
    @GetMapping({"/", "/article/list"})
    public ModelAndView index(@RequestParam(name = "page", required = false) Integer page) {

        ModelAndView modelAndView = this.initModelAndView(LIST_ARTICLES_TEMPLATE);
        articleService.loadLatestArticlesPage(modelAndView, page, PAGE_SIZE);

        return modelAndView;
    }

    /**
     * Delete
     */
    @GetMapping("/article/edit/{id}")
    public ModelAndView getFormEdit(@PathVariable("id") Long id) {

        ModelAndView modelAndView = this.initModelAndView(ADD_ARTICLES_TEMPLATE);
        modelAndView.addObject("title", "Edit");

        Article article = articleService.findById(id).isPresent() ? articleService.findById(id).get() : new Article();
        modelAndView.addObject("article", article);


        return modelAndView;
    }

    /**
     * Delete
     *
     */
    @GetMapping("/article/delete/{id}")
    public  String delete(@PathVariable("id") Long id) {

        articleService.deleteArticle(id);
        return "redirect:/article/list";
    }

    /**
     * Delete
     *
     */
    @GetMapping("/article/add")
    public ModelAndView getFormAdd(@ModelAttribute Article article) {

        ModelAndView modelAndView = this.initModelAndView(ADD_ARTICLES_TEMPLATE);
        modelAndView.addObject("title", "Create New");
        article = article == null ? new Article() : article;
        modelAndView.addObject("article", article);


        return modelAndView;
    }

    @PostMapping("/article/save")
    public String save(@Valid Article article, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if (!bindingResult.hasErrors()) {
            model.addAttribute("hasError", false);
            articleService.save(article);
        } else {
            redirectAttributes.addFlashAttribute("article", article);
            return "redirect:/article/add";
        }
        System.out.println("Saved");
        return "redirect:/article/list";
    }






}
