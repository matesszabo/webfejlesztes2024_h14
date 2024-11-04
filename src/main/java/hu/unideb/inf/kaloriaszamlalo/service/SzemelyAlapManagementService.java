package hu.unideb.inf.kaloriaszamlalo.service;

import hu.unideb.inf.kaloriaszamlalo.service.dto.SzemelyAlapAdatDto;

import java.util.List;

public interface SzemelyAlapManagementService {

    SzemelyAlapAdatDto getById(Long id);
    List<SzemelyAlapAdatDto> getAll();
    void deleteById(Long id);

}
