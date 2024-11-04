package hu.unideb.inf.kaloriaszamlalo.service.mapper;

import hu.unideb.inf.kaloriaszamlalo.data.entity.SzemelyEntity;
import hu.unideb.inf.kaloriaszamlalo.service.dto.SzemelyAlapAdatDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SzemelyAlapAdatMapper {

    @Mapping(source = "id", target = "id")
    SzemelyAlapAdatDto szemelyEntityToAlapDto(SzemelyEntity entity);
    List<SzemelyAlapAdatDto> szemelyEntityListToAlapDtoList(List<SzemelyEntity> entities);

    SzemelyEntity szemelyAlapDtoToEntity(SzemelyAlapAdatDto dto);
    List<SzemelyEntity> szemelyAlapListToEntityList(List<SzemelyAlapAdatDto> dtos);
}
