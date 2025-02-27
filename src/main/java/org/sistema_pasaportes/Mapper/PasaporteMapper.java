package org.sistema_pasaportes.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.sistema_pasaportes.Dto.PasaporteRequestDto;
import org.sistema_pasaportes.Dto.PasaporteResponseDto;
import org.sistema_pasaportes.Model.Pasaporte;

@Mapper(componentModel = "spring")
public interface PasaporteMapper {


    @Mapping(source = "persona", target = "persona")
    Pasaporte PasaporteRequestDtoToPasaporteDefault(PasaporteRequestDto pasaporteRequestDto);

    PasaporteResponseDto pasaporteToPasaporteResponseDtoDefault(Pasaporte pasaporte);


}
