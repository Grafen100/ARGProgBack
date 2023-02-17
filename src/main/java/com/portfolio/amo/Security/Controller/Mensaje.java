package com.portfolio.amo.Security.Controller;

/**
 *
 * @author Grafen Whor
 */
public class Mensaje {
    private String mensaje;
    
    //Constructor

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    //Getter & Setter

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
