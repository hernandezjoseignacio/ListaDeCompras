/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HERNANDEZ
 */
public class ModeloTablaListaDeCompras extends AbstractTableModel{
    private final List<String> nombresColumnas = new ArrayList<>();
    private List<Compra> compras = new ArrayList<>();
    private final GestorListaDeCompras gc = GestorListaDeCompras.instanciar();  
    private String filtro;

    public ModeloTablaListaDeCompras() {
        this.nombresColumnas.add("Producto");
        this.nombresColumnas.add("Observaciones");
        this.nombresColumnas.add("Precio");
        this.compras = gc.listaDeCompras;
    }

    public ModeloTablaListaDeCompras(String filtro) {
        this();
        this.filtro = filtro;
        if (filtro!=null && !filtro.isEmpty()) 
            this.compras = gc.buscarUnaCompra(filtro);
    }

    /**
    * Obtiene el valor de la celda especificada
    * @param fila fila de la celda
    * @param columna columna de la celda
    * @return Object  - valor de la celda
    */                        
    @Override
    public Object getValueAt(int fila, int columna) {
        Compra unaCompra = this.compras.get(fila);
        switch (columna) {
            case 0: return unaCompra.getUnaCompra();
            case 1: return unaCompra.getAnotaciones();
            case 2: return unaCompra.getPrecio();
            default: return "-";
        }
    }
    
    /**
    * Obtiene la cantidad de columnas de la tabla
    * @return int  - cantidad de columnas de la tabla
    */                            
    @Override
    public int getColumnCount() { 
        return this.nombresColumnas.size();
    }

    /**
    * Obtiene la cantidad de filas de la tabla
    * @return int  - cantidad de filas de la tabla
    */                        
    @Override
    public int getRowCount() { 
        return this.compras.size();
    }

    /**
    * Obtiene el nombre de una columna
    * @param columna columna sobre la que se quiere obtener el nombre
    * @return String  - nombre de la columna especificada
    */                        
    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }

    /**
    * Devuelve la compra correspondiente a la fila especificada dentro de la tabla
    * @param fila fila dentro de la tabla
    * @return una Compra  - objeto unaCompra correspondiente a la fila que se especifica
    * @see una Compra
    */        
    public Compra obtenerArea(int fila) {
        return this.compras.get(fila);
    }
    
    /** 
     * Método que se encarga de actualizar los valores de la tabla
     */
    public void refrescar() {
        this.fireTableDataChanged();
    }
    
}
