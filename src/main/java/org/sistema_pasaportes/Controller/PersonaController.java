package org.sistema_pasaportes.Controller;
import jakarta.validation.Valid;
import org.sistema_pasaportes.Dto.PersonaRequestDto;
import org.sistema_pasaportes.Dto.PersonaResponseDto;
import org.sistema_pasaportes.Exception.NotFoundException;
import org.sistema_pasaportes.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<Page<PersonaResponseDto>> listaPersona(Pageable pageable) {

        Page<PersonaResponseDto> listaPersonasDto = personaService.listaPersonas(pageable);

        return ResponseEntity.ok(listaPersonasDto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaResponseDto> obtenerPersona(@PathVariable Long id) throws NotFoundException {

        PersonaResponseDto personaObtenida = personaService.obtenerPersona(id);

        return ResponseEntity.ok(personaObtenida);

    }

    @PostMapping
    public ResponseEntity<PersonaResponseDto> crearPersona(@Valid @RequestBody PersonaRequestDto personaRequestDto) {

        PersonaResponseDto personaCreada = personaService.crearPersona(personaRequestDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(personaCreada.getId()).toUri();

        return ResponseEntity.created(location).body(personaCreada);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaResponseDto> editarPersona(@PathVariable Long id, @Valid @RequestBody PersonaRequestDto personaRequestDto) throws NotFoundException {

        personaService.editarPersona(id, personaRequestDto);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaResponseDto> eliminarPersona(@PathVariable Long id) throws NotFoundException {

        personaService.eliminarPersona(id);

        return ResponseEntity.noContent().build();
    }


}
