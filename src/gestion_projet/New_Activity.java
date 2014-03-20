/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion_projet;

import dao.impl.ActivityDAO;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.GregorianCalendar;
import java.util.*;

/**
 *
 * @author amadou
 */
public class New_Activity extends javax.swing.JDialog {
    ObjetsBDD objet;
    /**
     * Creates new form New_Activity
     */
    public New_Activity(java.awt.Frame parent, boolean modal, ObjetsBDD o) {
        super(parent, modal);
        initComponents();
        ObjetsBDD objets=o;
        //this.lancer();
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
            java.util.logging.Logger.getLogger(New_Activity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(New_Activity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(New_Activity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(New_Activity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
         
          this.setVisible(true);
            }
        
       
        
    
    
    
        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_label = new javax.swing.JLabel();
        labelTF = new javax.swing.JTextField();
        jLabel_Workload = new javax.swing.JLabel();
        Workload_TF = new javax.swing.JTextField();
        jLabel_Duration = new javax.swing.JLabel();
        Duration_TF = new javax.swing.JTextField();
        jLabel_Constraint = new javax.swing.JLabel();
        jLabel_ActivityDesc = new javax.swing.JLabel();
        Description_TF = new javax.swing.JTextField();
        Hypothesis_TF = new javax.swing.JTextField();
        jLabel_Hypothesis = new javax.swing.JLabel();
        Calculation_Note_TF = new javax.swing.JTextField();
        jLabel_Calculation = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ImposedDate_TF = new javax.swing.JTextField();
        jLabel_ResultingState = new javax.swing.JLabel();
        jLabel_label2 = new javax.swing.JLabel();
        RS_Label_TF = new javax.swing.JTextField();
        jCheckBox_Milestone = new javax.swing.JCheckBox();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        constraint_TF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel_label.setText("Label");

        jLabel_Workload.setText("Workload");

        jLabel_Duration.setText("Duration");

        Duration_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Duration_TFActionPerformed(evt);
            }
        });

        jLabel_Constraint.setText("Constraint Type");

        jLabel_ActivityDesc.setText("Activity Description");

        jLabel_Hypothesis.setText("Hypothesis");

        jLabel_Calculation.setText("Calculation Notes");

        jLabel8.setText("Imposed date");

        ImposedDate_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImposedDate_TFActionPerformed(evt);
            }
        });

        jLabel_ResultingState.setText("Resulting State:");

        jLabel_label2.setText("Label");

        jCheckBox_Milestone.setText("Milestone");

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Workload)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_label)
                                    .addComponent(labelTF, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Workload_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_Duration)
                                    .addComponent(Duration_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(constraint_TF, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_Constraint, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Calculation_Note_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_Calculation)
                                    .addComponent(jLabel_ActivityDesc)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Description_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel_Hypothesis)
                                            .addComponent(Hypothesis_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(68, 68, 68)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox_Milestone)
                                            .addComponent(jLabel_ResultingState)
                                            .addComponent(jLabel_label2)
                                            .addComponent(RS_Label_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ImposedDate_TF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(okButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_label)
                    .addComponent(jLabel_ActivityDesc))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Description_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel_ResultingState)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_label2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel_Workload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Workload_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_Duration, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Duration_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Hypothesis)
                            .addComponent(RS_Label_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Hypothesis_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jCheckBox_Milestone)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel_Constraint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(constraint_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel_Calculation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Calculation_Note_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImposedDate_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Duration_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Duration_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Duration_TFActionPerformed

    private void ImposedDate_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImposedDate_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImposedDate_TFActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
                                
                                String label = labelTF.getText();
                                String description = Description_TF.getText();
                                String hypothesis = Hypothesis_TF.getText();
                                String calculation_Note = Calculation_Note_TF.getText();
                                String dateString= ImposedDate_TF.getText();
                                String constraintType=constraint_TF.getText();
         
                                /*Gestion du calendrier. Demander si on ne peut pas remplacer l'utilisation des dates par des String.
                                //Egalement pour Place, ce serait plus simple de le gérer avec des String.
                                DateFormat df = new SimpleDateFormat("E, dd MMM yyyy hh:mm:ss Z");
                                Date parsed = df.parse(dateString);


                                 GregorianCalendar newCalendar = GregorianCalendar.getInstance();
                                 newCalendar.setTime(parsed);
                                GregorianCalendar imposed_date= new GregorianCalendar(ImposedDate_TF.getText());
                                */
                                
                                BigDecimal workload=new BigDecimal(Workload_TF.getText());
                                BigDecimal duration=new BigDecimal(Duration_TF.getText());
                                
                                
                                if(label.length()==0){
                                        JOptionPane.showMessageDialog(this, "L'activite a besoin d'un label", "Erreur entree utilisateur",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                                else{
                                        
                                        try{
                                              
                                                 model.Activity a = new model.Activity();
                                                a.setCaculationNote(calculation_Note);
                                                a.setConstraintDateType(constraintType);
                                                a.setDescription(description);
                                                a.setDuration(duration);
                                                a.setHypothesis(hypothesis);
                                                a.setLabel(label);
                                                a.setWorkload(workload);
                                                ActivityDAO activityDAO = new ActivityDAO(db);
                                                activityDAO.create(a);
                                                
                                                dispose();
                                                
                                                
                                        }
                                        catch(NumberFormatException exception){
                                                JOptionPane.showMessageDialog(this, "Erreur: ", "Erreur entree utilisateur",
                                                                                                        JOptionPane.ERROR_MESSAGE);
                                        }
                                }
                        
        
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Calculation_Note_TF;
    private javax.swing.JTextField Description_TF;
    private javax.swing.JTextField Duration_TF;
    private javax.swing.JTextField Hypothesis_TF;
    private javax.swing.JTextField ImposedDate_TF;
    private javax.swing.JTextField RS_Label_TF;
    private javax.swing.JTextField Workload_TF;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField constraint_TF;
    private javax.swing.JCheckBox jCheckBox_Milestone;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_ActivityDesc;
    private javax.swing.JLabel jLabel_Calculation;
    private javax.swing.JLabel jLabel_Constraint;
    private javax.swing.JLabel jLabel_Duration;
    private javax.swing.JLabel jLabel_Hypothesis;
    private javax.swing.JLabel jLabel_ResultingState;
    private javax.swing.JLabel jLabel_Workload;
    private javax.swing.JLabel jLabel_label;
    private javax.swing.JLabel jLabel_label2;
    private javax.swing.JTextField labelTF;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
