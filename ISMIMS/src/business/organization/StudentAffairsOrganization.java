/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization;

import business.role.Role;
import business.role.StudentRole;
import java.util.ArrayList;

/**
 *
 * @author gerrysu
 */
public class StudentAffairsOrganization extends Organization {

    public StudentAffairsOrganization() {
        super(Organization.Type.StudentAffairs.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new StudentRole());
        return roles;
    }    
}
