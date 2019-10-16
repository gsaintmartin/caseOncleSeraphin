package caseoncleseraphin.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import caseoncleseraphin.model.Command;
import caseoncleseraphin.model.criteria.CommandCriteria;

@Repository
@Transactional
public class CommandJpaRepository extends AbstractJpaRepository<Command> {

	public CommandJpaRepository() {
		super(Command.class);
	}

	public List<Command> search(CommandCriteria criteria) {
		String qlQuery = "select p from Command co left join fetch co.client cl";

		if (criteria.hasCriterias()) {
			qlQuery += " where 1=1";

			if (!StringUtils.isEmpty(criteria.getCommandReference())) {
				qlQuery += " and co.id like :id";
			}
			if (criteria.getCommandDate() != null) {
				qlQuery += " and co.commandDate = :commandDate";
			}
			if (criteria.getState() != null) {
				qlQuery += " and co.state like :state";
			}
			if (criteria.getUser() != null) {
				qlQuery += " and cl.id =: id";
			}

		}
		
		TypedQuery<Command> query = entityManager.createQuery(qlQuery, Command.class);

		if (criteria.hasCriterias()) {
			if (!StringUtils.isEmpty(criteria.getCommandReference())) {
				query.setParameter("Id", "%" + criteria.getCommandReference() + "%");
			}
			if (criteria.getCommandDate() != null) {
				query.setParameter("commandDate", criteria.getCommandDate());
			}
			if (criteria.getState() != null) {
				query.setParameter("state", criteria.getState());
			}
			if (criteria.getUser() != null) {
				query.setParameter("user", criteria.getUser());
			}
			
		}
		return query.getResultList();
	}
}