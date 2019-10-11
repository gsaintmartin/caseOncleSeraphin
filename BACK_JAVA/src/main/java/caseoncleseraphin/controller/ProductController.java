
package caseoncleseraphin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.model.Product;
import caseoncleseraphin.model.criteria.ProductCriteria;
import caseoncleseraphin.service.ProductService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api/products")
public class ProductController extends Controller {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Product findOneProductController(@PathVariable Long id) throws NotFoundException {
		return productService.findOneProduct(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Product> findAllProductsController() {
		return productService.findAllProducts();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createProductController(@RequestBody Product product) throws BadRequestException {
		productService.saveProduct(product);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateProductController(@PathVariable Long id, @RequestBody Product product) throws BadRequestException {
		productService.updateProduct(product);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteProductController(@PathVariable Long id) throws BadRequestException {
		productService.deleteProduct(id);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Product> search(@RequestParam(required = false) String name,
			@RequestParam(required = false) Long category,
			@RequestParam(required = false) String company,
			@RequestParam(required = false) Double priceMin,
			@RequestParam(required = false) Double priceMax) {
		ProductCriteria criteria = new ProductCriteria(name, category,  priceMin, priceMax, company);
		
		return productService.search(criteria);
	}

}