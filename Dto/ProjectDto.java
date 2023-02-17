package com.portfolio.amo.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Grafen Whor
 */

public class ProjectDto {
    
    @NotBlank
    private String nombreProj;
    @NotBlank
    private String descProj;
    @NotBlank
    private String imagenProj;
    
    //Constructors

    public ProjectDto() {
    }

    public ProjectDto(String nombreProj,String descProj, String imagenProj) {
        this.nombreProj = nombreProj;
        this.descProj = descProj;
        this.imagenProj = imagenProj;
    }
    
    //Getters & Setters

    public String getNombreProj() {
        return nombreProj;
    }

    public void setNombreProj(String nombreProj) {
        this.nombreProj = nombreProj;
    }

    public String getDescProj() {
        return descProj;
    }

    public void setDescProj(String descProj) {
        this.descProj = descProj;
    }
    
    public String getImagenProj() {
        return imagenProj;
    }

    public void setImagenProj(String imagenProj) {
        this.imagenProj = imagenProj;
    }
    
    
}
