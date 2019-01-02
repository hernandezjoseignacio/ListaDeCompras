/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.vistas;

import gui.interfaces.IControladorVentanaAMNuevaCompra;

/**
 *
 * @author HERNANDEZ
 */
public class VentanaAMCompra extends javax.swing.JDialog {
    IControladorVentanaAMNuevaCompra controlador;
    VentanaListaDeCompras ventanaListaDeCompras;
    
    /**
     * Creates new form VentanaAMNuevaCompra
     */
    public VentanaAMCompra(IControladorVentanaAMNuevaCompra controlador, VentanaListaDeCompras ventanaListaDeCompras, boolean modal) {
        super(ventanaListaDeCompras, modal);
        initComponents();
        this.controlador = controlador;
        this.setLocationRelativeTo(null);
        this.campoCompra.setText(null);
        this.campoAnotaciones.setText(null);
        this.botonVolver.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonVolver = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        campoCompra = new javax.swing.JTextField();
        campoPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoAnotaciones = new javax.swing.JEditorPane();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setText("Nueva Compra:");

        jLabel2.setText("Anotaciones:");

        jLabel3.setText("Precio:");

        botonVolver.setMnemonic('v');
        botonVolver.setText("Volver");
        botonVolver.setToolTipText("Volver a la Lista de Compras");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });
        botonVolver.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonVolverKeyPressed(evt);
            }
        });

        botonGuardar.setMnemonic('g');
        botonGuardar.setText("Guardar");
        botonGuardar.setToolTipText("Guardar en la Lista el producto a comprar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        campoCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoCompraKeyPressed(evt);
            }
        });

        campoPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoPrecioKeyPressed(evt);
            }
        });

        campoAnotaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoAnotacionesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(campoAnotaciones);

        jLabel4.setText("$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonGuardar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonVolver, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonGuardar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCompraKeyPressed
        this.controlador.campoNuevaCompraKeyPressed(evt);
    }//GEN-LAST:event_campoCompraKeyPressed

    private void campoPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPrecioKeyPressed
        this.controlador.campoPrecioKeyPressed(evt);
    }//GEN-LAST:event_campoPrecioKeyPressed

    private void campoAnotacionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoAnotacionesKeyPressed
        this.controlador.campoObservacionesKeyPressed(evt);
    }//GEN-LAST:event_campoAnotacionesKeyPressed

    private void botonVolverKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonVolverKeyPressed
        this.controlador.botonVolverKeyPressed(evt);
    }//GEN-LAST:event_botonVolverKeyPressed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        this.controlador.botonGuardarKeyPressed(evt);
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        this.controlador.botonVolverClic(evt);
    }//GEN-LAST:event_botonVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonVolver;
    private javax.swing.JEditorPane campoAnotaciones;
    private javax.swing.JTextField campoCompra;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getCampoCompra() {
        return this.campoCompra;
    }

    public javax.swing.JEditorPane getCampoAnotaciones() {
        return this.campoAnotaciones;
    }

    public javax.swing.JTextField getCampoPrecio() {
        return this.campoPrecio;
    }

}
