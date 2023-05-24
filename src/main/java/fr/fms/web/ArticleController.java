package fr.fms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;

@Controller
public class ArticleController {
	@Autowired
	ArticleRepository articleRepository;

	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/index")
	
	public String index(Model model) {  // le model est fourni par spring, je peux l'utiliser comme ci
		List<Article> articles = articleRepository.findAll();   // récupère tous les articles
		model.addAttribute("listArticle", articles);      // insertion de tous les articles dans le model
														 // accessible via l'attribut "listArticle"
		
		return "articles"; // cette méthode retourne au dispacterServlet la vue articles.html
	}
}	

