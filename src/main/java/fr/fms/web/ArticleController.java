package fr.fms.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;

@Controller
public class ArticleController {
	@Autowired
	ArticleRepository articleRepository;

	// @RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping("/index") // dans une servlet on utilisait request.getParameter("page")

	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "keyword", defaultValue = "") String kw) {
		Page<Article> articles = articleRepository.findByDescriptionContains(kw, PageRequest.of(page, 4));

		// Page<Article> articles = articleRepository.findAll(PageRequest.of(page, 4));
		// en retour, au lieu d'une liste d'articles, on a tous les articles formatés en
		// page pointant sur la page demandée
		model.addAttribute("listArticle", articles.getContent()); // pour récupérer sous forme de liste la page pointée

//pour afficher des liens de pagination permettant à l'utilisateur de passer d'une page à l'autre, il faut :
// 1- récupérer le nombre total de pages
// 2- l'injecter dans le modell sous forme de tableau d'entier
// 3- sur la partie html il suffira de boucler sur ce tableau pour afficher toutes les pages
		model.addAttribute("pages", new int[articles.getTotalPages()]);

// s'agissant de l'activation des liens de navigation, il faut transmettre à la vue la page courante
// thymeleaf pourra delors vérifier si la page courante est égae à l'index de la page active
		model.addAttribute("currentPage", page);
		return "articles";
	}

	@GetMapping("/delete") // on peut ne pas préciser le paramètre de la requête, il va chercher sur la
							// base id
	public String delete(Long id, int page, String keyword) {

		articleRepository.deleteById(id);

		return "redirect:/index?page=" + page + "&keyword=" + keyword;
	}

	@GetMapping("/article")
	public String article(Model model) {
		model.addAttribute("article", new Article());  // injection d'un article par défault dans le formulaire de la vue article
		return "article";
	}
	
	@PostMapping("/save")
	public String save(@Valid Article article, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
		// s'il n'y a pas de saisie d'un champs selon certains critères, pas d'insertion en base de données
			return "article";
		articleRepository.save(article);
		return "redirect:/index";
	}
	
}
