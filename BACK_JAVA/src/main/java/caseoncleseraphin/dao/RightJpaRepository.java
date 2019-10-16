package caseoncleseraphin.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import caseoncleseraphin.model.Category;
import caseoncleseraphin.model.Right;
import caseoncleseraphin.model.Role;
import caseoncleseraphin.model.User;
import caseoncleseraphin.model.criteria.CategoryCriteria;

@Repository
@Transactional
public class RightJpaRepository extends AbstractJpaRepository<Right> {

    public RightJpaRepository() {
        super(Right.class);
    }

    
    
    public Right findOneByUsername(String username) {
        String qlString = "select role from User u where u.username = :username";
        TypedQuery<Right> query = entityManager.createQuery(qlString, Right.class);
        query.setParameter("username", username);

        return query.getSingleResult();
    }

	public List<Right> search(CategoryCriteria criteria) {
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

		TypedQuery<Right> query = entityManager.createQuery(qlQuery, Right.class);

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
