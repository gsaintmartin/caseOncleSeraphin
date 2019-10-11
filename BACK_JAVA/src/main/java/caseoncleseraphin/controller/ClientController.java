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
import caseoncleseraphin.model.criteria.ClientCriteria;
import caseoncleseraphin.service.ClientService;
import javassist.NotFoundException;


@RestController
@RequestMapping ("/api/clients")
public class ClientController extends Controller {
    @Autowired
    private ClientService clientService;
    
    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Client findById(@PathVariable Long id) throws NotFoundException {
    return clientService.findOneById(id);
    }
    
    @RequestMapping ( method = RequestMethod.GET)
    @ResponseBody
    public List<Client> findAll() {
    return clientService.findAll();
    }
    
    @RequestMapping (method = RequestMethod.POST)
    @ResponseStatus (HttpStatus.CREATED)
    public void create (@RequestBody Client client)  throws BadRequestException{
			clientService.save (client);
    }
    
    @RequestMapping (value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update (@PathVariable Long id, @RequestBody Client client) throws BadRequestException {
    	clientService.update (id, client);
    }
    
    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete (@PathVariable Long id) throws BadRequestException {
    	clientService.delete (id);
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Client> search(@RequestParam(required = false) String name,
			@RequestParam(required = false) Long id,
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String username,
			@RequestParam(required = false) LocalDate creationDate,
			@RequestParam(required = false) int numberOrdersMade) {
		ClientCriteria criteria = new ClientCriteria(id,name, firstName, username, creationDate, numberOrdersMade);
		
		return clientService.search(criteria);
	}
}