package hu.unideb.inf.kaloriaszamlalo.service.impl;

import hu.unideb.inf.kaloriaszamlalo.data.entity.EtelEntity;
import hu.unideb.inf.kaloriaszamlalo.data.repository.EtelRepository;
import hu.unideb.inf.kaloriaszamlalo.service.EtelManagmentService;
import hu.unideb.inf.kaloriaszamlalo.service.dto.EtelDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        repo.deleteById(id);

    }

    @Override
    public List<EtelDto> findByTipus(String tipus) {
        List<EtelEntity> szurt = new ArrayList<>();
        szurt = repo.findAll()
                .stream()
                .filter(x -> x.getTipus().equals(tipus))
                .toList();

        return mapper.map(szurt, new TypeToken<List<EtelDto>>(){}.getType());
    }

    @Override
    public List<EtelDto> findByTipusRp(String tipus) {
        return mapper.map(repo.findAllByTipus(tipus), new TypeToken<List<EtelDto>>(){}.getType());

    }

    @Override
    public List<EtelDto> findByAny(String nev, Float suly, Integer kaloria, String tipus, Integer zsir, Integer szenhidrat, Integer feherje) {
        List<EtelEntity> szurt = repo.findAll();
        szurt = szurt.stream()
                .filter(x -> nev == null || x.getNev().equals(nev))
                .filter(x -> suly == null || x.getSuly().equals(suly))
                .filter(x -> kaloria == null || x.getKaloria() < kaloria)
                .filter(x -> tipus == null || x.getTipus().equals(tipus))
                .filter(x -> zsir == null || x.getZsir() < zsir)
                .filter(x -> szenhidrat == null || x.getSzenhidrat() < szenhidrat)
                .filter(x -> feherje == null || x.getFeherje() < feherje)
                .toList();

        return mapper.map(szurt, new TypeToken<List<EtelDto>>(){}.getType());
    }
}
