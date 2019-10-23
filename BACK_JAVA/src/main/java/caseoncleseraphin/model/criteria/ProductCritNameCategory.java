package caseoncleseraphin.model.criteria;

import org.springframework.util.StringUtils;

public class ProductCritNameCategory {
	private String name;
	private Long categoryId;
	
	
	public ProductCritNameCategory(String name, Long categoryId) {
		super();
		this.name = name;
		this.categoryId = categoryId;
	}
	public boolean hasCriteNameNCat() {
		return !StringUtils.isEmpty(name) || categoryId != null ;
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
	
	public String getName() {
		return name;
	}
	
}
