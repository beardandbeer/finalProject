package wsb.lastdance.finalProject.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service

public class ProjectServiceImpl implements  ProjectService {
    private ProjectRepository projectRepository;
    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDto> findAllProject() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(project -> mapToProjectDto(project)).collect(Collectors.toList());
    }

    @Override
    public Project saveProject(ProjectDto projectDto) {
        Project project = mapToProject(projectDto);
        return projectRepository.save(project);
    }

    @Override
    public ProjectDto findProjectById(Long projectId) {
        Project project = projectRepository.findById(projectId).get();
        return mapToProjectDto(project);
    }

    @Override
    public void updateProject(ProjectDto projectDto) {
        Project project = mapToProject(projectDto);
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);

    }

    private Project mapToProject(ProjectDto project) {
        Project projectDto = Project.builder()
                .id(project.getId())
                .id(project.getId())
                .name(project.getName())
                .code(project.getCode())
                .description(project.getDescription())
                .enabled(project.getEnabled())
                .dateCreated(project.getDateCreated())
                .build();
        return projectDto;
    }

    private ProjectDto mapToProjectDto(Project project){
        ProjectDto projectDto = ProjectDto.builder()
                .id(project.getId())
                .name(project.getName())
                .code(project.getCode())
                .description(project.getDescription())
                .enabled(project.getEnabled())
                .dateCreated(project.getDateCreated())
                .build();
        return projectDto;
    }
}
