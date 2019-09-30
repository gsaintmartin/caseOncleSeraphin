package caseoncleseraphin.test;



import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import caseoncleseraphin.App;
import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.model.Command;
import caseoncleseraphin.model.CommandState;
import caseoncleseraphin.service.CommandService;
import javassist.NotFoundException;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { App.class })
@Transactional
public class CommandServiceTest {
    
    @Autowired
    private CommandService commandService;

	@Test
	public void saveTest() {
		Command command = new Command(LocalDate.of(2019, 9, 21), CommandState.CREATED);
		try {
			command = commandService.save(command);
			System.out.println("La commande est crée et elle a le numéro " + command.getId());
		} catch (BadRequestException e) {
	
			e.printStackTrace();
		}
		assertNotNull("Id should be set after save.", command.getId());
	}
	
	@Test
	public void searchById() throws NotFoundException {
			Command command = commandService.findOneById(2L);
			assertNotNull(command);
			System.out.println("La commande a le numéro " + command.getId());
	}
	
	/* @Test(expected = DataAccessException.class)
	public void saveExistingTest() throws BadRequestException {
		Client user = new Client(null, "stazi", "Salim", "pwd", null, null, null, null, null);
		user.setId(1L);
		user = clientService.save(user);
	}*/
	
	

}

