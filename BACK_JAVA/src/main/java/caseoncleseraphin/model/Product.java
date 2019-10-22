package caseoncleseraphin.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class Product implements IdEntity {

	private static final long serialVersionUID = 708034339487829157L;

	@ManyToOne
	private Category category;

	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<CommandLine> listCommandLines;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String image;
	private String company;
	private double price;
	private int stockQuantity;
	

	public Product() {
		super();
	}

	public Product(String name, String description, String image,String company, double price, int stockQuantity) {
		super();

	
		this.name = name;
		this.description = description;
		this.image = image;
		this.company = company;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Category getCategory() {
		return category;

	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<CommandLine> getListCommandLines() {
		return listCommandLines;
	}

	public void setListCommandLines(List<CommandLine> listCommandLines) {
		this.listCommandLines = listCommandLines;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

}
