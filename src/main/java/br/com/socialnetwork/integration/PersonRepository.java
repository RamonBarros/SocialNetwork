package br.com.socialnetwork.integration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.socialnetwork.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

}
