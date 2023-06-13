package wsb.lastdance.finalProject.Project;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
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
    public Project saveProject(Project project) {
        return projectRepository.save(project);

    }

    @Override
    public ProjectDto findProjectById(long projectId) {
        Project project = projectRepository.findById(projectId).get();
        return mapToProjectDto(project);
    }

    @Override
    public void updateProject(ProjectDto projectDto) {
        Project project = mapToProject(projectDto);
        projectRepository.save(project);
    }

    private Project mapToProject(ProjectDto project) {
        Project projectDto = Project.builder()
                .id(project.getId())
                .name(project.getName())
                .code(project.getCode())
                .description(project.getDescription())
                .enabled(project.getEnabled())
                .dateCreated(project.getDateCreated())
                .build();
        return projectDto;
    }
    /*@Override
    public void updateProject(ProjectDto projectDto) {
        Project project = mapTOProject(projectDto);
        projectRepository.save(project);
    }

    private Project mapTOProject(ProjectDto project) {
        Project projectDto = Project.builder()
                .id(project.getId())
                .name(project.getName())
                .code(project.getCode())
                .description(project.getDescription())
                .enabled(project.getEnabled())
                .dateCreated(project.getDateCreated())
                .build();
        return projectDto;
    }*/

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