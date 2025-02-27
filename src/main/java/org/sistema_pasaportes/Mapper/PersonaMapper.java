package org.sistema_pasaportes.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema_pasaportes.Dto.PersonaRequestDto;
import org.sistema_pasaportes.Dto.PersonaResponseDto;
import org.sistema_pasaportes.Model.Persona;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    Persona personaRequestDtoToPersonaDefault(PersonaRequestDto personaRequestDto);

    @Mapping(source = "pasaporte", target = "pasaporte")
    PersonaResponseDto personaToPersonaResponseDefaultDto(Persona persona);


}
