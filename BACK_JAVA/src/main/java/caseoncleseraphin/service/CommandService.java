package caseoncleseraphin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import caseoncleseraphin.dao.CommandJpaRepository;
import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.model.Command;
import caseoncleseraphin.model.criteria.CommandCriteria;
import javassist.NotFoundException;

@Service
@Transactional
public class CommandService {

	@Autowired
	@Qualifier("commandJpaRepository")
	private CommandJpaRepository commandJpaRepository;	
	
	public Command findOneById(Long id) throws NotFoundException {
		try {
			return commandJpaRepository.findOneById(id);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new NotFoundException("La commande dont l'id est " + id + " n'existe pas", e);
		}
		
	}
	
	
	public List<Command> findAll() {
		return commandJpaRepository.findAll();
	}
	
	public Command save(Command command) throws BadRequestException {
		try {
			return commandJpaRepository.save(command);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("La commande n'a pas été créée", e);
		}
	}
	
	public Command update(Long id, Command command) throws BadRequestException {
		try {
			return commandJpaRepository.update(command);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("La commande n'a pas été mise à jour", e);
		}
		
	}
	
	public Command delete(Long id) throws BadRequestException {
		try {
			return commandJpaRepository.delete(id);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("La commande n'a pas été supprimée", e);
		}
		
	}
	
	public List<Command> search(CommandCriteria criteria) {
		return commandJpaRepository.search(criteria);
	}
}
