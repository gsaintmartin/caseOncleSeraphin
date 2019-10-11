package caseoncleseraphin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import caseoncleseraphin.exception.BadRequestException;
import javassist.NotFoundException;

@RestController
public abstract class Controller<T> {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public abstract T findById() throws NotFoundException;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public abstract T findAll();

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public abstract void create() throws BadRequestException;

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public abstract void update() throws BadRequestException;

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public abstract void delete() throws BadRequestException;

}