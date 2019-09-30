package caseoncleseraphin;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.model.Client;
import caseoncleseraphin.service.ClientService;
import javassist.NotFoundException;

@Component
public class Lanceur {
	@Autowired
	ClientService clientService;

	@PostConstruct
	public void creationClient() throws BadRequestException, NotFoundException {
		Client c1 = new Client("Deeljore", "Brice", "bdeeljore", "bdeeljore@gmail.com", "6 rue de la resistance",
				"0699842032", "azerty", (LocalDate.of(2019, 9, 21)));
		try {
			clientService.findOneByUsername("bdeeljore");
			System.out.println("le login " + c1.getUsername() + " existe déjà.");
		} catch (EmptyResultDataAccessException e) {
			clientService.save(c1);
			System.out.println("le client " + c1.getUsername() + " a ete créé.");
		}
	}
}
