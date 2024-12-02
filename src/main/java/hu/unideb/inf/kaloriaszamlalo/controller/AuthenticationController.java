package hu.unideb.inf.kaloriaszamlalo.controller;

import hu.unideb.inf.kaloriaszamlalo.service.AuthenticationService;
import hu.unideb.inf.kaloriaszamlalo.service.dto.BejelentkezesDto;
import hu.unideb.inf.kaloriaszamlalo.service.dto.RegisztracioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/regisztracio")
    public String regisztracio(@RequestBody RegisztracioDto dto){
        return authenticationService.regisztracio(dto);
    }

    @PostMapping("/bejelentkezes")
    public String bejelentkezes(@RequestBody BejelentkezesDto dto){
        return authenticationService.bejelentkezes(dto);
    }

    @GetMapping("/vt")
    public String vt(){
        return Thread.currentThread().toString();
    }
}
