package com.example.testeJava.Controller;

import com.example.testeJava.Model.HotelModel;
import com.example.testeJava.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class Teste {

    @Autowired
    public HotelRepository repository;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }


    @GetMapping(value = "/cliente")
    private  String getClient(){
        String uri = "http://localhost:8080/hello";
        //String uri = "http://api.infotravel.com.br/api/v1";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @PostMapping
    public ResponseEntity<HotelModel> postTeste (@RequestBody @Valid HotelModel hotelModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(hotelModel));
    }

    @PutMapping
    public ResponseEntity<HotelModel> put (@RequestBody @Valid HotelModel hotelModel){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(hotelModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> del (@PathVariable Long id){
        return repository.findById(id).map(resposta -> {repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();})
                .orElse(ResponseEntity.noContent().build());
    }

}
