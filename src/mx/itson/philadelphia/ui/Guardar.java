/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package mx.itson.philadelphia.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class Guardar extends javax.swing.JDialog {

    /**
     * Creates new form Guardar
     */
    public Guardar(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        
        cboDias.removeAllItems();
        cboAnios.removeAllItems();
        
        CambiarDias();
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNumeroLicencia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboMeses = new javax.swing.JComboBox<>();
        cboDias = new javax.swing.JComboBox<>();
        cboAnios = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre");

        jLabel2.setText("Numero de licencia");

        jLabel3.setText("Fecha de alta");

        cboMeses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cboMeses.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMesesItemStateChanged(evt);
            }
        });
        cboMeses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMesesActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumeroLicencia)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboDias, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboAnios, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 116, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAnios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboMesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMesesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMesesActionPerformed

    private void cboMesesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMesesItemStateChanged
        
        CambiarDias();
        
    }//GEN-LAST:event_cboMesesItemStateChanged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        try{
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MMMM/yyyy");

            String nombre = txtNombre.getText();
            String numeroLicencia = txtNumeroLicencia.getText();
            String fecha = cboDias.getSelectedItem().toString() + "/" + cboMeses.getSelectedItem().toString() + "/" + cboAnios.getSelectedItem().toString();
            Date fechaAlta = formato.parse(fecha);

            boolean funco = this.idDivisa == 0 ?
                    new Divisa().guardar(nombre, abreviacion, simbolo):
                    new Divisa().editar(idDivisa, nombre, abreviacion, simbolo);

            if(funco){

               JOptionPane.showMessageDialog(this, "El registro fue exitoso", "Guardado", JOptionPane.INFORMATION_MESSAGE);
               
               dispose();

            }else{

                JOptionPane.showMessageDialog(this, "El registro tuvo un error", "No guardado", JOptionPane.ERROR_MESSAGE);
                
                dispose();

            }

        }catch(Exception ex){

            System.err.println("Ocurrio un error: " + ex.getMessage());

        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void CambiarDias(){
        
         try{
             
             int dia = 1;
             int i = 0;
             int a = 1700;
             
             while(a <= 3000){
                 
                 cboAnios.addItem(Integer.toString(a));
                 a++;
                 
             }
            
             if(cboMeses.getSelectedItem().toString().equals("January")){
                 
                 while(i <= 31){
                     
                     cboDias.addItem(Integer.toString(dia));
                     i++;
                     
                 }
                 
             }else if(cboMeses.getSelectedItem().toString().equals("February")){
                 
                 while(i <= 29){
                     
                     cboDias.addItem(Integer.toString(dia));
                     i++;
                     
                 }
                 
             }else if(cboMeses.getSelectedItem().toString().equals("March")){
                 
                 while(i <= 31){
                     
                     cboDias.addItem(Integer.toString(dia));
                     i++;
                     
                 }
                 
             }else if(cboMeses.getSelectedItem().toString().equals("April")){
                 
                 while(i <= 30){
                     
                     cboDias.addItem(Integer.toString(dia));
                     i++;
                     
                 }
                 
             }else if(cboMeses.getSelectedItem().toString().equals("May")){
                 
                 while(i <= 31){
                     
                    cboDias.addItem(Integer.toString(dia));
                     i++;
                     
                 }
                 
             }else if(cboMeses.getSelectedItem().toString().equals("June")){
                 
                 while(i <= 30){
                     
                     cboDias.addItem(Integer.toString(dia));
                     i++;
                     
                 }
                 
             }else if(cboMeses.getSelectedItem().toString().equals("July")){
                 
                 while(i <= 31){
                     
                     cboDias.addItem(Integer.toString(dia));
                     i++;
                     
                 }
                 
             }else if(cboMeses.getSelectedItem().toString().equals("August")){
                 
                 while(i <= 31){
                     
                     cboDias.addItem(Integer.toString(dia));
                     i++;
                     
                 }
                 
             }else if(cboMeses.getSelectedItem().toString().equals("September")){
                 
                 while(i <= 30){
                     
                     cboDias.addItem(Integer.toString(dia));
                     i++;
                     
                 }
                 
             }else if(cboMeses.getSelectedItem().toString().equals("October")){
                 
                 while(i <= 31){
                     
                     cboDias.addItem(Integer.toString(dia));
                     i++;
                     
                 }
                 
             }else if(cboMeses.getSelectedItem().toString().equals("November")){
                 
                 while(i <= 30){
                     
                     cboDias.addItem(Integer.toString(dia));
                     i++;
                     
                 }
                 
             }else if(cboMeses.getSelectedItem().toString().equals("December")){
                 
                 while(i <= 31){
                     
                     cboDias.addItem(Integer.toString(dia));
                     i++;
                     
                 }
                 
             }
                
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Guardar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Guardar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Guardar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Guardar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Guardar dialog = new Guardar(new javax.swing.JFrame(), true, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboAnios;
    private javax.swing.JComboBox<String> cboDias;
    private javax.swing.JComboBox<String> cboMeses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroLicencia;
    // End of variables declaration//GEN-END:variables
}
