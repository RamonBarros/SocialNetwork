package br.com.socialnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.socialnetwork.domain.Person;
import br.com.socialnetwork.service.PersonService;
import br.com.socialnetwork.transaction.PersonTransaction;

@RestController
public class PersonController {
    
    @Autowired
    private PersonService personService;
        
    @RequestMapping(value = "person", method = RequestMethod.POST,  consumes = "application/json")
    public String savePerson(@RequestBody  Person person) {
        
        PersonTransaction personTransaction = new PersonTransaction();
        
        personTransaction.transactionIn(person);
        
        personService.savePerson(person);
        return "redirect:/employee/" + person.getIdPerson();
    }
    
    @RequestMapping(value = "person/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Person> showPerson(@PathVariable Long id) {
        
        Person person = new Person();
        PersonTransaction personTransaction = new PersonTransaction();
        person = personService.getPersonById(id);
        
        personTransaction.transactionOut(person);
        
        //extends HttpEntity and adds additional information of HTTP method and uri to the request.
        return new ResponseEntity<Person>(person, HttpStatus.FOUND);
    }
}
