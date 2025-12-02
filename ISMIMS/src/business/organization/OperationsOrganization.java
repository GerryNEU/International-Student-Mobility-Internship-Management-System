/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization;

import business.role.Role;
import business.role.VisaSpecialistRole;
import java.util.ArrayList;

/**
 *
 * @author gerrysu
 */
public class OperationsOrganization extends Organization {

    public OperationsOrganization() {
        super(Organization.Type.Operations.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new VisaSpecialistRole());
        return roles;
    }    
}
