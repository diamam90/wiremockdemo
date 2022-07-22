package com.diamam.statsApp.controller;

import com.diamam.statsApp.entity.Statistics;
import com.diamam.statsApp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
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
    public String getUserList(HttpServletRequest req) throws URISyntaxException, NullPointerException {
        Statistics stat = new Statistics(LocalDateTime.now(), req.getMethod() + " " + req.getRequestURI(), req.getRemoteAddr());
        storeService.saveData(stat);
        RestTemplate template =  builder.uriTemplateHandler(new DefaultUriBuilderFactory("localhost:8000")).build();
        template.getForEntity(new URI("localhost:8000/users"), HttpEntity.class);
//        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/users"))
//                .willReturn(WireMock.jsonResponse(userList, 200)));
//        return "redirect:https://localhost:8081/users";
        return "redirect:https://www.yandex.ru";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Integer id) {
//        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/users/")).willReturn(WireMock.jsonResponse(userList.get(1),200)));

        return "redirect:localhost:8081/users/" + id;
    }
}
