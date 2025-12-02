/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.employee.Employee;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.role.MobilityOfficerRole;
import business.role.StudentRole;
import business.role.SystemAdminRole;
import business.useraccount.UserAccount;

/**
 *
 * @author gerrysu
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        // 1. Create a Network (e.g., "Boston")
        Network network = system.createAndAddNetwork();
        network.setName("Boston Network");
        
        // 2. Create an Enterprise (e.g., "Northeastern University")
        Enterprise university = network.getEnterpriseDirectory().createAndAddEnterprise("Northeastern University", Enterprise.EnterpriseType.HomeUniversity);
        
        // 3. Create Organizations within the University
        Organization appOrg = university.getOrganizationDirectory().createOrganization(Organization.Type.ApplicationProcessing);
        Organization studentOrg = university.getOrganizationDirectory().createOrganization(Organization.Type.StudentAffairs);
        
        // 4. Create Employees (Real people)
        Employee sysAdmin = system.getEmployeeDirectory().createEmployee("SysAdmin User");
        Employee mobilityOfficer = appOrg.getEmployeeDirectory().createEmployee("Jane Mobility");
        Employee student = studentOrg.getEmployeeDirectory().createEmployee("John Student");
        
        // 5. Create User Accounts (Login credentials)
        
        // A. System Admin (Global)
        UserAccount uaAdmin = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", sysAdmin, new SystemAdminRole());
        
        // B. Mobility Officer (In Application Processing Org)
        UserAccount uaOfficer = appOrg.getUserAccountDirectory().createUserAccount("officer", "officer", mobilityOfficer, new MobilityOfficerRole());
        
        // C. Student (In Student Affairs Org)
        UserAccount uaStudent = studentOrg.getUserAccountDirectory().createUserAccount("student", "student", student, new StudentRole());
        
        return system;
    }    
}
