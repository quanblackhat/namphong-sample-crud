package com.namephong.samplecrud.services;

import com.namephong.samplecrud.models.Article;
import com.namephong.samplecrud.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Value("${page_show}")
    public int PAGE_SHOW;
    @Value("${page_init}")
    public int FIRST_PAGE;
    @Value("${page_size}")
    public int PAGE_SIZE;

    /**
     * Cac ham co san cua JPA
     */
    public Optional<Article> findById(Long articleId) {
        return articleRepository.findById(articleId);
    }

    public Page<Article> loadLatestArticles(Pageable pageRequest) {
        return articleRepository.loadLatestArticles(pageRequest);
    }

    public void save(Article article) {

        //todo - hardcode
        article.setDateCreatedTimestamp(1555848815L);
        article.setImage("images/demo.jpg");

        articleRepository.save(article);
    }

    public void saveAll(List<Article> articles) {
        articleRepository.saveAll(articles);
    }




    /**
     * Cac ham custom, su dung cac ham mac dinh, xu ly du lieu put vao view
     */
    public void loadLatestArticlesPage(ModelAndView modelAndView, Integer page, Integer pageSize) {

        page = page == null ? 1 : page;
        PageRequest pageRequest = PageRequest.of(page -1 , pageSize);

        //Tin moi nhat
        Page<Article> pages = articleRepository.loadLatestArticles(pageRequest);
        modelAndView.addObject("totalElements", pages.getTotalElements());
        modelAndView.addObject("totalPages", pages.getTotalPages());
        modelAndView.addObject("page", page);
        modelAndView.addObject("visiblePage", PAGE_SHOW);
        modelAndView.addObject("articles", pages.getContent());
    }



    public void loadArticleDetail(ModelAndView modelAndView, Long id) {

        Optional<Article> articleOptional = this.findById(id);
        articleOptional.ifPresent(article -> modelAndView.addObject("article", article));

        PageRequest pageRequest = PageRequest.of(FIRST_PAGE , 5);

        //Todo: Hardcode bai viet lien quan va bai viet duoc xem nhieu nhat
        Page<Article> pages = this.loadLatestArticles(pageRequest);
        modelAndView.addObject("relatedArticlesOne", pages.getContent());
        modelAndView.addObject("mostView", pages.getContent());
        modelAndView.addObject("relatedArticlesTwo", this.loadLatestArticles(pageRequest.next()).getContent());
    }

    @Transactional
    public void deleteArticle(Long id) {
        Optional<Article> articleOptional = articleRepository.findById(id);
        if (articleOptional.isPresent()) {
            articleRepository.delete(articleOptional.get());
        }
    }
}
