package com.api.ApiRest.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/***
 * Auto: Bruno Ernesto Zamorano Cansino
 * Fecha:  28 mayo 2024
 * Descripción: creacion de la clase ResourceNotFoundException
 * para el tiempo de ejecución del la llamada a la peticiones de
 * l a API REST.***/
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}