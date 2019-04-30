
package com.namephong.samplecrud.repositories;

import com.namephong.samplecrud.models.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "SELECT article"
            + " FROM Article article"
            + " ORDER BY article.dateCreatedTimestamp DESC ")
    Page<Article> loadLatestArticles(Pageable pageable);

}
