/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.employee.Employee;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.role.AdmissionsOfficerRole;
import business.role.CorporateRecruiterRole;
import business.role.FinancialAuditorRole;
import business.role.LegalVerifierRole;
import business.role.MobilityOfficerRole;
import business.role.RegistrarRole;
import business.role.StudentRole;
import business.role.SystemAdminRole;
import business.role.VisaSpecialistRole;
import business.role.SiteSupervisorRole;
import business.useraccount.UserAccount;

/**
 *
 * @author gerrysu
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        // 1. Create a Network
        Network network = system.createAndAddNetwork();
        network.setName("Boston Network");
        
        // 2. Create Enterprises
        Enterprise homeUniv = network.getEnterpriseDirectory().createAndAddEnterprise("Northeastern University", Enterprise.EnterpriseType.HomeUniversity);
        Enterprise hostUniv = network.getEnterpriseDirectory().createAndAddEnterprise("Oxford University", Enterprise.EnterpriseType.HostUniversity);
        Enterprise government = network.getEnterpriseDirectory().createAndAddEnterprise("US Government", Enterprise.EnterpriseType.VisaGovernment);
        Enterprise corporate = network.getEnterpriseDirectory().createAndAddEnterprise("Tech Corp", Enterprise.EnterpriseType.Corporate);
        
        // 3. Create Organizations & Users
        
        // --- A. SYSTEM ADMIN ---
        Employee sysAdmin = system.getEmployeeDirectory().createEmployee("SysAdmin");
        system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", sysAdmin, new SystemAdminRole());

        // --- B. HOME UNIVERSITY ---
        // 1. Application Processing
        Organization appOrg = homeUniv.getOrganizationDirectory().createOrganization(Organization.Type.ApplicationProcessing);
        Employee mobilityOfficer = appOrg.getEmployeeDirectory().createEmployee("Mobility Officer");
        appOrg.getUserAccountDirectory().createUserAccount("officer", "officer", mobilityOfficer, new MobilityOfficerRole());
        
        // 2. Student Affairs
        Organization studentOrg = homeUniv.getOrganizationDirectory().createOrganization(Organization.Type.StudentAffairs);
        Employee student = studentOrg.getEmployeeDirectory().createEmployee("Student John");
        studentOrg.getUserAccountDirectory().createUserAccount("student", "student", student, new StudentRole());
        
        // 3. Financial Aid
        Organization finOrg = homeUniv.getOrganizationDirectory().createOrganization(Organization.Type.FinancialAid);
        Employee auditor = finOrg.getEmployeeDirectory().createEmployee("Financial Auditor");
        finOrg.getUserAccountDirectory().createUserAccount("auditor", "auditor", auditor, new FinancialAuditorRole());
        
        // 4. Registrar (Home)
        Organization homeRegOrg = homeUniv.getOrganizationDirectory().createOrganization(Organization.Type.Registrar);
        Employee homeRegistrar = homeRegOrg.getEmployeeDirectory().createEmployee("Home Registrar");
        homeRegOrg.getUserAccountDirectory().createUserAccount("registrar", "registrar", homeRegistrar, new RegistrarRole());

        // --- C. HOST UNIVERSITY ---
        // 1. International Admissions
        Organization adminOrg = hostUniv.getOrganizationDirectory().createOrganization(Organization.Type.InternationalAdmissions);
        Employee adminOfficer = adminOrg.getEmployeeDirectory().createEmployee("Admissions Officer");
        adminOrg.getUserAccountDirectory().createUserAccount("admissions", "admissions", adminOfficer, new AdmissionsOfficerRole());
        
        // 2. Registrar (Host) - Fulfills 2 Organizations Rule
        Organization hostRegOrg = hostUniv.getOrganizationDirectory().createOrganization(Organization.Type.Registrar);
        Employee hostRegistrar = hostRegOrg.getEmployeeDirectory().createEmployee("Host Registrar");
        hostRegOrg.getUserAccountDirectory().createUserAccount("hostregistrar", "hostregistrar", hostRegistrar, new RegistrarRole());

        // --- D. GOVERNMENT ---
        // 1. Operations (Visa)
        Organization visaOrg = government.getOrganizationDirectory().createOrganization(Organization.Type.Operations);
        Employee visaSpec = visaOrg.getEmployeeDirectory().createEmployee("Visa Specialist");
        visaOrg.getUserAccountDirectory().createUserAccount("visa", "visa", visaSpec, new VisaSpecialistRole());
        
        // 2. Legal Compliance
        Organization legalOrg = government.getOrganizationDirectory().createOrganization(Organization.Type.LegalCompliance);
        Employee lawyer = legalOrg.getEmployeeDirectory().createEmployee("Legal Verifier");
        legalOrg.getUserAccountDirectory().createUserAccount("legal", "legal", lawyer, new LegalVerifierRole());

        // --- E. CORPORATE ---
        // 1. Talent Acquisition
        Organization hrOrg = corporate.getOrganizationDirectory().createOrganization(Organization.Type.TalentAcquisition);
        Employee recruiter = hrOrg.getEmployeeDirectory().createEmployee("Corporate Recruiter");
        hrOrg.getUserAccountDirectory().createUserAccount("recruiter", "recruiter", recruiter, new CorporateRecruiterRole());
        
        // 2. Site Supervision - Fulfills 2 Organizations Rule
        Organization siteOrg = corporate.getOrganizationDirectory().createOrganization(Organization.Type.SiteSupervision);
        Employee supervisor = siteOrg.getEmployeeDirectory().createEmployee("Site Supervisor");
        siteOrg.getUserAccountDirectory().createUserAccount("supervisor", "supervisor", supervisor, new SiteSupervisorRole());
        
        return system;
    }    
}
