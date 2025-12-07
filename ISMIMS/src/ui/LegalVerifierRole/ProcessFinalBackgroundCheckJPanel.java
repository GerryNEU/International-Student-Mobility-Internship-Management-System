/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.LegalVerifierRole;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.OperationsOrganization;
import business.organization.Organization;
import business.workqueue.StudyAbroadApplication;
import business.workqueue.VisaSupportRequest;
import business.workqueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author gerrysu
 */
public class ProcessFinalBackgroundCheckJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private VisaSupportRequest request;
    private Organization organization;
    private EcoSystem system;

    /**
     * Creates new form ProcessFinalBackgroundCheckJPanel
     */
    public ProcessFinalBackgroundCheckJPanel(JPanel userProcessContainer, VisaSupportRequest request, Organization organization, EcoSystem system) {
    initComponents();
    
    this.userProcessContainer = userProcessContainer;
    this.request = request;
    this.organization = organization;
    this.system = system;
    
    populateData();
}
    
    private void populateData() {
        if (request == null) return;
        
        // Basic information
        if (request.getSender() != null && request.getSender().getEmployee() != null) {
            txtStudent.setText(request.getSender().getEmployee().getName());
        }
        txtPassport.setText(request.getPassportNumber());
        txtCountry.setText(request.getIssuingCountry());
        
        // Check Financial Support status
        StudyAbroadApplication studentApp = findStudentApplication();
        
        if (studentApp != null && studentApp.isAidApproved()) {
            // Financial support approved
            txtFinanceStatus.setText("✓ Approved: $" + studentApp.getGrantAmount());
            txtFinanceStatus.setForeground(new java.awt.Color(0, 128, 0)); // Green
            chkFinancialProof.setEnabled(true);
        } else if (studentApp != null && studentApp.isAidSaved()) {
            // Aid saved but not approved yet
            txtFinanceStatus.setText("⏳ Pending: $" + studentApp.getGrantAmount());
            txtFinanceStatus.setForeground(new java.awt.Color(255, 165, 0)); // Orange
            chkFinancialProof.setEnabled(false);
        } else {
            // No financial support
            txtFinanceStatus.setText("✗ No Financial Support");
            txtFinanceStatus.setForeground(java.awt.Color.RED);
            chkFinancialProof.setEnabled(false);
        }
        
        // Disable display fields
        txtStudent.setEnabled(false);
        txtPassport.setEnabled(false);
        txtCountry.setEnabled(false);
        txtFinanceStatus.setEnabled(false);
        
        // Load existing status
        chkLegalCheck.setSelected(request.isLegalCheckPassed());
        if (chkFinancialProof.isEnabled()) {
            chkFinancialProof.setSelected(request.isFinancialProofVerified());
        }
    }

    private StudyAbroadApplication findStudentApplication() {
    if (request == null) {
        return null;
    }
    return request.getStudyAbroadApplication();
}
    
    private void goBack() {
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }
    
    
    private Organization findVisaSpecialistOrganization() {
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof OperationsOrganization && 
                        enterprise.getClass().getSimpleName().contains("VisaGovernment")) {
                        return org;
                    }
                }
            }
        }
        return null;
    }
    
     private void forwardToVisaSpecialist() {
        
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise.getClass().getSimpleName().contains("VisaGovernment")) {
                    for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (org.getClass().getSimpleName().contains("Operations")) {
                            org.getWorkQueue().getWorkRequestList().add(request);
                            return;
                        }
                    }
                }
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

        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblStudent = new javax.swing.JLabel();
        lblPassport = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        txtStudent = new javax.swing.JTextField();
        txtPassport = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        chkLegalCheck = new javax.swing.JCheckBox();
        chkFinancialProof = new javax.swing.JCheckBox();
        lblNotes = new javax.swing.JLabel();
        btnApprove = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        lblAid = new javax.swing.JLabel();
        txtFinanceStatus = new javax.swing.JTextField();

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("Background Check Verification");

        lblStudent.setText("Student Name:");

        lblPassport.setText("Passport No:");

        lblCountry.setText("Country:");

        txtStudent.setEnabled(false);

        txtPassport.setEnabled(false);

        txtCountry.setEnabled(false);

        chkLegalCheck.setText("Background Check Passed");

        chkFinancialProof.setText("Financial Proof Verified");

        lblNotes.setText("Verifier Notes:");

        btnApprove.setText("Approve & Forward");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnReject.setText("Reject Application");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        txtNotes.setColumns(20);
        txtNotes.setRows(5);
        jScrollPane1.setViewportView(txtNotes);

        lblAid.setText("Finance Aid:");

        txtFinanceStatus.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPassport)
                                    .addComponent(lblStudent)
                                    .addComponent(lblCountry)
                                    .addComponent(lblAid))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                    .addComponent(txtPassport, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                    .addComponent(txtCountry, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                    .addComponent(chkFinancialProof)
                                    .addComponent(chkLegalCheck)
                                    .addComponent(txtFinanceStatus)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnApprove)
                                .addGap(119, 119, 119)
                                .addComponent(btnReject))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(lblNotes)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnBack)
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStudent)
                    .addComponent(txtStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassport))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCountry))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAid)
                    .addComponent(txtFinanceStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(chkLegalCheck)
                .addGap(18, 18, 18)
                .addComponent(chkFinancialProof)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNotes)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApprove)
                    .addComponent(btnReject))
                .addGap(77, 77, 77))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
         // TODO add your handling code here:
          request.setStatus("Rejected by Legal Verifier");
        
        String notes = txtNotes.getText().trim();
        if (!notes.isEmpty()) {
            request.setResult("Rejected: " + notes);
        } else {
            request.setResult("Rejected by Legal Verifier");
        }
        
        JOptionPane.showMessageDialog(this, 
            "Application has been rejected.", 
            "Rejected", JOptionPane.INFORMATION_MESSAGE);
        
        goBack();
   
    }//GEN-LAST:event_btnRejectActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        // TODO add your handling code here:
  
        if (!chkLegalCheck.isSelected()) {
            JOptionPane.showMessageDialog(this, 
                "Please complete the Background Check first.", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
    
        if (!chkFinancialProof.isEnabled()) {
            JOptionPane.showMessageDialog(this, 
                "Cannot verify financial proof!\n\n" +
                "Student's financial aid must be approved by Financial Auditor first.", 
                "Financial Support Required", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!chkFinancialProof.isSelected()) {
            JOptionPane.showMessageDialog(this, 
                "Please check 'Financial Proof Verified' checkbox.", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        request.setLegalCheckPassed(true);
        request.setFinancialProofVerified(true);
        request.setStatus("Approved - Pending Visa Issuance");
        
        String notes = txtNotes.getText().trim();
        if (!notes.isEmpty()) {
            request.setResult(notes);
        }
        
        
        forwardToVisaSpecialist();
        
        JOptionPane.showMessageDialog(this, 
            "✅ Background Check Approved!\n\n" +
            "Request forwarded to Visa Specialist for visa issuance.", 
            "Success", JOptionPane.INFORMATION_MESSAGE);
        
        goBack();
    
    }//GEN-LAST:event_btnApproveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReject;
    private javax.swing.JCheckBox chkFinancialProof;
    private javax.swing.JCheckBox chkLegalCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAid;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblNotes;
    private javax.swing.JLabel lblPassport;
    private javax.swing.JLabel lblStudent;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtFinanceStatus;
    private javax.swing.JTextArea txtNotes;
    private javax.swing.JTextField txtPassport;
    private javax.swing.JTextField txtStudent;
    // End of variables declaration//GEN-END:variables
}


