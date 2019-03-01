package org.cxw.demo;


import org.cxw.pageobj.ProjectPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.cxw.setup.SetUp;

public class ProjectTest {

    private ProjectPage projectPage;

    public ProjectTest() {
        projectPage = new ProjectPage();
    }

    @Then("^User creates a project with templates and with curve type$")
    public void create_project(DataTable project) {

        try {
            projectPage.createProject(project);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
   
   // Step definition for edit project function.
   @Then("^User edits projects with following details$")
   public void edit_project(DataTable project) {
	   
	   try {
		   // Firing edit project function.
		   projectPage.editProject(project);
		   System.out.println("Update process successful!");
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
   }

 @Then("^User deletes the projects with following names$")
   public void delete_project(DataTable project) {
	   
	   try {
		   projectPage.deleteProject(project);
		   System.out.println("Update process successful!");
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
   }
      
    
    
}
