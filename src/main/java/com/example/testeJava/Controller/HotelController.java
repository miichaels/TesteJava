package com.example.testeJava.Controller;

import com.example.testeJava.Model.HotelModel;
import com.example.testeJava.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    public HotelRepository repository;

    @PostMapping
    public ResponseEntity<HotelModel> postHotel (@RequestBody @Valid HotelModel hotelModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(hotelModel));
    }



   /* @GetMapping(value = "/cliente")
    private  String getClient(){
        String uri = "https://restcountries.eu/rest/v2/all";
        //String uri = "http://api.infotravel.com.br/api/v1";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }*/

}
