package org.sistema_pasaportes.Dto;

public class PersonaResponseDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String nacionalidad;
    private PasaporteResponseDto pasaporte;

    public PersonaResponseDto() {
    }

    public PersonaResponseDto(Long id, String nombre, String apellido, String fechaNacimiento, String nacionalidad, PasaporteResponseDto pasaporte) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.pasaporte = pasaporte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public PasaporteResponseDto getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(PasaporteResponseDto pasaporte) {
        this.pasaporte = pasaporte;
    }
}
