package org.sistema_pasaportes.Exception;

import org.jetbrains.annotations.NotNull;
import org.sistema_pasaportes.Exception.Dto.ErrorMensaje;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMensaje> notFoundExceptio(@NotNull NotFoundException exception) {

        ErrorMensaje errorMensaje = new ErrorMensaje(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMensaje);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException exception) {

        Map<String, String> errorMensaje = new HashMap<>();

        List<FieldError> listaErrores = exception.getBindingResult().getFieldErrors();

        for (FieldError error : listaErrores) {

            String nombre = error.getField();
            String mensaje = error.getDefaultMessage();

            errorMensaje.put(nombre, mensaje);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMensaje);

    }
}
