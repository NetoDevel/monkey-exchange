package br.com.netodevel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.netodevel.model.Person;
import br.com.netodevel.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/v1/persons")
	public ResponseEntity<List<Person>> index() {
		return new ResponseEntity<List<Person>>(personService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/v1/persons/{id}")
	public ResponseEntity<Person> show(@PathVariable("id") Integer id) {
		return new ResponseEntity<Person>((Person) personService.findOne(id), HttpStatus.OK);
	}
	
	@PostMapping("/v1/persons")
	public ResponseEntity<Person> create(@RequestBody Person person) {
		return new ResponseEntity<Person>((Person) personService.save(person), HttpStatus.CREATED);
	}

	@PutMapping("/v1/persons")
	public ResponseEntity<Person> update(@RequestBody Person person) {
		return new ResponseEntity<Person>((Person) personService.save(person), HttpStatus.CREATED);
	}

	@DeleteMapping("/v1/persons/{id}")
	public void delete(@PathVariable("id") Integer id) {
		Person person = personService.findOne(id); 
		personService.delete(person);
	}
	
}