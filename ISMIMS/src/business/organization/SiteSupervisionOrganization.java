/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization;

import business.role.Role;
import business.role.SiteSupervisorRole;
import java.util.ArrayList;

/**
 *
 * @author gerrysu
 */
public class SiteSupervisionOrganization extends Organization {

    public SiteSupervisionOrganization() {
        super(Organization.Type.SiteSupervision.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SiteSupervisorRole());
        return roles;
    }    
}
