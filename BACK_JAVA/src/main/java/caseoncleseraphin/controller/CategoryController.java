package caseoncleseraphin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.exception.NotFoundException;
import caseoncleseraphin.model.Category;
import caseoncleseraphin.model.criteria.CategoryCriteria;
import caseoncleseraphin.service.CategoryService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/categories")
public class CategoryController extends Controller<Category> {
	@Autowired
	private CategoryService categoryService;

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Category findById(@PathVariable Long id) throws NotFoundException {
		return categoryService.findOneById(id);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Category> findAll() {
		return categoryService.findAll();
	}

	@Override
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('C_CATEGORY')")
	public void create(@RequestBody Category category) throws BadRequestException {
		categoryService.save(category);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	@PreAuthorize("hasAuthority('U_CATEGORY')")
	public void update(@PathVariable Long id, @RequestBody Category category) throws BadRequestException {
		categoryService.update(id, category);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@PreAuthorize("hasAuthority('D_CATEGORY')")
	public void delete(@PathVariable Long id) throws BadRequestException {
		categoryService.delete(id);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Category> search(@RequestParam(required = false) String categoryName,
			@RequestParam(required = false) Long id) {
		CategoryCriteria criteria = new CategoryCriteria(categoryName, id);

		return categoryService.search(criteria);
	}

}