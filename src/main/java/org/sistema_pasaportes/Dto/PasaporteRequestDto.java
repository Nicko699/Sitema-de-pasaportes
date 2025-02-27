package org.sistema_pasaportes.Dto;

public class PasaporteRequestDto {


    private PersonaResponseDto persona;

    public PasaporteRequestDto() {
    }

    public PasaporteRequestDto(PersonaResponseDto persona) {
        this.persona = persona;
    }

    public PersonaResponseDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaResponseDto persona) {
        this.persona = persona;
    }
}
