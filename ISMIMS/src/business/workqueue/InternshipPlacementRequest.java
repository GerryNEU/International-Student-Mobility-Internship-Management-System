/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.workqueue;

import java.util.ArrayList;

/**
 *
 * @author gerrysu
 */
public class InternshipPlacementRequest extends WorkRequest{

    private String studentSkills;
    private String preferredIndustry;
    private String companyPlaced;
    private boolean offerAccepted;
    private String positionOffered;
    private ArrayList<String> resumeKeywords;
    private String supervisorFeedback;

    public String getSupervisorFeedback() {
        return supervisorFeedback;
    }

    public void setSupervisorFeedback(String supervisorFeedback) {
        this.supervisorFeedback = supervisorFeedback;
    }

    public InternshipPlacementRequest(){
        super();
        resumeKeywords = new ArrayList<>();
    }

    public String getStudentSkills() {
        return studentSkills;
    }

    public void setStudentSkills(String studentSkills) {
        this.studentSkills = studentSkills;
    }

    public String getPreferredIndustry() {
        return preferredIndustry;
    }

    public void setPreferredIndustry(String preferredIndustry) {
        this.preferredIndustry = preferredIndustry;
    }

    public String getCompanyPlaced() {
        return companyPlaced;
    }

    public void setCompanyPlaced(String companyPlaced) {
        this.companyPlaced = companyPlaced;
    }

    public boolean isOfferAccepted() {
        return offerAccepted;
    }

    public void setOfferAccepted(boolean offerAccepted) {
        this.offerAccepted = offerAccepted;
    }    
    
    public String getPositionOffered() {
        return positionOffered;
    }

    public void setPositionOffered(String positionOffered) {
        this.positionOffered = positionOffered;
    }
    
    @Override
    public String toString() {
        if (getSender() != null) {
            return getSender().getEmployee().getName();
        }
        return "Internship Request";
    }
    
}
