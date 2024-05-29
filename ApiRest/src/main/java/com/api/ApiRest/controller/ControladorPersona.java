package com.api.ApiRest.controller;
/***
 * Autor: Bruno Ernesto Zamorano Casino
 * Fecha: 28 mayo 2024
 * Descripcion del la clase:
 * Controlador Persona para consumir datos y creacion del CRUD
 *
 * En esta clase del paquete contorlador se maneja  el envio
 * y recibir peticiones HTTP relacionando con la base de de datos
 *
 * */

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.ApiRest.model.Persona;
import com.api.ApiRest.repository.PersonaRepository;
import com.api.ApiRest.exception.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/persona")
/*** En esta direccion es la principal para ver si estamos conectados  por el puerto
 * 8080
 * la direccion es la siguiente http://127.0.0.1:8080/api/v1/persona***/
@AllArgsConstructor


public class ControladorPersona {
    @Autowired

    private PersonaRepository personaRepository;

    @GetMapping("conexion")
    /***ruta para ver si funciona la conexion con spring
     * http://127.0.0.1:8080/api/v1/persona/conexion ***/
    public String index(){
        return "CONECTADO";
    }


    /***Se crea con el metódo GET el listado de los datos insertados en la desde
     * el progama JSON  que se este utilizando en este caso utilice POSTMAN
     * para ingresar los datos y utilizando la url
     * http://127.0.0.1:8080/api/v1/persona/listaDatos***/
    @GetMapping("listaDatos")
    public List<Persona> getListaDatos(){
        return personaRepository.findAll();
    }


   /*** Se hace la llamada del metódo POST
    * para agregar nuevos datos y se puedan visualizar utilizando el
    * metódo GET
    * la url es : http://127.0.0.1:8080/api/v1/persona/agregar***/

    @PostMapping("agregar")
    public String save(@RequestBody Persona persona)
    {
        personaRepository.save(persona);
        return "Dato Agregado";
    }

    /***Se utiliza el metodo PUT para actualizar todos los campos
     * que se encuentran consumiendo.
     * La URL es: http://127.0.0.1:8080/api/v1/persona/editar/1***/
    @PutMapping("editar/{id}")
    public String update(@PathVariable long id,@RequestBody Persona persona ){
    Persona updatePersona=personaRepository.findById(id).get();
    updatePersona.setEmailId(persona.getEmailId());
    updatePersona.setFirstName(persona.getFirstName());
    updatePersona.setCelPhone(persona.getCelPhone());
    personaRepository.save(updatePersona);
    return "Edicion con exito";
     }

    /*** se utiliza el metódo PATCH para actualizar parcialmente
     *  los campos que se encuentran consumiendo aal menos en uno de los
     *  datos que se quiera modificar.
     * La URL es: http://127.0.0.1:8080/api/v1/persona/edicion/1***/
     @PatchMapping("edicion/{id}")
     public Persona editarPersona(@PathVariable long id, @RequestBody Persona persona)
     {
         Optional<Persona> updatePersona=personaRepository.findById(id);
         if(updatePersona.isPresent())
         {
             Persona updatePersona1=updatePersona.get();
             updatePersona1.setEmailId(persona.getEmailId());
             updatePersona1.setFirstName(persona.getFirstName());
             updatePersona1.setCelPhone(persona.getCelPhone());
             return personaRepository.save(updatePersona1);
         }
         return  null;
     }


 /*** El metodo DELETE sirve para eliminar un registro creado a partir de su id
  *  La URL es: http://127.0.0.1:8080/api/v1/persona/eliminar/1 <- ejemplo
  *  ***/
    @DeleteMapping("eliminar/{id}")
    public String delete(@PathVariable long id){
        Persona deletePersona=personaRepository.findById(id).get();
        personaRepository.delete(deletePersona);
        return "Se elimino un registro";
    }




}
