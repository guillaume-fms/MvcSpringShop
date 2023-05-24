package fr.fms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fms.dao.ArticleRepository;

@Controller
public class ArticleController {
	@Autowired
	ArticleRepository articleRepository;


	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/index")
	public String index() {
		return "articles"; // cette méthode retourne au dispacterServlet une vue 
	}
}	

