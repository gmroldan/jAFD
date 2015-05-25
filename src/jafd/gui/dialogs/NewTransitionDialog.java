/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package jafd.gui.dialogs;

import jafd.controller.JAfdController;
import jafd.exceptions.MachineException;
import java.awt.Event;
import javax.swing.JOptionPane;

public class NewTransitionDialog extends javax.swing.JDialog {
    private final int currentState;
    private final String symbol;
    private int nextState;    
    
    public NewTransitionDialog(java.awt.Frame parent, boolean modal, int currentState, String symbol) {
        super(parent, modal);
        this.currentState = currentState;
        this.symbol = symbol;
        initComponents();
        this.updateFields();
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAccept = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textTransition = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblCurrentState = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbSymbol = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Transición");

        btnAccept.setText("Aceptar");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        jLabel1.setText("transiciona al estado");

        textTransition.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textTransitionKeyPressed(evt);
            }
        });

        jLabel2.setText("Estado");

        lblCurrentState.setText("-");

        jLabel4.setText("con la letra");

        lbSymbol.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCurrentState, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textTransition, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textTransition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lblCurrentState)
                    .addComponent(jLabel4)
                    .addComponent(lbSymbol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAccept)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        this.enterTransition();
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void textTransitionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTransitionKeyPressed
        if (evt.getKeyCode() == Event.ENTER) {
            this.enterTransition();
        }
    }//GEN-LAST:event_textTransitionKeyPressed
        
    private void updateFields() {
        this.lblCurrentState.setText("" + currentState);
        this.lbSymbol.setText(symbol);
    }
    
    private void enterTransition() {
        try {
            String nextStateString = textTransition.getText();
            
            if (nextStateString == null || nextStateString.isEmpty()) {
                throw new MachineException("Invalid state.");
            }
            
            this.nextState = Integer.parseInt(nextStateString);
            
            JAfdController.getInstance().newTransition(currentState, symbol, nextState);
            this.dispose();
        } catch(MachineException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbSymbol;
    private javax.swing.JLabel lblCurrentState;
    private javax.swing.JTextField textTransition;
    // End of variables declaration//GEN-END:variables

}
