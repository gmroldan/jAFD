/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package jafd.gui;

import java.awt.Event;
import javax.swing.JOptionPane;
import jafd.exceptions.MachineException;
import jafd.gui.dialogs.AboutDialog;
import jafd.controller.JAfdController;
import jafd.gui.dialogs.FinalStatesDialog;
import jafd.gui.dialogs.NewTransitionDialog;
import jafd.gui.dialogs.NewAlphabetDialog;
import jafd.gui.dialogs.NewStatesDialog;
import jafd.gui.dialogs.ViewTransitionsDialog;

public class MainWindow extends javax.swing.JFrame {
    private final JAfdController jAfdController;    
    
    public MainWindow() {
        this.jAfdController = JAfdController.getInstance();
        initComponents();
        setLocationRelativeTo(null);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblFinalStates = new javax.swing.JLabel();
        lblStates = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblAlphabet = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textResult = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        textWord = new javax.swing.JTextField();
        btnEvaluate = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        optionNewDFA = new javax.swing.JMenuItem();
        optionQuit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        optionTransitions = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        optionAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jAFD - Simulador de Autómata Finito Determinista");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del AFD"));

        lblFinalStates.setText("[ - ]");

        lblStates.setText("[ - ]");

        jLabel4.setText("F =");

        jLabel2.setText("Q =");

        lblAlphabet.setText("[no se ingresó ningún alfabeto]");

        jLabel1.setText("Σ =");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAlphabet, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblFinalStates, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblStates, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblAlphabet, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStates)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblFinalStates))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Evaluación de Cadenas"));

        textResult.setEditable(false);
        textResult.setColumns(20);
        textResult.setRows(5);
        jScrollPane1.setViewportView(textResult);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadena a Evaluar"));

        textWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textWordKeyPressed(evt);
            }
        });

        btnEvaluate.setText("Evaluar");
        btnEvaluate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(textWord)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnEvaluate, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(textWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEvaluate)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        optionNewDFA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        optionNewDFA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jafd/gui/icons/aptdaemon-add.png"))); // NOI18N
        optionNewDFA.setText("Nuevo AFD");
        optionNewDFA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionNewDFAActionPerformed(evt);
            }
        });
        jMenu1.add(optionNewDFA);

        optionQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jafd/gui/icons/view-minimize.png"))); // NOI18N
        optionQuit.setText("Salir");
        optionQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionQuitActionPerformed(evt);
            }
        });
        jMenu1.add(optionQuit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("AFD");

        optionTransitions.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        optionTransitions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jafd/gui/icons/alacarte.png"))); // NOI18N
        optionTransitions.setText("Ver Tabla de Transiciones");
        optionTransitions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionTransitionsActionPerformed(evt);
            }
        });
        jMenu2.add(optionTransitions);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ayuda");

        optionAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jafd/gui/icons/help_about.png"))); // NOI18N
        optionAbout.setText("Acerca de");
        optionAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionAboutActionPerformed(evt);
            }
        });
        jMenu3.add(optionAbout);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void optionQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionQuitActionPerformed
        if (JOptionPane.showConfirmDialog(this, "¿Desea salir de la aplicación?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }        
    }//GEN-LAST:event_optionQuitActionPerformed

    private void optionNewDFAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionNewDFAActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Se va a generar un nuevo AFD. ¿Desea continuar?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {            
                this.jAfdController.newDFA();
                this.enterAlphabet();
                this.enterStates();
                this.enterFinalStates();
                this.enterTransitions();
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "No se pudo crear correctamente el AFD", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }        
    }//GEN-LAST:event_optionNewDFAActionPerformed

    private void btnEvaluateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvaluateActionPerformed
        this.resolve();
    }//GEN-LAST:event_btnEvaluateActionPerformed

    private void optionAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionAboutActionPerformed
        new AboutDialog(this, true).setVisible(true);
    }//GEN-LAST:event_optionAboutActionPerformed

    private void optionTransitionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionTransitionsActionPerformed
        try {
            if (jAfdController.getCurrentMachine() == null) {
                throw new MachineException("No se detectó ningún AFD");
            }
            
            new ViewTransitionsDialog(this, true).setVisible(true);
        } catch(MachineException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_optionTransitionsActionPerformed

    private void textWordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textWordKeyPressed
        if (evt.getKeyCode() == Event.ENTER) {
            this.resolve();
        }
    }//GEN-LAST:event_textWordKeyPressed

    private void enterAlphabet() throws Exception {
        NewAlphabetDialog dialog = new NewAlphabetDialog(this, true);
        this.lblAlphabet.setText(jAfdController.getAlphabet());
    }
    
    private void enterStates() {
        NewStatesDialog dialog = new NewStatesDialog(this, true);
        this.lblStates.setText(jAfdController.getStates());
    }
    
    private void enterFinalStates() throws Exception {
        FinalStatesDialog dialog = new FinalStatesDialog(this, true);
        this.lblFinalStates.setText(jAfdController.getFinalStates());
    }
    
    private void enterTransitions() {
        JOptionPane.showMessageDialog(this, "Se iniciará la carga de la tabla de transiciones", "", JOptionPane.INFORMATION_MESSAGE);
        
        for (int currentState = 0; currentState < jAfdController.getNumberOfStates(); currentState++) {
            for (Object symbol: jAfdController.getSymbols()) {
                NewTransitionDialog dialog = new NewTransitionDialog(this, true, currentState, symbol.toString());
            }            
        }
    }
    
    private void resolve() {
        this.textResult.setText(null);
        try {            
            this.textResult.setText(jAfdController.simulate(textWord.getText()));
        } catch (MachineException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo evaluar ninguna cadena. No se detectó ningún AFD", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());                    
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEvaluate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlphabet;
    private javax.swing.JLabel lblFinalStates;
    private javax.swing.JLabel lblStates;
    private javax.swing.JMenuItem optionAbout;
    private javax.swing.JMenuItem optionNewDFA;
    private javax.swing.JMenuItem optionQuit;
    private javax.swing.JMenuItem optionTransitions;
    private javax.swing.JTextArea textResult;
    private javax.swing.JTextField textWord;
    // End of variables declaration//GEN-END:variables

}
