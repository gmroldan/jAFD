/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package jafd.gui.dialogs;

import jafd.controller.JAfdController;
import javax.swing.table.DefaultTableModel;
import jafd.core.Transition;
import java.util.List;

public class ViewTransitionsDialog extends javax.swing.JDialog {    
        
    public ViewTransitionsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        updateTable();
        setLocationRelativeTo(parent);                
    }   
    
    private void updateTable() {
        List<Transition> transitionsList = JAfdController.getInstance().getTransitions();
        
        DefaultTableModel model = (DefaultTableModel) tableTransitions.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        
        for(Transition t: transitionsList){
            row[0] = t.getCurrentState();
            row[1] = t.getSymbol();
            row[2] = t.getNextState();            
            model.addRow(row);
        }
        
        tableTransitions.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableTransitions = new javax.swing.JTable();
        botonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transiciones");
        setResizable(false);

        tableTransitions.setModel(new javax.swing.table.DefaultTableModel(
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
        tableTransitions.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableTransitions);

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
    private javax.swing.JTable tableTransitions;
    // End of variables declaration//GEN-END:variables
}
