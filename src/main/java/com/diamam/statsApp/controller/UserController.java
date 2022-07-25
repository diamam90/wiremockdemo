package com.diamam.statsApp.controller;

import com.diamam.statsApp.entity.Statistics;
import com.diamam.statsApp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<String> userList = new ArrayList<>();
    private final StoreService storeService;
    private final RestTemplateBuilder builder;

    @Autowired
    public UserController(RestTemplateBuilder builder,StoreService storeService) {
        userList.add("Ivanov ivan");
        userList.add("Sergeev Sergey");
        userList.add("Alexandr Alexandrov");
        this.storeService = storeService;
        this.builder = builder;
    }

    @GetMapping
    public String getUserList(HttpServletRequest req)  {
        Statistics stat = new Statistics(LocalDateTime.now(), req.getMethod() + " " + req.getRequestURI(), req.getRemoteAddr());
        storeService.saveData(stat);
        RestTemplate template =  builder.uriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:8000/users")).build();
        ResponseEntity<String> forEntity = template.getForEntity("http://localhost:8000/users", String.class);
        return forEntity.getBody();
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Integer id,HttpServletRequest req)  {
        Statistics stat = new Statistics(LocalDateTime.now(), req.getMethod() + " " + req.getRequestURI(), req.getRemoteAddr());
        storeService.saveData(stat);
        RestTemplate template =  builder.uriTemplateHandler(new DefaultUriBuilderFactory("localhost:8000")).build();
        ResponseEntity<String> forEntity = template.getForEntity("http://localhost:8000/users/"+id, String.class);
        return forEntity.getBody();
    }
}
