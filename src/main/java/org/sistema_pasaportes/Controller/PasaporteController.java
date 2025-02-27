package org.sistema_pasaportes.Controller;
import jakarta.validation.Valid;
import org.sistema_pasaportes.Dto.PasaporteRequestDto;
import org.sistema_pasaportes.Dto.PasaporteResponseDto;
import org.sistema_pasaportes.Exception.NotFoundException;
import org.sistema_pasaportes.Service.PasaporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/pasaporte")
public class PasaporteController {

    @Autowired
    private PasaporteService pasaporteService;

    @GetMapping
    public ResponseEntity<Page<PasaporteResponseDto>> listaPasaportes(Pageable pageable) {

        Page<PasaporteResponseDto> listaPasaportes = pasaporteService.listaPasaportes(pageable);

        return ResponseEntity.ok(listaPasaportes);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PasaporteResponseDto> obtenerPasaporte(@PathVariable Long id) throws NotFoundException {

        PasaporteResponseDto pasaporteObtenido = pasaporteService.obtenerPasaporte(id);

        return ResponseEntity.ok(pasaporteObtenido);
    }

    @PostMapping()
    public ResponseEntity<PasaporteResponseDto> crearPasaporte(@RequestBody @Valid PasaporteRequestDto pasaporteRequestDto) throws NotFoundException {

        PasaporteResponseDto pasaporteCreado = pasaporteService.crearPasaporte(pasaporteRequestDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(pasaporteCreado.getId()).toUri();

        return ResponseEntity.created(location).body(pasaporteCreado);

    }

}
