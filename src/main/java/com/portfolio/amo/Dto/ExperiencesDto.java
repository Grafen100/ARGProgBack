package com.portfolio.amo.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Grafen Whor
 */
public class ExperiencesDto {

    @NotBlank
    private String nombreExp;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFinal;
    @NotBlank
    private String descExp;

    //Constructors
    public ExperiencesDto() {
    }

    public ExperiencesDto(String nombreExp, String fechaInicio, String fechaFinal, String descExp) {
        this.nombreExp = nombreExp;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.descExp = descExp;
    }

    // Getters & Setters
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
