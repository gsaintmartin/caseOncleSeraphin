package caseoncleseraphin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.model.Command;
import caseoncleseraphin.service.CommandService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api/commands")
public class CommandController {
	@Autowired
	private CommandService commandService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Command findById(@PathVariable Long id) throws NotFoundException {
		return commandService.findOneById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Command> findAll() {
		return commandService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Command command) throws BadRequestException {
			commandService.save(command);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void update(@PathVariable Long id, @RequestBody Command command) throws BadRequestException {
		commandService.update(id, command);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) throws BadRequestException {
		commandService.delete(id);
	}
}