/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.workqueue;

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
}
