package com.portfolio.amo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(min=1, max=255, message = "no cumple con la longitud" )
    private String nombre;
    @NotNull
    @Size(min=1, max=255, message = "no cumple con la longitud" )
    private String apellido;
    @NotNull
    private String imagen;
    @NotNull
    private String telefono;
    
    //Constructors

    public Person() {
    }

    public Person(String nombre, String apellido, String imagen,String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
        this.telefono = telefono;
    }
    
    //Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    

}
