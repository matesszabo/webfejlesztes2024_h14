package hu.unideb.inf.kaloriaszamlalo.controller;

import hu.unideb.inf.kaloriaszamlalo.service.AuthenticationService;
import hu.unideb.inf.kaloriaszamlalo.service.dto.BejelentkezesDto;
import hu.unideb.inf.kaloriaszamlalo.service.dto.RegisztracioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/regisztracio")
    public void regisztracio(@RequestBody RegisztracioDto dto){
        authenticationService.regisztracio(dto);
    }

    @PostMapping("/bejelentkezes")
    public void bejelentkezes(@RequestBody BejelentkezesDto dto){
        authenticationService.bejelentkezes(dto);
    }
}
