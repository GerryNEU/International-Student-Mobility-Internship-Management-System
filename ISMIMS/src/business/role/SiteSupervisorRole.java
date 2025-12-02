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
import ui.SiteSupervisorRole.SiteSupervisorWorkAreaJPanel;


/**
 *
 * @author gerrysu
 */
public class SiteSupervisorRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new SiteSupervisorWorkAreaJPanel(); // You will need to update the constructor of JPanel to accept these parameters later
    }        
}
