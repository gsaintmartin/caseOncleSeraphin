
package caseoncleseraphin.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import caseoncleseraphin.model.User;
import caseoncleseraphin.model.criteria.UserCriteria;

@Repository
@Transactional
public class UserJpaRepository extends AbstractJpaRepository<User> {

	public UserJpaRepository() {
		super(User.class);
	}
	
	@Transactional
	public User findByUsername(String username) {
		
		String qlQuery = "from User u left join fetch u.role r left join fetch r.rights where u.username = :username";
		TypedQuery<User> query = entityManager.createQuery(qlQuery, User.class);
		query.setParameter("username", username);
		
		User user = query.getSingleResult();
		return user;
		
	}

	public List<User> search(UserCriteria criteria) {
		String qlQuery = "select p from User u left join fetch u.command co";

		if (criteria.hasCriterias()) {
			qlQuery += " where 1=1";

			if (!StringUtils.isEmpty(criteria.getName())) {
				qlQuery += " and u.name like :name";
			}
			if (criteria.getId() != null) {
				qlQuery += " and u.id = :clientId";
			}
			if (criteria.getFirstName() != null) {
				qlQuery += " and u.firstName like :firstName";
			}
			if (criteria.getUsername() != null) {
				qlQuery += " and u.username like :username";
			}
			if (criteria.getCreationDate() != null) {
				qlQuery += " and u.creationDate = :creationDate";
			}
			if (criteria.getNumberOrdersMade() >= 0) {
				qlQuery += " and co.numberOrdersMade = :numberOrdersMade";
			}
		}

		TypedQuery<User> query = entityManager.createQuery(qlQuery, User.class);

		if (criteria.hasCriterias()) {
			if (!StringUtils.isEmpty(criteria.getName())) {
				query.setParameter("name", "%" + criteria.getName() + "%");
			}
			if (criteria.getId() != null) {
				query.setParameter("Id", criteria.getId());
			}
			if (criteria.getFirstName() != null) {
				query.setParameter("firstName", criteria.getFirstName());
			}
			if (criteria.getUsername() != null) {
				query.setParameter("userName", criteria.getUsername());
			}
			if (criteria.getCreationDate() != null) {
				query.setParameter("creationDate", criteria.getCreationDate());
			}
			if (criteria.getNumberOrdersMade() >= 0) {
				query.setParameter("numberOrdersMade", criteria.getNumberOrdersMade());
			}
		}
		return query.getResultList();
	}

	public User findOneByUsername(String username) {
		String qlString = "from User u where u.username = :username";
		TypedQuery<User> query = entityManager.createQuery(qlString, User.class);
		query.setParameter("username", username);

		return query.getSingleResult();
	}

	public User findOneById(Long id) {
		String qlString = "from User u where u.id = :id";
		TypedQuery<User> query = entityManager.createQuery(qlString, User.class);
		query.setParameter("id", id);

		return query.getSingleResult();
	}

}
