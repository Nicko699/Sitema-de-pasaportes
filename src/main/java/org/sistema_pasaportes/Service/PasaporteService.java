package org.sistema_pasaportes.Service;

import org.sistema_pasaportes.Dto.PasaporteRequestDto;
import org.sistema_pasaportes.Dto.PasaporteResponseDto;
import org.sistema_pasaportes.Exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PasaporteService {

    public Page<PasaporteResponseDto> listaPasaportes(Pageable pageable);

   public  PasaporteResponseDto obtenerPasaporte(Long id) throws NotFoundException;

    public PasaporteResponseDto crearPasaporte(PasaporteRequestDto pasaporteRequestDto) throws  NotFoundException;
}