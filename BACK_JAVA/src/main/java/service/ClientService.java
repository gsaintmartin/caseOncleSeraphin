
package caseoncleseraphin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import caseoncleseraphin.dao.ClientJpaRepository;
import caseoncleseraphin.exception.BadRequestException;
import caseoncleseraphin.model.Client;
import caseoncleseraphin.model.criteria.ClientCriteria;
import javassist.NotFoundException;

@Service
@Transactional
public class ClientService {

	@Autowired
	@Qualifier("clientJpaRepository")
	private ClientJpaRepository clientJpaRepository;

	public Client findOneById(Long id) throws NotFoundException {
		try {
			return clientJpaRepository.findOneById(id);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new NotFoundException("Le client dont l'id est " + id + " n'existe pas", e);
		}

	}

	public Client findOneByUsername(String username) {
		return clientJpaRepository.findOneByUsername(username);
	}

	public List<Client> findAll() {
		return clientJpaRepository.findAll();
	}

	public Client save(Client client) throws BadRequestException {
		try {
			return clientJpaRepository.save(client);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("Le client n'a pas été créé", e);
		}
	}

	public Client update(Long id, Client client) throws BadRequestException {
		try {
			return clientJpaRepository.update(client);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("Le client n'a pas été mis à jour", e);
		}

	}

	public Client delete(Long id) throws BadRequestException {
		try {
			return clientJpaRepository.delete(id);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("Le client n'a pas été supprimé", e);
		}

	}
	public List<Client> search(ClientCriteria criteria) {
		return clientJpaRepository.search(criteria);
	}
}
