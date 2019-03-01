package org.cxw.pageobj;

import org.apache.log4j.Logger;
import org.cxw.setup.Common;
import org.cxw.setup.PropertyFile;
import org.cxw.setup.SetUp;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;

import java.util.List;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PerformanceMissionPage {

	private final static Logger logger = Logger.getLogger(PerformanceMissionPage.class);
	private WebDriver driver = SetUp.setupDriver();
	private WebDriverWait wait = new WebDriverWait(driver, 30);
	private Common cmn = new Common();
	
	
	 /* 
	Description : This method selects Mission tab from left navigation menu		
   */	
	public void clickLeftNavMissions() {
		
		By leftNavMission = By.xpath(".//a[contains(text(),'Mission')]");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(leftNavMission).click();
		logger.debug("clickLeftNavMissions");
		
	}

	 /* 
	Description : This method navigates to Mission type selected from left navigation menu		
   	Parameters : 
	MissionType: Employees|Project Team|Customers
    */
	public void clickLeftNavMissionListPage(String MissionType) {
		By leftNavEmployee = By.xpath(".//a[contains(text(),'"+MissionType+"')]");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(leftNavEmployee ).click();
		System.out.println("clickleftNav"+MissionType);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement btnCreateMission = driver.findElement(By.xpath("//button[contains(text(),'Create New Performance Mission')]"));
		Assert.assertNull(btnCreateMission.getAttribute("disabled"));
	}

	
	 /* 
	Description : This method clicks on New Performance Mission button		
   	*/		
	public void clickNewPerfMissionBtn() {
		By btnPerfMission = By.xpath("//button[contains(text(),'Create New Performance Mission')]");
		wait.until(ExpectedConditions.elementToBeClickable(btnPerfMission));
		driver.findElement(btnPerfMission).click();
		System.out.println("clickPerfMissionBtn");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement lbtPerMission = driver.findElement(By.xpath(".//h3[contains(text(),'Performance Mission Setup')]"));
		Assert.assertNull(lbtPerMission.getAttribute("disabled"));
		
	}
	
	/* 
	Description : This method gives a name to the Mission 
   	Parameters : 
	MissionName: Any unique name
    */	
	public void typePerfMissiontitle(String MissionName) {
		By txtPerfMissionTitle = By.xpath(".//input[@id='title']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtPerfMissionTitle));
		driver.findElement(txtPerfMissionTitle).sendKeys(MissionName);
		
	}
	
	/* 
	Description : This method is used to create URL - Performance missions for Project team and Employees
	              Since CUSTOMER MISSIONS have some additional steps, a separate method is used to create URL - Performance missions for customers 
   	Parameters : 
	distribType: URL
	PerMission: Data table is used with following column
	           |Action Position|
	         Map position values should be the names/positions of the actions
	         ex:     |1.1.2|
                     |2.1.2|
	 
			*/		
	public void DistrbutionTypeURL(String distribType, DataTable PerMission) {
		
		
		By radioDistribType = By.xpath(".//*[@id='distributionType" + distribType + "']");
		
			wait.until(ExpectedConditions.elementToBeClickable(radioDistribType));
			driver.findElement(radioDistribType).click();
			System.out.println("selectDistrbutionType");	
		
			/*
			 Description : clickSaveMission
			 */
		By btnPerfMissionSave = By.xpath(".//button[contains(text(),'Save')]");
		wait.until(ExpectedConditions.elementToBeClickable(btnPerfMissionSave));
		driver.findElement(btnPerfMissionSave).click();
		System.out.println("clickSaveMission");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement drpdwnledgend = driver.findElement(By.xpath("//div[@class='col-xs-7 pad-l-0 legend-container dropdown']//a[@class='dropdown-toggle']"));
		Assert.assertNull(drpdwnledgend.getAttribute("disabled"));
		
	

		/*
		 Description : select Actions
		*/ 
		
		List<Map<String, String>> list = PerMission.asMaps(String.class, String.class);
		for(int i=0; i<list.size(); i++) {
			
			/* 
			 Description : user can select many/one actions
			*/ 
			
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		By checkBoxChooseAction = By.xpath("//td[contains(text(),'"+list.get(i).get("Action Position")+"')]/..//td/input[@type='checkbox']");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxChooseAction));
		driver.findElement(checkBoxChooseAction).click();
		System.out.println("selectActions");
	}
		
		
		/* 
		 Description : Navigates to the second step
		*/ 
		
				By stepTwo = By.xpath(".//*[@id='step-two']");
				// wait.until(ExpectedConditions.elementToBeClickable(stepTwo));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				driver.findElement(stepTwo).click();
				System.out.println("gotoStepTwo");
				
				
				WebElement lblParticpantInstruction = driver.findElement(By.xpath("//h4[@class='title' and contains(text(), 'Please write instructions for each Action included in your Mission')]"));
				Assert.assertNull(lblParticpantInstruction.getAttribute("disabled"));
			

				/* 
				 Description : type Participant Instructions
				*/ 
				
				
				for(int a=2; a<list.size()+2; a++) {
					
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
							
				
					
				By txtParticipantInstructions = By.xpath(".//div[@class='list-group-body show-hide ng-scope']//div[@placeholder='Enter detailed instructions for users']//div[@placeholder='Enter detailed instructions for users']");
				// wait.until(ExpectedConditions.presenceOfElementLocated(txtParticipantInstructions));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(txtParticipantInstructions).sendKeys("Please answer the below questionnaire");
				System.out.println("typeParticipantInstructions");
			
				/* 
				 Description : select Media Upload
				*/ 
				By checkBoxMediaInstructions = By.xpath("//div[@class='list-group-body show-hide ng-scope']//input[@type='checkbox']");
				// wait.until(ExpectedConditions.presenceOfElementLocated(checkBoxMediaInstructions));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(checkBoxMediaInstructions).click();
				System.out.println("selectMediaUpload");
			

				/* 
				 Description :type Media Instructions
				*/
					
				By txtMediaInstructions = By.xpath("//div[@class='list-group-body show-hide ng-scope']//div[@placeholder='Enter specific directions for what kind of media to upload and what it should be focused on']//div[@placeholder='Enter specific directions for what kind of media to upload and what it should be focused on']");
				wait.until(ExpectedConditions.presenceOfElementLocated(txtMediaInstructions));
				driver.findElement(txtMediaInstructions).sendKeys("Please upload media files with less than the size of 300Mb");
				System.out.println("typeMediaInstructions");
				
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
					
				if (a<list.size()+1){
				By txtMediaInstructionsbtnActionSteps = By.xpath(".//div/h4[contains(text(),'Action Item "+a+"')]");
				/*
				 Description: scrolling to the particular element
				 */
					
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				driver.findElement(txtMediaInstructionsbtnActionSteps).click();	
				}							
				}				
					
				/* 
				  Description :navigates To Step 3
				*/
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				By stepThree = By.xpath(".//button[@id='step-three']");
				wait.until(ExpectedConditions.elementToBeClickable(stepThree));
				
				driver.findElement(stepThree).click();
				System.out.println("gotoStepThree");
				
				
				WebElement lblMessages = driver.findElement(By.xpath("//h4[contains(text(),'After Mission is submitted, the below message will appear.')]"));
				Assert.assertNull(lblMessages.getAttribute("disabled"));
				 /*
				  Description : type Thank You Message
				  */
				By txtThankMessage = By.xpath(".//div[@id='thankYouMessage']//div[contains(@id,'taTextElement')]");
				// wait.until(ExpectedConditions.presenceOfElementLocated(txtThankMessage));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(txtThankMessage).sendKeys("Thank You");
				System.out.println("typeThankYouMessage");
			
				/* 
				  Description :navigates To Step five
				*/
				By stepFive = By.xpath(".//*[@id='step-five']");
				// wait.until(ExpectedConditions.elementToBeClickable(stepFive));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				driver.findElement(stepFive).click();
				System.out.println("gotoStepFive");

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

				/* 
				  Description : click Generate URL
				*/
				
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
				By btnGenerateURL = By.xpath(".//button[@class='btn btn-primary']/span[contains(text(),'Generate URL')]");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// wait.until(ExpectedConditions.elementToBeClickable(btnGenerateURL));
				driver.findElement(btnGenerateURL).click();
				System.out.println("clickGenerateURL");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				WebElement btnCopyUrl = driver.findElement(By.xpath("//button[@ng-init='initCopyLinkPopover()']"));
				Assert.assertNull(btnCopyUrl.getAttribute("disabled"));			
		}
	
	
	
	//----------------------------------------------EMAIL Performance missions distribution-------------------------
	
	
	/* 
	Description : This method is used to create Email - Performance missions for Project team and Employees
	              Since CUSTOMER MISSIONS have some additional steps, a separate method is used to create EMAIL - Performance missions for customers 
   	Parameters : 
   	ListName: The name of the mail list (these list are created in ListPage)
	type: Email
	PerMission: Data table is used with following column
	           |Action Position|
	         Map position values should be the names/positions of the actions
	         ex:     |1.1.2|
                     |2.1.2|
			*/		
	
	public void DistrbutionTypeEmail(String type, String ListName, DataTable PerMission) {	
		
		
		/*
		  Description :click Save Mission
		*/
		By btnPerfMissionSave = By.xpath(".//button[contains(text(),'Save')]");
		wait.until(ExpectedConditions.elementToBeClickable(btnPerfMissionSave));
		driver.findElement(btnPerfMissionSave).click();
		System.out.println("clickSaveMission");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement drpdwnledgend = driver.findElement(By.xpath("//div[@class='col-xs-7 pad-l-0 legend-container dropdown']//a[@class='dropdown-toggle']"));
		Assert.assertNull(drpdwnledgend.getAttribute("disabled"));
		
		/*
		  Description : Select Actions
		*/
		List<Map<String, String>> list = PerMission.asMaps(String.class, String.class);
		for(int i=0; i<list.size(); i++) {
			
			/*
			  Description :user can select many/one actions/action
			*/ 
			
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		By checkBoxChooseAction = By.xpath("//td[contains(text(),'"+list.get(i).get("Action Position")+"')]/..//td/input[@type='checkbox']");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxChooseAction));
		driver.findElement(checkBoxChooseAction).click();
		System.out.println("selectActions");
	}
		
		
		/*
		  Description : Navigates to Step Two
		 */
		
				By stepTwo = By.xpath(".//*[@id='step-two']");
				// wait.until(ExpectedConditions.elementToBeClickable(stepTwo));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				driver.findElement(stepTwo).click();
				System.out.println("gotoStepTwo");
				
				
				WebElement lblParticpantInstruction = driver.findElement(By.xpath("//h4[@class='title' and contains(text(), 'Please write instructions for each Action included in your Mission')]"));
				Assert.assertNull(lblParticpantInstruction.getAttribute("disabled"));
			

				/*
				  Description : type Participant Instructions
			   */ 
				for(int a=2; a<list.size()+2; a++) {
					
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
							
				
				By txtParticipantInstructions = By.xpath(".//div[@class='list-group-body show-hide ng-scope']//div[@placeholder='Enter detailed instructions for users']//div[@placeholder='Enter detailed instructions for users']");
				// wait.until(ExpectedConditions.presenceOfElementLocated(txtParticipantInstructions));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(txtParticipantInstructions).sendKeys("Please answer the below questionnaire");
				System.out.println("typeParticipantInstructions");
			
				/*
				  Description : select Media Upload
			   */
				By checkBoxMediaInstructions = By.xpath("//div[@class='list-group-body show-hide ng-scope']//input[@type='checkbox']");
				// wait.until(ExpectedConditions.presenceOfElementLocated(checkBoxMediaInstructions));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(checkBoxMediaInstructions).click();
				System.out.println("selectMediaUpload");
			

				 /*
				  Description : type Media Instructions
			   */
				By txtMediaInstructions = By.xpath("//div[@class='list-group-body show-hide ng-scope']//div[@placeholder='Enter specific directions for what kind of media to upload and what it should be focused on']//div[@placeholder='Enter specific directions for what kind of media to upload and what it should be focused on']");
				wait.until(ExpectedConditions.presenceOfElementLocated(txtMediaInstructions));
				driver.findElement(txtMediaInstructions).sendKeys("Please upload media files with less than the size of 300Mb");
				System.out.println("typeMediaInstructions");
				
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
					
				if (a<list.size()+1){
				By txtMediaInstructionsbtnActionSteps = By.xpath(".//div/h4[contains(text(),'Action Item "+a+"')]");
				
				/*
				 Description: scrolling to the particular element
				 */
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				driver.findElement(txtMediaInstructionsbtnActionSteps).click();	
				}							
				}				
					
				/*
				  Description: go to Step Three
				*/
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				By stepThree = By.xpath(".//button[@id='step-three']");
				wait.until(ExpectedConditions.elementToBeClickable(stepThree));
				
				driver.findElement(stepThree).click();
				System.out.println("gotoStepThree");
				
				
				WebElement lblMessages = driver.findElement(By.xpath("//h4[contains(text(),'Please Setup Messages')]"));
				Assert.assertNull(lblMessages.getAttribute("disabled"));
				
			 /*
				  Description: Fill Mission Invitation Email Details
		     */
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				By txtEmailSubject = By.xpath(".//input[@id='welcomeSubjectLine']");
				driver.findElement(txtEmailSubject).sendKeys("You are invited for a performance mission");
				
				By txtEmailbody = By.xpath("//fieldset/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div[3]");
				driver.findElement(txtEmailbody).sendKeys("We would like to see your preference on the product we newly introduced. Please answer the mission which you can reach from clicking the below given link");
			
				
				/*
				  Description: Fill Thank You Message
			    */
				By btnMsgThree = By.xpath(".//div[@class='list-group-item ng-scope']//h4[contains(text(),'Message 3 of 3')]");
				driver.findElement(btnMsgThree).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				By txtThankMessage = By.xpath(".//div[@id='thankYouMessage']//div[contains(@id,'taTextElement')]");
				driver.findElement(txtThankMessage).sendKeys("Thank You");
				System.out.println("typeThankYouMessage");
				
				
				/*
				  Description: Go to Step Four
				*/
				
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				By stepFour = By.xpath(".//*[@id='step-four']");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(stepFour).click();
				System.out.println("gotoStepFour");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				WebElement lblParticipantList = driver.findElement(By.xpath("//h4[contains(text(),'Please select the participant list, or create a new one.')]"));
				Assert.assertNull(lblParticipantList.getAttribute("disabled"));
				
					
			    /*
				  Description: select participant list
				*/
				By SelectList = By.xpath(".//td[contains(text(),'"+ListName+"')]/..//label/input[@type='checkbox']");
				driver.findElement(SelectList).click();
				

				/*
				  Description: go to Step Five
				*/
				By stepFive = By.xpath(".//*[@id='step-five']");
				// wait.until(ExpectedConditions.elementToBeClickable(stepFive));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				driver.findElement(stepFive).click();
				System.out.println("gotoStepFive");

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				WebElement lblSendMission = driver.findElement(By.xpath("//h4[contains(text(),'Please review your Missions carefully before sending')]"));
				Assert.assertNull(lblSendMission.getAttribute("disabled"));	
			
				/*
				  Description: click Send Mission
				 */
				
				By btnSendMission = By.xpath(".//button[@class='btn btn-primary']/span[contains(text(),'Send')]");
				driver.findElement(btnSendMission).click();
				System.out.println("clickSendMission");
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				By btnSendMissionNow = By.xpath(".//button[@class='btn btn-primary' and contains(text(),'Yes')]");
				driver.findElement(btnSendMissionNow).click();
				

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				By btnSendMissionQueue = By.xpath(".//button[@class='btn btn-primary ng-binding' and contains(text(),'OK')]");
				driver.findElement(btnSendMissionQueue).click();
				
				
			}	
	
	
	//-----------------------------------------Customer Performance missions----------------------------------------------------------------------------
	
	
	/* 
	Description : This method is used to create URL - Performance missions for Customers
	              
   	Parameters : 
   	
	type: URL
	PerMission: Data table is used with following column
	           |Action Position|
	         Map position values should be the names/positions of the actions
	         ex:     |1.1.2|
                     |2.1.2|
			*/		
	
		public void CustomerPMDistrbutionTypeURL(String type, DataTable PerMission) {
			
				By radioDistribType = By.xpath(".//*[@id='distributionType" + type + "']");
				
				
					wait.until(ExpectedConditions.elementToBeClickable(radioDistribType));
					driver.findElement(radioDistribType).click();
					System.out.println("selectDistrbutionType");	
				
				/* 
					 Description: Clicks Save Mission
				 */	
				By btnPerfMissionSave = By.xpath(".//button[contains(text(),'Save')]");
				wait.until(ExpectedConditions.elementToBeClickable(btnPerfMissionSave));
				driver.findElement(btnPerfMissionSave).click();
				System.out.println("clickSaveMission");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				WebElement drpdwnledgend = driver.findElement(By.xpath("//div[@class='col-xs-7 pad-l-0 legend-container dropdown']//a[@class='dropdown-toggle']"));
				Assert.assertNull(drpdwnledgend.getAttribute("disabled"));
				
		
	
				/*
				  Description: Select Actions
				*/
				List<Map<String, String>> list = PerMission.asMaps(String.class, String.class);
				for(int i=0; i<list.size(); i++) {
					
					/*
					  Description: user can select many/one Actions
					*/
					
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					
				By checkBoxChooseAction = By.xpath("//td[contains(text(),'"+list.get(i).get("Action Position")+"')]/..//td/input[@type='checkbox']");
				//wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxChooseAction));
				driver.findElement(checkBoxChooseAction).click();
				System.out.println("selectActions");
			}
			
			
				/*
				  Description: Navigates to Step Two
				*/
			
					By stepTwo = By.xpath(".//*[@id='step-two']");
					// wait.until(ExpectedConditions.elementToBeClickable(stepTwo));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					
					driver.findElement(stepTwo).click();
					System.out.println("gotoStepTwo");
					
					
					WebElement lblParticpantInstruction = driver.findElement(By.xpath("//h4[@class='title' and contains(text(), 'Please write instructions for each Action included in your Mission')]"));
					Assert.assertNull(lblParticpantInstruction.getAttribute("disabled"));
				
	
					/*
					  Description: type Participant Instructions
					*/
					for(int a=2; a<list.size()+2; a++) {
						
						try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}			
								
					
						
					By txtParticipantInstructions = By.xpath(".//div[@class='list-group-body show-hide ng-scope']//div[@placeholder='Enter detailed instructions for users']//div[@placeholder='Enter detailed instructions for users']");
					// wait.until(ExpectedConditions.presenceOfElementLocated(txtParticipantInstructions));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(txtParticipantInstructions).sendKeys("Please answer the below questionnaire");
					System.out.println("typeParticipantInstructions");
				
					/*
					  Description: select Media Upload
					*/
					By checkBoxMediaInstructions = By.xpath("//div[@class='list-group-body show-hide ng-scope']//input[@type='checkbox']");
					// wait.until(ExpectedConditions.presenceOfElementLocated(checkBoxMediaInstructions));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(checkBoxMediaInstructions).click();
					System.out.println("selectMediaUpload");
				
	
					/*
					  Description: type Media Instructions 
					 */
					By txtMediaInstructions = By.xpath("//div[@class='list-group-body show-hide ng-scope']//div[@placeholder='Enter specific directions for what kind of media to upload and what it should be focused on']//div[@placeholder='Enter specific directions for what kind of media to upload and what it should be focused on']");
					wait.until(ExpectedConditions.presenceOfElementLocated(txtMediaInstructions));
					driver.findElement(txtMediaInstructions).sendKeys("Please upload media files with less than the size of 300Mb");
					System.out.println("typeMediaInstructions");
					
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
						
					if (a<list.size()+1){
					By txtMediaInstructionsbtnActionSteps = By.xpath(".//div/h4[contains(text(),'Action Item "+a+"')]");
					
					/* 
					 Description:scrolling to the particular element
					 */	
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					
					driver.findElement(txtMediaInstructionsbtnActionSteps).click();	
					}							
					}				
						
					/*
					  Description: navigate To Step 3
					*/
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					By stepThree = By.xpath(".//button[@id='step-three']");
					wait.until(ExpectedConditions.elementToBeClickable(stepThree));
					
					driver.findElement(stepThree).click();
					System.out.println("gotoStepThree");
					
					
					WebElement lblMessages = driver.findElement(By.xpath("//h4[contains(text(),'After Mission is submitted, the below message will appear.')]"));
					Assert.assertNull(lblMessages.getAttribute("disabled"));
					
					/*
					  Description: select Terms and Conditions
					 */
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
						
					By rbtnEnableTerms  = By.xpath(".//input[@id='trmConEnable']");
					driver.findElement(rbtnEnableTerms).click();
					
					
					System.out.println("Enabled Terms");
								
					/*
					  Description: type Thank You Message
					*/
					
										
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(rbtnEnableTerms).click();
					
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
					

					By btnNext = By.xpath("//section[@class='row mission ng-scope']//button[@type='button'][contains(text(),'Next')]");
					driver.findElement(btnNext).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					By txtThankMessage = By.xpath(".//div[@id='thankYouMessage']//div[contains(@id,'taTextElement')]");
					// wait.until(ExpectedConditions.presenceOfElementLocated(txtThankMessage));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(txtThankMessage).sendKeys("Thank You");
					System.out.println("typeThankYouMessage");
				
	
					/*
					  Description: go to Step Five
					 */
					By stepFive = By.xpath(".//*[@id='step-five']");
					// wait.until(ExpectedConditions.elementToBeClickable(stepFive));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
					driver.findElement(stepFive).click();
					System.out.println("gotoStepFive");
	
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					/*
					  Description: click Generate URL
					*/
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
					
					By btnGenerateURL = By.xpath(".//button[@class='btn btn-primary']/span[contains(text(),'Generate URL')]");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// wait.until(ExpectedConditions.elementToBeClickable(btnGenerateURL));
					driver.findElement(btnGenerateURL).click();
					System.out.println("clickGenerateURL");
					
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					WebElement btnCopyUrl = driver.findElement(By.xpath("//button[@ng-init='initCopyLinkPopover()']"));
					Assert.assertNull(btnCopyUrl.getAttribute("disabled"));			
			}
		
		//--------------------------------------Customer Email Performance Missions--------------------------------------------
		
		
		/* 
		Description : This method is used to create Email - Performance missions for Customers
		              
	   	Parameters : 
	   	ListName: The name of the mail list (these list are created in ListPage)
		type: Email 
		PerMission: Data table is used with following column
		           |Action Points|
		         Action point values/positions should be the names of the available actions
		         ex:     
						 |1.1.1|
						 |1.1.2|
		 
				*/	
							
		
		public void CustomerPMDistrbutionTypeEmail(String type,String ListName, DataTable PerMission) {
			
			
			
			//clickSaveMission
			By btnPerfMissionSave = By.xpath(".//button[contains(text(),'Save')]");
			wait.until(ExpectedConditions.elementToBeClickable(btnPerfMissionSave));
			driver.findElement(btnPerfMissionSave).click();
			System.out.println("clickSaveMission");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement drpdwnledgend = driver.findElement(By.xpath("//div[@class='col-xs-7 pad-l-0 legend-container dropdown']//a[@class='dropdown-toggle']"));
			Assert.assertNull(drpdwnledgend.getAttribute("disabled"));
			
		

			/* 
			  Description: select Action Points
			*/
			
			List<Map<String, String>> list = PerMission.asMaps(String.class, String.class);
			for(int i=0; i<list.size(); i++) {
				
				/* 
				  Description: user can select many/one actions/action 
				*/
				
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				
			By checkBoxChooseAction = By.xpath("//td[contains(text(),'"+list.get(i).get("Action Position")+"')]/..//td/input[@type='checkbox']");
			//wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxChooseAction));
			driver.findElement(checkBoxChooseAction).click();
			System.out.println("selectActions");
		}
			
			
			/* 
			  Description: User navigates to Step Two
			*/
			
					By stepTwo = By.xpath(".//*[@id='step-two']");
					// wait.until(ExpectedConditions.elementToBeClickable(stepTwo));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					
					driver.findElement(stepTwo).click();
					System.out.println("gotoStepTwo");
					
					
					WebElement lblParticpantInstruction = driver.findElement(By.xpath("//h4[@class='title' and contains(text(), 'Please write instructions for each Action included in your Mission')]"));
					Assert.assertNull(lblParticpantInstruction.getAttribute("disabled"));
				

					/* 
					  Description: type Participant Instructions
					 */			
					for(int a=2; a<list.size()+2; a++) {
						
						try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}			
								
					
						
					By txtParticipantInstructions = By.xpath(".//div[@class='list-group-body show-hide ng-scope']//div[@placeholder='Enter detailed instructions for users']//div[@placeholder='Enter detailed instructions for users']");
					// wait.until(ExpectedConditions.presenceOfElementLocated(txtParticipantInstructions));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(txtParticipantInstructions).sendKeys("Please answer the below questionnaire");
					System.out.println("typeParticipantInstructions");
				
					/* 
					  Description: select Media Upload
					*/
					By checkBoxMediaInstructions = By.xpath("//div[@class='list-group-body show-hide ng-scope']//input[@type='checkbox']");
					// wait.until(ExpectedConditions.presenceOfElementLocated(checkBoxMediaInstructions));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(checkBoxMediaInstructions).click();
					System.out.println("selectMediaUpload");
				

					/* 
					  Description: type media instructions 
					*/
					
					By txtMediaInstructions = By.xpath("//div[@class='list-group-body show-hide ng-scope']//div[@placeholder='Enter specific directions for what kind of media to upload and what it should be focused on']//div[@placeholder='Enter specific directions for what kind of media to upload and what it should be focused on']");
					wait.until(ExpectedConditions.presenceOfElementLocated(txtMediaInstructions));
					driver.findElement(txtMediaInstructions).sendKeys("Please upload media files with less than the size of 300Mb");
					System.out.println("typeMediaInstructions");
					
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
						
					if (a<list.size()+1){
					By txtMediaInstructionsbtnActionSteps = By.xpath(".//div/h4[contains(text(),'Action Item "+a+"')]");
					/*  			 
					  Description: scrolling to the particular element
					 */
						
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					
					driver.findElement(txtMediaInstructionsbtnActionSteps).click();	
					}							
					}				
						
					/*  			 
					  Description: go to Step Three
					*/
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					By stepThree = By.xpath(".//button[@id='step-three']");
					wait.until(ExpectedConditions.elementToBeClickable(stepThree));
					
					driver.findElement(stepThree).click();
					System.out.println("gotoStepThree");
					
					
					WebElement lblMessages = driver.findElement(By.xpath("//h4[contains(text(),'Please Setup Messages')]"));
					Assert.assertNull(lblMessages.getAttribute("disabled"));
					
					/*  			 
					  Description: Fill Mission  Invitation Email Details
					*/
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					By txtEmailSubject = By.xpath(".//input[@id='welcomeSubjectLine']");
					driver.findElement(txtEmailSubject).sendKeys("You are invited for a performance mission");
					
					By txtEmailbody = By.xpath("//fieldset/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div[3]");
					driver.findElement(txtEmailbody).sendKeys("We would like to see your preference on the product we newly introduced. Please answer the mission which you can reach from clicking the below given link");
				
					/*  			 
					  Description: Fill Terms and Conditions
					*/
					
					By btnFillTerms = By.xpath(".//div[@class='list-group-item ng-scope']//h4[contains(text(),'Message 2 of 4')]");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(btnFillTerms).click();
					
					
					By rbtEnableTerms = By.xpath(".//input[@id='trmConEnable']");
					driver.findElement(rbtEnableTerms).click();
					
					
					/*  			 
					  Description: FillThankYouMessage
					*/
					By btnMsgThree = By.xpath(".//div[@class='list-group-item ng-scope']//h4[contains(text(),'Message 4 of 4')]");
					driver.findElement(btnMsgThree).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					By txtThankMessage = By.xpath(".//div[@id='thankYouMessage']//div[contains(@id,'taTextElement')]");
					driver.findElement(txtThankMessage).sendKeys("Thank You");
					System.out.println("typeThankYouMessage");
					
					
					/*  			 
					  Description: go to Step Four
					*/
					
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
					
					By stepFour = By.xpath(".//*[@id='step-four']");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(stepFour).click();
					System.out.println("gotoStepFour");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					WebElement lblParticipantList = driver.findElement(By.xpath("//h4[contains(text(),'Please select the participant list, or create a new one.')]"));
					Assert.assertNull(lblParticipantList.getAttribute("disabled"));
					
						
					/*  			 
					  Description: select participant list
					*/
					By SelectList = By.xpath(".//td[contains(text(),'"+ListName+"')]/..//label/input[@type='checkbox']");
					driver.findElement(SelectList).click();
					

					/*  			 
					  Description: go to Step Five
					*/
					By stepFive = By.xpath(".//*[@id='step-five']");
					// wait.until(ExpectedConditions.elementToBeClickable(stepFive));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					driver.findElement(stepFive).click();
					System.out.println("gotoStepFive");

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					WebElement lblSendMission = driver.findElement(By.xpath("//h4[contains(text(),'Please review your Missions carefully before sending')]"));
					Assert.assertNull(lblSendMission.getAttribute("disabled"));	
				
					/*  			 
					  Description: click Send Mission
					*/
					
					By btnSendMission = By.xpath(".//button[@class='btn btn-primary']/span[contains(text(),'Send')]");
					driver.findElement(btnSendMission).click();
					System.out.println("clickSendMission");
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					By btnSendMissionNow = By.xpath(".//button[@class='btn btn-primary' and contains(text(),'Yes')]");
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					driver.findElement(btnSendMissionNow).click();
					

				
					
					By btnSendMissionQueue = By.xpath(".//button[@class='btn btn-primary ng-binding' and contains(text(),'OK')]");
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
					
					driver.findElement(btnSendMissionQueue).click();
					
						
					
				}			
		
		  /* 
		    Description: This method is used to copy a URL Mission
		   */
	     		public void gotoURLmission() {
				By btnCopyURL = By.xpath(".//button[contains(text(),'Copy Link')]");
				driver.findElement(btnCopyURL).click();
				// Write down the text copied to the clipboard
				driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
				System.out.println(Keys.chord(Keys.LEFT_CONTROL, "v"));
	
    
	}
			
			
			
			
			
}
		
	
