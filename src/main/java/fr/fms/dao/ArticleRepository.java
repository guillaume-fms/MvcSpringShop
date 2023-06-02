package fr.fms.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import fr.fms.entities.Article;


public interface ArticleRepository extends JpaRepository<Article,Long>{


	// requête qui renvoie l’ensemble des articles
	//public List<Article> findAll(String description);
	
	public Page<Article> findByCategoryId(Long categoryId, Pageable pageable);
	
	Page<Article> findByDescriptionContains(String description, Pageable pageable);

	Page<Article> findByDescriptionContains(String kw, PageRequest of);
	
	
}
