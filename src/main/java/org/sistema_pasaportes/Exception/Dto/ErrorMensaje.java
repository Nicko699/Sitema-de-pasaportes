package org.sistema_pasaportes.Exception.Dto;

import org.springframework.http.HttpStatus;

public class ErrorMensaje {

    private HttpStatus httpStatus;

    private String mensaje;

    public ErrorMensaje() {
    }

    public ErrorMensaje(HttpStatus httpStatus, String mensaje) {
        this.httpStatus = httpStatus;
        this.mensaje = mensaje;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
