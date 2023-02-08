package peaksoft.service.serviceImpl;

import peaksoft.model.Programmer;
import peaksoft.service.ProgrammerService;

import java.util.List;

/**
 * The golden boy
 */
public class ProgrammerServiceImpl implements ProgrammerService {
    @Override
    public String save(Programmer programmer, Long addressId) {
        return null;
    }

    @Override
    public String saveAll(List<Programmer> list) {
        return null;
    }

    @Override
    public Programmer findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Programmer update(Long id, Programmer newProgrammer) {
        return null;
    }

    @Override
    public List<Programmer> findAllByCountry(String countryName) {
        return null;
    }

    @Override
    public void minAgeProgrammer() {

    }

    @Override
    public void maxAgeProgrammer() {

    }
}
