/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.workqueue;

/**
 *
 * @author gerrysu
 */
public class NominationRequest extends WorkRequest {

    private StudyAbroadApplication studentApplication;
    private boolean isNominated;
    private String nominationNotes;

    public NominationRequest() {
        // Default constructor
        super();
        isNominated = true; // Default to true since this object creation implies nomination
    }

    public StudyAbroadApplication getStudentApplication() {
        return studentApplication;
    }

    public void setStudentApplication(StudyAbroadApplication studentApplication) {
        this.studentApplication = studentApplication;
    }

    public boolean isIsNominated() {
        return isNominated;
    }

    public void setIsNominated(boolean isNominated) {
        this.isNominated = isNominated;
    }

    public String getNominationNotes() {
        return nominationNotes;
    }

    public void setNominationNotes(String nominationNotes) {
        this.nominationNotes = nominationNotes;
    }
    
    @Override
    public String toString() {
        if(studentApplication != null) {
            return "Nomination: " + studentApplication.getSender().getEmployee().getName();
        }
        return "Nomination Request";
    }    
}
