package peaksoft.repository;

import peaksoft.model.Address;

import java.util.List;

/**
 * The golden boy
 */
public interface AddressRepository {
    String saveAddress(Address address,Long countryId);
    String saveAll(List<Address> addressList);
    List<Address>getAll();
    Address findById(Long id);
    void deleteById(Long id);
    void deleteAll();
    Address update(Long id,Address newAddress);





}
