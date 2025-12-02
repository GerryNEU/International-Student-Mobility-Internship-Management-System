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
import ui.CorporateRecruiterRole.CorporateRecruiterWorkAreaJPanel;

/**
 *
 * @author gerrysu
 */
public class CorporateRecruiterRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new CorporateRecruiterWorkAreaJPanel(userProcessContainer, account, organization, enterprise, business);
    }        
}
