package hu.unideb.inf.kaloriaszamlalo.service.impl;

import hu.unideb.inf.kaloriaszamlalo.data.entity.Jogosultsag;
import hu.unideb.inf.kaloriaszamlalo.data.entity.SzemelyEntity;
import hu.unideb.inf.kaloriaszamlalo.data.repository.JogosultsagRepository;
import hu.unideb.inf.kaloriaszamlalo.data.repository.SzemelyRepository;
import hu.unideb.inf.kaloriaszamlalo.service.AuthenticationService;
import hu.unideb.inf.kaloriaszamlalo.service.dto.BejelentkezesDto;
import hu.unideb.inf.kaloriaszamlalo.service.dto.RegisztracioDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    SzemelyRepository repo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    JogosultsagRepository jogRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager manager;

    @Override
    public void regisztracio(RegisztracioDto dto) {
        SzemelyEntity szemely = modelMapper.map(dto, SzemelyEntity.class);
        szemely.setJelszo(passwordEncoder.encode(szemely.getJelszo()));
        Jogosultsag jog = jogRepo.findByName("FELHASZNALO");
        if (jog == null) {
            jog = new Jogosultsag();
            jog.setName("FELHASZNALO");
            jog = jogRepo.save(jog);

            szemely.setJogosultsag(jog);
        } else {
            szemely.setJogosultsag(jog);
        }

        repo.save(szemely);

    }

    @Override
    public void bejelentkezes(BejelentkezesDto dto) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail()
                        ,dto.getJelszo()
                )
        );

    }
}
