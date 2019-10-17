package caseoncleseraphin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.exception.NotFoundException;

@RestController
public abstract class Controller<T> {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public abstract T findById(@PathVariable Long id) throws NotFoundException;

	@RequestMapping(method = RequestMethod.GET)
	public abstract List<T> findAll();

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public abstract void create(@RequestBody T t) throws BadRequestException;

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public abstract void update(@PathVariable Long id, @RequestBody T t) throws BadRequestException;

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public abstract void delete(@PathVariable Long id) throws BadRequestException;

}