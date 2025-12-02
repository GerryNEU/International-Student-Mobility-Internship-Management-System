/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization;

import business.role.LegalVerifierRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author gerrysu
 */
public class LegalComplianceOrganization extends Organization{

    public LegalComplianceOrganization() {
        super(Organization.Type.LegalCompliance.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new LegalVerifierRole());
        return roles;
    }    
}
