package io.pragra.lms.lmsdemo.feign;

import io.pragra.lms.lmsdemo.domain.GitHubUserDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "git" , url = "https://api.github.com")
public interface GitClient {
    @GetMapping("/users/{login}")
    GitHubUserDetails getGitUser(@PathVariable("login") String login);

    @PostMapping("/user")
    GitHubUserDetails createUser(@RequestBody GitHubUserDetails userDetails);

}
