package com.portfolio.amo.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Grafen Whor
 */
public class EducationDto {
    
    @NotBlank
    private String nombreEduc; 
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFinal;
    @NotBlank
    private String descEduc;
    
    //Constructors

    public EducationDto() {
    }

    public EducationDto(String nombreEduc, String fechaInicio, String fechaFinal, String descEduc) {
        this.nombreEduc = nombreEduc;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.descEduc = descEduc;
    }
    
    //Getters & Setters

    public String getNombreEduc() {
        return nombreEduc;
    }

    public void setNombreEduc(String nombreEduc) {
        this.nombreEduc = nombreEduc;
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

    public String getDescEduc() {
        return descEduc;
    }

    public void setDescEduc(String descEduc) {
        this.descEduc = descEduc;
    }
}
