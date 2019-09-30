package caseoncleseraphin.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements IdEntity {

	
	@OneToMany(mappedBy="client")
	private List <Contact> listContacts;
	
	

	@OneToMany(mappedBy="client")
	private List <Command> listCommands;

	private static final long serialVersionUID = 4030989545851358176L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String firstName;
	private String username;

	private String email; 
	private String adress;
	private String phone;
	private String password;
	private LocalDate creationDate;

	public Client() {
		super();
	}

	public Client(String name, String firstName, String username, String email, String adress, String phone,
			String password, LocalDate creationDate) {
		super();

		this.name = name;
		this.firstName = firstName;
		this.username = username;
		this.email = email;
		this.adress = adress;
		this.phone = phone;
		this.password = password;
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	

	public List<Command> getListCommands() {
		return listCommands;
	}

	public void setListCommands(List<Command> listCommands) {
		this.listCommands = listCommands;
	}
	
	public List<Contact> getListContacts() {
		return listContacts;
	}

	public void setListContacts(List<Contact> listContacts) {
		this.listContacts = listContacts;
	}
	

	
	
		

}
