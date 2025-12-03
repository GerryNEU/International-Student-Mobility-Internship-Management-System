/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.workqueue;

import java.util.Date;

/**
 *
 * @author gerrysu
 */
public class StudyAbroadApplication extends WorkRequest{

    private String studentId;
    private String major;
    private double currentGPA;
    private String desiredCountry;
    private String selectedUniversity; // The Host University name
    private String result; // Admission Result
    private double scholarshipAmount;        // Approved scholarship amount
    private String financialStatus;          // "Pending" / "Aid Calculated" / "Funds Released"
    
    // Add these new fields for admission offer
    private java.util.Date offerDate;        // When offer was given
    private boolean offerAccepted;           // Student accepted offer?
    private java.util.Date offerAcceptanceDate;  // When student accepted
    

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getCurrentGPA() {
        return currentGPA;
    }

    public void setCurrentGPA(double currentGPA) {
        this.currentGPA = currentGPA;
    }

    public String getDesiredCountry() {
        return desiredCountry;
    }

    public void setDesiredCountry(String desiredCountry) {
        this.desiredCountry = desiredCountry;
    }

    public String getSelectedUniversity() {
        return selectedUniversity;
    }

    public void setSelectedUniversity(String selectedUniversity) {
        this.selectedUniversity = selectedUniversity;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }    

    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    public void setScholarshipAmount(double scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }

    public String getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(String financialStatus) {
        this.financialStatus = financialStatus;
    }

    public Date getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
    }

    public boolean isOfferAccepted() {
        return offerAccepted;
    }

    public void setOfferAccepted(boolean offerAccepted) {
        this.offerAccepted = offerAccepted;
    }

    public Date getOfferAcceptanceDate() {
        return offerAcceptanceDate;
    }

    public void setOfferAcceptanceDate(Date offerAcceptanceDate) {
        this.offerAcceptanceDate = offerAcceptanceDate;
    }
    
}
