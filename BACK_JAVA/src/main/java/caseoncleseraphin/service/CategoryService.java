package caseoncleseraphin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import caseoncleseraphin.dao.CategoryJpaRepository;
import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.model.Category;
import caseoncleseraphin.model.criteria.CategoryCriteria;
import javassist.NotFoundException;

@Service
@Transactional
public class CategoryService {

	@Autowired
	@Qualifier("categoryJpaRepository")
	private CategoryJpaRepository categoryJpaRepository;

	public Category findOneById(Long id) throws NotFoundException {
		try {
			return categoryJpaRepository.findOneById(id);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new NotFoundException("La catégorie dont l'id est " + id + " n'existe pas", e);
		}

	}

	public List<Category> findAll() {
		return categoryJpaRepository.findAll();
	}

	public Category save(Category category) throws BadRequestException {
		try {
			return categoryJpaRepository.save(category);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("La catégorie n'a pas été créée", e);
		}
	}

	public Category update(Long id, Category category) throws BadRequestException {
		try {
			return categoryJpaRepository.update(category);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("La catégorie n'a pas été mise à jour", e);
		}

	}

	public Category delete(Long id) throws BadRequestException {
		try {
			return categoryJpaRepository.delete(id);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("La catégorie n'a pas été supprimée", e);
		}

	}

	public List<Category> search(CategoryCriteria criteria) {
		return categoryJpaRepository.search(criteria);
	}
}
