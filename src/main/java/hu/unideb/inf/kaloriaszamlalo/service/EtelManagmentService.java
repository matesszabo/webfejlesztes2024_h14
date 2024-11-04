package hu.unideb.inf.kaloriaszamlalo.service;

import hu.unideb.inf.kaloriaszamlalo.service.dto.EtelDto;

import java.util.List;

public interface EtelManagmentService {

    EtelDto save(EtelDto dto);
    List<EtelDto> findAll();
    EtelDto findById(Long id);
    EtelDto update(EtelDto dto);
    void delete(Long id);
}
