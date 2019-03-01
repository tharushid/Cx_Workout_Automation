package org.cxw.pageobj;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.channels.Channel;
import java.util.List;
import java.util.Map;

import org.cxw.setup.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.DataTable;


public class ProjectPage {
	private WebDriver driver = SetUp.setupDriver();
	private Elements e = new Elements();
	
	/*
	 Description: This method navigates to Project Tab from Left navigation menu
	 */
	public void clickLeftNavProject() {
		
		//navigate to CX project		
		sleep(50000);
		driver.findElement(e.MenuItemCXProject).click();
		System.out.println("Projects menu clicked!");
	}
	/*
	 Description: This method navigates to Project Tab from Left navigation menu after a edit
	 */
	public void clickLeftNavProjectDuringEdit() {
		//navigate to CX project		
		sleep(10000);
		driver.findElement(e.MenuItemCXProject).click();
		System.out.println();
		System.out.println("Projects menu clicked.");
	   }
	
	/*
	 Description: This method expands Map section in the project
	 */
	public void expandMap() {
		 driver.findElement(e.expandMap).click();
	}
	/*
	 Description: This method collapses Map section in the project
	 */
	public void collapseMap() {
		driver.findElement(e.collapseMap).click();
	}
	/*
	 Description: This method collapses Fill Project Details section in the project
	 */
	public void collapseProject() {
		 driver.findElement(e.collapseProject).click();
	}
	/*
	 Description: This method is used to sleep the thread
	 Parameters: 
	    seconds: 1000|2000
	 */
	public void sleep(int seconds) {
		try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
        }
	}
	/*
	 Description: This method is used to Fill the details of the Project Section
	 Parameters: 
	    Project: This data table has values in following columns
	            | Project Name | Template | Curve type |
	            Values can be added to the table like below
	            | Project_1 | SPCI Template | Emotion |
    			| Project_2 | SPCI Template | Value |
    			| Project_3 | SPCI Template | Experience |
	 */
	public void fillDetails_Project(DataTable Project) throws InterruptedException, IOException{	
			
			
			List<Map<String, String>> list = Project.asMaps(String.class, String.class);
			for(int i=0; i<list.size(); i++) {
				
				 clickLeftNavProject();
				 sleep(5000);
				 driver.findElement(e.btnNewCXProject).click();
				 sleep(3000);

				 driver.findElement(e.txtProjectName).sendKeys(list.get(i).get("Project Name"));
				 driver.findElement(e.drpdwnProjectLeader).click();
				 sleep(2000);
				 driver.findElement(e.selectSpecificProjectLeader).click();
			
				 collapseProject();
			
				/* 
				  Description: Fill details of the 'CX_MAP' section	
				 */
				sleep(3000);
				expandMap();
				sleep(3000);
				
				WebElement chkbxChannel = driver.findElement(By.xpath(".//div[@class='col-xs-6 channel ng-scope'][1]/input"));
				System.out.println(chkbxChannel.getText());
				chkbxChannel.click();
				sleep(4000);
				
				By btnChooseImage = By.xpath("//button[@class='btn-sm btn btn-default ng-scope' and contains(text(), 'Choose File')]");
				driver.findElement(btnChooseImage).click();
				Thread.sleep(3000);
				
					Runtime.getRuntime().exec("./src/resources/Script.exe");
					
					Thread.sleep(5000);
					
					System.out.println("Script executed");
				
		
				/* 
				  Description:  Select Template CXMap	
				 */
				sleep(3000);
				driver.findElement(e.drpdwnSelectTemplate).click();
				By SelectTemplate = By.xpath("//span[@class='ng-binding ng-scope' and contains(text(),'" +list.get(i).get("Template")+ "')]");
				driver.findElement(SelectTemplate).click();
			
			
				
		/* 
		 Description: Select CurveType CXMap		
		 */
			
			sleep(1000);
			By radiobtnCurvetype = By.xpath("//button[@name='curveType' and contains(text(), '" +list.get(i).get("Curve type")+ "')]");
			driver.findElement(radiobtnCurvetype).click();
			sleep(1000);
			collapseMap();
			
			sleep(1000);
			driver.findElement(e.expandSender).click();
			sleep(2000);
			driver.findElement(e.txtsenderName).sendKeys("Sender");
			driver.findElement(e.txtreplyToEmail).sendKeys("cxworkout@aeturnum.com");
			driver.findElement(e.collapseSender).click();
			
			sleep(3000);
			driver.findElement(e.btnSaveProject).click();
			System.out.println("Save button clicked!");
			sleep(3000);
			
		}
	}
	/*
	 Description: This method call the method for Project Creation
	 */
	 public void createProject(DataTable Project) throws InterruptedException, IOException{
		   fillDetails_Project(Project);		    
		    
	 }
	 
	 public void searchProject(String projectName) {
         WebElement searchElement = driver.findElement(e.txtSearch);
         searchElement.clear();
         searchElement.sendKeys(projectName);
         System.out.println("Searching for Project");
	 }
 
	 /*
	 Description: This method edits project function declaration.
	  Parameters:
	   Project: This data table has values in following columns
	            | Project Name | Template | Curve type |
	            Values can be added to the table like below
	            | Project_1 | SPCI Template | Emotion |
    			| Project_2 | SPCI Template | Value |
    			| Project_3 | SPCI Template | Experience |
	 */
	 public void editProject(DataTable project) {
		
		 /*
		  Description: Taking data table elements into a list.
		  */
		 List<Map<String, String>> list = project.asMaps(String.class, String.class);
		 
		 int x=1;
		 for(int i=0; i<list.size(); i++) {
			 /*
			  Description: Navigating to projects section of left navigation.
			  */
			 clickLeftNavProjectDuringEdit();
			 
			 /*
			  Description: Taking list values of first row into variables.
			  */
			 String projectName = list.get(i).get("Project Name");
			 String description = list.get(i).get("Description");
			 String endDate = list.get(i).get("End date");
			 String channel	= list.get(i).get("Channel");
			 
			 /*
			  Description: Search for a given project in a data table.
			  */
			 sleep(3000);
			 searchProject(projectName);
	       
	         /* 
	          Description: Clicking on edit icon of search results project.
	          */
			 sleep(1000);
	         driver.findElement(e.projectEditBtn).click();
	         sleep(4000);
  
	         /*
	          Description: Changing description of the project.
	          */
	         WebElement descriptionElement = driver.findElement(e.txtProjectDescription);
	         descriptionElement.clear();
	         descriptionElement.sendKeys(description);
	         System.out.println("Description changed.");
	         sleep(3000);
	 	     
	         /*
	          Description: Changing the end date of the project.
	          */
	         WebElement endDateElement = driver.findElement(e.txtEndDate);
	         endDateElement.clear();
	         endDateElement.sendKeys(endDate);
	         System.out.println("Date changed.");
	         
	         /*
	          * Description: Assign project roles and Assign project leader.
	          */
	        
			 driver.findElement(e.drpdwnProjectLeader).click();
			 driver.findElement(e.selectSpecificProjectLeader).click();
			 System.out.println("Project Leader assigned.");
			 sleep(3000);
	 	     
			 /*
			  Description: Assign project team.
			  */
			 driver.findElement(e.drpdwnProjectTeam).click();
			 driver.findElement(e.selectProjectTeam).click();
			 System.out.println("Project Team Assigned.");
			 sleep(3000);
			 
			 /*
			  Description: Assign project support.
			  */
			 driver.findElement(e.drpdwnProjectSupport).click();
			 driver.findElement(e.selectProjectSupport).click();
			 System.out.println("Project Support Assigned.");
			 sleep(3000);
			 
			 /*
			  Description: Assign SME
			  */
			 driver.findElement(e.drpdwnSme).click();
			 driver.findElement(e.selectSme).click();
			 System.out.println("SME Assigned.");
			 sleep(800);
	         
	         collapseProject();
			 sleep(3000);
			 expandMap();
			 sleep(1000);
			 
			 /*
			  Description: Select channel.
			  */
			 String jsonBody = "{\"title\":\""+ channel + "\",\"check\":false,\"editable\":true,\"disabled\":false}";
			 
			 By channelCheckBox = By.xpath("//input[@class='ng-pristine ng-untouched ng-valid' and @value='"+jsonBody+"']");
			 driver.findElement(channelCheckBox).click();
			 System.out.println(channel + " channel ticked.");
			 sleep(3000);
			
			 driver.findElement(e.btnChangeImage).click();
			 sleep(5000);
			 
			 try {
					Runtime.getRuntime().exec("./src/resources/edit_logo_script.exe");
					System.out.println("Project logo changed.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Inexception");
					e.printStackTrace();
				}		
			 
			 
			 sleep(6000);
			 collapseMap();
	         /*
	          Description: Save project details.
	          */
	         sleep(8000);
			 driver.findElement(e.btnSaveProject).click();
			 System.out.println("Project_" + x + " update completed!");
			 System.out.println();

			 WebElement projectNameElement = driver.findElement(e.txtProjectName);
			
			 /*
			  Description: Assertions to see if the updated details are saved.
			  */
			 String projectNameActualResult = projectNameElement.getAttribute("value");
			 assertEquals(projectName, projectNameActualResult);
			 String descriptionActualResult = descriptionElement.getAttribute("value");
			 assertEquals(description, descriptionActualResult);
			 sleep(3000);
			 collapseProject();
			
			 sleep(3000);
			 expandMap();
			 sleep(6000);
			/*
			 * String jsonBody_SelectedChannel = "{\"title\":\""+ channel +
			 * "\",\"check\":true,\"editable\":true,\"disabled\":false}"; By selectedChannel
			 * = By.xpath("//input[@class='ng-pristine ng-untouched ng-valid' and @value='"
			 * +jsonBody_SelectedChannel+"']"); boolean channelActualResult =
			 * driver.findElement(selectedChannel).isSelected();
			 * assertFalse(channelActualResult);
			 */
			 
			 x++;
		 }  	 
	 }
	
	 
	 public void deleteProject(DataTable project) {
		
		 // Description: Taking data table elements into a list.

		 List<Map<String, String>> list = project.asMaps(String.class, String.class);
		 
		 int x=1;
		 for(int i=0; i<list.size(); i++) {
	
			 // Description: Navigating to projects section of left navigation.
			 clickLeftNavProjectDuringEdit();
			 
			 // Description: Taking list values of first row into variables.
			 String projectName = list.get(i).get("Project Name");
			 
			 // Description: Search for a given project in a data table.
			 sleep(3000); 
	         searchProject(projectName);
	         sleep(1000);
	         
	         // Get working project's name
	        /* WebElement selectedProjectElement = driver.findElement(e.selectedProject);
	         String selectedProjectValue = selectedProjectElement.getText();
	         System.out.print(selectedProjectValue); */

	         // Description: Clicking on delete icon of search results project.
	         driver.findElement(e.projectDeleteBtn).click();
	         sleep(1000);
	         driver.findElement(e.projectDeleteYesBtn).click(); 
	         sleep(5000);
	         driver.findElement(e.switchProject).click();
	         
		 }  	 
	 }
	 
	 
	
}

		
		
		


 