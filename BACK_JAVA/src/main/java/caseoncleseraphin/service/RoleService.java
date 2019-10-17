package caseoncleseraphin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import caseoncleseraphin.dao.CategoryJpaRepository;
import caseoncleseraphin.dao.RoleJpaRepository;
import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.exception.NotFoundException;
import caseoncleseraphin.model.Category;
import caseoncleseraphin.model.Role;
import caseoncleseraphin.model.User;
import caseoncleseraphin.model.criteria.CategoryCriteria;

@Service
@Transactional
public class RoleService {

	@Autowired
	@Qualifier("roleJpaRepository")
	private RoleJpaRepository roleJpaRepository;

	public Role findOneByUsername(String username) throws NotFoundException {
		try {
			return roleJpaRepository.findOneByUsername(username);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new NotFoundException("L'utilisateur " + username + " n'existe pas", e);
		}

	}

	public List<Role> findAll() {
		return roleJpaRepository.findAll();
	}
	
	
	public Role save(Role role) throws BadRequestException {
		try {
			return roleJpaRepository.save(role);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("La catégorie n'a pas été créée", e);
		}
	}

}
