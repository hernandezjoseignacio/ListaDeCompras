/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfaces;

import gui.modelo.Compra;
import java.util.List;

/**
 *
 * @author HERNANDEZ
 */
public interface IGestorListaDeCompras {
    
    public String nuevaCompra(String compra, String unaAnotacion, float unPrecio);
    
    public Compra dameUnaCompra(String compra);
    
    public List<Compra> buscarUnaCompra(String compra);
    
    public String borrarUnaCompra(Compra unaCompra);
    
    public String modificarUnaCompra(Compra unaCompra, String compra, String unaAnotacion, float unPrecio);

    public int obtenerPosicion(Compra unaCompra);
    
}
