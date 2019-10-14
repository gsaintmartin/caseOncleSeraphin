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
import caseoncleseraphin.model.Category;
import caseoncleseraphin.model.criteria.CategoryCriteria;
import caseoncleseraphin.service.CategoryService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api/categories")
public class CategoryController extends Controller<Object> {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Category findById(@PathVariable Long id) throws NotFoundException {
		return categoryService.findOneById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Category> findAll() {
		return categoryService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Category category) throws BadRequestException {
		categoryService.save(category);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void update(@PathVariable Long id, @RequestBody Category category) throws BadRequestException {
		categoryService.update(id, category);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) throws BadRequestException {
		categoryService.delete(id);
	}

	 @RequestMapping(value = "/search", method = RequestMethod.GET)
		public List<Category> search(@RequestParam(required = false) String categoryName,
				@RequestParam(required = false) Long id) {
			CategoryCriteria criteria = new CategoryCriteria(categoryName, id);
			
			return categoryService.search(criteria);
		}
	
	@Override
	public Object findById() throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create() throws BadRequestException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() throws BadRequestException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() throws BadRequestException {
		// TODO Auto-generated method stub
		
	}

	
}