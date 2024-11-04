package hu.unideb.inf.kaloriaszamlalo.service.impl;

import hu.unideb.inf.kaloriaszamlalo.data.entity.EtelEntity;
import hu.unideb.inf.kaloriaszamlalo.data.repository.EtelRepository;
import hu.unideb.inf.kaloriaszamlalo.service.EtelManagmentService;
import hu.unideb.inf.kaloriaszamlalo.service.dto.EtelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtelManagementServiceImpl implements EtelManagmentService {

    @Autowired
    EtelRepository repo;

    @Override
    public EtelDto save(EtelDto dto) {
        return null;
    }

    @Override
    public List<EtelDto> findAll() {
        return List.of();
    }

    @Override
    public EtelDto findById(Long id) {
        EtelDto dto = new EtelDto();
        EtelEntity entity = repo.getReferenceById(id);

        dto.setId(entity.getId());
        dto.setNev(entity.getNev());
        dto.setFeherje(entity.getFeherje());
        dto.setKaloria(entity.getKaloria());
        dto.setSuly(entity.getSuly());
        dto.setZsir(entity.getZsir());
        dto.setTipus(entity.getTipus());
        dto.setSzenhidrat(entity.getSzenhidrat());

        return dto;
    }

    @Override
    public EtelDto update(EtelDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
