/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author HERNANDEZ
 */
public interface IControladorVentanaListaDeCompras {

    public void campoBusquedaFocusGained(FocusEvent evt);

    public void tablaListaDeComprasFocusGained(FocusEvent evt);

    public void campoBusquedaKeyPressed(KeyEvent evt);

    public void botonSalirKeyPressed(KeyEvent evt);

    public void botonSalir(ActionEvent evt);

    public void botonBorrar(ActionEvent evt);

    public void botonNueva(ActionEvent evt);

    public void campoBusqueda(ActionEvent evt);

    public void botonEditar(ActionEvent evt);
    
}
