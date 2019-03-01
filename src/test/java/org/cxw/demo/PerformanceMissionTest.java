package org.cxw.demo;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.cxw.pageobj.PerformanceMissionPage;

public class PerformanceMissionTest {

    private PerformanceMissionPage PerfMissionPage;

    public PerformanceMissionTest() {
        PerfMissionPage = new PerformanceMissionPage();
    }

    @Then("^User Create \"([^\"]*)\" mision with the name \"([^\"]*)\" as \"([^\"]*)\"$")
    public void user_create_projectTeam_perf_mission_URL(String MissionType,String MissionName,String distribType,DataTable PerMission)  {

        try {
            PerfMissionPage.clickLeftNavMissions();
            PerfMissionPage.clickLeftNavMissionListPage(MissionType);
            PerfMissionPage.clickNewPerfMissionBtn();            
            PerfMissionPage.typePerfMissiontitle(MissionName);
            PerfMissionPage.DistrbutionTypeURL(distribType,PerMission);
            
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }    
        
        
       @Then("^User Create \"([^\"]*)\" mission with the name \"([^\"]*)\" as \"([^\"]*)\" for list \"([^\"]*)\"$")
        public void user_create_projectTeam_perf_mission_EMAIL(String MissionType,String MissionName, String distribType,String ListName, DataTable PerMission) {

            try {
                PerfMissionPage.clickLeftNavMissions();
                PerfMissionPage.clickLeftNavMissionListPage(MissionType);
                PerfMissionPage.clickNewPerfMissionBtn();
                PerfMissionPage.typePerfMissiontitle(MissionName);
                PerfMissionPage.DistrbutionTypeEmail(distribType,ListName,PerMission);
                
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    
        }
        
        
        
        @Then("^User Creates- \"([^\"]*)\" mision with the name \"([^\"]*)\" as \"([^\"]*)\"$")
        public void user_Creates_mission_with_the_name_as(String MissionType,String MissionName, String distribType, DataTable PerMission)  {

            try {
                PerfMissionPage.clickLeftNavMissions();
                PerfMissionPage.clickLeftNavMissionListPage(MissionType);
                PerfMissionPage.clickNewPerfMissionBtn();            
                PerfMissionPage.typePerfMissiontitle(MissionName);
                PerfMissionPage.CustomerPMDistrbutionTypeURL(distribType,PerMission);
                
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }   
        
        @Then("^User Creates- \"([^\"]*)\" mission with the name \"([^\"]*)\" as \"([^\"]*)\" for list \"([^\"]*)\"$")
        public void user_Creates_customer_perf_mission_EMAIL(String MissionType,String MissionName, String distribType,String ListName, DataTable PerMission) {

            try {
                PerfMissionPage.clickLeftNavMissions();
                PerfMissionPage.clickLeftNavMissionListPage(MissionType);
                PerfMissionPage.clickNewPerfMissionBtn();
                PerfMissionPage.typePerfMissiontitle(MissionName);
                PerfMissionPage.CustomerPMDistrbutionTypeEmail(distribType,ListName,PerMission);
                
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    
        }   
    
}
