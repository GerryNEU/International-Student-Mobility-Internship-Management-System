/*
 * ConfigureASystem.java
 * Member 4: System Admin & Data Specialist
 * Enhanced with JavaFaker for dummy data generation
 */
package business;

import business.employee.Employee;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.role.*;
import business.useraccount.UserAccount;
import business.workqueue.*;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 * System Configuration with JavaFaker Data Generation
 * @author Member4
 */
public class ConfigureASystem {
    
    private static Faker faker = new Faker(new Locale("en-US"));
    private static Random random = new Random();
    
    /**
     * Main configuration method - sets up the entire ecosystem
     */
    public static EcoSystem configure() {
        
        EcoSystem system = EcoSystem.getInstance();
        
        // 1. Create a Network
        Network network = system.createAndAddNetwork();
        network.setName("Global Education Network");
        
        // ====================================================================
        // 2. Create Enterprises
        // ====================================================================
        Enterprise homeUniv = network.getEnterpriseDirectory().createAndAddEnterprise(
                "Northeastern University", Enterprise.EnterpriseType.HomeUniversity);
        Enterprise hostUniv = network.getEnterpriseDirectory().createAndAddEnterprise(
                "Oxford University", Enterprise.EnterpriseType.HostUniversity);
        Enterprise government = network.getEnterpriseDirectory().createAndAddEnterprise(
                "US Immigration Services", Enterprise.EnterpriseType.VisaGovernment);
        Enterprise corporate = network.getEnterpriseDirectory().createAndAddEnterprise(
                "Tech Corp International", Enterprise.EnterpriseType.Corporate);
        
        // ====================================================================
        // 3. Create Organizations
        // ====================================================================
        
        // --- HOME UNIVERSITY Organizations ---
        Organization appOrg = homeUniv.getOrganizationDirectory().createOrganization(Organization.Type.ApplicationProcessing);
        Organization studentOrg = homeUniv.getOrganizationDirectory().createOrganization(Organization.Type.StudentAffairs);
        Organization finOrg = homeUniv.getOrganizationDirectory().createOrganization(Organization.Type.FinancialAid);
        Organization regOrg = homeUniv.getOrganizationDirectory().createOrganization(Organization.Type.Registrar);

        // --- HOST UNIVERSITY Organizations ---
        Organization adminOrg = hostUniv.getOrganizationDirectory().createOrganization(Organization.Type.InternationalAdmissions);
        Organization hostRegOrg = hostUniv.getOrganizationDirectory().createOrganization(Organization.Type.Registrar);

        // --- GOVERNMENT Organizations ---
        Organization visaOrg = government.getOrganizationDirectory().createOrganization(Organization.Type.Operations);
        Organization legalOrg = government.getOrganizationDirectory().createOrganization(Organization.Type.LegalCompliance);

        // --- CORPORATE Organizations ---
        Organization hrOrg = corporate.getOrganizationDirectory().createOrganization(Organization.Type.TalentAcquisition);
        Organization opsOrg = corporate.getOrganizationDirectory().createOrganization(Organization.Type.Operations);

        // ====================================================================
        // 4. Create Core Staff Users
        // ====================================================================
        
        // --- SYSTEM ADMIN (at EcoSystem level) ---
        Employee sysAdmin = system.getEmployeeDirectory().createEmployee("System Administrator");
        system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", sysAdmin, new SystemAdminRole());

        // --- SYSTEM AUDITOR (at EcoSystem level) ---
        Employee sysAuditor = system.getEmployeeDirectory().createEmployee("System Auditor");
        system.getUserAccountDirectory().createUserAccount("auditor", "auditor", sysAuditor, new SystemAuditorRole());

        // --- HOME UNIVERSITY Staff ---
        Employee mobilityOfficer = appOrg.getEmployeeDirectory().createEmployee("Dr. Sarah Chen");
        appOrg.getUserAccountDirectory().createUserAccount("officer", "officer", mobilityOfficer, new MobilityOfficerRole());
        
        Employee finAuditor = finOrg.getEmployeeDirectory().createEmployee("Michael Thompson");
        finOrg.getUserAccountDirectory().createUserAccount("finance", "finance", finAuditor, new FinancialAuditorRole());
        
        Employee registrar = regOrg.getEmployeeDirectory().createEmployee("Emily Davis");
        regOrg.getUserAccountDirectory().createUserAccount("registrar", "registrar", registrar, new RegistrarRole());

        // --- HOST UNIVERSITY Staff ---
        Employee adminOfficer = adminOrg.getEmployeeDirectory().createEmployee("Prof. James Wilson");
        adminOrg.getUserAccountDirectory().createUserAccount("admissions", "admissions", adminOfficer, new AdmissionsOfficerRole());

        // --- GOVERNMENT Staff ---
        Employee visaSpec = visaOrg.getEmployeeDirectory().createEmployee("Agent Robert Brown");
        visaOrg.getUserAccountDirectory().createUserAccount("visa", "visa", visaSpec, new VisaSpecialistRole());
        
        Employee legalVerifier = legalOrg.getEmployeeDirectory().createEmployee("Attorney Lisa Martinez");
        legalOrg.getUserAccountDirectory().createUserAccount("legal", "legal", legalVerifier, new LegalVerifierRole());

        // --- CORPORATE Staff ---
        Employee recruiter = hrOrg.getEmployeeDirectory().createEmployee("Jennifer Lee");
        hrOrg.getUserAccountDirectory().createUserAccount("recruiter", "recruiter", recruiter, new CorporateRecruiterRole());
        
        Employee supervisor = opsOrg.getEmployeeDirectory().createEmployee("David Kim");
        opsOrg.getUserAccountDirectory().createUserAccount("supervisor", "supervisor", supervisor, new SiteSupervisorRole());

        // ====================================================================
        // 5. Create ONE demo student for quick testing
        // ====================================================================
        Employee demoStudent = studentOrg.getEmployeeDirectory().createEmployee("John Demo");
        studentOrg.getUserAccountDirectory().createUserAccount("student", "student", demoStudent, new StudentRole());

        return system;
    }
    
    /**
     * Generate dummy data using JavaFaker
     * Call this method when admin clicks "Populate Data" button
     * 
     * @param system The EcoSystem instance
     * @param numStudents Number of students to generate (default 20)
     * @param numCompanies Number of companies to generate (default 5)
     */
    public static void populateFakeData(EcoSystem system, int numStudents, int numCompanies) {
        
        Network network = system.getNetworkList().get(0);
        
        // Find Home University and its Student Affairs org
        Enterprise homeUniv = findEnterpriseByType(network, Enterprise.EnterpriseType.HomeUniversity);
        Enterprise hostUniv = findEnterpriseByType(network, Enterprise.EnterpriseType.HostUniversity);
        
        if (homeUniv == null || hostUniv == null) {
            System.out.println("Error: Required enterprises not found!");
            return;
        }
        
        Organization studentOrg = findOrganizationByType(homeUniv, Organization.Type.StudentAffairs);
        Organization appOrg = findOrganizationByType(homeUniv, Organization.Type.ApplicationProcessing);
        Organization adminOrg = findOrganizationByType(hostUniv, Organization.Type.InternationalAdmissions);
        
        if (studentOrg == null || appOrg == null) {
            System.out.println("Error: Required organizations not found!");
            return;
        }
        
        // ====================================================================
        // Generate Fake Students
        // ====================================================================
        ArrayList<UserAccount> generatedStudents = new ArrayList<>();
        
        for (int i = 1; i <= numStudents; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String fullName = firstName + " " + lastName;
            
            // Create employee and user account
            Employee student = studentOrg.getEmployeeDirectory().createEmployee(fullName);
            String username = (firstName.toLowerCase() + "." + lastName.toLowerCase()).replaceAll(" ", "");
            
            // Ensure unique username
            username = username + i;
            
            UserAccount studentAccount = studentOrg.getUserAccountDirectory().createUserAccount(
                    username, 
                    "password123", 
                    student, 
                    new StudentRole()
            );
            
            generatedStudents.add(studentAccount);
        }
        
        System.out.println("✓ Generated " + numStudents + " fake students");
        
        // ====================================================================
        // Generate Fake Companies (add to Corporate directory)
        // ====================================================================
        String[] industries = {"Technology", "Finance", "Healthcare", "Consulting", "Manufacturing"};
        
        for (int i = 1; i <= numCompanies; i++) {
            String companyName = faker.company().name();
            Enterprise company = network.getEnterpriseDirectory().createAndAddEnterprise(
                    companyName, 
                    Enterprise.EnterpriseType.Corporate
            );
            
            // Add HR organization to each company
            Organization hrOrg = company.getOrganizationDirectory().createOrganization(Organization.Type.TalentAcquisition);
            
            // Create a recruiter for each company
            String recruiterName = faker.name().fullName();
            Employee recruiterEmp = hrOrg.getEmployeeDirectory().createEmployee(recruiterName);
            hrOrg.getUserAccountDirectory().createUserAccount(
                    "recruiter" + i, 
                    "password123", 
                    recruiterEmp, 
                    new CorporateRecruiterRole()
            );
        }
        
        System.out.println("✓ Generated " + numCompanies + " fake companies");
        
        // ====================================================================
        // Generate Sample WorkRequests (Pending Applications)
        // ====================================================================
        String[] majors = {"Computer Science", "Data Science", "Business Analytics", 
                           "Information Systems", "Electrical Engineering", "Mechanical Engineering",
                           "Economics", "Finance", "Biology", "Chemistry"};
        
        String[] universities = {"Oxford University", "Cambridge University", "MIT", 
                                 "Stanford University", "ETH Zurich"};
        
        // Create some pending applications (about half of the students)
        int numPendingApps = numStudents / 2;
        for (int i = 0; i < numPendingApps && i < generatedStudents.size(); i++) {
            UserAccount studentAccount = generatedStudents.get(i);
            
            StudyAbroadApplication app = new StudyAbroadApplication();
            app.setSender(studentAccount);
            app.setMajor(majors[random.nextInt(majors.length)]);
            app.setCurrentGPA(generateRandomGPA());
            app.setSelectedUniversity(universities[random.nextInt(universities.length)]);
            app.setMessage("Study Abroad Application - " + studentAccount.getEmployee().getName());
            app.setStatus(getRandomStatus());
            app.setStudentId(generateStudentId());
            
            // Add to Mobility Officer's queue
            appOrg.getWorkQueue().getWorkRequestList().add(app);
            
            // Add to student's own queue for tracking
            studentAccount.getWorkQueue().getWorkRequestList().add(app);
        }
        
        System.out.println("✓ Generated " + numPendingApps + " pending applications");
        
        // ====================================================================
        // Generate Some Nomination Requests (for Host University)
        // ====================================================================
        int numNominations = numStudents / 4;
        for (int i = 0; i < numNominations && i < generatedStudents.size(); i++) {
            UserAccount studentAccount = generatedStudents.get(i);
            
            // First create a study abroad application
            StudyAbroadApplication app = new StudyAbroadApplication();
            app.setSender(studentAccount);
            app.setMajor(majors[random.nextInt(majors.length)]);
            app.setCurrentGPA(generateRandomGPA());
            app.setSelectedUniversity("Oxford University"); // Target the host university we have
            app.setMessage("Nomination - " + studentAccount.getEmployee().getName());
            app.setStatus("Nominated");
            
            // Create nomination request
            NominationRequest nomination = new NominationRequest();
            nomination.setStudentApplication(app);
            nomination.setSender(studentAccount);
            nomination.setMessage("Nomination for " + studentAccount.getEmployee().getName());
            nomination.setStatus("Pending Review");
            
            // Add to Host University Admissions queue
            if (adminOrg != null) {
                adminOrg.getWorkQueue().getWorkRequestList().add(nomination);
            }
        }
        
        System.out.println("✓ Generated " + numNominations + " nomination requests");
        Organization finOrg = findOrganizationByType(homeUniv, Organization.Type.FinancialAid);

        if (finOrg != null && generatedStudents.size() > 0) {
            int numFinancialRequests = numStudents / 3; // About 33% of students

            for (int i = 0; i < numFinancialRequests && i < generatedStudents.size(); i++) {
                UserAccount studentAccount = generatedStudents.get(i);

                // Create a study abroad application for reference
                StudyAbroadApplication app = new StudyAbroadApplication();
                app.setSender(studentAccount);
                app.setMajor(majors[random.nextInt(majors.length)]);
                app.setCurrentGPA(generateRandomGPA());
                app.setSelectedUniversity(universities[random.nextInt(universities.length)]);
                app.setMessage("Financial aid needed for study abroad");
                app.setStatus("Nominated");

                // Create financial clearance request
                FinancialClearanceRequest fcr = new FinancialClearanceRequest();
                fcr.setStudentApplication(app);
                fcr.setSender(studentAccount);
                fcr.setMessage("Financial clearance request for " + 
                              studentAccount.getEmployee().getName());
                fcr.setStatus("Pending Review");

                // Set grant amount based on GPA
                double gpa = app.getCurrentGPA();
                double grantRequested;
                if (gpa >= 3.8) {
                    grantRequested = 20000.0;
                } else if (gpa >= 3.5) {
                    grantRequested = 15000.0;
                } else if (gpa >= 3.0) {
                    grantRequested = 10000.0;
                } else {
                    grantRequested = 5000.0;
                }
                fcr.setGrantAmountRequested(grantRequested);

                // Add to Financial Aid Organization's queue
                finOrg.getWorkQueue().getWorkRequestList().add(fcr);
            }

            System.out.println("✓ Generated " + numFinancialRequests + 
                              " financial clearance requests");
        }
        System.out.println("========================================");
        System.out.println("Data population complete!");
    }
    
    /**
     * Convenience method with default values
     */
    public static void populateFakeData(EcoSystem system) {
        populateFakeData(system, 20, 5);
    }
    
    // ========================================================================
    // Helper Methods
    // ========================================================================
    
    private static Enterprise findEnterpriseByType(Network network, Enterprise.EnterpriseType type) {
        for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (e.toString().contains(type.getValue()) || 
                (type == Enterprise.EnterpriseType.HomeUniversity && e.getName().contains("Northeastern")) ||
                (type == Enterprise.EnterpriseType.HostUniversity && e.getName().contains("Oxford"))) {
                return e;
            }
        }
        // Fallback: check by enterprise type through class name
        for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            String className = e.getClass().getSimpleName();
            if (type == Enterprise.EnterpriseType.HomeUniversity && className.contains("HomeUniversity")) {
                return e;
            }
            if (type == Enterprise.EnterpriseType.HostUniversity && className.contains("HostUniversity")) {
                return e;
            }
        }
        return null;
    }
    
    private static Organization findOrganizationByType(Enterprise enterprise, Organization.Type type) {
        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (o.getName() != null && o.getName().equals(type.getValue())) {
                return o;
            }
        }
        return null;
    }
    
    private static double generateRandomGPA() {
        // Generate GPA between 2.5 and 4.0
        double gpa = 2.5 + (random.nextDouble() * 1.5);
        return Math.round(gpa * 100.0) / 100.0; // Round to 2 decimal places
    }
    
    private static String generateStudentId() {
        // Generate student ID like "002xxxxxx"
        return String.format("002%06d", random.nextInt(999999));
    }
    
    private static String getRandomStatus() {
        String[] statuses = {"Pending Review", "Under Review", "Pending Financial Clearance"};
        return statuses[random.nextInt(statuses.length)];
    }
    
    // ========================================================================
    // Statistics Methods (for System Auditor Dashboard)
    // ========================================================================
    
    /**
     * Get total number of students in the system
     */
    public static int getTotalStudentCount(EcoSystem system) {
        int count = 0;
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount account : org.getUserAccountDirectory().getUserAccountList()) {
                        if (account.getRole() instanceof StudentRole) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    
    /**
     * Get total number of pending work requests
     */
    public static int getTotalPendingRequests(EcoSystem system) {
        int count = 0;
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (WorkRequest request : org.getWorkQueue().getWorkRequestList()) {
                        if (request.getStatus() != null && 
                            (request.getStatus().contains("Pending") || request.getStatus().contains("Review"))) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    
    /**
     * Get count of applications by status
     */
    public static int getApplicationCountByStatus(EcoSystem system, String status) {
        int count = 0;
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (WorkRequest request : org.getWorkQueue().getWorkRequestList()) {
                        if (request.getStatus() != null && request.getStatus().equalsIgnoreCase(status)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    
    /**
     * Get number of enterprises by type
     */
    public static int getEnterpriseCountByType(EcoSystem system, Enterprise.EnterpriseType type) {
        int count = 0;
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                String className = enterprise.getClass().getSimpleName();
                if (className.toLowerCase().contains(type.getValue().toLowerCase().replace(" ", ""))) {
                    count++;
                }
            }
        }
        return count;
    }
}