/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization;

import business.role.CorporateRecruiterRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author gerrysu
 */
public class TalentAcquisitionOrganization extends Organization {
    
    public TalentAcquisitionOrganization() {
        super(Organization.Type.TalentAcquisition.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CorporateRecruiterRole());
        return roles;
    }    
}
