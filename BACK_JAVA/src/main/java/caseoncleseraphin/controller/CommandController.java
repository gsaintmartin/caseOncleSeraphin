package caseoncleseraphin.controller;

import java.time.LocalDate;
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
import caseoncleseraphin.model.Client;
import caseoncleseraphin.model.Command;
import caseoncleseraphin.model.CommandState;
import caseoncleseraphin.model.criteria.CommandCriteria;
import caseoncleseraphin.service.CommandService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api/commands")
public class CommandController extends Controller<Object> {
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

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Command> search(@RequestParam(required = false)  Long commandReference,
			@RequestParam(required = false) LocalDate commandDate,
			@RequestParam(required = false) CommandState state,
			@RequestParam(required = false) Client client) {
		CommandCriteria criteria = new CommandCriteria(commandReference,commandDate, state, client);
		
		return commandService.search(criteria);
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