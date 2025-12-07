/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.workqueue;

/**
 *
 * @author gerrysu
 */
public class VisaSupportRequest extends WorkRequest {

    private String passportNumber;
    private String issuingCountry;
    private boolean legalCheckPassed;
    private boolean financialProofVerified;
    private boolean visaIssued;
    private String visaNumber;
    private StudyAbroadApplication studyAbroadApplication;

    public VisaSupportRequest() {
        super();
        legalCheckPassed = false;
        financialProofVerified = false;
        visaIssued = false;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
    }

    public boolean isLegalCheckPassed() {
        return legalCheckPassed;
    }

    public void setLegalCheckPassed(boolean legalCheckPassed) {
        this.legalCheckPassed = legalCheckPassed;
    }

    public boolean isFinancialProofVerified() {
        return financialProofVerified;
    }

    public void setFinancialProofVerified(boolean financialProofVerified) {
        this.financialProofVerified = financialProofVerified;
    }

    public boolean isVisaIssued() {
        return visaIssued;
    }

    public void setVisaIssued(boolean visaIssued) {
        this.visaIssued = visaIssued;
    }

    public String getVisaNumber() {
        return visaNumber;
    }

    public void setVisaNumber(String visaNumber) {
        this.visaNumber = visaNumber;
    }

    public StudyAbroadApplication getStudyAbroadApplication() {
        return studyAbroadApplication;
    }

    public void setStudyAbroadApplication(StudyAbroadApplication studyAbroadApplication) {
        this.studyAbroadApplication = studyAbroadApplication;
    }
    
    
    @Override
    public String toString() {
        return "Visa Request for " + (getSender() != null ? getSender().getUsername() : "Unknown");
    }    
}
