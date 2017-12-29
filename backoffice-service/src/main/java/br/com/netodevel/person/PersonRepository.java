package br.com.netodevel.person;
import org.springframework.stereotype.Repository;

import br.com.netodevel.person.Person;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	
}