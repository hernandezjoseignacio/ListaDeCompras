/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author HERNANDEZ
 */
public interface IControladorVentanaAMNuevaCompra {

    public void campoNuevaCompraKeyPressed(KeyEvent evt);

    public void campoPrecioKeyPressed(KeyEvent evt);

    public void campoObservacionesKeyPressed(KeyEvent evt);

    public void botonVolverKeyPressed(KeyEvent evt);

    public void botonGuardarKeyPressed(ActionEvent evt);

    public void botonVolverClic(ActionEvent evt);
  
    
    
}
