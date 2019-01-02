/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.vistas;

import gui.interfaces.IControladorVentanaListaDeCompras;
import gui.interfaces.IGestorListaDeCompras;
import gui.modelo.GestorListaDeCompras;
import gui.modelo.ModeloTablaListaDeCompras;

/**
 *
 * @author HERNANDEZ
 */
public class VentanaListaDeCompras extends javax.swing.JDialog {
    IControladorVentanaListaDeCompras controlador;
    IGestorListaDeCompras gc = GestorListaDeCompras.instanciar();
    
    /**
     * Creates new form VentanaListaDeCompras
     */
    public VentanaListaDeCompras(java.awt.Frame parent, boolean modal,IControladorVentanaListaDeCompras controaldor) {
        super(parent, modal);
        initComponents();
        this.cargarTabla();
        this.tablaListaDeCompras.getTableHeader().setReorderingAllowed(false);
        this.botonEditar.setEnabled(false);
        this.botonBorrar.setEnabled(false);
        this.controlador = controaldor;
        this.botonSalir.requestFocus();
    }

    /**
     * Este metodo se encarga de asiganrle el modelo a la tablaListaDeCompras, 
     * en este caso, la tablaListaDeCompras
     * se llena con todos los elementos del array del GestorListaDeCompras..
     */
    public void cargarTabla(){
        ModeloTablaListaDeCompras modelo = new ModeloTablaListaDeCompras();
        this.tablaListaDeCompras.setModel(modelo);
        //El modelo es quien tiene los datos que llenan la tablaAreas
    }
    /**
     * Este metodo se encarga de asiganrle el modelo a la tablaListaDeCompras, 
     * en este caso, la tablaListaDeCompras se llena con todos 
     * los elementos del array reducido, que contiene todos 
     * los ementos que pasen el filtro que recibe este metodo.
     * @param filtro es un string que representa 
     * el producto que se desea buscar.
     */
    public void cargarTabla(String filtro){
        ModeloTablaListaDeCompras modelo = new ModeloTablaListaDeCompras(filtro);
        this.tablaListaDeCompras.setModel(modelo);
        //Aqui se carga el modelo a la tablaListaDeCompras, pero con un filtro para el List
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListaDeCompras = new javax.swing.JTable();
        botonNueva = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        campoBusqueda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoBusquedaFocusGained(evt);
            }
        });
        campoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBusquedaActionPerformed(evt);
            }
        });
        campoBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoBusquedaKeyPressed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        tablaListaDeCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaListaDeCompras.setToolTipText("Lista de Compras");
        tablaListaDeCompras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaListaDeComprasFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tablaListaDeCompras);

        botonNueva.setMnemonic('n');
        botonNueva.setText("Nueva");
        botonNueva.setToolTipText("Agregar un producto a la Lista de Compras");
        botonNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaActionPerformed(evt);
            }
        });

        botonEditar.setMnemonic('e');
        botonEditar.setText("Editar");
        botonEditar.setToolTipText("Editar un producto seleccionado de la Lista de Compras");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonBorrar.setMnemonic('b');
        botonBorrar.setText("Borrar");
        botonBorrar.setToolTipText("Borrar un producto seleccionado de la Lista de Compras");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonSalir.setMnemonic('s');
        botonSalir.setText("Salir");
        botonSalir.setToolTipText("Salir y cerrar el programa");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        botonSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonSalirKeyPressed(evt);
            }
        });

        jLabel2.setText("Lista de Compras:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonEditar)
                                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botonBorrar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonNueva)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonNueva)
                        .addGap(18, 18, 18)
                        .addComponent(botonEditar)
                        .addGap(32, 32, 32)
                        .addComponent(botonBorrar)
                        .addGap(106, 106, 106)
                        .addComponent(botonSalir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        this.controlador.botonEditar(evt);
    }//GEN-LAST:event_botonEditarActionPerformed

    private void campoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBusquedaActionPerformed
        this.controlador.campoBusqueda(evt);
    }//GEN-LAST:event_campoBusquedaActionPerformed

    private void botonNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaActionPerformed
        this.controlador.botonNueva(evt);
    }//GEN-LAST:event_botonNuevaActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        this.controlador.botonBorrar(evt);
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.controlador.botonSalir(evt);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonSalirKeyPressed
        this.controlador.botonSalirKeyPressed(evt);
    }//GEN-LAST:event_botonSalirKeyPressed

    private void campoBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBusquedaKeyPressed
        this.controlador.campoBusquedaKeyPressed(evt);
    }//GEN-LAST:event_campoBusquedaKeyPressed

    private void tablaListaDeComprasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaListaDeComprasFocusGained
        this.controlador.tablaListaDeComprasFocusGained(evt);
    }//GEN-LAST:event_tablaListaDeComprasFocusGained

    private void campoBusquedaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoBusquedaFocusGained
        this.controlador.campoBusquedaFocusGained(evt);
    }//GEN-LAST:event_campoBusquedaFocusGained

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonNueva;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaListaDeCompras;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTable getTablaListaDeCompras() {
        return this.tablaListaDeCompras;
    }

    public javax.swing.JTextField getCampoBusqueda(){
        return this.campoBusqueda;
    }

    public javax.swing.JButton getBotonBorrar(){
        return this.botonBorrar;
    }

    public javax.swing.JButton getBotonEditar(){
        return this.botonEditar;
    }
    
    public javax.swing.JButton getBotonSalir(){
        return this.botonSalir;
    }


}
