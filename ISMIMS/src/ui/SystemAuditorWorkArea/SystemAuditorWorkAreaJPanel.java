/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.SystemAuditorWorkArea;

import business.ConfigureASystem;
import business.EcoSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.useraccount.UserAccount;
import business.workqueue.WorkRequest;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author gerrysu
 */
public class SystemAuditorWorkAreaJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    /**
     * Creates new form SystemAuditorWorkAreaJPanel
     */
    public SystemAuditorWorkAreaJPanel(EcoSystem system) {
        initComponents();
        
        this.system = system;
        
        loadStatistics();
        populateStatusTable();
        populateEnterpriseTable();
    }
    
     private void loadStatistics() {
        int studentCount = ConfigureASystem.getTotalStudentCount(system);
        int pendingCount = ConfigureASystem.getTotalPendingRequests(system);
        
        int enterpriseCount = 0;
        int approvedCount = 0;
        
        for (Network network : system.getNetworkList()) {
            enterpriseCount += network.getEnterpriseDirectory().getEnterpriseList().size();
            
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (WorkRequest request : org.getWorkQueue().getWorkRequestList()) {
                        if (request.getStatus() != null && 
                            (request.getStatus().contains("Approved") || request.getStatus().contains("Admitted"))) {
                            approvedCount++;
                        }
                    }
                }
            }
        }
        
        lblStudentVal.setText("Students: "+ String.valueOf(studentCount));
        lblEntVal.setText("Enterprises: " + String.valueOf(enterpriseCount));
        lblPendingVal.setText("Pending: " + String.valueOf(pendingCount));
        lblAppVal.setText("Approved: " + String.valueOf(approvedCount));
    }
     
     private void populateStatusTable() {
        DefaultTableModel model = (DefaultTableModel) tblStatusStats.getModel();
        model.setRowCount(0);
        
        Map<String, Integer> statusCounts = new HashMap<>();
        
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (WorkRequest request : org.getWorkQueue().getWorkRequestList()) {
                        String status = request.getStatus();
                        if (status == null || status.isEmpty()) {
                            status = "Unknown";
                        }
                        statusCounts.put(status, statusCounts.getOrDefault(status, 0) + 1);
                    }
                }
            }
        }
        
        for (Map.Entry<String, Integer> entry : statusCounts.entrySet()) {
            Object[] row = new Object[2];
            row[0] = entry.getKey();
            row[1] = entry.getValue();
            model.addRow(row);
        }
        
        if (statusCounts.isEmpty()) {
            Object[] row = new Object[2];
            row[0] = "No requests found";
            row[1] = 0;
            model.addRow(row);
        }
    }
    
     
      private void populateEnterpriseTable() {
        DefaultTableModel model = (DefaultTableModel) tblEnterpriseStats.getModel();
        model.setRowCount(0);
        
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                int pending = 0;
                int total = 0;
                
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (WorkRequest request : org.getWorkQueue().getWorkRequestList()) {
                        total++;
                        if (request.getStatus() != null && 
                            (request.getStatus().contains("Pending") || request.getStatus().contains("Review"))) {
                            pending++;
                        }
                    }
                }
                
                Object[] row = new Object[3];
                row[0] = enterprise.getName();
                row[1] = pending;
                row[2] = total;
                model.addRow(row);
            }
        }
    }
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStatusStats = new javax.swing.JTable();
        lblStudentVal = new javax.swing.JLabel();
        lblEntVal = new javax.swing.JLabel();
        lblPendingVal = new javax.swing.JLabel();
        lblAppVal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEnterpriseStats = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblTitle.setText("System Auditor Work Area");

        tblStatusStats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Status", "Count"
            }
        ));
        jScrollPane1.setViewportView(tblStatusStats);

        lblStudentVal.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblStudentVal.setText("Students");

        lblEntVal.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblEntVal.setText("Enterprises");

        lblPendingVal.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblPendingVal.setText("Pending");

        lblAppVal.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblAppVal.setText("Approved");

        jLabel5.setText("Requests by Status");

        jLabel6.setText("Requests by Enterprise");

        tblEnterpriseStats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Enterprise", "Pending", "Total"
            }
        ));
        jScrollPane2.setViewportView(tblEnterpriseStats);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(283, 283, 283))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStudentVal)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)))
                        .addGap(63, 63, 63))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(lblEntVal)
                                .addGap(156, 156, 156)
                                .addComponent(lblPendingVal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                                .addComponent(lblAppVal)))))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblTitle)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStudentVal)
                    .addComponent(lblEntVal)
                    .addComponent(lblPendingVal)
                    .addComponent(lblAppVal))
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel6)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnRefresh)
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        loadStatistics();
        populateStatusTable();
        populateEnterpriseTable();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAppVal;
    private javax.swing.JLabel lblEntVal;
    private javax.swing.JLabel lblPendingVal;
    private javax.swing.JLabel lblStudentVal;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblEnterpriseStats;
    private javax.swing.JTable tblStatusStats;
    // End of variables declaration//GEN-END:variables
}
