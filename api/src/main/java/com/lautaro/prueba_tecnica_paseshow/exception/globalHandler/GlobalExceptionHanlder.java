package com.lautaro.prueba_tecnica_paseshow.exception.globalHandler;
import com.lautaro.prueba_tecnica_paseshow.exception.exceptions.DuplicatedDniException;
import com.lautaro.prueba_tecnica_paseshow.exception.exceptions.ExternalValidationError;
import com.lautaro.prueba_tecnica_paseshow.exception.exceptions.NoTicketsException;
import com.lautaro.prueba_tecnica_paseshow.exception.exceptions.ResourceNotFoundException;
import com.lautaro.prueba_tecnica_paseshow.exception.modelException.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHanlder {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiException> handlerNotFound(ResourceNotFoundException ex) {
        ApiException error = new ApiException(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicatedDniException.class)
    public ResponseEntity<ApiException> handlerDuplicatedDni(DuplicatedDniException ex) {
        ApiException error = new ApiException(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExternalValidationError.class)
    public ResponseEntity<ApiException> handlerExternalValidation(ExternalValidationError ex) {
        ApiException error = new ApiException(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NoTicketsException.class)
    public ResponseEntity<ApiException> handlerNoTicketsException(NoTicketsException ex) {
        ApiException error = new ApiException(HttpStatus.NO_CONTENT.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiException> handlerGeneralException() {
        ApiException error = new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error interno del servidor");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
