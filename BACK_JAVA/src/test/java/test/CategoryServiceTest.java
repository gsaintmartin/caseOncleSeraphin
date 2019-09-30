package caseoncleseraphin.test;



import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import caseoncleseraphin.App;
import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.model.Category;
import caseoncleseraphin.service.CategoryService;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { App.class })
@Transactional
public class CategoryServiceTest {
    
    @Autowired
    private CategoryService categoryService;

	@Test
	public void saveTest() {
		Category cat = new Category();
		try {
			cat = categoryService.save(cat);
		} catch (BadRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull("Id should be set after save.", cat.getId());
	}
	
	/* @Test(expected = DataAccessException.class)
	public void saveExistingTest() throws BadRequestException {
		Category user = new Category();
		user.setId(1L);
		user = categoryService.save(user);
	}*/
	
	

}

