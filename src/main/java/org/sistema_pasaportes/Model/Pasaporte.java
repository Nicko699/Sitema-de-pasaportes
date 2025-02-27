package org.sistema_pasaportes.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Pasaporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroPasaporte;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaEmision;
    @Temporal(TemporalType.DATE)
    private LocalDate FechaExpiracion;
    private String pais_emision;
    @OneToOne
    private Persona persona;

    public Pasaporte() {
    }

    public Pasaporte(Long id, String numeroPasaporte, LocalDate fechaEmision, LocalDate fechaExpiracion, String pais_emision, Persona persona) {
        this.id = id;
        this.numeroPasaporte = numeroPasaporte;
        this.fechaEmision = fechaEmision;
        FechaExpiracion = fechaExpiracion;
        this.pais_emision = pais_emision;
        this.persona = persona;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
