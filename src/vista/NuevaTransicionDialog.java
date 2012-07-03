/* 
 *  Copyright (C) 2011  Gerardo Martín Roldán
 *  GNU General Pulbic License
 */
package vista;

import controlador.dialogs.ControllerNT;
import javax.swing.JOptionPane;
import modelo.AutomataFinito;

public class NuevaTransicionDialog extends javax.swing.JDialog {
    private ControllerNT controlador;
    private int qActual=0,simboloPos=0;
    private String simboloActual=AutomataFinito.getAlfabeto().getSimbolos().get(0);
    private int topeQ=AutomataFinito.getEstados().size()-1;
    private String ultimoSimbolo=AutomataFinito.getAlfabeto().getSimbolos().get(AutomataFinito.getAlfabeto().getSimbolos().size()-1);
    
    public NuevaTransicionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        controlador=new ControllerNT();
        initComponents();
        actualizarLabels();
        this.setLocationRelativeTo(parent);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textTransicion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbQActual = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbSimbolo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Transición");

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("transiciona al estado");

        jLabel2.setText("Estado");

        lbQActual.setText("-");

        jLabel4.setText("con la letra");

        lbSimbolo.setText("-");

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
                        .addComponent(lbQActual, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSimbolo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textTransicion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textTransicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lbQActual)
                    .addComponent(jLabel4)
                    .addComponent(lbSimbolo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        // TODO add your handling code here:
        int proximoEstado;
        try{
            proximoEstado=Integer.parseInt(textTransicion.getText());    
            controlador.nuevaTransicion(qActual, simboloActual, proximoEstado);
            actualizarAtributos();
            actualizarLabels();                
            if(!verificar())                
                this.dispose();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Debe ingresar un número entero", "ERROR", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_botonAceptarActionPerformed
    
    private boolean verificar(){
        boolean resultado=true;        
        if(topeQ==-1)
            resultado=false;
        return resultado;
    }
    
    private void actualizarAtributos(){                
        if(qActual!=topeQ && simboloActual.equals(ultimoSimbolo)){                
            qActual++;
            simboloPos=0;
            simboloActual=AutomataFinito.getAlfabeto().getSimbolos().get(0);
        }
        else{
            if(qActual==topeQ && simboloActual.equals(ultimoSimbolo))
                topeQ=-1;
            else{
                simboloPos++;
                simboloActual=AutomataFinito.getAlfabeto().getSimbolos().get(simboloPos);
            }            
        }
    }
    
    private void actualizarLabels(){
        lbQActual.setText(""+qActual);
        lbSimbolo.setText(simboloActual);
        textTransicion.setText(null);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbQActual;
    private javax.swing.JLabel lbSimbolo;
    private javax.swing.JTextField textTransicion;
    // End of variables declaration//GEN-END:variables
}
