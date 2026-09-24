package org.pluto.clientmachine.controller;

import org.pluto.clientmachine.controller.model.LoginRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ------------------------------------------------------------------------
 * Author   : Sanjay Krishna Narayanan
 * Created  : 9/24/26
 * Version  : 1.0
 * ------------------------------------------------------------------------
 */

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Value("${security-manager.v1.login}")
    private String loginUrl;

    public ClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final RestTemplate restTemplate;

    @GetMapping("/login")
    public String login(LoginRequest loginRequest) {
        LoginRequest login = new LoginRequest("admin", "password123");
        return restTemplate.postForObject(loginUrl, login, String.class);
    }

}
