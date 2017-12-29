package br.com.netodevel.web;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.netodevel.person.Person;
import br.com.netodevel.person.PersonService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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
	public @ResponseBody String create(@RequestBody Person person) {
		Person personInserted = personService.save(person);
		String token = Jwts.builder().setSubject(String.valueOf(personInserted.getId())).signWith(SignatureAlgorithm.HS512, "chave").compact();
		String url = "http://localhost:8080/api/token/register?url_token=" + token;
		return url;
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