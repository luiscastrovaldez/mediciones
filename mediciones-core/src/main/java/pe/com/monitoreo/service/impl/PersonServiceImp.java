package pe.com.monitoreo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.monitoreo.dao.PersonDao;
import pe.com.monitoreo.entity.Person;
import pe.com.monitoreo.service.PersonService;

/**
 * 
 * @author lcastro
 *
 */
@Transactional
@Service("personService")
public class PersonServiceImp implements PersonService {

   @Autowired
   private PersonDao userDao;

   @Transactional   
   public void add(Person person) {
      userDao.add(person);
   }

   @Transactional(readOnly = true)
   public List<Person> listPersons() {
      return userDao.listPersons();
   }

}
