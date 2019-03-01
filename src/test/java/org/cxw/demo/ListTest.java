package org.cxw.demo;

import org.cxw.pageobj.ListPage;
import org.cxw.pageobj.MapPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class ListTest {
	
	 private ListPage ListPage;
	 
	 public ListTest() {
	        ListPage = new ListPage();
	    }

	 	@Then("^User creates ProjectTeamList \"([^\"]*)\"$")
	    public void Create_ProjecteamList(String ListName, DataTable Map) {

	        try {
	          ListPage.CreateProjecteamList(ListName,Map);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	 	
	 	@Then("^User updates ProjectTeamList \"([^\"]*)\"$")
	    public void Update_ProjecteamList(String ListName, DataTable Map) {

	        try {
	          ListPage.UpdateProjectTeamList(ListName, Map);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	 	
	 	@Then("^User creates EmployeeList \"([^\"]*)\" with list type \"([^\"]*)\"$")
	    public void Create_EmployeeList(String ListName, String ListType, DataTable Map) {

	        try {
	          ListPage.CreateEmployeeList(ListName, ListType, Map);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	 	
	 	@Then("^User updates Employee List \"([^\"]*)\"$")
	    public void Update_EmployeeList(String ListName) {

	        try {
	          ListPage.UpdateEmployeeList(ListName);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	 	
	 	@Then("^User creates CustomerList \"([^\"]*)\" with list type \"([^\"]*)\"$")
	    public void Create_CustomerList(String ListName, String ListType, DataTable Map) {

	        try {
	          ListPage.CreateCustomerList(ListName, ListType, Map);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	    
	 	@Then("^User updates Customer List \"([^\"]*)\"$")
	    public void Update_CustomerList(String ListName) {

	        try {
	          ListPage.UpdateCustomerList(ListName);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

}
