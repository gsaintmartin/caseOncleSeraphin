package caseoncleseraphin;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.model.Right;
import caseoncleseraphin.model.Role;
import caseoncleseraphin.model.User;
import caseoncleseraphin.service.RightService;
import caseoncleseraphin.service.RoleService;
import caseoncleseraphin.service.UserService;
import javassist.NotFoundException;

@Component
public class Lanceur {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RightService rightService;

	
	@Autowired
	private RoleService roleService;
	

	@PostConstruct
	public void initializeData() throws BadRequestException, NotFoundException {
		if (userService.findAll().isEmpty()) {
			
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Creation des droits 
			
			//Droits client
			Right createCommand = new Right("C_COMMAND");
			rightService.save(createCommand);
			Right updateCommand = new Right("U_COMMAND");
			rightService.save(updateCommand);
			Right deleteCommand = new Right("D_COMMAND");
			rightService.save(deleteCommand);
			
			//Droits Admin
			Right createProduct = new Right("C_PRODUCT");
			rightService.save(createProduct);
			Right updateProduct = new Right("U_PRODUCT");
			rightService.save(updateProduct);
			Right deleteProduct = new Right("D_PRODUCT");
			rightService.save(deleteProduct);
			Right createCategory = new Right("C_CATEGORY");
			rightService.save(createCategory);
			Right updateCategory = new Right("U_CATEGORY");
			rightService.save(updateCategory);
			Right deleteCategory = new Right("D_CATEGORY");
			rightService.save(deleteCategory);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
//Creation des rôles et attribution des droits aux rôles
			
			//Creation des droits admin
			List<Right> adminRights = Arrays.asList(createProduct,updateProduct,deleteProduct,createCategory,updateCategory,deleteCategory);
			Role roleAdmin = new Role("ADMIN");
			roleAdmin.setRights(adminRights);
			roleService.save(roleAdmin);

			//Creation des droits client
			List<Right> customerRights = Arrays.asList(createCommand,updateCommand,deleteCommand);
			Role roleCustomer = new Role("CUSTOMER");
			roleCustomer.setRights(customerRights);
			roleService.save(roleCustomer);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
//Creation des users et attribution d'un rôle pour chaque user
			//Creation des admins
			
			User admin1 = new User("Deeljore", "Brice", "bdeeljore", "bdeeljore@gmail.com", "7 rue de la resistance",
					"0699842032", "azerty", (LocalDate.of(2019, 9, 21)), roleAdmin);
			try {
				userService.findOneByUsername("bdeeljore");
				System.out.println("le login " + admin1.getUsername() + " existe déjà.");
			} catch (EmptyResultDataAccessException e) {
				userService.save(admin1);
				System.out.println("l'utilisateur " + admin1.getUsername() + " a ete créé.");
			}
			
			User admin2 = new User("Giraud", "Pierre", "pgiraud", "pgiraud@gmail.com", "8 rue de la resistance",
					"0699842033", "azerty", (LocalDate.of(2019, 9, 21)), roleAdmin);
			try {
				userService.findOneByUsername("bdeeljore");
				System.out.println("le login " + admin2.getUsername() + " existe déjà.");
			} catch (EmptyResultDataAccessException e) {
				userService.save(admin2);
				System.out.println("l'utilisateur " + admin2.getUsername() + " a ete créé.");
			}
			
			User admin3 = new User("Augier", "Julien", "jaugier", "jaugier@gmail.com", "9 rue de la resistance",
					"0699842034", "azerty", (LocalDate.of(2019, 9, 21)), roleAdmin);
			try {
				userService.findOneByUsername("bdeeljore");
				System.out.println("le login " + admin3.getUsername() + " existe déjà.");
			} catch (EmptyResultDataAccessException e) {
				userService.save(admin3);
				System.out.println("l'utilisateur " + admin3.getUsername() + " a ete créé.");
			}
			User admin4 = new User("Saint-Martin", "Guillaume", "gsaintmartin", "gsaintmartin@gmail.com", "10 rue de la resistance",
					"0699842035", "azerty", (LocalDate.of(2019, 9, 21)), roleAdmin);
			try {
				userService.findOneByUsername("bdeeljore");
				System.out.println("le login " + admin4.getUsername() + " existe déjà.");
			} catch (EmptyResultDataAccessException e) {
				userService.save(admin4);
				System.out.println("l'utilisateur " + admin4.getUsername() + " a ete créé.");
			}
			
			//Creation des clients
			User client1 = new User("Duce", "J-C", "jcduce", "jcduce@gmail.com", "11 rue de la resistance",
					"0699842137", "azerty", (LocalDate.of(2019, 9, 24)), roleCustomer);

			try {
				userService.findOneByUsername("jcduce");
				System.out.println("le login " + client1.getUsername() + " existe déjà.");
			} catch (EmptyResultDataAccessException e) {
				userService.save(client1);
				System.out.println("l'utilisateur " + client1.getUsername() + " a ete créé.");
			}
		}
	}
	
	
	@PostConstruct
	public void testDataBaseAdmin1() {
	User serverUser = userService.findByUsername("jcduce");
	
	System.out.println(serverUser.getName());
	
	}
	@PostConstruct
	public void testDataBaseClient1() {
	User serverUser = userService.findByUsername("bdeeljore");
	
	System.out.println(serverUser.getName());
	
	}
}
