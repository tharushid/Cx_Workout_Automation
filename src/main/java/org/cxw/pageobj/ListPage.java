package org.cxw.pageobj;


import java.io.IOException;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;
import org.cxw.setup.Common;
import org.cxw.setup.PropertyFile;
import org.cxw.setup.SetUp;
import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


	public class ListPage {
	
	
	private WebDriver driver = SetUp.setupDriver();
	
	
	/* 
	  Description:  navigates to list form Left navigation menu
	*/
	
	public void NavigateList(){
		
    
		
		try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
	   By MenuItemCXList = By.xpath("//a[@class='tab list' and contains(text(),'Lists')]");
	   driver.findElement(MenuItemCXList).click();
	   System.out.println("Select list from menu");
	     
		
	}
	
	/* 
	  Description:navigate to project team list
    */
		
	public void NavigateProjectTeamList(){
				
		
		try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
		By MenuItemProjectTeamList = By.xpath("//li[@aet-has-permission='LIST_SEARCH_PT_LISTS']");
		driver.findElement(MenuItemProjectTeamList).click();
		System.out.println("Navigates to Project team list");
		try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
		
		Assert.assertEquals(PropertyFile.readProperty("ProjectTeamListURL"), driver.getCurrentUrl());
	}

	/* 
	  Description: navigate to employee list
   */ 
	public void NavigateEmployeesList(){
		
		try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
		By MenuItemEmployeesList = By.xpath("//li[@aet-has-permission='LIST_SEARCH_EMPLOYEE_LISTS']");
		driver.findElement(MenuItemEmployeesList).click();
		System.out.println("Navigates to Employee list");
		try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
		Assert.assertEquals(PropertyFile.readProperty("EmployeesListURL"), driver.getCurrentUrl());
	}
   
	/* 
	  Description: navigate to customer list
	 */
	
	public void NavigateCustomersList(){
	
		
		try {
        Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		By MenuItemCustomersList = By.xpath("//li[@aet-has-permission='LIST_SEARCH_CUSTOMER_LIST']");
		driver.findElement(MenuItemCustomersList).click();
		System.out.println("Navigates to Customer list");
		try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
		Assert.assertEquals(PropertyFile.readProperty("CustomersListURL"), driver.getCurrentUrl());
	}
	
	/* 
	  Description: create Project Team list
	  Parameters: 
	   ListName: Any name for the list
	   Members: a data table with names of the members of the list
	    ex: | Team Member Name |
    		| Lucas Graham |
    		| Ann Brown |
	*/
	public void CreateProjecteamList(String ListName, DataTable Members){
		
		
		NavigateList();
		NavigateProjectTeamList();
		
		
		try {
	        Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		By buttonCreateNewProjectTeamList = By.xpath("//button[@class ='btn create-btn btn-primary' and @title='New Project Team List']");
		driver.findElement(buttonCreateNewProjectTeamList).click();
		try {
	        Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
		Assert.assertEquals(PropertyFile.readProperty("CreateNewProjectTeamListURL"), driver.getCurrentUrl());
		
		By txtProjectTeamListTitle = By.xpath("//input[@id='title' and @name='title']");
		driver.findElement(txtProjectTeamListTitle).sendKeys(ListName);
		
			
		
		List<Map<String, String>> list = Members.asMaps(String.class, String.class);
		for(int i=0; i<list.size(); i++) {
			
			try {
		        Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
		By chckbxProjectTeamList = By.xpath("//label[@class='checkbox-inline ng-binding' and contains(text(),'"+list.get(i).get("Team Member Name")+"')]");
		driver.findElement(chckbxProjectTeamList).click();
		
		}
		
		By btnSaveProjectTeamList = By.xpath("//button[@type='submit' and contains(text(),'Save')]");
		driver.findElement(btnSaveProjectTeamList).click();
		System.out.println("Created ProjectTeamlist");		
		
		try {
	        Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		
		By lbllistname = By.xpath(".//tr[@class='search-result ng-scope']/td[1] /span[1]/span[contains(text(),'"+ListName+"')]");
		Assert.assertEquals(ListName, driver.findElement(lbllistname).getText());
	
		}
	
	/* 
	  Description: This method Updates created project team list
	  
	  Parameters: 
	   ListName: Any name for the list
	   Members: a data table with names of the members of the list
	    ex: | Team Member Name |
    		| Lucas Graham |
    		| Ann Brown |
	*/ 
	
	  public void UpdateProjectTeamList(String ListName, DataTable Members){
		
		// update project team list
		
		NavigateList();
		NavigateProjectTeamList();
		
		
		try {
	        Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		
		By btnlistedit = By.xpath("//tr[@class='search-result ng-scope']//../td[@title='"+ListName+"']//../td[4]/a/span[@class='icon-cx-workout-icons-cx-edit']");
		driver.findElement(btnlistedit).click();
		try {
	        Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		By txtProjectTeamListTitle = By.xpath("//input[@id='title' and @name='title']");
		driver.findElement(txtProjectTeamListTitle).sendKeys("_Updated");
		
		
		List<Map<String, String>> list = Members.asMaps(String.class, String.class);
		for(int i=0; i<list.size(); i++) {
			
			try {
		        Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
		By chckbxProjectTeamList = By.xpath("//label[@class='checkbox-inline ng-binding' and contains(text(),'"+list.get(i).get("Team Member Name")+"')]");
		driver.findElement(chckbxProjectTeamList).click();
		
		}
		
		By btnSaveProjectTeamList = By.xpath("//button[@type='submit' and contains(text(),'Save')]");
		driver.findElement(btnSaveProjectTeamList).click();
		System.out.println("Updated ProjectTeamlist");
		
		try {
	        Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		By lbllistname = By.xpath(".//tr[@class='search-result ng-scope']/td[1] /span[1]/span[contains(text(),'"+ListName+"_Updated"+"')]");
		Assert.assertEquals(ListName+"_Updated", driver.findElement(lbllistname).getText());
		
	}
	  
	  /*
	   Description: This method creates list for Employees 
	   Parameters: 
	     ListName: Any name for the list
	     ListType: csv|manuallyAdded 
	   Members: a data table with names of the members of the list
	    ex:  |Employee first Name|Employee last Name|Employee email address|
             |Jenny|Smith|amelia.grace259@gmail.com|
             |Amelia|Grace|ameliag.race259@gmail.com|
             |Steve|Taylor|ameliagr.ace259@gmail.com|
	   	   */
	  
	  public void CreateEmployeeList(String ListName, String ListType, DataTable Members){
		  
			
		  
		  List<Map<String, String>> list = Members.asMaps(String.class, String.class);
				  
			
				NavigateList();
				NavigateEmployeesList();
				
				try {
			        Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
				By buttonCreateNewEmployeeList = By.xpath("//button[@class ='btn create-btn btn-primary' and @title='New Employee List']");
				driver.findElement(buttonCreateNewEmployeeList).click();
				try {
			        Thread.sleep(5000);
					} catch (InterruptedException e) {
					}
				Assert.assertEquals(PropertyFile.readProperty("CreateNewEmployeeListURL"), driver.getCurrentUrl());
				
				By txtEmployeeListTitle = By.xpath("//input[@id='title' and @name='title']");
				driver.findElement(txtEmployeeListTitle).sendKeys(ListName);
				System.out.println(ListType);
				try {
			        Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
				
				 /*
				   Description:  name list taken from csv
				*/
				
				if (ListType.equals("csv")){
					
				By btnEmployeeListupload = By.xpath("//input[@type='file' and @accept='.csv']");
				driver.findElement(btnEmployeeListupload).click();
				try {
		            Thread.sleep(5000);
		        } catch (InterruptedException e) {
		        }
				try {
					Runtime.getRuntime().exec("./src/resources/ScriptEmployeeCSV.exe");
					System.out.println("Script executed");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}
				
				
				 /*
				   Description: name list is manually added
				 */
				
				   
				if (ListType.equals("manuallyAdded")){
					
					for(int i=0; i<list.size(); i++) {
										
					By txtEmployeefirstname = By.xpath("//input[@id='manuallyAddedFirstName']");
					driver.findElement(txtEmployeefirstname).sendKeys(list.get(i).get("Employee first Name"));
					
					By txtEmployeelastname = By.xpath("//input[@id='manuallyAddedLastName']");
					driver.findElement(txtEmployeelastname).sendKeys(list.get(i).get("Employee last Name"));
					
					By txtEmployeeemailaddress = By.xpath("//input[@id='manuallyAddedEmailAddress']");
					driver.findElement(txtEmployeeemailaddress).sendKeys(list.get(i).get("Employee email address"));
					
					try {
			            Thread.sleep(3000);
			        } catch (InterruptedException e) {
			        }
					By btnAdd = By.xpath("//button[@type='submit' and contains(text(),'Add')]");
					driver.findElement(btnAdd).click();
					
					}
					
				}
				
				
				try {
		            Thread.sleep(3000);
		        } catch (InterruptedException e) {
		        }	
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
				By btnSaveEmployeeList = By.xpath("//button[@type='submit' and contains(text(),'Save List')]");
				driver.findElement(btnSaveEmployeeList).click();
				System.out.println("Created Employeelist");		
				
				try {
			        Thread.sleep(5000);
					} catch (InterruptedException e) {
					}
				
				By lbllistname = By.xpath(".//tr[@class='search-result ng-scope']/td[1]/span[1]/span[contains(text(),'"+ListName+"')]");
				Assert.assertEquals(ListName, driver.findElement(lbllistname).getText());
			
					  
	  }
	  
	  /*
	   Description: this method updates employee list
	   Parameters:
	    ListName: Any name for the list
	  */ 
	  
			  public void UpdateEmployeeList(String ListName){
					
					
					
					NavigateList();	
					NavigateEmployeesList();
					
					
					try {
				        Thread.sleep(2000);
						} catch (InterruptedException e) {
						}
					
					By btnlistedit = By.xpath("//tr[@class='search-result ng-scope']//../td[@title='"+ListName+"']//../td[4]/a/span[@class='icon-cx-workout-icons-cx-edit']");
					driver.findElement(btnlistedit).click();
					try {
				        Thread.sleep(2000);
						} catch (InterruptedException e) {
						}
					By txtEmployeeListTitle = By.xpath("//input[@id='title' and @name='title']");
					driver.findElement(txtEmployeeListTitle).sendKeys("_Updated");
					
					//user deletes a random recipient
					
					try {
					        Thread.sleep(5000);
							} catch (InterruptedException e) {
							}
					
					By btnRemoveUser = By.xpath("//tr[1]/td[1]/button[@class='btn btn-sm btn-default btn-rounded']");
					driver.findElement(btnRemoveUser).click();
					try {
			            Thread.sleep(2000);
			        } catch (InterruptedException e) {
			        }	
								
								
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
					By btnSaveEmployeeList = By.xpath("//button[@type='submit' and contains(text(),'Save List')]");
					driver.findElement(btnSaveEmployeeList).click();
					
					System.out.println("Updated Employee list");
					
					try {
				        Thread.sleep(6000);
						} catch (InterruptedException e) {
						}
					By lbllistname = By.xpath(".//tr[@class='search-result ng-scope']/td[1] /span[1]/span[contains(text(),'"+ListName+"_Updated"+"')]");
					Assert.assertEquals(ListName+"_Updated", driver.findElement(lbllistname).getText());
					
				} 	 
	  
			  /*
			   Description:  this method creates customer list
			   ListName: Any name for the list
	     	   ListType: csv|manuallyAdded 
	           Members: a data table with names of the members of the list
	    ex:  |Customer first Name|Customer last Name|Customer email address|
             |Jenny|Smith|amelia.grace259@gmail.com|
             |Amelia|Grace|ameliag.race259@gmail.com|
             |Steve|Taylor|ameliagr.ace259@gmail.com|
	   	   */
			  
	    public void CreateCustomerList(String ListName, String ListType, DataTable Members){
		  
		 
		  
		  List<Map<String, String>> list = Members.asMaps(String.class, String.class);
				  
			
				NavigateList();
				NavigateCustomersList();
				
				try {
			        Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
				By buttonCreateNewCustomerList = By.xpath("//button[@class ='btn create-btn btn-primary' and @title='New Customer List']");
				driver.findElement(buttonCreateNewCustomerList).click();
				try {
			        Thread.sleep(5000);
					} catch (InterruptedException e) {
					}
				Assert.assertEquals(PropertyFile.readProperty("CreateNewCustomerListURL"), driver.getCurrentUrl());
				
				By txtCustomerListTitle = By.xpath("//input[@id='title' and @name='title']");
				driver.findElement(txtCustomerListTitle).sendKeys(ListName);
				System.out.println(ListType);
				try {
			        Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
				
				/* 
				  Description: list taken as a csv
				 */
				if (ListType.equals("csv")){
					
				By btnCustomerListupload = By.xpath("//input[@type='file' and @accept='.csv']");
				driver.findElement(btnCustomerListupload).click();
				try {
		            Thread.sleep(5000);
		        } catch (InterruptedException e) {
		        }
				try {
					Runtime.getRuntime().exec("./src/resources/ScriptCustomerCSV.exe");
					System.out.println("Script executed");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}
				
				/* 
				 * Description: name list is manually added
				*/
				if (ListType.equals("manuallyAdded")){
					
					for(int i=0; i<list.size(); i++) {
										
					By txtCustomerfirstname = By.xpath("//input[@id='manuallyAddedFirstName']");
					driver.findElement(txtCustomerfirstname).sendKeys(list.get(i).get("Customer first Name"));
					
					By txtCustomerlastname = By.xpath("//input[@id='manuallyAddedLastName']");
					driver.findElement(txtCustomerlastname).sendKeys(list.get(i).get("Customer last Name"));
					
					By txtCustomermailaddress = By.xpath("//input[@id='manuallyAddedEmailAddress']");
					driver.findElement(txtCustomermailaddress).sendKeys(list.get(i).get("Customer email address"));
					
					try {
			            Thread.sleep(3000);
			        } catch (InterruptedException e) {
			        }
					By btnAdd = By.xpath("//button[@type='submit' and contains(text(),'Add')]");
					driver.findElement(btnAdd).click();
					
					}
					
				}
				
				
				try {
		            Thread.sleep(3000);
		        } catch (InterruptedException e) {
		        }	
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
				By btnSaveCustomerList = By.xpath("//button[@type='submit' and contains(text(),'Save List')]");
				driver.findElement(btnSaveCustomerList).click();
				System.out.println("Created Customerlist");		
				
				try {
			        Thread.sleep(5000);
					} catch (InterruptedException e) {
					}
				
				By lbllistname = By.xpath(".//tr[@class='search-result ng-scope']/td[1]/span[1]/span[contains(text(),'"+ListName+"')]");
				Assert.assertEquals(ListName, driver.findElement(lbllistname).getText());
			
		  
	  }
	    
	    /* 
	      Description: this method updates customer list by removing a random recipient
	     */
	
	  public void UpdateCustomerList(String ListName){
			
			
			
			NavigateList();	
			NavigateCustomersList();
			
			
			try {
		        Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
			
			By btnlistedit = By.xpath("//tr[@class='search-result ng-scope']//../td[@title='"+ListName+"']//../td[4]/a/span[@class='icon-cx-workout-icons-cx-edit']");
			driver.findElement(btnlistedit).click();
			try {
		        Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
			By txtCustomerListTitle = By.xpath("//input[@id='title' and @name='title']");
			driver.findElement(txtCustomerListTitle).sendKeys("_Updated");
			
			
			
			try {
			        Thread.sleep(5000);
					} catch (InterruptedException e) {
					}
			/* 
			  Description: user removes a random recipient
			*/
			
			By btnRemoveUser = By.xpath("//tr[1]/td[1]/button[@class='btn btn-sm btn-default btn-rounded']");
			driver.findElement(btnRemoveUser).click();
			try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	        }	
						
						
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			By btnSaveCustomerList = By.xpath("//button[@type='submit' and contains(text(),'Save List')]");
			driver.findElement(btnSaveCustomerList).click();
			
			System.out.println("Updated Customer list");
			
			try {
		        Thread.sleep(6000);
				} catch (InterruptedException e) {
				}
			By lbllistname = By.xpath(".//tr[@class='search-result ng-scope']/td[1] /span[1]/span[contains(text(),'"+ListName+"_Updated"+"')]");
			Assert.assertEquals(ListName+"_Updated", driver.findElement(lbllistname).getText());
			
		} 	 
	  	  
	  
	
}
