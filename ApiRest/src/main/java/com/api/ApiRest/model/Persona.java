package com.api.ApiRest.model;
/***Autor: Bruno Ernesto Zamorano Cansino
 * Fecha: 28 Mayo 2024
 * Descripcion del  archivo:
 * Creacion de clase persona para traer los argumentos necesarios
 * para una tabla en SQL para el consumo de datos de una API REST***/
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*** La libreria (lombok) sirve para spring boot que no escribamos los metodos
 * Getter y Setter  del los datos. ***/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "api_res")
/***Nombre de la tabla que se encuentra en el servidor local
 * de la base de datos de MySQL de la base de datos llamada personas.
 * Desde el archivo appplication.properties se crea la conexion de la BD en MySQL de forma local
 * y el pom.xml nos sir para agregar las dependencias para utilizar ciertas librerias
 * en el proyecto spring  boot en cuestion.
 ***/

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String emailId;

    @Column(name = "name")
    private String firstName;

    @Column(name = "phone")
    private String celPhone;
}
/*** Nombre de los campos que se utilizaran para actulizar con JSON son los
 * datos private  y los @Column sirve para el nombre de los campos de la
 * tabla en MySQL***/