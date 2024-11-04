package hu.unideb.inf.kaloriaszamlalo.service.impl;

import hu.unideb.inf.kaloriaszamlalo.service.SzemelyAlapManagementService;
import hu.unideb.inf.kaloriaszamlalo.service.dto.SzemelyAlapAdatDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SzemelyAlapAdatManagementServiceImpl implements SzemelyAlapManagementService {

    @Override
    public SzemelyAlapAdatDto getById(Long id) {
        return null;
    }

    @Override
    public List<SzemelyAlapAdatDto> getAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }
}
