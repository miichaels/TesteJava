package com.example.testeJava.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Teste {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }


    @GetMapping(value = "/cliente")
    private  String getClient(){
        //String uri = "https://restcountries.eu/rest/v2/all";
        String uri = "http://localhost:8080/hello";
        //String uri = "http://api.infotravel.com.br/api/v1";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }


}
