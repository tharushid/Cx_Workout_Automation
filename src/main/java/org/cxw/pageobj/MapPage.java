package org.cxw.pageobj;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.cxw.setup.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.DataTable;
import org.junit.Assert;
import org.cxw.setup.PropertyFile;
public class MapPage {
	
	private WebDriver driver = SetUp.setupDriver();
	

	/*
	 Description: This method navigates to edit tab of the Map from Left navigation menu
	 */
	public void NavigateMapEdit(){
		
		try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
	   By MenuItemCXMap = By.xpath("//a[@class='tab map' and contains(text(),'Map')]");
	   driver.findElement(MenuItemCXMap).click();
	   
	   try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }			    
	   By MenuItemCXMapEditCreate = By.xpath("//a[@href='#/map/edit' and contains(text(), 'Create/Edit')]");
	   driver.findElement(MenuItemCXMapEditCreate).click();
	   
	   try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {    	  
       }
	   Assert.assertEquals(PropertyFile.readProperty("MapCreateEditURL"), driver.getCurrentUrl());
		
	}
	
	 /*
    Description: This method create stages , touchpoints and actions of the map. The script create two Stages
                 two touchpoint for each stage and two actions for each touchpoint.
     Parameters:
        Map: Data table has coulumns for | Stage Name | Touchpoint Name | Action Name | 
   			name values can be passed as below
   			           | S1 | T1 | A1 | 
                       | S2 | T2 | A2 | 
      */
    
	public void CreateStageTouchpointAction(DataTable Map){
		
		/*
		 Description: create stage
		 */
		
		NavigateMapEdit();
		int divNumber =1;
		int Touchdivno = 1;
		int actionNum = 1;  
		
		String[] Stages = {"S1", "S2"};
		int sizeS = Stages.length;
		
		String[] Touchpoints = {"S1-T1", "S1-T2", "S2-T1", "S2-T2"};
		int sizeT = Touchpoints.length;   
		
		String[] Actions = {"S1-T1-A1", "S1-T1-A2","S1-T2-A1", "S1-T2-A2", "S2-T1-A1", "S2-T1-A2", "S2-T2-A1","S2-T2-A2"};
		int sizeA = Actions.length;
		
		List<Map<String, String>> list = Map.asMaps(String.class, String.class);
		for(int i=0; i<list.size(); i++) {
				   
			try {
			Thread.sleep(5000);
			} catch (InterruptedException e) {
			}			   		
			By btnAddStage = By.xpath("//button[@class='btn btn-success add' and contains(text(),'Add Stage')]");
			driver.findElement(btnAddStage).click();
				   
			try {
			Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			By txtStageTitle = By.xpath("//input[@id='stageTitle' and @name='stageTitle']");
			driver.findElement(txtStageTitle).sendKeys(list.get(i).get("Stage Name"));
			By btnSaveStageTitle = By.xpath("//button[@class='btn btn-primary' and contains (text(),'Save')]");
			driver.findElement(btnSaveStageTitle).click();
			
		/* 
		 Description: create touchpoint	
		*/
			
			
			for(int x=0; x <2; x++) {				   
			
				try {
				Thread.sleep(10000);
				} catch (InterruptedException e) {		}	
							
				By btnAddTouchpoint = By.xpath("//div["+divNumber+"]/map-edit-stage/div/button");
				driver.findElement(btnAddTouchpoint).click();
				try {
				Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
				By txtTouchpointTitle = By.xpath("//input[@id='touchpointTitle' and @name='touchpointTitle']");
				driver.findElement(txtTouchpointTitle).sendKeys("S"+divNumber+"-"+list.get(x).get("Touchpoint Name"));
				By btnSaveTouchPointTitle = By.xpath("//button[@class='btn btn-primary' and contains (text(),'Save')]");
				driver.findElement(btnSaveTouchPointTitle).click();	
				
				
			/* 
			 Description: create Actions
			 */
						
						for(int y=0; y < 2 ; y++) {				   
						
							try {
							Thread.sleep(5000);
							} catch (InterruptedException e) {		}	
							System.out.println(divNumber);
										
							By btnAddAction = By.xpath("//div["+Touchdivno+"]/map-edit-touchpoint/div/button");
							driver.findElement(btnAddAction).click();
							try {
							Thread.sleep(6000);
							} catch (InterruptedException e) {
							}
							By txtActionTitle = By.xpath("//input[@id='actionTitle' and @name='actionTitle']");
							driver.findElement(txtActionTitle).sendKeys("S"+divNumber+"-"+"T"+Touchdivno+"-"+list.get(y).get("Action Name"));
							
							try {
								Thread.sleep(5000);
								} catch (InterruptedException e) {		}
							
							By dpbchannel = By.xpath("//div[@id='channel' and @name='channel']");
							driver.findElement(dpbchannel).click();
							By selectCahnnel = By.xpath("//span[@class='ng-binding ng-scope' and contains(text(), 'Web')]");
							driver.findElement(selectCahnnel).click();
									
							By btnSaveActionTitle = By.xpath("//button[@class='btn btn-primary' and contains (text(),'Save')]");
							driver.findElement(btnSaveActionTitle).click();	
						
							try {
								Thread.sleep(2000);
								} catch (InterruptedException e) {
								}
						
							 						     
						}
						
						for (int ac=0; ac<7; ac++)
				        {

						 if (Touchdivno <= 2){	
						 if (actionNum <= 2){		 
						 By ActionName = By.xpath("//h4[contains( text(),'S"+divNumber+"-T"+Touchdivno+"-A"+actionNum+"')]");
					     Assert.assertEquals(Actions[ac], driver.findElement(ActionName).getText());
						 }
					 	
					 	 }    
						 actionNum++;				
						
					        }
						
						actionNum--; 
						Touchdivno++;		
			}
			
			try {
				Thread.sleep(2000);
				} catch (InterruptedException e) {
				}		
			 for (int t=0; t<4; t++)
		        {

				 if (Touchdivno <= 2){	 
				 By TouchpointName = By.xpath("//h4[contains( text(),'S"+divNumber+"-T"+Touchdivno+"')]");
			     Assert.assertEquals(Touchpoints[t], driver.findElement(TouchpointName).getText());
				 }
		        }
			 
			divNumber++;
			Touchdivno=Touchdivno-2;
		}
		
		
		try {
			Thread.sleep(2000);
			} catch (InterruptedException e) {
			}		
		 for (int s=0; s<sizeS; s++)
	        {	      
		   if (divNumber <= 2){	 
		   By StageName = By.xpath("//h4[contains(text(),'S"+divNumber+"')]");
	       Assert.assertEquals(Stages[s], driver.findElement(StageName).getText());
		     }
	        }
		
		divNumber--;

	}
	
	 /*
    Description: This method updates created map's stages , touchpoints and actions. The script updates names  of the two Stages
                 touchpoints of each stage and actions of each touchpoint and chanel of each action.
     Parameters:
        Map: Data table has columns for | Stage Name |Updated Stage Name | Touchpoint Name | Updated Touchpoint Name  |Action Name | Updated Action Name |
   			name values can be passed as below
   			           
						   | S1 | _Updated | T1 | _Updated | A1 | _Updated |
						   | S2 | _Updated | T2 | _Updated | A2 | _Updated |
   
      */
	
     public void UpdateStageTouchpointAction(DataTable Map){
		
		/*
		 Description: edit stage
		 */
    	 
    	int divNumber =1;
 		int Touchdivno = 1;
 		int actionNum = 1;
 		
 		String[] UpdatedStages = {"S1_Updated", "S2_Updated"};
		NavigateMapEdit();
		
		for(int s=0; s<2; s++){
		
		List<Map<String, String>> list = Map.asMaps(String.class, String.class);
		for(int i=0; i<list.size(); i++) {
				   
			try {
			Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			 By btnStageEdit = By.xpath("//h4[contains(text(),'"+list.get(i).get("Stage Name")+"')]/../div/button[1]");
			 driver.findElement(btnStageEdit).click();
				   
			try {
			Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			By txtStageTitle = By.xpath("//input[@id='stageTitle' and @name='stageTitle']");
			driver.findElement(txtStageTitle).sendKeys(list.get(i).get("Updated Stage Name"));
			By btnSaveStageTitle = By.xpath("//button[@class='btn btn-primary' and contains (text(),'Save')]");
			driver.findElement(btnSaveStageTitle).click();
			try {
				Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
			By StageName = By.xpath("//h4[contains(text(),'S"+divNumber+"')]");
		    Assert.assertEquals(UpdatedStages[s], driver.findElement(StageName).getText());
		    
		
			
          /* 
           Description: update touchpoint	
           */
									   
			for(int x=0; x<2; x++) {
				
			
				try {
				Thread.sleep(5000);
				} catch (InterruptedException e) {		}	
							
				By btnTouchPointEdit = By.xpath("//h4[contains(text(),'"+(list.get(x).get("Touchpoint Name"))+"')]/../div/button[1]");
				driver.findElement(btnTouchPointEdit).click();
				try {
				Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				By txtTouchPointTitle = By.xpath("//input[@id='touchpointTitle' and @name='touchpointTitle']");
				driver.findElement(txtTouchPointTitle).sendKeys(list.get(x).get("Updated Touchpoint Name"));
				By btnSaveTouchpointTitle = By.xpath("//button[@class='btn btn-primary' and contains (text(),'Save')]");
				driver.findElement(btnSaveTouchpointTitle).click();
				
				
			/* 
			 Description: update action	
			 */
				   
				for(int y=0; y<2; y++) {	
					
					try {
						Thread.sleep(3000);
						} catch (InterruptedException e) {		}	
									
						By btnActionEdit = By.xpath("//h4[contains(text(),'"+(list.get(y).get("Action Name"))+"')]/../div/button[1]");
						driver.findElement(btnActionEdit).click();
						try {
						Thread.sleep(6000);
						} catch (InterruptedException e) {
						}
						By txtActionTitle = By.xpath("//input[@id='title' and @name='actionTitle']");
						driver.findElement(txtActionTitle).sendKeys(list.get(y).get("Updated Action Name"));
													
						By dpbchannel = By.xpath("//div[@id='channel' and @name='channel']");
						driver.findElement(dpbchannel).click();
						try {
							Thread.sleep(2000);
							} catch (InterruptedException e) {		}	
						
						By selectCahnnel = By.xpath("//span[@class='ng-binding ng-scope' and contains(text(), 'Web')]");
						driver.findElement(selectCahnnel).click();
								
						By btnSaveActionTitle = By.xpath("//button[@class='btn btn-primary' and contains (text(),'Save')]");
						driver.findElement(btnSaveActionTitle).click();	
					
					}
				
				}
						
			}
     
		}
		
     }
     
     
     
}