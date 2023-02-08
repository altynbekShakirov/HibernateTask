package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import peaksoft.config.HibernateConfiguration;
import peaksoft.model.Country;
import peaksoft.repository.CountryRepository;

import javax.security.auth.login.Configuration;
import java.sql.ResultSet;
import java.util.List;
import java.util.Random;

/**
 * The golden boy
 */
public class CountryRepositoryImpl implements CountryRepository {
    EntityManager entityManager= HibernateConfiguration.getEntityManager();
    @Override
    public String save(Country country) {
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved!";
    }

    @Override
    public void saveAll(List<Country> countries) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("select l from Country l");
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<Country> getAll() {
        entityManager.getTransaction().begin();
        List<Country> resultList = entityManager.createQuery("select l from Country l",Country.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    @Override
    public Country getId(Long id) {
        entityManager.getTransaction().begin();
       Country query = entityManager.createQuery("select l from Country l where l.id=?", Country.class).setParameter("?",id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return query;
    }

    @Override
    public void deleteId(Long id) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete  Country c where c.id=?").setParameter("?",id);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void deleteAll() {
        entityManager.getTransaction().begin();
        entityManager.clear();
        entityManager.getTransaction().commit();
        entityManager.close();


    }

    @Override
    public Country update(Long id, Country newCountry) {
        entityManager.getTransaction().begin();
        Country country = entityManager.createQuery("update  Country c  set  c.id= ?", Country.class).setParameter("?", id).getSingleResult();
        country.setCountry(newCountry.getCountry());
        country.setAddresses(newCountry.getAddresses());
        country.setDescription(newCountry.getDescription());
        entityManager.getTransaction().commit();
        entityManager.close();
        return newCountry;
    }

    @Override
    public Country maxLength() {
        entityManager.getTransaction().begin();
        Country singleResult = (Country) entityManager.createNativeQuery("select  * from  country order by c length(desciption) desc limit 1 ", Country.class);
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public int countCountry(String country) {
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("select count(*) from country where country=?").setParameter("?", country);
        entityManager.getTransaction().commit();
        entityManager.close();

        return new Random().nextInt(2,5);
    }
}
