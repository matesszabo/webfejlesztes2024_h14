package hu.unideb.inf.kaloriaszamlalo.service;

import hu.unideb.inf.kaloriaszamlalo.service.dto.EtelDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EtelManagmentService {

    EtelDto save(EtelDto dto);
    List<EtelDto> findAll();
    EtelDto findById(Long id);
    EtelDto update(EtelDto dto);
    void delete(Long id);

    List<EtelDto> findByTipus(String tipus);
    List<EtelDto> findByTipusRp(String tipus);
    List<EtelDto> findByAny(String nev,
                            Float suly,
                            Integer kaloria,
                            String tipus,
                            Integer zsir,
                            Integer szenhidrat,
                            Integer feherje);


}
