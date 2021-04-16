package io.pragra.lms.lmsdemo.service;

import io.pragra.lms.lmsdemo.domain.GitHubUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class GitService {

    @Value("${git.api.user}")
    private String userEndPoint;
    private final RestTemplate restTemplate;

    public GitService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GitHubUserDetails getGitUser(String loginName) {
        ResponseEntity<GitHubUserDetails> responseEntity = this.restTemplate.exchange(userEndPoint, HttpMethod.GET, null, GitHubUserDetails.class, loginName);
        return responseEntity.getBody();
        //return this.restTemplate.getForObject(userEndPoint,GitHubUserDetails.class, loginName);
    }
}
