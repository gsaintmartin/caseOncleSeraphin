
package caseoncleseraphin.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import caseoncleseraphin.model.Client;
import caseoncleseraphin.model.criteria.ClientCriteria;

@Repository
@Transactional
public class ClientJpaRepository extends AbstractJpaRepository<Client> {

	public ClientJpaRepository() {
		super(Client.class);
	}

	public List<Client> search(ClientCriteria criteria) {
		String qlQuery = "select p from Client cl left join fetch cl.command co";

		if (criteria.hasCriterias()) {
			qlQuery += " where 1=1";

			if (!StringUtils.isEmpty(criteria.getName())) {
				qlQuery += " and cl.name like :name";
			}
			if (criteria.getId() != null) {
				qlQuery += " and cl.id = :clientId";
			}
			if (criteria.getFirstName() != null) {
				qlQuery += " and cl.firstName like :firstName";
			}
			if (criteria.getUsername() != null) {
				qlQuery += " and cl.username like :username";
			}
			if (criteria.getCreationDate() != null) {
				qlQuery += " and cl.creationDate = :creationDate";
			}
			if (criteria.getNumberOrdersMade() >= 0) {
				qlQuery += " and co.numberOrdersMade = :numberOrdersMade";
			}
		}

		TypedQuery<Client> query = entityManager.createQuery(qlQuery, Client.class);

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

	public Client findOneByUsername(String username) {
		String qlString = "from Client cl where cl.username = :username";
		TypedQuery<Client> query = entityManager.createQuery(qlString, Client.class);
		query.setParameter("username", username);

		return query.getSingleResult();
	}

	public Client findOneById(Long id) {
		String qlString = "from Client cl where cl.id = :id";
		TypedQuery<Client> query = entityManager.createQuery(qlString, Client.class);
		query.setParameter("id", id);

		return query.getSingleResult();
	}

}
