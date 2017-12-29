package br.com.netodevel.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person findOne(Integer id) {
		return personRepository.findOne(id);
	}

	@Transactional(readOnly = false)
	public Person save(Person entity) {
		return personRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Person entity) {
		personRepository.delete(entity);
	}

}
