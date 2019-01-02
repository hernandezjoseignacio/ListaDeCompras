/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelo;

import java.util.Objects;

/**
 *
 * @author HERNANDEZ
 */
public class Compra {
    private String unaCompra;
    private String anotaciones;
    private float precio;
    
    //<editor-fold defaultstate="collapsed" desc="getter&setter">
    public String getUnaCompra() {
        return unaCompra;
    }

    public void setUnaCompra(String unaCompra) {
        this.unaCompra = unaCompra;
    }

    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Equals&Hascode">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.unaCompra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compra other = (Compra) obj;
        if (!Objects.equals(this.unaCompra, other.unaCompra)) {
            return false;
        }
        return true;
    }
//</editor-fold>
    
    public Compra(String compra, String anotaciones, float precio){
        this.unaCompra = compra;
        this.anotaciones = anotaciones;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "unaCompra{" + unaCompra + ", Anotaciones:" + anotaciones + ", Precio: $" + precio + '}';
    }

}
