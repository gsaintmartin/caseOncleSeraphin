
package caseoncleseraphin.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import caseoncleseraphin.model.Product;
import caseoncleseraphin.model.criteria.ProductCritNameCategory;
import caseoncleseraphin.model.criteria.ProductCriteria;

@Repository
//@Transactionnal
public class ProductJpaRepository extends AbstractJpaRepository<Product> {

	protected ProductJpaRepository() {
		super(Product.class);
	}

	public List<Product> search(ProductCriteria criteria) {
		String qlQuery2 = "select p from Product p left join fetch p.category c";
		
		if (criteria.hasCriterias()) {
			qlQuery2 += " where 1=1";
			
			if (!StringUtils.isEmpty(criteria.getName())) {
				qlQuery2 += " and p.name like :name";
			}
			if (criteria.getCategoryId() != null) {
				qlQuery2 += " and c.id = :categoryId";
			}
			if (criteria.getCompany() != null) {
				qlQuery2 += " and p.company like :company";
			}
			if (criteria.getPriceMin() != null) {
				qlQuery2 += " and p.price >= :priceMin";
			}
			if (criteria.getPriceMax() != null) {
				qlQuery2+= " and p.price <= :priceMax";
			}
		}
		
		TypedQuery<Product> query2 = entityManager.createQuery(qlQuery2, Product.class);
		
		if (criteria.hasCriterias()) {
			if (!StringUtils.isEmpty(criteria.getName())) {
				query2.setParameter("name", "%" + criteria.getName() + "%");
			}
			if (criteria.getCategoryId() != null) {
				query2.setParameter("categoryId", criteria.getCategoryId());
			}
			if (criteria.getCompany() != null) {
				query2.setParameter("company", criteria.getCompany());
			}
			if (criteria.getPriceMin() != null) {
				query2.setParameter("priceMin", criteria.getPriceMin());
			}
			if (criteria.getPriceMax() != null) {
				query2.setParameter("priceMax", criteria.getPriceMax());
			}
		}
		
		return query2.getResultList();
	}

	public List<Product> searchBar(ProductCritNameCategory critNameNCat) {
String qlQuery = "select p from Product p left join fetch p.category c";
		
		if (critNameNCat.hasCriteNameNCat()) {
			qlQuery += " where 1=1";
			
			if (!StringUtils.isEmpty(critNameNCat.getName())) {
				qlQuery += " and p.name like :name";
			}
			if (critNameNCat.getCategoryId() != null) {
				qlQuery += " and c.id = :categoryId";
			}}
		
		TypedQuery<Product> query = entityManager.createQuery(qlQuery, Product.class);
		
		if (critNameNCat.hasCriteNameNCat()) {
			if (!StringUtils.isEmpty(critNameNCat.getName())) {
				query.setParameter("name", "%" + critNameNCat.getName() + "%");
			}
			if (critNameNCat.getCategoryId() != null) {
				query.setParameter("categoryId", critNameNCat.getCategoryId());
			}}
		
		
		return query.getResultList();
	}
}
			
