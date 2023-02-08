package peaksoft.repository.repositoryImpl;

import peaksoft.model.Project;
import peaksoft.repository.ProjectRepository;

import java.util.List;

/**
 * The golden boy
 */
public class ProjectRepositoryImpl implements ProjectRepository {
    @Override
    public String save(Project project) {
        return null;
    }

    @Override
    public void saveAll(List<Project> projects) {

    }

    @Override
    public List<Project> getAll() {
        return null;
    }

    @Override
    public Project findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Project update(Long id, Project newProject) {
        return null;
    }

    @Override
    public String assignProgrammer(Long programmerId, Long projectId) {
        return null;
    }

    @Override
    public Project maxPriceProject() {
        return null;
    }

    @Override
    public Project minTimeProject() {
        return null;
    }
}
