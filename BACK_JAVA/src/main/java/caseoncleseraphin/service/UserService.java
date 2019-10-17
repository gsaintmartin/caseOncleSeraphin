
package caseoncleseraphin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import caseoncleseraphin.dao.UserJpaRepository;
import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.exception.NotFoundException;
import caseoncleseraphin.model.User;
import caseoncleseraphin.model.criteria.UserCriteria;

@Service
@Transactional
public class UserService {

	@Autowired
	@Qualifier("userJpaRepository")
	private UserJpaRepository userJpaRepository;

	public User findOneById(Long id) throws NotFoundException {
		try {
			return userJpaRepository.findOneById(id);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new NotFoundException("L'utilisateur dont l'id est " + id + " n'existe pas", e);
		}

	}
	
	public User findByUsername(String username) {
		
		return userJpaRepository.findByUsername(username);
		
	}
	
	

	public User findOneByUsername(String username) {
		return userJpaRepository.findOneByUsername(username);
	}

	public List<User> findAll() {
		return userJpaRepository.findAll();
	}

	public User save(User user) throws BadRequestException {
		try {
			return userJpaRepository.save(user);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("L'utilisateur n'a pas été créé", e);
		}
	}

	public User update(Long id, User user) throws BadRequestException {
		try {
			return userJpaRepository.update(user);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("Le client n'a pas été mis à jour", e);
		}

	}

	public User delete(Long id) throws BadRequestException {
		try {
			return userJpaRepository.delete(id);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("Le client n'a pas été supprimé", e);
		}

	}
	public List<User> search(UserCriteria criteria) {
		return userJpaRepository.search(criteria);
	}
}
