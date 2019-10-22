
package caseoncleseraphin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import caseoncleseraphin.dao.ProductJpaRepository;
import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.exception.NotFoundException;
import caseoncleseraphin.model.Product;
import caseoncleseraphin.model.criteria.ProductCritNameCategory;
import caseoncleseraphin.model.criteria.ProductCriteria;

@Transactional
@Service
public class ProductService {

	@Autowired
	@Qualifier("productJpaRepository")
	private ProductJpaRepository productJpaRepository;

	public Product findOneProduct(Long id) throws NotFoundException {
		try {
			return productJpaRepository.findOneById(id);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new NotFoundException("Le produit dont l'id est " + id + " n'existe pas", e);
		}

	}

//	public Product findOneByLogin(String login) {
//		return productJpaRepository.findOneByLogin(login);
//	}

	public List<Product> findAllProducts() {
		return productJpaRepository.findAll();
	}

	public Product saveProduct(Product product) throws BadRequestException {
		try {
			return productJpaRepository.save(product);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("Le produit n'a pas été créé", e);
		}
	}

	public Product updateProduct(Product product) throws BadRequestException {
		try {
			return productJpaRepository.update(product);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("Le produit n'a pas été mis à jour", e);
		}

	}

	public Product deleteProduct(Long id) throws BadRequestException {
		try {
			return productJpaRepository.delete(id);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("Le produit n'a pas été supprimé", e);
		}

	}

	public List<Product> search(ProductCriteria criteria) {
		return productJpaRepository.search(criteria);
	}

	

	public List<Product> searchBar(ProductCritNameCategory critNameNCat) {
		
		return productJpaRepository.searchBar(critNameNCat);
	}

}
