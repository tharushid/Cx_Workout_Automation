package org.cxw.demo;

import org.cxw.pageobj.MapPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class MapTest {
	
	
	 private MapPage MapPage;

	    public MapTest() {
	        MapPage = new MapPage();
	    }

	  	    
	    @Then("^User creates map$")
	    public void Create_StageTouchpointAction(DataTable Map) {

	        try {
	          MapPage.CreateStageTouchpointAction(Map);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	    
	    @Then("^User updates map$")
	    public void Update_StageTouchpointAction(DataTable Map) {

	        try {
	          MapPage.UpdateStageTouchpointAction(Map);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	   
}