/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.workqueue;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gerrysu
 */
public class CourseTransferRequest extends WorkRequest {

    // Map of Course Code -> Grade Received
    private Map<String, String> coursesTaken; 
    private int creditsEarned;
    private boolean transcriptVerified;
    private String hostUniversityName;

    public CourseTransferRequest() {
        coursesTaken = new HashMap<>();
    }

    public Map<String, String> getCoursesTaken() {
        return coursesTaken;
    }

    public void addCourse(String courseCode, String grade) {
        coursesTaken.put(courseCode, grade);
    }

    public int getCreditsEarned() {
        return creditsEarned;
    }

    public void setCreditsEarned(int creditsEarned) {
        this.creditsEarned = creditsEarned;
    }

    public boolean isTranscriptVerified() {
        return transcriptVerified;
    }

    public void setTranscriptVerified(boolean transcriptVerified) {
        this.transcriptVerified = transcriptVerified;
    }

    public String getHostUniversityName() {
        return hostUniversityName;
    }

    public void setHostUniversityName(String hostUniversityName) {
        this.hostUniversityName = hostUniversityName;
    }    
}
