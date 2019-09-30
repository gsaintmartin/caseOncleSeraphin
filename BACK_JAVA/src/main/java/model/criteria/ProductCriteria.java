package caseoncleseraphin.model.criteria;

import org.springframework.util.StringUtils;

public class ProductCriteria {

	private String name;
	private Long categoryId;
	private Double priceMin;
	private Double priceMax;
	private String company;
	
	public ProductCriteria(String name, Long categoryId, Double priceMin, Double priceMax,String company) {
		this.name = name;
		this.categoryId = categoryId;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
		this.company = company;
	}
	
	public boolean hasCriterias() {
		return !StringUtils.isEmpty(name) || categoryId != null || company != null || priceMin != null || priceMax != null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Double getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Double priceMin) {
		this.priceMin = priceMin;
	}

	public Double getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(Double priceMax) {
		this.priceMax = priceMax;
	}

}
