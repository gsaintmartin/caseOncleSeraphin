package caseoncleseraphin.model.criteria;

import java.time.LocalDate;

import org.springframework.util.StringUtils;

public class ClientCriteria {
	private Long id;
	private String name;
	private String firstName;
	private String username;
	private LocalDate creationDate;
	private int numberOrdersMade;
	
	public ClientCriteria(Long id, String name, String firstName, String username, LocalDate creationDate,
			int numberOrdersMade) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.username = username;
		this.creationDate = creationDate;
		this.numberOrdersMade = numberOrdersMade;
	}

	
	public boolean hasCriterias() {
		return !StringUtils.isEmpty(name) || id != null || name != null || firstName != null  || username != null  || creationDate != null  || numberOrdersMade != 0;
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



	public LocalDate getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}



	public int getNumberOrdersMade() {
		return numberOrdersMade;
	}



	public void setNumberOrdersMade(int numberOrdersMade) {
		this.numberOrdersMade = numberOrdersMade;
	}



	
	

}
