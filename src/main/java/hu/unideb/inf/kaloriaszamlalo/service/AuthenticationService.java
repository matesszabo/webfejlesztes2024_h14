package hu.unideb.inf.kaloriaszamlalo.service;

import hu.unideb.inf.kaloriaszamlalo.service.dto.BejelentkezesDto;
import hu.unideb.inf.kaloriaszamlalo.service.dto.RegisztracioDto;

public interface AuthenticationService {

    String regisztracio(RegisztracioDto dto);

    String bejelentkezes(BejelentkezesDto dto);
}
