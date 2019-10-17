package caseoncleseraphin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import caseoncleseraphin.dao.CategoryJpaRepository;
import caseoncleseraphin.dao.RightJpaRepository;
import caseoncleseraphin.dao.RoleJpaRepository;
import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.exception.NotFoundException;
import caseoncleseraphin.model.Category;
import caseoncleseraphin.model.Right;
import caseoncleseraphin.model.Role;
import caseoncleseraphin.model.User;
import caseoncleseraphin.model.criteria.CategoryCriteria;

@Service
@Transactional
public class RightService {

	@Autowired
	@Qualifier("rightJpaRepository")
	private RightJpaRepository rightJpaRepository;

	public Right findOneByUsername(String username) throws NotFoundException {
		try {
			return rightJpaRepository.findOneByUsername(username);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new NotFoundException("L'utilisateur " + username + " n'existe pas", e);
		}

	}

	public List<Right> findAll() {
		return rightJpaRepository.findAll();
	}
	
	
	public Right save(Right right) throws BadRequestException {
		try {
			return rightJpaRepository.save(right);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("La catégorie n'a pas été créée", e);
		}
	}

}
