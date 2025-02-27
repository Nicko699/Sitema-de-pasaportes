package org.sistema_pasaportes.Service;

import org.apache.commons.lang3.RandomStringUtils;
import org.sistema_pasaportes.Dto.PasaporteRequestDto;
import org.sistema_pasaportes.Dto.PasaporteResponseDto;
import org.sistema_pasaportes.Exception.NotFoundException;
import org.sistema_pasaportes.Mapper.PasaporteMapper;
import org.sistema_pasaportes.Model.Pasaporte;
import org.sistema_pasaportes.Model.Persona;
import org.sistema_pasaportes.Repository.PasaporteRepository;
import org.sistema_pasaportes.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PasaporteServiceImpl implements PasaporteService {

    @Autowired
    private PasaporteRepository pasaporteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PasaporteMapper pasaporteMapper;


    @Override
    public Page<PasaporteResponseDto> listaPasaportes(Pageable pageable) {

        Page<Pasaporte> listaPasaportes = pasaporteRepository.findAll(pageable);

        List<PasaporteResponseDto> listaPasaportesDto = new ArrayList<>();

        for (Pasaporte pasaporte : listaPasaportes) {

            PasaporteResponseDto pasaporteDto = pasaporteMapper.pasaporteToPasaporteResponseDtoDefault(pasaporte);

            listaPasaportesDto.add(pasaporteDto);

        }
        return new PageImpl<>(listaPasaportesDto, pageable, listaPasaportes.getTotalElements());
    }

    @Override
    public PasaporteResponseDto obtenerPasaporte(Long id) throws NotFoundException {

        Optional<Pasaporte> pasaporte = pasaporteRepository.findById(id);

        if (pasaporte.isPresent()) {

            return pasaporteMapper.pasaporteToPasaporteResponseDtoDefault(pasaporte.get());
        } else {
            throw new NotFoundException("Id del pasaporte no encontrado:" + id);
        }
    }

    @Override
    public PasaporteResponseDto crearPasaporte(PasaporteRequestDto pasaporteRequestDto) throws NotFoundException {

        Pasaporte pasaporte = pasaporteMapper.PasaporteRequestDtoToPasaporteDefault(pasaporteRequestDto);

        String randomLetters = RandomStringUtils.randomAlphanumeric(9);

        pasaporte.setNumeroPasaporte(randomLetters);

        LocalDate fechaActual = LocalDate.now();

        pasaporte.setFechaEmision(fechaActual);

        pasaporte.setFechaExpiracion(fechaActual.plusYears(7));

        pasaporte.setPais_emision("Colombia");

        Optional<Persona> persona = personaRepository.findById(pasaporte.getPersona().getId());

        if (persona.isPresent()) {

            pasaporte.setPersona(persona.get());


            Pasaporte pasaporteGuardado=pasaporteRepository.save(pasaporte);

            persona.get().setPasaporte(pasaporteGuardado);

            personaRepository.save(persona.get());

            return pasaporteMapper.pasaporteToPasaporteResponseDtoDefault(pasaporteGuardado);

        } else {

            throw new NotFoundException("Id de la persona no encontrado:" + pasaporte.getPersona().getId());
        }

    }
}
