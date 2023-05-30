package fr.fms;



import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;


@SpringBootApplication
public class MvcSpringStockApplication implements CommandLineRunner {
	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	CategoryRepository categoryRepository;


	
	
	public static void main(String[] args) {
		SpringApplication.run(MvcSpringStockApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello My CommandLineRunner !!");
		System.out.println();



		// generate Datas articles
		/*
		 * articleRepository.save(new Article(null,"Samsung S8", 350));
		 * articleRepository.save(new Article(null,"Samsung S10", 550));
		 * articleRepository.save(new Article(null,"Apple iPhone 14", 1250));
		 * articleRepository.save(new Article(null,"Google Pixel 7a", 550));
		 * articleRepository.save(new Article(null,"Xiaomi Mi 11", 480));
		 * articleRepository.save(new Article(null,"Sony Ericsson T28S", 495));
		 * articleRepository.save(new Article(null,"Oppo Reno", 499));
		 * articleRepository.save(new Article(null,"Nokia Xr 21",599));
		 * articleRepository.save(new Article(null,"Motorola edge 30 ultra", 899));
		 * articleRepository.save(new Article(null,"Honor Magic5 Pro", 499.70));
		 * articleRepository.save(new Article(null,"Wiko Y82", 287));
		 * articleRepository.save(new Article(null,"Google Pixel 7 Pro", 799));
		 * articleRepository.save(new Article(null,"Nokia 3310", 880));
		 * articleRepository.save(new Article(null,"Sony Xperia XA1", 780));
		 * articleRepository.save(new Article(null,"Motorola edge 30 fusion", 699));
		 * articleRepository.save(new Article(null,"Huawei P40 Pro", 799));
		 * articleRepository.save(new Article(null,"OnePlus 8T", 599));
		 * articleRepository.save(new Article(null,"Oppo Find X2 Pro", 88899));
		 */
		
		
		// display articles console
		System.out.println();
		articleRepository.findAll().forEach(a -> System.out.println(a));
		System.out.println();


		// generate Datas catégories
		//Category smartphone = categoryRepository.save(new Category((long)1,"Smartphone",null));
		//Category tablet = categoryRepository.save(new Category((long)2,"Tablet",null));
		//Category pc = categoryRepository.save(new Category((long)3,"PC",null));
		
		
		// display categories console
				System.out.println();
				categoryRepository.findAll().forEach(c -> System.out.println(c));
				System.out.println();
		
				
				
				  /*articleRepository.save(new Article(null,"Apple Ipad Tab 9.7",480,tablet));
				  articleRepository.save(new Article(null,"Huawei Matebook D16",999,tablet));
				  articleRepository.save(new Article(null,"HP Chromebook 15a",799,pc));
				  articleRepository.save(new Article(null,"Samsung S12",550,smartphone));
				  articleRepository.save(new Article(null,"Samsung S10",500,smartphone));
				  articleRepository.save(new Article(null,"Samsung S9",380,smartphone));
				  articleRepository.save(new Article(null,"Apple iPhone 14",1380,smartphone));
				  articleRepository.save(new Article(null,"Samsung Galaxy Tab A8",880,tablet));
				  articleRepository.save(new Article(null,"Apple Ipad Tab 10.9",980,tablet));
				  articleRepository.save(new Article(null,"Dell XPS 15",2999,pc));
				  articleRepository.save(new Article(null,"Dell Inspiron 15",799,pc));
				  articleRepository.save(new Article(null,"Hewlett Packard Spectre",1799,pc));
				  articleRepository.save(new Article(null,"Sony Xperia XA1",380,smartphone));
				  articleRepository.save(new Article(null,"Honor Magic5 Pro",499.70,smartphone)); 
				  articleRepository.save(new Article(null,"OnePlus 8T",599,smartphone));*/
				 
	}

}	


