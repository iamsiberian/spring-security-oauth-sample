package org.example.oauth2client.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class TestController {

    @Autowired
    private WebClient webClient;

    @GetMapping(value = "/me")
    public Object getArticles(
    ) {
        return null;
    }
}