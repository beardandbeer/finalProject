package wsb.lastdance.finalProject.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProjectController {

    final private ProjectService projectService;
@Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @GetMapping("/projects")
    public String listProject (Model model){
    List<Project> projects = projectService.findall();
    model.addAttribute("projects", projects );
    return "project-list";
    }
    @GetMapping("/projects/new")
    public String createProject (Model model){
        Project project = new Project();
        model.addAttribute("project", project);
        return "project-create";
    }
    @PostMapping("/projects/new")
    public String saveProject(@ModelAttribute("project")Project project){
    projectService.saveProject(project);
    return "redirect:/projects";
    }
}

