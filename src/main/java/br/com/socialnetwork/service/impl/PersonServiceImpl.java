package br.com.socialnetwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.socialnetwork.domain.Person;
import br.com.socialnetwork.integration.PersonRepository;
import br.com.socialnetwork.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
    
    @Autowired
    private PersonRepository personRepository;
    
    @Override
    public Iterable<Person> listAllPerson() {
        
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        
        return personRepository.findOne(id);
    }

    @Override
    public Person savePerson(Person person) {
        
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        
        personRepository.delete(id);
    }
}
