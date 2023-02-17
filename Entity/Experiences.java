package com.portfolio.amo.Entity;

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
public class Experiences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombreExp;
    @NotNull
    private String fechaInicio;
    @NotNull
    private String fechaFinal;
    @NotNull
    private String descExp;

    // Constructors

    public Experiences() {
    }

    public Experiences(String nombreExp, String fechaInicio, String fechaFinal, String descExp) {
        this.nombreExp = nombreExp;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.descExp = descExp;
    }

    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getDescExp() {
        return descExp;
    }

    public void setDescExp(String descExp) {
        this.descExp = descExp;
    }
}
