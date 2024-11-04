package hu.unideb.inf.kaloriaszamlalo.service.impl;

import hu.unideb.inf.kaloriaszamlalo.data.entity.EtelEntity;
import hu.unideb.inf.kaloriaszamlalo.data.repository.EtelRepository;
import hu.unideb.inf.kaloriaszamlalo.service.EtelManagmentService;
import hu.unideb.inf.kaloriaszamlalo.service.dto.EtelDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtelManagementServiceImpl implements EtelManagmentService {

    @Autowired
    EtelRepository repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public EtelDto save(EtelDto dto) {
        /*return mapper.map(repo.save(mapper.map(dto, EtelEntity.class)),
                EtelDto.class);*/

        EtelEntity entity = mapper.map(dto, EtelEntity.class);
        entity = repo.save(entity);

        EtelDto rdto = mapper.map(entity, EtelDto.class);

        return rdto;
    }

    @Override
    public List<EtelDto> findAll() {
        List<EtelEntity> entities = repo.findAll();
        return mapper.map(entities, new TypeToken<List<EtelDto>>(){}.getType());
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
