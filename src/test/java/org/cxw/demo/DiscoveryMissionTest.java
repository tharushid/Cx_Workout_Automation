package org.cxw.demo;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.cxw.pageobj.DiscoveryMissionPage;


   

public class DiscoveryMissionTest {
	
	
	private DiscoveryMissionPage DiscoveryMissionPage;

    public DiscoveryMissionTest() {
    	
    	DiscoveryMissionPage = new DiscoveryMissionPage();
    }
    
    
    @Then("^User Create \"([^\"]*)\" Discovery mision with the name \"([^\"]*)\" as \"([^\"]*)\"$")
    public void user_create_Discovery_mission_URL(String MissionType,String MissionName,String distribType,DataTable MapPoints)  {

        try {
            DiscoveryMissionPage.clickLeftNavMissions();
            DiscoveryMissionPage.clickLeftNavMissionListPage(MissionType);
            DiscoveryMissionPage.clickNewDiscoveryMissionBtn();            
            DiscoveryMissionPage.typeDiscoveryMissiontitle(MissionName);
            DiscoveryMissionPage.DistrbutionTypeURL(distribType,MapPoints);
            
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }    
        
    @Then("^User Create \"([^\"]*)\" Discovery mision with the name \"([^\"]*)\" for \"([^\"]*)\" as \"([^\"]*)\"$")
    public void user_create_Discovery_mission_for_email_list(String MissionType,String MissionName,String ListName,String distribType,DataTable MapPoints)  {

        try {
            DiscoveryMissionPage.clickLeftNavMissions();
            DiscoveryMissionPage.clickLeftNavMissionListPage(MissionType);
            DiscoveryMissionPage.clickNewDiscoveryMissionBtn();            
            DiscoveryMissionPage.typeDiscoveryMissiontitle(MissionName);
            DiscoveryMissionPage.DistrbutionTypeEMAIL(ListName,distribType,MapPoints);
            
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }    
    
    @Then("^User Create \"([^\"]*)\" Discovery_C mision with the name \"([^\"]*)\" as \"([^\"]*)\"$")
    public void user_create_customer_Discovery_mission_URL(String MissionType,String MissionName,String distribType,DataTable MapPoints)  {

        try {
            DiscoveryMissionPage.clickLeftNavMissions();
            DiscoveryMissionPage.clickLeftNavMissionListPage(MissionType);
            DiscoveryMissionPage.clickNewDiscoveryMissionBtn();            
            DiscoveryMissionPage.typeDiscoveryMissiontitle(MissionName);
            DiscoveryMissionPage.CustomerDistrbutionTypeURL(distribType,MapPoints);
            
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }      
    
    
    @Then("^User Create \"([^\"]*)\" Discovery_C mission with the name \"([^\"]*)\" for \"([^\"]*)\" as \"([^\"]*)\"$")
    public void user_create_Customer_Discovery_mission_for_email_list(String MissionType,String MissionName,String ListName,String distribType,DataTable MapPoints)  {

        try {
            DiscoveryMissionPage.clickLeftNavMissions();
            DiscoveryMissionPage.clickLeftNavMissionListPage(MissionType);
            DiscoveryMissionPage.clickNewDiscoveryMissionBtn();            
            DiscoveryMissionPage.typeDiscoveryMissiontitle(MissionName);
            DiscoveryMissionPage.CustomerDistrbutionTypeEMAIL(ListName,distribType,MapPoints);
            
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }    
    
    @Then("^User verify \"([^\"]*)\" Discovery_C mision is created as \"([^\"]*)\"$")
    public void user_verify_Discovery_mission_for_email_list_is_created(String MissionType,String MissionName){

        try {
        	
        	 DiscoveryMissionPage.verifyMissionCreation(MissionType,MissionName);
            
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }    
    

}



