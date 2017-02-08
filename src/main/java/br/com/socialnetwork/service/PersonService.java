package br.com.socialnetwork.service;

import br.com.socialnetwork.domain.Person;

public interface PersonService {
    
    Iterable <Person> listAllPerson();
    
    Person getPersonById(Long id);
    
    Person savePerson(Person person);
    
    void deletePerson(Long id);
}
