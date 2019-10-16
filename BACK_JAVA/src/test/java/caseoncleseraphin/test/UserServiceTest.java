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
import caseoncleseraphin.model.User;
import caseoncleseraphin.service.UserService;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { App.class })
@Transactional
public class UserServiceTest {
    
    @Autowired
    private UserService userService;

	@Test
	public void saveTest() {
		User user = new User("Saint-Martin" , "Guillaume" , "gsaintmartin", "gsaintmartin@sfr.fr",
				"33 rue du dudul", "067895667", "zeub" , (LocalDate.of(2019, 9, 21)), null);
		try {
			user = userService.save(user);
			System.out.println("Un client a été créé et il a le numéro " + user.getId());
		} catch (BadRequestException e) {
	
			e.printStackTrace();
		}
		assertNotNull("Id should be set after save.", user.getId());
	}
	
	
	
	
	/* @Test(expected = DataAccessException.class)
	public void saveExistingTest() throws BadRequestException {
		Client user = new Client(null, "stazi", "Salim", "pwd", null, null, null, null, null);
		user.setId(1L);
		user = clientService.save(user);
	}*/
	
	

}

