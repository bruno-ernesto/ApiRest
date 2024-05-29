package com.api.ApiRest.repository;
import com.api.ApiRest.model.Persona ;
import org.springframework.data.jpa.repository.JpaRepository;

/*** Autor: Bruno Ernesto Zamorano Cansino
 *  Descripcion: Creación de un Interface para los atributos de una clase persona
 *  Fecha: 28 mayo 2024
 ***/
public interface PersonaRepository extends JpaRepository<Persona,Long>
{

    //Capa de repositorio
    /*** Capa del repositorio spring***/
}