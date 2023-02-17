package com.portfolio.amo.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Grafen Whor
 */
public class PersonDto {
    
    @NotBlank
    private String nombre;
     @NotBlank
    private String apellido;
    @NotBlank
    private String descPers;
    @NotBlank
    private String imagen;
     @NotBlank
    private String telefono;
    
    //Constructors

    public PersonDto() {
    }

    public PersonDto(String nombre, String apellido, String descPers, String imagen, 
            String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descPers = descPers;
        this.imagen = imagen;
        this.telefono = telefono;
    }
     
     //Getters & Setters

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

    public String getDescPers() {
        return descPers;
    }

    public void setDescPers(String descPers) {
        this.descPers = descPers;
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
