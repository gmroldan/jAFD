/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package vista.dialogs;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Transicion;

public class TransicionesDialog extends javax.swing.JDialog {
    private ArrayList<Transicion> transiciones;
        
    public TransicionesDialog(java.awt.Frame parent, boolean modal, ArrayList<Transicion> transiciones) {
        super(parent, modal);
        this.transiciones = transiciones;
        initComponents();
        actualizarTabla();
        setLocationRelativeTo(parent);                
    }   
    
    private void actualizarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) tablaDeTransiciones.getModel();
        modelo.setRowCount(0);
        Object[] fila = new Object[3];
        for(Transicion t: transiciones){
            fila[0] = t.getEstadoActual();
            fila[1] = t.getSimbolo();
            fila[2] = t.getProximoEstado();            
            modelo.addRow(fila);
        }                             
        tablaDeTransiciones.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDeTransiciones = new javax.swing.JTable();
        botonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transiciones");
        setResizable(false);

        tablaDeTransiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "q Actual", "Símbolo", "Próximo q"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDeTransiciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaDeTransiciones);

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botonAceptar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDeTransiciones;
    // End of variables declaration//GEN-END:variables
}
