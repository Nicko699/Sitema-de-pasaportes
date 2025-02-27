package org.sistema_pasaportes.Service;

import org.sistema_pasaportes.Dto.PersonaRequestDto;
import org.sistema_pasaportes.Dto.PersonaResponseDto;
import org.sistema_pasaportes.Exception.NotFoundException;
import org.sistema_pasaportes.Mapper.PersonaMapper;
import org.sistema_pasaportes.Model.Persona;
import org.sistema_pasaportes.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaMapper personaMapper;

    @Override
    public Page<PersonaResponseDto> listaPersonas(Pageable pageable) {

        Page<Persona> listaPersonas = personaRepository.findAll(pageable);

        List<PersonaResponseDto> listaPersonasDto = new ArrayList<>();

        for (Persona persona : listaPersonas) {

            PersonaResponseDto personaDto = personaMapper.personaToPersonaResponseDefaultDto(persona);

            listaPersonasDto.add(personaDto);
        }

        return new PageImpl<>(listaPersonasDto, pageable, listaPersonas.getTotalElements());

    }

    @Override
    public PersonaResponseDto obtenerPersona(Long id) throws NotFoundException {

        Optional<Persona> persona = personaRepository.findById(id);

        if (persona.isPresent()) {

            return personaMapper.personaToPersonaResponseDefaultDto(persona.get());
        } else {
            throw new NotFoundException("Id de la persona no encontrado:"+id);
        }

    }

    @Override
    public PersonaResponseDto crearPersona(PersonaRequestDto personaRequestDto) {

        Persona persona = personaMapper.personaRequestDtoToPersonaDefault(personaRequestDto);

        Persona personaGuardada = personaRepository.save(persona);

        return personaMapper.personaToPersonaResponseDefaultDto(personaGuardada);
    }

    @Override
    public PersonaResponseDto editarPersona(Long id, PersonaRequestDto personaRequestDto) throws NotFoundException {

        Optional<Persona> persona=personaRepository.findById(id);

        if ((persona.isPresent())){

            persona.get().setNombre(personaRequestDto.getNombre());
            persona.get().setApellido(personaRequestDto.getApellido());
            persona.get().setFechaNacimiento(personaRequestDto.getFechaNacimiento());
            persona.get().setNacionalidad(personaRequestDto.getNacionalidad());

            Persona personaEditada=personaRepository.save(persona.get());

            return personaMapper.personaToPersonaResponseDefaultDto(personaEditada);
        }
        else {
            throw new NotFoundException("Id de la persona no encontrado:"+id);
        }

    }

    @Override
    public void eliminarPersona(Long id) throws NotFoundException {

       Optional<Persona> persona=personaRepository.findById(id);

       if(persona.isPresent()){

           personaRepository.deleteById(id);
       }
       else{
           throw new  NotFoundException("Id de la persona no encontrado:"+id);
       }

    }
}
