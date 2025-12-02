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
public class HomeUniversityEnterprise extends Enterprise{
    public HomeUniversityEnterprise(String name){
        super(name,EnterpriseType.HomeUniversity);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null; // Enterprise Admin roles are handled at UserAccount level, generic here
    }    
}
