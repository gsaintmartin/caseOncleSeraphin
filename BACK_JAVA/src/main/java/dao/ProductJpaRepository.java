
package caseoncleseraphin.dao;



import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import caseoncleseraphin.model.Product;
import caseoncleseraphin.model.criteria.ProductCriteria;

@Repository
//@Transactionnal
public class ProductJpaRepository extends AbstractJpaRepository<Product>{

	protected ProductJpaRepository() {
		super(Product.class);
	}

	public List<Product> search(ProductCriteria criteria) {
		String qlQuery = "select p from Product p left join fetch p.category c";
		
		if (criteria.hasCriterias()) {
			qlQuery += " where 1=1";
			
			if (!StringUtils.isEmpty(criteria.getName())) {
				qlQuery += " and p.name like :name";
			}
			if (criteria.getCategoryId() != null) {
				qlQuery += " and c.id = :categoryId";
			}
			if (criteria.getCompany() != null) {
				qlQuery += " and p.company like :company";
			}
			if (criteria.getPriceMin() != null) {
				qlQuery += " and p.price >= :priceMin";
			}
			if (criteria.getPriceMax() != null) {
				qlQuery += " and p.price <= :priceMax";
			}
		}
		
		TypedQuery<Product> query = entityManager.createQuery(qlQuery, Product.class);
		
		if (criteria.hasCriterias()) {
			if (!StringUtils.isEmpty(criteria.getName())) {
				query.setParameter("name", "%" + criteria.getName() + "%");
			}
			if (criteria.getCategoryId() != null) {
				query.setParameter("categoryId", criteria.getCategoryId());
			}
			if (criteria.getCompany() != null) {
				query.setParameter("company", criteria.getCompany());
			}
			if (criteria.getPriceMin() != null) {
				query.setParameter("priceMin", criteria.getPriceMin());
			}
			if (criteria.getPriceMax() != null) {
				query.setParameter("priceMax", criteria.getPriceMax());
			}
		}
		
		return query.getResultList();
	}
}

