package wsb.lastdance.finalProject.Project;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> findAllProject();

    Project saveProject(Project project);


    ProjectDto findProjectById(long projectId);

    void updateProject(ProjectDto project);
}
