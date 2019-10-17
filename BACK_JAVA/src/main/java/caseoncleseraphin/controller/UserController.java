package caseoncleseraphin.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
import caseoncleseraphin.model.User;
import caseoncleseraphin.model.criteria.UserCriteria;
import caseoncleseraphin.service.UserService;


@RestController
@RequestMapping ("/api/users")
public class UserController extends Controller<User> {
    @Autowired
    private UserService userService;
    
    @Override
    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User findById(@PathVariable Long id) throws NotFoundException {
    return userService.findOneById(id);
    }

    @Override
    @RequestMapping ( method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAll() {
    return userService.findAll();
    }

    @Override
    @RequestMapping (method = RequestMethod.POST)
    @ResponseStatus (HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('C_USER')")
    public void create (@RequestBody User user)  throws BadRequestException{
			userService.save (user);
    }

    @Override
    @RequestMapping (value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    @PreAuthorize("hasAuthority('U_USER')")
    public void update (@PathVariable Long id, @RequestBody User user) throws BadRequestException {
    	userService.update (id, user);
    }

    @Override
    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @PreAuthorize("hasAuthority('D_USER')")
    public void delete (@PathVariable Long id) throws BadRequestException {
    	userService.delete (id);
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<User> search(@RequestParam(required = false) String name,
			@RequestParam(required = false) Long id,
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String username,
			@RequestParam(required = false) LocalDate creationDate,
			@RequestParam(required = false) int numberOrdersMade) {
		UserCriteria criteria = new UserCriteria(id,name, firstName, username, creationDate, numberOrdersMade);
		
		return userService.search(criteria);
	}
}