package wsb.lastdance.finalProject.Project;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public final class ProjectService {
    @Autowired
    private final ProjectRepository projectRepository;

    public List<Project> findall() {
        return projectRepository.findAll();
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }
}

