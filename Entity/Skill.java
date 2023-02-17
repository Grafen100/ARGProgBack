package com.portfolio.amo.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Grafen Whor
 */

@Entity
public class Skill implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private Integer porcentaje;
    @NotNull
    private String imagen;
    @NotNull
    private String color;

    //Constructors
    public Skill() {
    }

    public Skill(Integer porcentaje, String imagen, String color) {
       
        this.porcentaje = porcentaje;
        this.imagen = imagen;
        this.color = color;
    }

    
    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
