package caseoncleseraphin.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import caseoncleseraphin.model.Category;
import caseoncleseraphin.model.Role;
import caseoncleseraphin.model.User;
import caseoncleseraphin.model.criteria.CategoryCriteria;

@Repository
@Transactional
public class RoleJpaRepository extends AbstractJpaRepository<Role> {

    public RoleJpaRepository() {
        super(Role.class);
    }

    
    
    public Role findOneByUsername(String username) {
        String qlString = "select role from User u where u.username = :username";
        TypedQuery<Role> query = entityManager.createQuery(qlString, Role.class);
        query.setParameter("username", username);

        return query.getSingleResult();
    }

	public List<Category> search(CategoryCriteria criteria) {
		String qlQuery = "select p from Category ca ";

		if (criteria.hasCriterias()) {
			qlQuery += " where 1=1";

			if (!StringUtils.isEmpty(criteria.getCategoryName())) {
				qlQuery += " and ca.categoryName like :categoryName";
			}
			if (criteria.getId() != null) {
				qlQuery += " and ca.id = :id";
			}
		
		}

		TypedQuery<Category> query = entityManager.createQuery(qlQuery, Category.class);

		if (criteria.hasCriterias()) {
			if (!StringUtils.isEmpty(criteria.getCategoryName())) {
				query.setParameter("name", "%" + criteria.getCategoryName() + "%");
			}
			if (criteria.getId() != null) {
				query.setParameter("Id", criteria.getId());
			}
			
		}
		return query.getResultList();
	}



	
}
