/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelo;

/**
 *
 * @author HERNANDEZ
 */
public class ListaDeCompras {
    private String compra;
    private String anotaciones;
    private float precio;
    
    //<editor-fold defaultstate="collapsed" desc="getter&setter">
    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
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
    
    public ListaDeCompras(String compra, String anotaciones, float precio){
        this.compra = compra;
        this.anotaciones = anotaciones;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ListaDeCompras{" + "compra:" + compra + ", anotaciones:" + anotaciones + ", precio: $" + precio + '}';
    }

    
       
    
}
