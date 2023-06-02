package fr.fms.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor  @ToString(exclude = {"articles"}) 
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	//private String name;

	@NotNull
	private String name;
	
	@OneToMany(mappedBy = "category")
	private Collection<Article> articles;    // une catégorie est liée à plusieurs articles{
	

}


