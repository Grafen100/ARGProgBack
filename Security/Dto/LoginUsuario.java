package com.portfolio.amo.Security.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Grafen Whor
 */
public class LoginUsuario {
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;
    
    //Getters & Setters

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
