/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.workqueue;

/**
 *
 * @author gerrysu
 */
public class FinancialClearanceRequest extends WorkRequest {

    private double grantAmountRequested;
    private double approvedAmount;
    private boolean auditPassed;
    private String financialProofPath; // Path to bank statement file

    public double getGrantAmountRequested() {
        return grantAmountRequested;
    }

    public void setGrantAmountRequested(double grantAmountRequested) {
        this.grantAmountRequested = grantAmountRequested;
    }

    public double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public boolean isAuditPassed() {
        return auditPassed;
    }

    public void setAuditPassed(boolean auditPassed) {
        this.auditPassed = auditPassed;
    }

    public String getFinancialProofPath() {
        return financialProofPath;
    }

    public void setFinancialProofPath(String financialProofPath) {
        this.financialProofPath = financialProofPath;
    }    
}
