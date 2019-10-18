package caseoncleseraphin.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "commandLine")
public class CommandLine implements IdEntity{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6056148948961901952L;
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantity;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Command command;

	public CommandLine() {
		super();
	}

	public CommandLine(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void addProductToBasket(Product product) {

	}

	public void deleteProductFromBasket(Product product) {

	}

	public void updateProductQuantityInBasket(Product product) {

	}

}
