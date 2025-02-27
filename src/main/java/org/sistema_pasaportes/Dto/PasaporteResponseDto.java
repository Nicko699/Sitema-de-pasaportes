package org.sistema_pasaportes.Dto;

import java.time.LocalDate;

public class PasaporteResponseDto {

    private Long id;
    private String numeroPasaporte;
    private LocalDate fechaEmision;
    private LocalDate FechaExpiracion;
    private String pais_emision;

    public PasaporteResponseDto() {
    }

    public PasaporteResponseDto(Long id, String numeroPasaporte, LocalDate fechaEmision, LocalDate fechaExpiracion, String pais_emision) {
        this.id = id;
        this.numeroPasaporte = numeroPasaporte;
        this.fechaEmision = fechaEmision;
        FechaExpiracion = fechaExpiracion;
        this.pais_emision = pais_emision;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public void setNumeroPasaporte(String numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaExpiracion() {
        return FechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        FechaExpiracion = fechaExpiracion;
    }

    public String getPais_emision() {
        return pais_emision;
    }

    public void setPais_emision(String pais_emision) {
        this.pais_emision = pais_emision;
    }
}
