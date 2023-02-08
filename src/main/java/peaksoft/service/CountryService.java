package peaksoft.service;

import peaksoft.model.Country;

import java.util.List;

/**
 * The golden boy
 */
public interface CountryService {
    String save(Country country);
    void saveAll(List<Country> countries);
    List<Country >getAll();
    Country getId(Long id);
    void deleteId(Long id);
    void  deleteAll();
    Country update(Long id,Country newCountry);
    Country maxLength();
    int countCountry(String country);
}
