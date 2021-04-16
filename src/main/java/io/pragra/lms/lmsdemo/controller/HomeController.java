package io.pragra.lms.lmsdemo.controller;

import io.pragra.lms.lmsdemo.domain.GitHubUserDetails;
import io.pragra.lms.lmsdemo.entitiy.Course;
import io.pragra.lms.lmsdemo.feign.GitClient;
import io.pragra.lms.lmsdemo.service.CourseService;
import io.pragra.lms.lmsdemo.service.GitService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
@Data
@Slf4j
public class HomeController {

    private final CourseService service;
   // private final GitService gitService;
    private final GitClient gitClient;

    @GetMapping("/")
    public String home(Model model) {

        List<Course> courses = service.getAllCourse();
        model.addAttribute("cs", courses);
        GitHubUserDetails userDetails = gitClient.getGitUser("atinsingh");
        log.debug("Got following {} from github", userDetails);
        model.addAttribute("gituser", userDetails);
        return "index";
    }

    @GetMapping("/{login}")
    public String homeWithLogin(@PathVariable String login,  Model model) {

        List<Course> courses = service.getAllCourse();
        model.addAttribute("cs", courses);
        GitHubUserDetails userDetails = gitClient.getGitUser(login);
        log.debug("Got following {} from github", userDetails);
        model.addAttribute("gituser", userDetails);
        return "index";
    }
}
