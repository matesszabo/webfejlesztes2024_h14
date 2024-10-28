package hu.unideb.inf.kaloriaszamlalo.controller;

import hu.unideb.inf.kaloriaszamlalo.data.entity.EtelEntity;
import hu.unideb.inf.kaloriaszamlalo.data.repository.EtelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //json-t küld, json-t fogad
@RequestMapping("/api")
public class EtelController {

    @Autowired
    EtelRepository repository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/hw")
    public ResponseEntity<String> helloworld(){
        return new ResponseEntity<>("Hello, world!", HttpStatus.I_AM_A_TEAPOT);
    }

    @PostMapping("/saveetel")
    public EtelEntity save(@RequestBody EtelEntity entity){
        return repository.save(entity);
    }

    @PutMapping("/updateetel")
    public EtelEntity update(@RequestBody EtelEntity entity){
        if(entity.getId() >= 0L){
            return repository.save(entity);
        }
        return null;
    }






}
