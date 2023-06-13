package wsb.lastdance.finalProject.Project;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private ProjectService projectService;
@Autowired
    public ProjectController(ProjectService projectService) {

    this.projectService = projectService;
    }
    @GetMapping("/projects")
    public String listProject (Model model){
    List<ProjectDto> projects = projectService.findAllProject();
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
    @GetMapping("/projects/{projectId}/edit")
    public String editProject (@PathVariable("projectId")long projectId, Model model){
        ProjectDto project = projectService.findProjectById(projectId);
        model.addAttribute("project", project);
        return "project-edit";
    }

    @PostMapping("/projects/{projectId}/edit")
    public String editProject (@PathVariable("projectId")Long projectId,
                               @ModelAttribute("project")ProjectDto project){
    project.setId(projectId);
    projectService.updateProject(project);
    return "redirect:/projects";
    }


}

