package org.sistema_pasaportes.Service;

import org.sistema_pasaportes.Dto.PersonaRequestDto;
import org.sistema_pasaportes.Dto.PersonaResponseDto;
import org.sistema_pasaportes.Exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonaService {

    public Page<PersonaResponseDto> listaPersonas(Pageable pageable);

    public PersonaResponseDto obtenerPersona(Long id)throws NotFoundException;

    public PersonaResponseDto crearPersona(PersonaRequestDto personaRequestDto);

    public PersonaResponseDto editarPersona(Long id,PersonaRequestDto personaRequestDto) throws  NotFoundException;

    public void eliminarPersona(Long id)throws NotFoundException;
}