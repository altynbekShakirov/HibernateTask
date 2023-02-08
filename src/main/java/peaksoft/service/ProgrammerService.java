package peaksoft.service;

import peaksoft.model.Programmer;

import java.util.List;

/**
 * The golden boy
 */

public interface ProgrammerService {String save(Programmer programmer, Long addressId);
    String saveAll(List<Programmer> list);
    Programmer findById(Long id);
    void  deleteById(Long id);
    void  deleteAll();
    Programmer update(Long id , Programmer newProgrammer);
    List<Programmer>findAllByCountry(String countryName);
    void minAgeProgrammer();
    void  maxAgeProgrammer();




}
