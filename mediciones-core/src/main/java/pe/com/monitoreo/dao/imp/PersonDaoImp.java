package pe.com.monitoreo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import pe.com.monitoreo.dao.PersonDao;
import pe.com.monitoreo.entity.Person;

/**
 * 
 * @author lcastro
 *
 */
@Repository
public class PersonDaoImp implements PersonDao {

   @PersistenceContext
   private EntityManager em;

   public void add(Person person) {
      em.persist(person);
   }

   public List<Person> listPersons() {
      CriteriaQuery<Person> criteriaQuery = em.getCriteriaBuilder().createQuery(Person.class);
      @SuppressWarnings("unused")
      Root<Person> root = criteriaQuery.from(Person.class);
      return em.createQuery(criteriaQuery).getResultList();
   }

}

