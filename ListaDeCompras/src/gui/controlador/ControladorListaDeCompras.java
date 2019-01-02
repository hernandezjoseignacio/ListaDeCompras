/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controlador;

import gui.interfaces.IControladorAMCompra;
import gui.modelo.Compra;
import gui.modelo.GestorListaDeCompras;
import gui.vistas.VentanaListaDeCompras;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import gui.interfaces.IControladorListaDeCompras;
import java.awt.event.WindowEvent;

/**
 *
 * @author HERNANDEZ
 */
public class ControladorListaDeCompras implements IControladorListaDeCompras{
    GestorListaDeCompras gc = GestorListaDeCompras.instanciar();
    private final VentanaListaDeCompras ventanaListaDeCompras;
    private Compra unaCompra;
    
    public ControladorListaDeCompras(Compra unaCompra) {
        this.ventanaListaDeCompras = new VentanaListaDeCompras(this);
        this.unaCompra = unaCompra;
        this.ventanaListaDeCompras.setLocationRelativeTo(null);
        this.ventanaListaDeCompras.setVisible(true);
    }

    @Override
    public void botonNueva(ActionEvent evt) {
        IControladorAMCompra controlador = new ControladorAMCompra(this.ventanaListaDeCompras,null);
    }

    @Override
    public void botonBorrar(ActionEvent evt) {
        if (this.ventanaListaDeCompras.getTablaListaDeCompras().getSelectedRow() >= 0) {
            int valor = JOptionPane.showConfirmDialog(this.ventanaListaDeCompras, "Seguro que desea borrar la Anotación :\n " + this.gc.dameUnaCompra((String) this.ventanaListaDeCompras.getTablaListaDeCompras().getValueAt(this.ventanaListaDeCompras.getTablaListaDeCompras().getSelectedRow(), 0)).getUnaCompra() + "?", "Borrar Anotación", JOptionPane.YES_NO_OPTION);
            if (valor == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this.ventanaListaDeCompras, this.gc.borrarUnaCompra(this.gc.dameUnaCompra((String) this.ventanaListaDeCompras.getTablaListaDeCompras().getValueAt(this.ventanaListaDeCompras.getTablaListaDeCompras().getSelectedRow(), 0))));
                this.gc.escribirArchivo();
                this.ventanaListaDeCompras.cargarTabla();
            }
        }else{
            JOptionPane.showMessageDialog(this.ventanaListaDeCompras, "No se ha seleecionado nada");
        }
    }
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Salir
     * @param evt evento
     */                            
    @Override
    public void botonSalir(ActionEvent evt) {
        int opcion = JOptionPane.showOptionDialog(this.ventanaListaDeCompras, "¿Seguro que desea salir de la Lista de Compras?", "Lista de Compras", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, this);
        if (opcion == JOptionPane.YES_OPTION) {
            this.ventanaListaDeCompras.dispose();
            System.exit(0);
        }       
    }
    
    @Override
    public void botonEditar(ActionEvent evt) {
        if(this.ventanaListaDeCompras.getTablaListaDeCompras().getSelectedRow()>-1){
            IControladorAMCompra controlador = new ControladorAMCompra(this.ventanaListaDeCompras, gc.dameUnaCompra((String)this.ventanaListaDeCompras.getTablaListaDeCompras().getValueAt(this.ventanaListaDeCompras.getTablaListaDeCompras().getSelectedRow(),0)));
        }else{
            JOptionPane.showMessageDialog(this.ventanaListaDeCompras, "Debe seleccionar una Anotacion para editar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void campoBusquedaFocusGained(FocusEvent evt) {
        this.ventanaListaDeCompras.getCampoBusqueda().setText(null);
        this.ventanaListaDeCompras.getBotonEditar().setEnabled(false);
        this.ventanaListaDeCompras.getBotonBorrar().setEnabled(false);
    }

    @Override
    public void tablaListaDeComprasFocusGained(FocusEvent evt) {
        this.ventanaListaDeCompras.getBotonEditar().setEnabled(true);
        this.ventanaListaDeCompras.getBotonBorrar().setEnabled(true);
    }

    @Override
    public void campoBusquedaKeyPressed(KeyEvent evt) {
        this.ventanaListaDeCompras.cargarTabla(this.ventanaListaDeCompras.getCampoBusqueda().getText().trim());
    }

    @Override
    public void botonSalirKeyPressed(KeyEvent evt) {
        this.botonSalir(null);
    }

//    @Override
//    public void ventanaGanaFoco(WindowEvent evt) {
//        this.ventanaListaDeCompras.getBotonEditar().setEnabled(false);
//        this.ventanaListaDeCompras.getBotonBorrar().setEnabled(false);
//        this.ventanaListaDeCompras.getBotonSalir().requestFocus();
//    }
  
    
    public static void main(String[] args) {
        IControladorListaDeCompras controladorPrincipal = new ControladorListaDeCompras(null);
    }
    
}
