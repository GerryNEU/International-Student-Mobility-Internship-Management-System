/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.organization;

import business.organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author gerrysu
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.ApplicationProcessing.getValue())){
            organization = new ApplicationProcessingOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.InternationalAdmissions.getValue())){
            organization = new InternationalAdmissionsOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.LegalCompliance.getValue())){
            organization = new LegalComplianceOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Operations.getValue())){
            organization = new OperationsOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.FinancialAid.getValue())){
            organization = new FinancialAidOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Registrar.getValue())){
            organization = new RegistrarOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.TalentAcquisition.getValue())){
            organization = new TalentAcquisitionOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.StudentAffairs.getValue())){
            organization = new StudentAffairsOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.SiteSupervision.getValue())){ // Logic for new org
            organization = new SiteSupervisionOrganization();
            organizationList.add(organization);
        }
        return organization;
    }    
}
