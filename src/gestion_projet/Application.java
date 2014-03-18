/*d open the template in the editor.
 */
package gestion_projet;



/**
 *
 * @author amadou
 */
public class Application extends javax.swing.JFrame {
ObjetsBDD objets = new ObjetsBDD();
    
    public Application() {
        initComponents();
        
        
        System.out.println("test");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel_Home = new javax.swing.JPanel();
        jPanel_Home.setVisible(false);
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel_WBS = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_WBS = new javax.swing.JTable();
        jPanel_Resources = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jPanel_Risks = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel_Activities = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel_Communication = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jPanel_Referential = new javax.swing.JPanel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jPanel_Export = new javax.swing.JPanel();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Load Project");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("New Project");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Deconnection");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_HomeLayout = new javax.swing.GroupLayout(jPanel_Home);
        jPanel_Home.setLayout(jPanel_HomeLayout);
        jPanel_HomeLayout.setHorizontalGroup(
            jPanel_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_HomeLayout.createSequentialGroup()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(405, Short.MAX_VALUE))
        );
        jPanel_HomeLayout.setVerticalGroup(
            jPanel_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton3)
                .addComponent(jButton1)
                .addComponent(jButton2))
        );

        jTabbedPane1.addTab("Home", jPanel_Home);

        jButton7.setText("Export as List");

        jButton8.setText("Show as List");

        jButton9.setText("Show as a Tree");

        jButton22.setText("Export as PDF");

        jButton16.setText("New Element");

        jButton17.setText("Estimation");

        MyModel mtm = new MyModel(this.objets);
        jTable_WBS.setModel(mtm);
        jScrollPane1.setViewportView(jTable_WBS);
        jTable_WBS.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable_WBS.getColumnModel().getColumnCount() > 0) {
            jTable_WBS.getColumnModel().getColumn(0).setHeaderValue("Code");
            jTable_WBS.getColumnModel().getColumn(1).setHeaderValue("Label");
            jTable_WBS.getColumnModel().getColumn(2).setHeaderValue("Work Package");
            jTable_WBS.getColumnModel().getColumn(3).setHeaderValue("Concractual");
            jTable_WBS.getColumnModel().getColumn(4).setHeaderValue("Start Date");
            jTable_WBS.getColumnModel().getColumn(5).setHeaderValue("Delivery Date");
        }

        javax.swing.GroupLayout jPanel_WBSLayout = new javax.swing.GroupLayout(jPanel_WBS);
        jPanel_WBS.setLayout(jPanel_WBSLayout);
        jPanel_WBSLayout.setHorizontalGroup(
            jPanel_WBSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_WBSLayout.createSequentialGroup()
                .addComponent(jButton17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton22)
                .addContainerGap(96, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel_WBSLayout.setVerticalGroup(
            jPanel_WBSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_WBSLayout.createSequentialGroup()
                .addGroup(jPanel_WBSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton7)
                    .addComponent(jButton9)
                    .addComponent(jButton22)
                    .addComponent(jButton16)
                    .addComponent(jButton17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("WBS", jPanel_WBS);

        jButton4.setText("Human");

        jButton5.setText("Material");

        jButton6.setText("New Material");

        jButton25.setText("New Human");

        javax.swing.GroupLayout jPanel_ResourcesLayout = new javax.swing.GroupLayout(jPanel_Resources);
        jPanel_Resources.setLayout(jPanel_ResourcesLayout);
        jPanel_ResourcesLayout.setHorizontalGroup(
            jPanel_ResourcesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ResourcesLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton25)
                .addContainerGap(359, Short.MAX_VALUE))
        );
        jPanel_ResourcesLayout.setVerticalGroup(
            jPanel_ResourcesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ResourcesLayout.createSequentialGroup()
                .addGroup(jPanel_ResourcesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton6)
                    .addComponent(jButton25))
                .addGap(0, 199, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Resources", jPanel_Resources);

        jButton20.setText("New Requirement");

        jButton21.setText("New Risk");

        javax.swing.GroupLayout jPanel_RisksLayout = new javax.swing.GroupLayout(jPanel_Risks);
        jPanel_Risks.setLayout(jPanel_RisksLayout);
        jPanel_RisksLayout.setHorizontalGroup(
            jPanel_RisksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RisksLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jButton21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton20)
                .addContainerGap(493, Short.MAX_VALUE))
        );
        jPanel_RisksLayout.setVerticalGroup(
            jPanel_RisksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RisksLayout.createSequentialGroup()
                .addGroup(jPanel_RisksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20)
                    .addComponent(jButton21))
                .addGap(0, 199, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Risks", jPanel_Risks);

        jButton13.setText("Allocate Human Resource");

        jButton14.setText("Activities List");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("New");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton15MouseClicked(evt);
            }
        });

        jButton24.setText("State List");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton18.setText("Allocate Material Resource");

        jLabel1.setText("Work Package:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        MyModelActivity a= new MyModelActivity(this.objets);
        jTable2.setModel(a);
        jTable2.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setHeaderValue("Activity Label");
            jTable2.getColumnModel().getColumn(1).setHeaderValue("States at the origin of the activity");
            jTable2.getColumnModel().getColumn(2).setHeaderValue("Workload");
            jTable2.getColumnModel().getColumn(3).setHeaderValue("Duration");
            jTable2.getColumnModel().getColumn(4).setHeaderValue("Constraint Type");
            jTable2.getColumnModel().getColumn(5).setHeaderValue("Imposed Date");
            jTable2.getColumnModel().getColumn(5).setHeaderValue("Execution Place");
            jTable2.getColumnModel().getColumn(5).setHeaderValue("Completed");
        }

        javax.swing.GroupLayout jPanel_ActivitiesLayout = new javax.swing.GroupLayout(jPanel_Activities);
        jPanel_Activities.setLayout(jPanel_ActivitiesLayout);
        jPanel_ActivitiesLayout.setHorizontalGroup(
            jPanel_ActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ActivitiesLayout.createSequentialGroup()
                .addGroup(jPanel_ActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ActivitiesLayout.createSequentialGroup()
                        .addGroup(jPanel_ActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_ActivitiesLayout.createSequentialGroup()
                                .addComponent(jButton15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton18))
                            .addGroup(jPanel_ActivitiesLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 125, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel_ActivitiesLayout.setVerticalGroup(
            jPanel_ActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ActivitiesLayout.createSequentialGroup()
                .addGroup(jPanel_ActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14)
                    .addComponent(jButton13)
                    .addComponent(jButton15)
                    .addComponent(jButton24)
                    .addComponent(jButton18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Activities", jPanel_Activities);

        jButton26.setText("Meeting");

        jButton27.setText("Target Group");

        jButton28.setText("Document");

        javax.swing.GroupLayout jPanel_CommunicationLayout = new javax.swing.GroupLayout(jPanel_Communication);
        jPanel_Communication.setLayout(jPanel_CommunicationLayout);
        jPanel_CommunicationLayout.setHorizontalGroup(
            jPanel_CommunicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_CommunicationLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jButton27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton28)
                .addContainerGap(430, Short.MAX_VALUE))
        );
        jPanel_CommunicationLayout.setVerticalGroup(
            jPanel_CommunicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_CommunicationLayout.createSequentialGroup()
                .addGroup(jPanel_CommunicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton26)
                    .addComponent(jButton27)
                    .addComponent(jButton28))
                .addGap(0, 199, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Communication", jPanel_Communication);

        jButton29.setText("Unit");

        jButton30.setText("Responsability");

        jButton31.setText("Place");

        javax.swing.GroupLayout jPanel_ReferentialLayout = new javax.swing.GroupLayout(jPanel_Referential);
        jPanel_Referential.setLayout(jPanel_ReferentialLayout);
        jPanel_ReferentialLayout.setHorizontalGroup(
            jPanel_ReferentialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ReferentialLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jButton30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton31)
                .addContainerGap(470, Short.MAX_VALUE))
        );
        jPanel_ReferentialLayout.setVerticalGroup(
            jPanel_ReferentialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ReferentialLayout.createSequentialGroup()
                .addGroup(jPanel_ReferentialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton29)
                    .addComponent(jButton30)
                    .addComponent(jButton31))
                .addGap(0, 199, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Referential", jPanel_Referential);

        jButton32.setText("Activities Graph");

        jButton33.setText("Activities / State Graph");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setText("Export To MS Project");

        javax.swing.GroupLayout jPanel_ExportLayout = new javax.swing.GroupLayout(jPanel_Export);
        jPanel_Export.setLayout(jPanel_ExportLayout);
        jPanel_ExportLayout.setHorizontalGroup(
            jPanel_ExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ExportLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jButton33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton34)
                .addContainerGap(296, Short.MAX_VALUE))
        );
        jPanel_ExportLayout.setVerticalGroup(
            jPanel_ExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ExportLayout.createSequentialGroup()
                .addGroup(jPanel_ExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton32)
                    .addComponent(jButton33)
                    .addComponent(jButton34))
                .addGap(0, 199, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Export", jPanel_Export);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseClicked
 // TODO add your handling code here:
        new New_Activity(this, true);
    }//GEN-LAST:event_jButton15MouseClicked

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
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Application().setVisible(true) ;
                
               
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel_Activities;
    private javax.swing.JPanel jPanel_Communication;
    private javax.swing.JPanel jPanel_Export;
    private javax.swing.JPanel jPanel_Home;
    private javax.swing.JPanel jPanel_Referential;
    private javax.swing.JPanel jPanel_Resources;
    private javax.swing.JPanel jPanel_Risks;
    private javax.swing.JPanel jPanel_WBS;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable_WBS;
    // End of variables declaration//GEN-END:variables

    
}
