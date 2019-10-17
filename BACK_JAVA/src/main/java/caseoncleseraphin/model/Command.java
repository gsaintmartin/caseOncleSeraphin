package caseoncleseraphin.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Embeddable
@Entity
@Table(name = "command")
public class Command implements IdEntity {

	private static final long serialVersionUID = 5437908641536653640L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commandReference;

	private LocalDate commandDate;
	@Enumerated(EnumType.STRING)
	private CommandState state;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "command")
	private List<CommandLine> listCommandLines;

	public Command() {
		super();
	}

	public Command(LocalDate commandDate, CommandState state) {
		super();

		this.commandDate = commandDate;
		this.state = state;

	}

//getters and setters
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public List<CommandLine> getListCommandLines() {
		return listCommandLines;
	}

	public void setListCommandLines(List<CommandLine> listCommandLines) {
		this.listCommandLines = listCommandLines;
	}

	public Long getId() {
		return commandReference;
	}

	public void setId(Long id) {
		this.commandReference = id;
	}

}
