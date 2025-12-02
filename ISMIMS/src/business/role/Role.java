/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.role;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.useraccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author gerrysu
 */
public abstract class Role {
    
    public enum RoleType{
        SystemAdmin("SystemAdmin"),
        MobilityOfficer("MobilityOfficer"),
        Student("Student"),
        AdmissionsOfficer("AdmissionsOfficer"),
        VisaSpecialist("VisaSpecialist"),
        LegalVerifier("LegalVerifier"),
        FinancialAuditor("FinancialAuditor"),
        Registrar("Registrar"),
        SiteSupervisor("SiteSupervisor"),
        CorporateRecruiter("CorporateRecruiter");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }    
}
