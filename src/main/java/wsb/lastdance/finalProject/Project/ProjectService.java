package wsb.lastdance.finalProject.Project;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> findAllProject();

    Project saveProject(ProjectDto project);

    ProjectDto findProjectById(Long projectId);

    void updateProject(ProjectDto project);

    void deleteProject(Long projectId);
}
