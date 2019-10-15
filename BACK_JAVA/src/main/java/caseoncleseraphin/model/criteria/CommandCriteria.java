package caseoncleseraphin.model.criteria;

import java.time.LocalDate;

import org.springframework.util.StringUtils;

import caseoncleseraphin.model.Client;
import caseoncleseraphin.model.CommandState;

public class CommandCriteria {
	private Long commandReference;
	private LocalDate commandDate;
	private CommandState state;
	private Client client;

	
	public CommandCriteria(Long commandReference, LocalDate commandDate, CommandState state, Client client) {
		super();
		this.commandReference = commandReference;
		this.commandDate = commandDate;
		this.state = state;
		this.client = client;
	}

	
	public boolean hasCriterias() {
		return !StringUtils.isEmpty(commandReference) || commandDate != null  || state != null || client != null;
	}


	public Long getCommandReference() {
		return commandReference;
	}


	public void setCommandReference(Long commandReference) {
		this.commandReference = commandReference;
	}


	public LocalDate getCommandDate() {
		return commandDate;
	}


	public void setCommandDate(LocalDate commandDate) {
		this.commandDate = commandDate;
	}


	public CommandState getState() {
		return state;
	}


	public void setState(CommandState state) {
		this.state = state;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}



}
