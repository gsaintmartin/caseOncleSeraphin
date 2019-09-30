package caseoncleseraphin.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import caseoncleseraphin.model.Command;


@Repository
@Transactional
public class CommandJpaRepository extends AbstractJpaRepository<Command> {

	public CommandJpaRepository() {
		super(Command.class);
	}
}
