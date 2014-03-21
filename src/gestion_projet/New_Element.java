/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion_projet;


import java.math.BigDecimal;
import java.util.Date;
import javax.swing.JOptionPane;
import dao.impl.WBSElementDAO;
import exceptions.ProjectException;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.DatabaseManager;


/**
 *
 * @author amadou
 */
public class New_Element extends javax.swing.JFrame {

    protected DatabaseManager db;
    protected Long idProject;
    
    /**
     * Creates new form New_Element
     */
    public New_Element(DatabaseManager db, Long idProject) {
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
            java.util.logging.Logger.getLogger(New_Element.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(New_Element.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(New_Element.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(New_Element.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       this.setVisible(true);
        initComponents();
        this.db=db;
        this.idProject = idProject;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox_WP = new javax.swing.JCheckBox();
        jLabel_label = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        jX_date_choice = new org.jdesktop.swingx.JXDatePicker();
        okButton = new javax.swing.JButton();
        jLabel_ActivityDesc = new javax.swing.JLabel();
        jLabel_Constraint = new javax.swing.JLabel();
        jLabel_Workload = new javax.swing.JLabel();
        constraint_TF = new javax.swing.JTextField();
        Workload_TF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel_Duration = new javax.swing.JLabel();
        Duration_TF = new javax.swing.JTextField();
        labelTF = new javax.swing.JTextField();
        jCheckBox_Contractual = new javax.swing.JCheckBox();
        achievement_TF = new javax.swing.JTextField();
        jLabel_Duration1 = new javax.swing.JLabel();
        delivery_date = new org.jdesktop.swingx.JXDatePicker();
        jLabel9 = new javax.swing.JLabel();
        laborA_TF = new javax.swing.JTextField();
        jLabel_Constraint1 = new javax.swing.JLabel();
        jLabel_Constraint2 = new javax.swing.JLabel();
        EA_TF = new javax.swing.JTextField();
        jLabel_Constraint3 = new javax.swing.JLabel();
        SA_TF = new javax.swing.JTextField();
        jLabel_Constraint4 = new javax.swing.JLabel();
        PA_TF = new javax.swing.JTextField();
        jLabel_Constraint5 = new javax.swing.JLabel();
        RA_TF = new javax.swing.JTextField();
        jLabel_Constraint6 = new javax.swing.JLabel();
        FS_TF = new javax.swing.JTextField();
        TS_TF = new javax.swing.JTextField();
        jLabel_Constraint7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        early_finish = new org.jdesktop.swingx.JXDatePicker();
        early_start = new org.jdesktop.swingx.JXDatePicker();
        jLabel11 = new javax.swing.JLabel();
        late_Start = new org.jdesktop.swingx.JXDatePicker();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        late_finish = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        Description_TF = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        parent_TF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCheckBox_WP.setText("IsWorkPackage");

        jLabel_label.setText("Label");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel_ActivityDesc.setText(" Description");

        jLabel_Constraint.setText("Constraint Type");

        jLabel_Workload.setText("Workload");

        jLabel8.setText("Start Date");

        jLabel_Duration.setText("Duration");

        Duration_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Duration_TFActionPerformed(evt);
            }
        });

        jCheckBox_Contractual.setText("Is Contractual");

        jLabel_Duration1.setText("Achievement Criteria");

        jLabel9.setText("Delivery Date");

        jLabel_Constraint1.setText("Labor Amount");

        jLabel_Constraint2.setText("Expense Amount");

        jLabel_Constraint3.setText("Subcontract Amount");

        jLabel_Constraint4.setText("Purchase Amount");

        jLabel_Constraint5.setText("Rent Amount");

        jLabel_Constraint6.setText("Free Slack");

        jLabel_Constraint7.setText("Total Slack");

        jLabel10.setText("Early Finish");

        jLabel11.setText("Early Start");

        jLabel12.setText("Late Start");

        jLabel13.setText("Late Finish");

        Description_TF.setColumns(20);
        Description_TF.setRows(5);
        jScrollPane1.setViewportView(Description_TF);

        jLabel1.setText("Parent ID");

        parent_TF.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_label)
                            .addComponent(jLabel_Workload)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Workload_TF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                            .addComponent(jLabel_Duration)
                            .addComponent(jLabel_Duration1)
                            .addComponent(achievement_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Duration_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(parent_TF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(constraint_TF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_Constraint, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(laborA_TF, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_Constraint1, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(EA_TF, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_Constraint2, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel_Constraint5)
                                    .addComponent(PA_TF)
                                    .addComponent(jLabel_Constraint4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(RA_TF))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel_Constraint7)
                                    .addComponent(FS_TF)
                                    .addComponent(jLabel_Constraint6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TS_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_ActivityDesc)
                                            .addComponent(jX_date_choice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)
                                            .addComponent(delivery_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(early_start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)
                                            .addComponent(early_finish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox_WP)
                                            .addComponent(jCheckBox_Contractual)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(late_Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12)
                                            .addComponent(late_finish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13)))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(SA_TF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_Constraint3, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(okButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_label)
                            .addComponent(jLabel_ActivityDesc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Workload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Workload_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_Duration, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(Duration_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Duration1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(achievement_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_Constraint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(constraint_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox_WP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox_Contractual)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(late_Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(late_finish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jX_date_choice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(delivery_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(early_start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(early_finish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel_Constraint1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(laborA_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel_Constraint2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(EA_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel_Constraint5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(RA_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel_Constraint4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(PA_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel_Constraint7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TS_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_Constraint6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FS_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Constraint3)
                    .addComponent(parent_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SA_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:

        String label = labelTF.getText();
        long parent_id=Long.valueOf(parent_TF.getText()).longValue();
                
        String description = Description_TF.getText();
        String constraintType=constraint_TF.getText();

        BigDecimal workload=null;
        try {
            workload=new BigDecimal(Workload_TF.getText());
        }
        catch (NumberFormatException e) {
            
        }
        BigDecimal duration=null;
        try{
             duration=new BigDecimal(Duration_TF.getText());
        }
        catch (NumberFormatException e) {
            
        }
        String achievement=achievement_TF.getText();
        Date StartDate= jX_date_choice.getDate();
        Date earlyStart=early_start.getDate();
        Date earlyFinish=early_finish.getDate();
        Date deliveryDate=delivery_date.getDate();
        Date lateStart=late_Start.getDate();
        Date lateFinish=late_Start.getDate();
        
        BigDecimal laborAmount=null;
        try{
               laborAmount=new BigDecimal(laborA_TF.getText());

        }
        catch (NumberFormatException e) {
            
        }
        
        BigDecimal ExpAmount=null;
        try{
            ExpAmount=new BigDecimal(EA_TF.getText());
        }
        catch (NumberFormatException e){
            
        }
        BigDecimal FreeSlack= null;
        try{
            FreeSlack=new BigDecimal(FS_TF.getText());
        }
        catch (NumberFormatException e){
            
        }
        BigDecimal PurchaseAmount=null;
        try{
           PurchaseAmount = new BigDecimal(PA_TF.getText());
        }
        catch (NumberFormatException e){
            
        }
        BigDecimal RentAmount= null;
        try {
         RentAmount= new BigDecimal(RA_TF.getText());
        }
        catch (NumberFormatException e){
            
        }
        BigDecimal TotalSlack=null;
        try{
           TotalSlack=new BigDecimal(TS_TF.getText());  
        }
        catch (NumberFormatException e){
            
        }
        BigDecimal SubcontractAmount=null;
        try{
         SubcontractAmount= new BigDecimal(SA_TF.getText());
        }
        catch (NumberFormatException e){
            
        }
        
        boolean IsWorkPackage=jCheckBox_WP.isSelected();
        boolean IsContractual=jCheckBox_Contractual.isSelected();
        
        
        
        

        if(label.length()==0){
            JOptionPane.showMessageDialog(this, "L'activite a besoin d'un label", "Erreur entree utilisateur",
                JOptionPane.ERROR_MESSAGE);
        }
        else{

            try{
                
                model.WBSElement a = new model.WBSElement(null, label, description, IsWorkPackage, StartDate, workload, duration, IsContractual, achievement, deliveryDate, laborAmount, PurchaseAmount, RentAmount, ExpAmount, SubcontractAmount, earlyStart, earlyFinish, lateStart, lateFinish, TotalSlack, FreeSlack, parent_id, null,idProject);
                WBSElementDAO elementDAO = new WBSElementDAO(db);
                    elementDAO.create(a);
                 
                

            }
            catch(NumberFormatException exception){
                JOptionPane.showMessageDialog(this, "Erreur: ", "Erreur entree utilisateur",
                    JOptionPane.ERROR_MESSAGE);
            }
            catch (ProjectException ex) {
                    Logger.getLogger(New_Element.class.getName()).log(Level.SEVERE, null, ex);
                }
            dispose();
        }

    }//GEN-LAST:event_okButtonActionPerformed

    private void Duration_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Duration_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Duration_TFActionPerformed

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
            java.util.logging.Logger.getLogger(New_Element.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(New_Element.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(New_Element.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(New_Element.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Description_TF;
    private javax.swing.JTextField Duration_TF;
    private javax.swing.JTextField EA_TF;
    private javax.swing.JTextField FS_TF;
    private javax.swing.JTextField PA_TF;
    private javax.swing.JTextField RA_TF;
    private javax.swing.JTextField SA_TF;
    private javax.swing.JTextField TS_TF;
    private javax.swing.JTextField Workload_TF;
    private javax.swing.JTextField achievement_TF;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField constraint_TF;
    private org.jdesktop.swingx.JXDatePicker delivery_date;
    private org.jdesktop.swingx.JXDatePicker early_finish;
    private org.jdesktop.swingx.JXDatePicker early_start;
    private javax.swing.JCheckBox jCheckBox_Contractual;
    private javax.swing.JCheckBox jCheckBox_WP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_ActivityDesc;
    private javax.swing.JLabel jLabel_Constraint;
    private javax.swing.JLabel jLabel_Constraint1;
    private javax.swing.JLabel jLabel_Constraint2;
    private javax.swing.JLabel jLabel_Constraint3;
    private javax.swing.JLabel jLabel_Constraint4;
    private javax.swing.JLabel jLabel_Constraint5;
    private javax.swing.JLabel jLabel_Constraint6;
    private javax.swing.JLabel jLabel_Constraint7;
    private javax.swing.JLabel jLabel_Duration;
    private javax.swing.JLabel jLabel_Duration1;
    private javax.swing.JLabel jLabel_Workload;
    private javax.swing.JLabel jLabel_label;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jX_date_choice;
    private javax.swing.JTextField labelTF;
    private javax.swing.JTextField laborA_TF;
    private org.jdesktop.swingx.JXDatePicker late_Start;
    private org.jdesktop.swingx.JXDatePicker late_finish;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField parent_TF;
    // End of variables declaration//GEN-END:variables
}
