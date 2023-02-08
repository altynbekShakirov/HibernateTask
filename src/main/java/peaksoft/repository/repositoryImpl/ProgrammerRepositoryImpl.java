package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfiguration;
import peaksoft.model.Address;
import peaksoft.model.Country;
import peaksoft.model.Programmer;
import peaksoft.repository.ProgrammerRepository;

import java.util.List;

/**
 * The golden boy
 */
public class ProgrammerRepositoryImpl implements ProgrammerRepository {
    EntityManager entityManager= HibernateConfiguration.getEntityManager();
    @Override
    public String save(Programmer programmer, Long addressId) {
        entityManager.getTransaction().begin();
        entityManager.persist(programmer);
        Address address = entityManager.find(Address.class, addressId);
        programmer.setAddress(address);
        entityManager.getTransaction().commit();
        entityManager.close();

        return "Successfully saved!!" ;
    }

    @Override
    public String saveAll(List<Programmer> list) {
        entityManager.getTransaction().begin();
        entityManager.persist(list);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved!!";
    }

    @Override
    public Programmer findById(Long id) {
        entityManager.getTransaction().begin();
        Programmer singleResult = entityManager.createQuery("SELECT l from Programmer l where l.id=?", Programmer.class).setParameter("?",id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete Programmer a where a.id=?").setParameter("?",id);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void deleteAll() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete Programmer a");
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public Programmer update(Long id, Programmer newProgrammer) {
        entityManager.getTransaction().begin();
        Programmer singleResult = entityManager.createQuery("update Programmer  p set p.id=?", Programmer.class).setParameter("?", id).getSingleResult();
        singleResult.setAddress(newProgrammer.getAddress());
        singleResult.setEmail(newProgrammer.getEmail());
        singleResult.setLocation(newProgrammer.getLocation());
        singleResult.setProjects(newProgrammer.getProjects());
        singleResult.setDateOfBirth(newProgrammer.getDateOfBirth());
        singleResult.setFullName(newProgrammer.getFullName());
        singleResult.setStatus(newProgrammer.getStatus());
        entityManager.getTransaction().commit();
        entityManager.close();
        return newProgrammer;
    }

    @Override
    public List<Programmer> findAllByCountry(String countryName) {
        entityManager.getTransaction().begin();
        List<Programmer> resultList = entityManager.createNativeQuery("select * from programmer", Programmer.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    @Override
    public void minAgeProgrammer() {
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("select  * from  ");
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void maxAgeProgrammer() {

    }
}
