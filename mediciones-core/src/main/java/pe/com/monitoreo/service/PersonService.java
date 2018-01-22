package pe.com.monitoreo.service;

import java.util.List;

import pe.com.monitoreo.entity.Person;

/**
 * 
 * @author lcastro
 *
 */
public interface PersonService {
    void add(Person person);
    List<Person> listPersons();
}
