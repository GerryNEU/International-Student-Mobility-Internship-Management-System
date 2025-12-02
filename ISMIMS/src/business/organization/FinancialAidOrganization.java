/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization;

import business.role.FinancialAuditorRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author gerrysu
 */
public class FinancialAidOrganization extends Organization {
    
    public FinancialAidOrganization() {
        super(Organization.Type.FinancialAid.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new FinancialAuditorRole());
        return roles;
    }    
}
