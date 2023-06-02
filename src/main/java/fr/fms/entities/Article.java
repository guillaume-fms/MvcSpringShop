package fr.fms.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString 
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	//private String description;
	//private double price;
	
	
	// messages erreurs description
	@NotNull
	@Size(min=5, max=40)
	private String description;
	
	// messages erreurs 
	@DecimalMin("50")
	private double price;
	
	
	
	
	@ManyToOne
	private Category category;    // plusieurs articles sont liés à une seule catégorie
	
}











