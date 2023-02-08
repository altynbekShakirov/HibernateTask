package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfiguration;
import peaksoft.model.Address;
import peaksoft.model.Country;
import peaksoft.repository.AddressRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * The golden boy
 */
public class AddressRepositoryImpl implements AddressRepository {
    EntityManager entityManager= HibernateConfiguration.getEntityManager();

    @Override
    public String saveAddress(Address address, Long countryId) {
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        Country country = entityManager.find(Country.class, countryId);
        address.setCountry(country);
        entityManager.getTransaction().commit();
        entityManager.close();

        return "Successfully saved!";
    }

    @Override
    public String saveAll(List<Address> addressList) {
        entityManager.getTransaction().begin();
        entityManager.persist(addressList);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved!!";
    }

    @Override
    public List<Address> getAll() {
        entityManager.getTransaction().begin();
        List<Address> resultList = entityManager.createNativeQuery("select * from adddress",
                Address.class)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    @Override
    public Address findById(Long id) {
        entityManager.getTransaction().begin();
        Address singleResult = entityManager.createQuery("select  a from Address a  where id= ?", Address.class).setParameter("?", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete Address a where a.id=?",Address.class);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void deleteAll() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete Address ",Address.class);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public Address update(Long id, Address newAddress) {
        entityManager.getTransaction().begin();
        Address singleResult = entityManager.createQuery("update  Address  a set a.id=?", Address.class).setParameter("?", id).getSingleResult();
        singleResult.setCountry(newAddress.getCountry());
        singleResult.setStreet(newAddress.getStreet());
        singleResult.setPhoneNumber(newAddress.getPhoneNumber());
        singleResult.setRegionName(newAddress.getRegionName());
        singleResult.setProgrammer(newAddress.getProgrammer());
        entityManager.getTransaction().commit();
        entityManager.close();
        return newAddress;
    }
}
