package pe.com.monitoreo.dao;

import java.util.List;

import pe.com.monitoreo.entity.Person;

/**
 * 
 * @author lcastro
 *
 */
public interface PersonDao {
   void add(Person person);
   List<Person> listPersons();
}
