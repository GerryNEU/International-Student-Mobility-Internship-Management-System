/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.enterprise;

import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author gerrysu
 */
public class CorporateEnterprise extends Enterprise{

    public CorporateEnterprise(String name){
        super(name, EnterpriseType.Corporate);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }    
}
