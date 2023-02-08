package peaksoft.repository;

import peaksoft.model.Project;

import java.util.List;

/**
 * The golden boy
 */
public interface ProjectRepository {
    String save(Project project);
    void saveAll(List<Project>projects);
    List<Project>getAll();
    Project findById(Long id);
    void deleteById(Long id);
    void  deleteAll();
    Project update(Long id ,Project newProject);
    String assignProgrammer(Long programmerId,Long projectId);
    Project maxPriceProject();
    Project minTimeProject();



}
