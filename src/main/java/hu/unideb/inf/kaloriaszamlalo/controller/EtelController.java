package hu.unideb.inf.kaloriaszamlalo.controller;

import hu.unideb.inf.kaloriaszamlalo.service.EtelManagmentService;
import hu.unideb.inf.kaloriaszamlalo.service.dto.EtelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //json-t küld, json-t fogad
@RequestMapping("/api")
public class EtelController {

    @Autowired
    EtelManagmentService service;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/hw")
    public ResponseEntity<String> helloworld(){
        return new ResponseEntity<>("Hello, world!", HttpStatus.I_AM_A_TEAPOT);
    }

    @PostMapping("/saveetel")
    public EtelDto save(@RequestBody EtelDto dto){
        return service.save(dto);
    }

    @PutMapping("/updateetel")
    public EtelDto update(@RequestBody EtelDto dto){
        if(dto.getId() >= 0L){
            return service.save(dto);
        }
        return null;
    }

    // /localhost:8080/api/etel?id=1
    @DeleteMapping("/etel")
    public void deleteById(@RequestParam long id){
        service.delete(id);
    }

    @GetMapping("/etel")
    public List<EtelDto> findAll(){
        return service.findAll();
    }


    // localhost:8080/api/etel/reggeli
    @GetMapping("/etel/{tipus}")
    public List<EtelDto> findByTipus(@PathVariable String tipus){
        return service.findByTipus(tipus);
    }

    // localhost:8080/api/eteltipus?tipus=reggeli
    @GetMapping("/eteltipus")
    public List<EtelDto> findByTipusRp(@RequestParam String tipus){
        return service.findByTipusRp(tipus);
    }

    @GetMapping("/filterEtel")
    public List<EtelDto> filterEtel(@RequestParam(required = false) String nev,
                                       @RequestParam(required = false) Float suly,
                                       @RequestParam(required = false) Integer kaloria,
                                       @RequestParam(required = false) String tipus,
                                       @RequestParam(required = false) Integer zsir,
                                       @RequestParam(required = false) Integer szenhidrat,
                                       @RequestParam(required = false) Integer feherje){

        return service.findByAny(nev,suly,kaloria,tipus,zsir,szenhidrat,feherje);
    }






}
