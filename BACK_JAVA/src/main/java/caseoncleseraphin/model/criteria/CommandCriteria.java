package caseoncleseraphin.model.criteria;

import java.time.LocalDate;

import org.springframework.util.StringUtils;

import caseoncleseraphin.model.User;
import caseoncleseraphin.model.CommandState;

public class CommandCriteria {
	private Long commandReference;
	private LocalDate commandDate;
	private CommandState state;
	private User user;

	
	public CommandCriteria(Long commandReference, LocalDate commandDate, CommandState state, User user) {
		super();
		this.commandReference = commandReference;
		this.commandDate = commandDate;
		this.state = state;
		this.user = user;
	}

	
	public boolean hasCriterias() {
		return !StringUtils.isEmpty(commandReference) || commandDate != null  || state != null || user != null;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



}
