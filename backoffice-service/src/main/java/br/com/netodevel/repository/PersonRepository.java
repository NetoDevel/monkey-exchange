package br.com.netodevel.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.netodevel.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	
}