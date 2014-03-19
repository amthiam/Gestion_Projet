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
        jButton_LoadProject = new javax.swing.JButton();
        jButton_NewProject = new javax.swing.JButton();
        jButton_Deconnection = new javax.swing.JButton();
        jPanel_WBS = new javax.swing.JPanel();
        jButton_ExportList = new javax.swing.JButton();
        jButton_ShowAsList = new javax.swing.JButton();
        jButton_ShowTree = new javax.swing.JButton();
        jButton_ExportPDF = new javax.swing.JButton();
        jButton_New_Element = new javax.swing.JButton();
        jButton_Estimation = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_WBS = new javax.swing.JTable();
        jPanel_Resources = new javax.swing.JPanel();
        jButton_Human = new javax.swing.JButton();
        jButton_Material = new javax.swing.JButton();
        jButton_NewMaterial = new javax.swing.JButton();
        jButton_NewHuman = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_RH = new javax.swing.JTable();
        jPanel_Risks = new javax.swing.JPanel();
        jButton_NewReq = new javax.swing.JButton();
        jButton_NewRisk = new javax.swing.JButton();
        jPanel_Activities = new javax.swing.JPanel();
        jButton_AllocHumanResource = new javax.swing.JButton();
        jButton_Act_List = new javax.swing.JButton();
        jButton_NewAct = new javax.swing.JButton();
        jButton_StateList = new javax.swing.JButton();
        jButton_AllocMatResource = new javax.swing.JButton();
        jLabel_WP = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel_Communication = new javax.swing.JPanel();
        jButton_Meeting = new javax.swing.JButton();
        jButtonTargetGroup = new javax.swing.JButton();
        jButton_Doc = new javax.swing.JButton();
        jPanel_Referential = new javax.swing.JPanel();
        jButton_Unit = new javax.swing.JButton();
        jButton_Respo = new javax.swing.JButton();
        jButton_Place = new javax.swing.JButton();
        jPanel_Export = new javax.swing.JPanel();
        jButton_ActGraph = new javax.swing.JButton();
        jButton_ActStateGraph = new javax.swing.JButton();
        jButton_ExportMSProject = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_LoadProject.setText("Load Project");
        jButton_LoadProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LoadProjectActionPerformed(evt);
            }
        });

        jButton_NewProject.setText("New Project");
        jButton_NewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NewProjectActionPerformed(evt);
            }
        });

        jButton_Deconnection.setText("Deconnection");
        jButton_Deconnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeconnectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_HomeLayout = new javax.swing.GroupLayout(jPanel_Home);
        jPanel_Home.setLayout(jPanel_HomeLayout);
        jPanel_HomeLayout.setHorizontalGroup(
            jPanel_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_HomeLayout.createSequentialGroup()
                .addComponent(jButton_NewProject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_LoadProject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Deconnection)
                .addContainerGap(405, Short.MAX_VALUE))
        );
        jPanel_HomeLayout.setVerticalGroup(
            jPanel_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton_NewProject)
                .addComponent(jButton_LoadProject)
                .addComponent(jButton_Deconnection))
        );

        jTabbedPane1.addTab("Home", jPanel_Home);

        jButton_ExportList.setText("Export as List");

        jButton_ShowAsList.setText("Show as List");

        jButton_ShowTree.setText("Show as a Tree");

        jButton_ExportPDF.setText("Export as PDF");

        jButton_New_Element.setText("New Element");

        jButton_Estimation.setText("Estimation");

        gestion_projet.MyModel_WBS mtm = new gestion_projet.MyModel_WBS(this.objets);
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
                .addComponent(jButton_Estimation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_New_Element)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_ShowAsList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_ExportList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_ShowTree)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_ExportPDF)
                .addContainerGap(96, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel_WBSLayout.setVerticalGroup(
            jPanel_WBSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_WBSLayout.createSequentialGroup()
                .addGroup(jPanel_WBSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_ShowAsList)
                    .addComponent(jButton_ExportList)
                    .addComponent(jButton_ShowTree)
                    .addComponent(jButton_ExportPDF)
                    .addComponent(jButton_New_Element)
                    .addComponent(jButton_Estimation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("WBS", jPanel_WBS);

        jButton_Human.setText("Human");

        jButton_Material.setText("Material");

        jButton_NewMaterial.setText("New Material");

        jButton_NewHuman.setText("New Human");

        gestion_projet.Model_ResourcesH model_rh= new gestion_projet.Model_ResourcesH(this.objets);
        jTable_RH.setModel(model_rh);
        jTable_RH.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(jTable_RH);
        jTable_RH.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable_RH.getColumnModel().getColumnCount() > 0) {
            jTable_RH.getColumnModel().getColumn(0).setHeaderValue("Code");
            jTable_RH.getColumnModel().getColumn(1).setHeaderValue("Label");
            jTable_RH.getColumnModel().getColumn(2).setHeaderValue("Initials");
            jTable_RH.getColumnModel().getColumn(3).setHeaderValue("Unit");
            jTable_RH.getColumnModel().getColumn(4).setHeaderValue("Skill");
            jTable_RH.getColumnModel().getColumn(5).setHeaderValue("Capacity");
            jTable_RH.getColumnModel().getColumn(6).setHeaderValue("Std Rate");
            jTable_RH.getColumnModel().getColumn(7).setHeaderValue("Overtime");
            jTable_RH.getColumnModel().getColumn(8).setHeaderValue("Use Cost");
            jTable_RH.getColumnModel().getColumn(9).setHeaderValue("Critical");
            jTable_RH.getColumnModel().getColumn(10).setHeaderValue("Allocation Mode");
            jTable_RH.getColumnModel().getColumn(11).setHeaderValue("Target Group");
            jTable_RH.getColumnModel().getColumn(12).setHeaderValue("Place");

        }

        javax.swing.GroupLayout jPanel_ResourcesLayout = new javax.swing.GroupLayout(jPanel_Resources);
        jPanel_Resources.setLayout(jPanel_ResourcesLayout);
        jPanel_ResourcesLayout.setHorizontalGroup(
            jPanel_ResourcesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ResourcesLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jButton_Material)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_NewMaterial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Human)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_NewHuman)
                .addContainerGap(359, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        jPanel_ResourcesLayout.setVerticalGroup(
            jPanel_ResourcesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ResourcesLayout.createSequentialGroup()
                .addGroup(jPanel_ResourcesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Material)
                    .addComponent(jButton_Human)
                    .addComponent(jButton_NewMaterial)
                    .addComponent(jButton_NewHuman))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Resources", jPanel_Resources);

        jButton_NewReq.setText("New Requirement");

        jButton_NewRisk.setText("New Risk");

        javax.swing.GroupLayout jPanel_RisksLayout = new javax.swing.GroupLayout(jPanel_Risks);
        jPanel_Risks.setLayout(jPanel_RisksLayout);
        jPanel_RisksLayout.setHorizontalGroup(
            jPanel_RisksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RisksLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jButton_NewRisk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_NewReq)
                .addContainerGap(493, Short.MAX_VALUE))
        );
        jPanel_RisksLayout.setVerticalGroup(
            jPanel_RisksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RisksLayout.createSequentialGroup()
                .addGroup(jPanel_RisksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_NewReq)
                    .addComponent(jButton_NewRisk))
                .addGap(0, 199, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Risks", jPanel_Risks);

        jButton_AllocHumanResource.setText("Allocate Human Resource");

        jButton_Act_List.setText("Activities List");
        jButton_Act_List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Act_ListActionPerformed(evt);
            }
        });

        jButton_NewAct.setText("New");
        jButton_NewAct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_NewActMouseClicked(evt);
            }
        });
        jButton_NewAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NewActActionPerformed(evt);
            }
        });

        jButton_StateList.setText("State List");
        jButton_StateList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_StateListActionPerformed(evt);
            }
        });

        jButton_AllocMatResource.setText("Allocate Material Resource");

        jLabel_WP.setText("Work Package:");

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
            jTable2.getColumnModel().getColumn(6).setHeaderValue("Execution Place");
            jTable2.getColumnModel().getColumn(7).setHeaderValue("Completed");
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
                                .addComponent(jButton_NewAct)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Act_List)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_StateList)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_AllocHumanResource)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_AllocMatResource))
                            .addGroup(jPanel_ActivitiesLayout.createSequentialGroup()
                                .addComponent(jLabel_WP)
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
                    .addComponent(jButton_Act_List)
                    .addComponent(jButton_AllocHumanResource)
                    .addComponent(jButton_NewAct)
                    .addComponent(jButton_StateList)
                    .addComponent(jButton_AllocMatResource))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_WP)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Activities", jPanel_Activities);

        jButton_Meeting.setText("Meeting");

        jButtonTargetGroup.setText("Target Group");

        jButton_Doc.setText("Document");

        javax.swing.GroupLayout jPanel_CommunicationLayout = new javax.swing.GroupLayout(jPanel_Communication);
        jPanel_Communication.setLayout(jPanel_CommunicationLayout);
        jPanel_CommunicationLayout.setHorizontalGroup(
            jPanel_CommunicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_CommunicationLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jButtonTargetGroup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Meeting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Doc)
                .addContainerGap(430, Short.MAX_VALUE))
        );
        jPanel_CommunicationLayout.setVerticalGroup(
            jPanel_CommunicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_CommunicationLayout.createSequentialGroup()
                .addGroup(jPanel_CommunicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Meeting)
                    .addComponent(jButtonTargetGroup)
                    .addComponent(jButton_Doc))
                .addGap(0, 199, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Communication", jPanel_Communication);

        jButton_Unit.setText("Unit");

        jButton_Respo.setText("Responsability");

        jButton_Place.setText("Place");

        javax.swing.GroupLayout jPanel_ReferentialLayout = new javax.swing.GroupLayout(jPanel_Referential);
        jPanel_Referential.setLayout(jPanel_ReferentialLayout);
        jPanel_ReferentialLayout.setHorizontalGroup(
            jPanel_ReferentialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ReferentialLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jButton_Respo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Unit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Place)
                .addContainerGap(470, Short.MAX_VALUE))
        );
        jPanel_ReferentialLayout.setVerticalGroup(
            jPanel_ReferentialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ReferentialLayout.createSequentialGroup()
                .addGroup(jPanel_ReferentialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Unit)
                    .addComponent(jButton_Respo)
                    .addComponent(jButton_Place))
                .addGap(0, 199, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Referential", jPanel_Referential);

        jButton_ActGraph.setText("Activities Graph");

        jButton_ActStateGraph.setText("Activities / State Graph");
        jButton_ActStateGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActStateGraphActionPerformed(evt);
            }
        });

        jButton_ExportMSProject.setText("Export To MS Project");

        javax.swing.GroupLayout jPanel_ExportLayout = new javax.swing.GroupLayout(jPanel_Export);
        jPanel_Export.setLayout(jPanel_ExportLayout);
        jPanel_ExportLayout.setHorizontalGroup(
            jPanel_ExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ExportLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jButton_ActStateGraph)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_ActGraph)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_ExportMSProject)
                .addContainerGap(296, Short.MAX_VALUE))
        );
        jPanel_ExportLayout.setVerticalGroup(
            jPanel_ExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ExportLayout.createSequentialGroup()
                .addGroup(jPanel_ExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_ActGraph)
                    .addComponent(jButton_ActStateGraph)
                    .addComponent(jButton_ExportMSProject))
                .addGap(0, 199, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Export", jPanel_Export);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
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

    private void jButton_ActStateGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActStateGraphActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ActStateGraphActionPerformed

    private void jButton_StateListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_StateListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_StateListActionPerformed

    private void jButton_Act_ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Act_ListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Act_ListActionPerformed

    private void jButton_DeconnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeconnectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_DeconnectionActionPerformed

    private void jButton_NewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NewProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_NewProjectActionPerformed

    private void jButton_LoadProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LoadProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_LoadProjectActionPerformed

    private void jButton_NewActMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_NewActMouseClicked
 // TODO add your handling code here:
        new New_Activity(this, true, objets);
    }//GEN-LAST:event_jButton_NewActMouseClicked

    private void jButton_NewActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NewActActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton_NewActActionPerformed

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
    private javax.swing.JButton jButtonTargetGroup;
    private javax.swing.JButton jButton_ActGraph;
    private javax.swing.JButton jButton_ActStateGraph;
    private javax.swing.JButton jButton_Act_List;
    private javax.swing.JButton jButton_AllocHumanResource;
    private javax.swing.JButton jButton_AllocMatResource;
    private javax.swing.JButton jButton_Deconnection;
    private javax.swing.JButton jButton_Doc;
    private javax.swing.JButton jButton_Estimation;
    private javax.swing.JButton jButton_ExportList;
    private javax.swing.JButton jButton_ExportMSProject;
    private javax.swing.JButton jButton_ExportPDF;
    private javax.swing.JButton jButton_Human;
    private javax.swing.JButton jButton_LoadProject;
    private javax.swing.JButton jButton_Material;
    private javax.swing.JButton jButton_Meeting;
    private javax.swing.JButton jButton_NewAct;
    private javax.swing.JButton jButton_NewHuman;
    private javax.swing.JButton jButton_NewMaterial;
    private javax.swing.JButton jButton_NewProject;
    private javax.swing.JButton jButton_NewReq;
    private javax.swing.JButton jButton_NewRisk;
    private javax.swing.JButton jButton_New_Element;
    private javax.swing.JButton jButton_Place;
    private javax.swing.JButton jButton_Respo;
    private javax.swing.JButton jButton_ShowAsList;
    private javax.swing.JButton jButton_ShowTree;
    private javax.swing.JButton jButton_StateList;
    private javax.swing.JButton jButton_Unit;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel_WP;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable_RH;
    private javax.swing.JTable jTable_WBS;
    // End of variables declaration//GEN-END:variables

    
}
