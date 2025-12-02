/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization;

/**
 *
 * @author gerrysu
 */
public class RegistrarOrganization extends Organization {

    public RegistrarOrganization() {
        super(Organization.Type.Registrar.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new RegistrarRole());
        return roles;
    }    
}
