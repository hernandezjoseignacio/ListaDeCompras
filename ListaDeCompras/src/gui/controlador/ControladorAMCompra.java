/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controlador;

import gui.interfaces.IGestorListaDeCompras;
import gui.modelo.Compra;
import gui.modelo.GestorListaDeCompras;
import gui.modelo.ModeloTablaListaDeCompras;
import gui.vistas.VentanaAMCompra;
import gui.vistas.VentanaListaDeCompras;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import gui.interfaces.IControladorAMCompra;

/**
 *
 * @author HERNANDEZ
 */
public class ControladorAMCompra implements IControladorAMCompra{
    private final VentanaListaDeCompras ventanaListaDeCompras;
    private final VentanaAMCompra ventanaAMCompra;
    private final IGestorListaDeCompras gc = GestorListaDeCompras.instanciar();
    private Compra unaCompra;
    
    public ControladorAMCompra(VentanaListaDeCompras ventanaListaDeCompras,Compra unaCompra) {
        this.ventanaListaDeCompras = ventanaListaDeCompras;
        ventanaAMCompra = new VentanaAMCompra(this, ventanaListaDeCompras, true);
        this.unaCompra = unaCompra;
        if(unaCompra!=null){
            ventanaAMCompra.setTitle("Modificar una Compra");
            this.ventanaAMCompra.getCampoCompra().setText(unaCompra.getUnaCompra());
            this.ventanaAMCompra.getCampoAnotaciones().setText(unaCompra.getAnotaciones());
            this.ventanaAMCompra.getCampoPrecio().setText(Float.toString(unaCompra.getPrecio()));
        }else{
            ventanaAMCompra.setTitle("Guardar un Producto a comprar");
        }
        ventanaAMCompra.setLocationRelativeTo(null);
        ventanaAMCompra.setVisible(true);
    }
    
    @Override
    public void botonGuardarKeyPressed(ActionEvent evt) {
        this.guardar();
    }

    @Override
    public void botonVolverClic(ActionEvent evt) {
        this.ventanaListaDeCompras.getBotonSalir().requestFocus();
        this.ventanaAMCompra.dispose();
    }

    @Override
    public void campoNuevaCompraKeyPressed(KeyEvent evt) {
        if(evt.getKeyChar() == KeyEvent.VK_ENTER)
            this.guardar();
    }
   
    @Override
    public void campoPrecioKeyPressed(KeyEvent evt) {
        if(evt.getKeyChar() == KeyEvent.VK_ENTER)
            this.guardar();
    }

    @Override
    public void campoObservacionesKeyPressed(KeyEvent evt) {
        if(evt.getKeyChar() == KeyEvent.VK_ENTER)
            this.guardar();
    }

    @Override
    public void botonVolverKeyPressed(KeyEvent evt) {
        if(evt.getKeyChar() == KeyEvent.VK_ENTER)
            this.botonVolverClic(null);
    }

    public void guardar(){
        String resultado;
        if(this.unaCompra!=null){ //en el caso que se edita una compra
            if(this.gc.modificarUnaCompra(this.unaCompra, this.ventanaAMCompra.getCampoCompra().getText().trim(), this.ventanaAMCompra.getCampoAnotaciones().getText().trim(), Float.parseFloat(this.ventanaAMCompra.getCampoPrecio().getText().trim()) ).equals("EXITO")){
                this.ventanaListaDeCompras.cargarTabla();
                this.ventanaAMCompra.dispose();
                JOptionPane.showMessageDialog(ventanaAMCompra, "La Compra ha sido modificada con éxito.", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
            }else{
                this.ventanaAMCompra.dispose();
                JOptionPane.showMessageDialog(ventanaAMCompra, "No se realizaron cambios en la Compra.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{ //caso en que se guarda una compra
            resultado = gc.nuevaCompra(this.ventanaAMCompra.getCampoCompra().getText().trim(), this.ventanaAMCompra.getCampoAnotaciones().getText().trim(), Float.parseFloat(this.ventanaAMCompra.getCampoPrecio().getText().trim()));
            this.ventanaAMCompra.dispose();
            if(resultado.equals("EXITO")){
                JOptionPane.showMessageDialog(ventanaAMCompra, "LA compra fué guardada con éxito.", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if(resultado.equals("DUPLICADOS")){
                    JOptionPane.showMessageDialog(ventanaAMCompra, "Puede ser que la Compra ya esté en la Lista", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(ventanaAMCompra,"No se puede Guardar la Compra", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        ModeloTablaListaDeCompras unModeloTablaListaDeCompras = (ModeloTablaListaDeCompras)this.ventanaListaDeCompras.getTablaListaDeCompras().getModel();
        unModeloTablaListaDeCompras.refrescar();
        
        if(this.unaCompra!=null){ //se selecciona el area que fue editado 
            this.ventanaListaDeCompras.getTablaListaDeCompras().changeSelection(this.gc.obtenerPosicion(unaCompra), 0, true, false);
        }else{ //se selecciona en la tabla el area que fue creado
            this.ventanaListaDeCompras.getTablaListaDeCompras().changeSelection(this.gc.obtenerPosicion(gc.dameUnaCompra(ventanaAMCompra.getCampoCompra().getText())), 0, true, false);
        }
        
        this.ventanaListaDeCompras.getBotonSalir().requestFocus();
    }
}
