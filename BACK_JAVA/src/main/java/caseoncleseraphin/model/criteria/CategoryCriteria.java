package caseoncleseraphin.model.criteria;

import org.springframework.util.StringUtils;

public class CategoryCriteria {

	private String categoryName;
	private Long id;
	
	public CategoryCriteria(String categoryName, Long id) {
		super();
		this.categoryName = categoryName;
		this.id = id;
	}
	
	public boolean hasCriterias() {
		return !StringUtils.isEmpty(categoryName) || id != null;
	}

	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
