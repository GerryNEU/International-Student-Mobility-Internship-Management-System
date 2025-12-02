/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization;

import business.role.MobilityOfficerRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author gerrysu
 */
public class ApplicationProcessingOrganization extends Organization{
    
    public ApplicationProcessingOrganization() {
        super(Organization.Type.ApplicationProcessing.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new MobilityOfficerRole());
        return roles;
    }    
}
