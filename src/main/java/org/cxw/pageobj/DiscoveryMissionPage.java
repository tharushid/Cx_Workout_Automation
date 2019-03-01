package org.cxw.pageobj;


import org.cxw.setup.PropertyFile;
import org.cxw.setup.SetUp;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

import cucumber.api.DataTable;

    
   

	public class DiscoveryMissionPage {
				
				
		private WebDriver driver = SetUp.setupDriver();
		private WebDriverWait wait = new WebDriverWait(driver, 30);
		
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
					}
			
			 /* 
			Description : This method navigates to Mission type selected from left navigation menu		
		   	Parameters : 
			MissionType: Employees|Project Team|Customers
		    */		
			
			public void clickLeftNavMissionListPage(String MissionType) {
				
				
				
				By leftNavType = By.xpath(".//a[contains(text(),'"+MissionType+"')]");
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				driver.findElement(leftNavType).click();
				System.out.println("clickleftNav"+MissionType);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				WebElement btnCreateMission = driver.findElement(By.xpath("//button[contains(text(),'Create New Discovery Mission')]"));
				Assert.assertNull(btnCreateMission.getAttribute("disabled"));
			}
			
			 /* 
			Description : This method clicks on New Discovery Mission button		
		   	
		*/		
			public void clickNewDiscoveryMissionBtn() {
				By btnDiscoveryMission = By.xpath(".//button[contains(text(),'Create New Discovery Mission')]");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				driver.findElement(btnDiscoveryMission).click();
				System.out.println("clickbtnDiscoveryMissionBtn");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				WebElement lbtbtnDiscoveryMission = driver.findElement(By.xpath(".//h3[contains(text(),'Discovery Mission Setup')]"));
				Assert.assertNull(lbtbtnDiscoveryMission.getAttribute("disabled"));
				
			}
			
			 /* 
			Description : This method gives a name to the Mission 
		   	Parameters : 
			MissionName: Any unique name
		    */		
			
			public void typeDiscoveryMissiontitle(String MissionName) {
				
				
				By txtDiscoveryMissionTitle = By.xpath(".//input[@id='title']");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(txtDiscoveryMissionTitle).sendKeys(MissionName);
			
			}
			
			
			/* 
			Description : This method is used to create URL - discovery missions for Project team and Employees
			              Since CUSTOMER MISSIONS have some additional steps, a separate method is used to create URL - discovery missions for customers 
		   	Parameters : 
			type: URL
			MapPoints: Data table is used with following column
			           |Map Position|
			         Map position values should be the names of the available stages, touchpoints and actions
			         ex:     |1 - S1_Updated|
    						 |1.1 - S1-T1_Updated|
    						 |1.1.1 - S1-T1-A1_Updated|
			 
					*/		
			

			public void DistrbutionTypeURL(String type, DataTable MapPoints) {
					By radioDistribType = By.xpath(".//*[@id='distributionType" + type + "']");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					driver.findElement(radioDistribType).click();
					System.out.println("selectDistrbutionType");	
				
					/*
					 Description : clickSaveMission
					 */
					
					By btnDiscoveryMissionSave = By.xpath(".//button[contains(text(),'Save')]");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(btnDiscoveryMissionSave).click();
					System.out.println("clickSaveMission");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					WebElement txtMsg = driver.findElement(By.xpath(".//h4[contains(text(),'Select one or more Stages, Touchpoints and/or Acti')]"));
					Assert.assertNull(txtMsg.getAttribute("disabled"));
				
					
					/*
					 Description : select Map Points
					*/ 
					
					List<Map<String, String>> list = MapPoints.asMaps(String.class, String.class);
					for(int i=0; i<list.size(); i++) {
						
					/* 
					 Description : user can select many/one map points
					*/ 
						
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		
						
					By checkBoxChoosePoints = By.xpath(".//span[contains(text(),'"+list.get(i).get("Map Position")+"')]/..//input[@type='checkbox']");
					//wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxChooseAction));
					driver.findElement(checkBoxChoosePoints).click();
					System.out.println("selectMapPoints");
				}
					
					/* 
					 Description : Navigates to the second step
					*/ 
					
					By stepTwo = By.xpath(".//*[@id='step-two']");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					
					driver.findElement(stepTwo).click();
					System.out.println("gotoStepTwo");
					
					
					WebElement lblParticpantInstruction = driver.findElement(By.xpath("//h4[@class='title' and contains(text(), 'Please write instructions for each item (stage, touchpoint and/or actions) in your Mission')]"));
					Assert.assertNull(lblParticpantInstruction.getAttribute("disabled"));
				

					/* 
					 Description : type Participant Instructions
					*/ 
					
					
					int divno=1;
					
					for(int a=2; a<=list.size()+1; a++) {
						
						
						
						try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}			
								
					
						
					By txtParticipantInstructions = By.xpath(".//div[@class='list-group-body show-hide ng-scope']//div[@placeholder='Enter detailed instructions for users']//div[@placeholder='Enter detailed instructions for users']");
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
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(txtMediaInstructions).sendKeys("Please upload media files with less than the size of 300Mb");
					System.out.println("typeMediaInstructions");
					
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					
					/* 
					 Description : Script adds 9 different questions (in default settings)
                                   Required option is selected for all the question types
					               There is an issue with selecting N/A option for some question types					 
					*/
					
					
					By btnAddQuestions = By.xpath(".//div["+divno+"]/div[4]/aet-discovery-questions/div/button[1]");
					driver.findElement(btnAddQuestions).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					WebElement panelQuestions = driver.findElement(By.xpath("//h4[@class='ng-binding']"));
					Assert.assertNull(panelQuestions.getAttribute("disabled"));
					
					/* 
					 Description : Add Free-text question					 
					*/
					
					By menuAddFreeTextQuestion = By.xpath(".//div[contains(text(),'Free Text')]");
					driver.findElement(menuAddFreeTextQuestion).click();
					
					/* 
					 Description : make the question required
					 
					*/
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					By rbtnRequired = By.xpath("//input[@name='isRequired']");
					driver.findElement(rbtnRequired).click();
					
					By saveQuestion = By.xpath("//button[@class='btn btn-primary'][contains(text(),'Save')]");
					driver.findElement(saveQuestion).click();
					System.out.println("Add Free-text question");
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
					
					/* 
					 Description : Adding multiple choice questions
					*/
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(btnAddQuestions).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
								
					By menuAddmultiplechoiceQuestion = By.xpath(".//div[contains(text(),'Multiple Choice')]");
					driver.findElement(menuAddmultiplechoiceQuestion).click();
					
					         
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
						//make the question required
					driver.findElement(rbtnRequired).click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(saveQuestion).click();
					System.out.println("Adding multiple choice questions");
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
					
					/* 
					 Description : Add Yes/No question
					 */
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					
					
					driver.findElement(btnAddQuestions).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					By menuYesNoQuestion = By.xpath(".//div[contains(text(),'Yes / No')]");
					driver.findElement(menuYesNoQuestion).click();
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
								         
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					
					
					/* 
					 Description : make the question required					 
					 */
					
					
					driver.findElement(rbtnRequired).click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
								
					
					driver.findElement(saveQuestion).click();
					System.out.println("Add Yes/No question");
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
					//Add Rank question
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(btnAddQuestions).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					By menuRankQuestion = By.xpath(".//div[@class='question-types']//div[4]");
					driver.findElement(menuRankQuestion).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
						//make the question required
					driver.findElement(rbtnRequired).click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
										
					driver.findElement(saveQuestion).click();
					System.out.println("Add Rank question");
					
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
					
					/* 
					 Description : Add Weighted Ranking question
					*/
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(btnAddQuestions).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					By menuWeightRankQuestion = By.xpath(".//div[contains(text(),'Weighted Ranking')]");
					driver.findElement(menuWeightRankQuestion).click();
					
					         
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					
						//make the question required
					driver.findElement(rbtnRequired).click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					
					//enable N/A option
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(saveQuestion).click();
					System.out.println("Add Weighted Ranking question");
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
					
					/* 
					 Description : Add Numeric slider question					 
					 */
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(btnAddQuestions).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					By menuNumericSliderQuestion = By.xpath(".//div[contains(text(),'Numeric Slider')]");
					driver.findElement(menuNumericSliderQuestion).click();
						         
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
						//make the question required
					driver.findElement(rbtnRequired).click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					//enable N/A option
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(saveQuestion).click();
					System.out.println("Add Numeric slider question");
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
					
					//Add Label slider question
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(btnAddQuestions).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					By menuLabelSliderQuestion = By.xpath(".//div[contains(text(),'Label Slider')]");
					driver.findElement(menuLabelSliderQuestion).click();
					
					         
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
						//make the question required
					driver.findElement(rbtnRequired).click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					//enable N/A option
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(saveQuestion).click();
					System.out.println("Add Label slider question");
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
					
					//Add NetPromoteScorer question
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(btnAddQuestions).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					By menuNetPromoteScorerrQuestion = By.xpath(".//div[contains(text(),'Net Promoter Score')]");
					driver.findElement(menuNetPromoteScorerrQuestion).click();
					
					         
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
						//make the question required
					driver.findElement(rbtnRequired).click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(saveQuestion).click();
					System.out.println("Add NetPromoter slider question");
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
					
					//Add Rating slider question
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(btnAddQuestions).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					By menuRatingSliderQuestion = By.xpath(".//div[contains(text(),'Rating Slider')]");
					driver.findElement(menuRatingSliderQuestion).click();
					
					         
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					//make the question required
					driver.findElement(rbtnRequired).click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}

					/* 
					 Description :enable N/A option
					*/
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					driver.findElement(saveQuestion).click();
					System.out.println("Add Rating slider question");
					
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
					
					if (a<=list.size()){
						
					By txtMediaInstructionsbtnActionSteps = By.xpath(".//div/h4[contains(text(),'Item "+a+" of "+list.size()+"')]");
					System.out.println("list size = "+list.size());
					System.out.println("a  = "+a);
					
					
					// Description : scrolling to the particular element
						
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block 
						e.printStackTrace();
					}
					
					driver.findElement(txtMediaInstructionsbtnActionSteps).click();	
					}						
									
						divno++;
					
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
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					By txtThankMessage = By.xpath(".//div[@id='thankYouMessage']//div[contains(@id,'taTextElement')]");
					//wait.until(ExpectedConditions.presenceOfElementLocated(txtThankMessage));
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(txtThankMessage).sendKeys("Thank You");
					System.out.println("typeThankYouMessage");
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");

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
				
			
			
     //----------------------------------------------EMAIL discovery mission distribution-------------------------
			
			
			/* 
			Description : This method is used to create Email - discovery missions for Project team and Employees
			              Since CUSTOMER MISSIONS have some additional steps, a separate method is used to create EMAIL - discovery missions for customers 
		   	Parameters : 
		   	ListName: The name of the mail list (these list are created in ListPage)
			type: Email
			MapPoints: Data table is used with following column
			           |Map Position|
			         Map position values should be the names of the available stages, touchpoints and actions
			         ex:     |1 - S1_Updated|
    						 |1.1 - S1-T1_Updated|
    						 |1.1.1 - S1-T1-A1_Updated|
			 
					*/		
			
			
			
			
			public void DistrbutionTypeEMAIL(String ListName,String type,DataTable MapPoints) {
				By radioDistribType = By.xpath(".//*[@id='distributionType" + type + "']");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				System.out.println("selectDistrbutionType");	
			
				/*
				  Description :click Save Mission
				*/
				By btnDiscoveryMissionSave = By.xpath(".//button[contains(text(),'Save')]");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(btnDiscoveryMissionSave).click();
				System.out.println("clickSaveMission");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				WebElement txtMsg = driver.findElement(By.xpath(".//h4[contains(text(),'Select one or more Stages, Touchpoints and/or Actions')]"));
				Assert.assertNull(txtMsg.getAttribute("disabled"));
			
				
				/*
				  Description :select Map Points
				*/ 
				
				List<Map<String, String>> list = MapPoints.asMaps(String.class, String.class);
				for(int i=0; i<list.size(); i++) {
					
					/*
					  Description : user can select many/one map points
					*/
					
					
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					
				By checkBoxChoosePoints = By.xpath(".//span[contains(text(),'"+list.get(i).get("Map Position")+"')]/..//input[@type='checkbox']");
				//wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxChooseAction));
				driver.findElement(checkBoxChoosePoints).click();
				System.out.println("selectMapPoints");
			}
				
				/*
				  Description : Navigates to Step Two
				 */
				
				By stepTwo = By.xpath(".//*[@id='step-two']");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				driver.findElement(stepTwo).click();
				System.out.println("gotoStepTwo");
				
				
				WebElement lblParticpantInstruction = driver.findElement(By.xpath("//h4[@class='title' and contains(text(), 'Please write instructions for each item (stage, touchpoint and/or actions) in your Mission')]"));
				Assert.assertNull(lblParticpantInstruction.getAttribute("disabled"));
			

				/*
				  Description : type Participant Instructions
			   */  
				
				int divno=1;
				
				for(int a=2; a<=list.size()+1; a++) {
					
					
					
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
							
				
					
				By txtParticipantInstructions = By.xpath(".//div[@class='list-group-body show-hide ng-scope']//div[@placeholder='Enter detailed instructions for users']//div[@placeholder='Enter detailed instructions for users']");
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
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(txtMediaInstructions).sendKeys("Please upload media files with less than the size of 300Mb");
				System.out.println("typeMediaInstructions");
				
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				/*
				  Description : Adding questions
				*/
					
				
				By btnAddQuestions = By.xpath(".//div["+divno+"]/div[4]/aet-discovery-questions/div/button[1]");
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				WebElement panelQuestions = driver.findElement(By.xpath("//h4[@class='ng-binding']"));
				Assert.assertNull(panelQuestions.getAttribute("disabled"));
				
				/*
				  Description : Add Free-text question
				*/
				
				By menuAddFreeTextQuestion = By.xpath(".//div[contains(text(),'Free Text')]");
				driver.findElement(menuAddFreeTextQuestion).click();
				
				         //make the question required
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By rbtnRequired = By.xpath("//input[@name='isRequired']");
				driver.findElement(rbtnRequired).click();
				
				By saveQuestion = By.xpath("//button[@class='btn btn-primary'][contains(text(),'Save')]");
				driver.findElement(saveQuestion).click();
				System.out.println("Add Free-text question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/*
				  Description : Adding multiple choice questions
				*/
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
							
				By menuAddmultiplechoiceQuestion = By.xpath(".//div[contains(text(),'Multiple Choice')]");
				driver.findElement(menuAddmultiplechoiceQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Adding multiple choice questions");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/*
				  Description : Add Yes/No question
				*/
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuYesNoQuestion = By.xpath(".//div[contains(text(),'Yes / No')]");
				driver.findElement(menuYesNoQuestion).click();
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
							         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
							
				
				driver.findElement(saveQuestion).click();
				System.out.println("Add Yes/No question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				//Add Rank question
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuRankQuestion = By.xpath(".//div[@class='question-types']//div[4]");
				driver.findElement(menuRankQuestion).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				//enable N/A option
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Rank question");
				
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/*
				  Description : Add Weighted Ranking question
				*/  
				 
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuWeightRankQuestion = By.xpath(".//div[contains(text(),'Weighted Ranking')]");
				driver.findElement(menuWeightRankQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				//enable N/A option
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Weighted Ranking question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/*
				  Description :Add Numeric slider question
				*/  
				 
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuNumericSliderQuestion = By.xpath(".//div[contains(text(),'Numeric Slider')]");
				driver.findElement(menuNumericSliderQuestion).click();
					         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				/*
				  Description : enable N/A option
				*/
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Numeric slider question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/*
				  Description : Add Label slider question
				*/
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuLabelSliderQuestion = By.xpath(".//div[contains(text(),'Label Slider')]");
				driver.findElement(menuLabelSliderQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				/*
				  Description :enable N/A option
				*/
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Label slider question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/*
				  Description :Add NetPromoteScorer question
				*/
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuNetPromoteScorerrQuestion = By.xpath(".//div[contains(text(),'Net Promoter Score')]");
				driver.findElement(menuNetPromoteScorerrQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add NetPromoter slider question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/*
				  Description: Add Rating slider question
				*/
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuRatingSliderQuestion = By.xpath(".//div[contains(text(),'Rating Slider')]");
				driver.findElement(menuRatingSliderQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}

				/*
				  Description: enable N/A option
				*/
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Rating slider question");
				
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				if (a<=list.size()){
					
				By txtMediaInstructionsbtnActionSteps = By.xpath(".//div/h4[contains(text(),'Item "+a+" of "+list.size()+"')]");
				System.out.println("list size = "+list.size());
				System.out.println("a  = "+a);
				
				/*
				  Description: scrolling to the particular element
				*/
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				driver.findElement(txtMediaInstructionsbtnActionSteps).click();	
				}						
								
					divno++;
				
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
				driver.findElement(txtEmailSubject).sendKeys("You are invited for a Discovery mission");
				
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
				
				
		}		
			
			
	//-----------------------------------------Customer discovery missions----------------------------------------------------------------------------
			
			
			/* 
			Description : This method is used to create URL - discovery missions for Customers
			              
		   	Parameters : 
		   	
			type: URL
			MapPoints: Data table is used with following column
			           |Map Position|
			         Map position values should be the names of the available stages, touchpoints and actions
			         ex:     |1 - S1_Updated|
    						 |1.1 - S1-T1_Updated|
    						 |1.1.1 - S1-T1-A1_Updated|
			 
					*/	
			
			public void CustomerDistrbutionTypeURL(String type, DataTable MapPoints) {
				By radioDistribType = By.xpath(".//*[@id='distributionType" + type + "']");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				driver.findElement(radioDistribType).click();
				System.out.println("selectDistrbutionType");	
			
				/* 
				 Description: Clicks Save Mission
				 */
				By btnDiscoveryMissionSave = By.xpath(".//button[contains(text(),'Save')]");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(btnDiscoveryMissionSave).click();
				System.out.println("clickSaveMission");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				WebElement txtMsg = driver.findElement(By.xpath(".//h4[contains(text(),'Select one or more Stages, Touchpoints and/or Acti')]"));
				Assert.assertNull(txtMsg.getAttribute("disabled"));
			
				
				/*
				  Description: Select Map Points
				*/ 
				
				List<Map<String, String>> list = MapPoints.asMaps(String.class, String.class);
				for(int i=0; i<list.size(); i++) {
					
					/*
					  Description: user can select many/one map points
					*/
					
					
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					
				By checkBoxChoosePoints = By.xpath(".//span[contains(text(),'"+list.get(i).get("Map Position")+"')]/..//input[@type='checkbox']");
				//wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxChooseAction));
				driver.findElement(checkBoxChoosePoints).click();
				System.out.println("selectMapPoints");
			}
				
				/*
				  Description: Navigates to Step Two
				*/
				
				By stepTwo = By.xpath(".//*[@id='step-two']");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				driver.findElement(stepTwo).click();
				System.out.println("gotoStepTwo");
				
				
				WebElement lblParticpantInstruction = driver.findElement(By.xpath("//h4[@class='title' and contains(text(), 'Please write instructions for each item (stage, touchpoint and/or actions) in your Mission')]"));
				Assert.assertNull(lblParticpantInstruction.getAttribute("disabled"));
			

				/*
				  Description: type Participant Instructions
				*/
				
				int divno=1;
				
				for(int a=2; a<=list.size()+1; a++) {
					
					
					
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
							
				
					
				By txtParticipantInstructions = By.xpath(".//div[@class='list-group-body show-hide ng-scope']//div[@placeholder='Enter detailed instructions for users']//div[@placeholder='Enter detailed instructions for users']");
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
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(txtMediaInstructions).sendKeys("Please upload media files with less than the size of 300Mb");
				System.out.println("typeMediaInstructions");
				
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				/*
				  Description: Adding questions
				*/			
				
				
				By btnAddQuestions = By.xpath(".//div["+divno+"]/div[4]/aet-discovery-questions/div/button[1]");
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				WebElement panelQuestions = driver.findElement(By.xpath("//h4[@class='ng-binding']"));
				Assert.assertNull(panelQuestions.getAttribute("disabled"));
				
				/*
				  Description: Add Free-text question
				*/
				
				By menuAddFreeTextQuestion = By.xpath(".//div[contains(text(),'Free Text')]");
				driver.findElement(menuAddFreeTextQuestion).click();
				
				         //make the question required
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By rbtnRequired = By.xpath("//input[@name='isRequired']");
				driver.findElement(rbtnRequired).click();
				
				By saveQuestion = By.xpath("//button[@class='btn btn-primary'][contains(text(),'Save')]");
				driver.findElement(saveQuestion).click();
				System.out.println("Add Free-text question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/*
				  Description: Adding multiple choice questions
				*/
				
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
							
				By menuAddmultiplechoiceQuestion = By.xpath(".//div[contains(text(),'Multiple Choice')]");
				driver.findElement(menuAddmultiplechoiceQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Adding multiple choice questions");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/*
				  Description: Add Yes/No question
				*/
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuYesNoQuestion = By.xpath(".//div[contains(text(),'Yes / No')]");
				driver.findElement(menuYesNoQuestion).click();
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
							         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
							
				
				driver.findElement(saveQuestion).click();
				System.out.println("Add Yes/No question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");


				/*
				  Description: Add Rank question
				*/
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuRankQuestion = By.xpath(".//div[@class='question-types']//div[4]");
				driver.findElement(menuRankQuestion).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				//enable N/A option
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Rank question");
				
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/*
				  Description: Add Weighted Ranking question
				*/  
				  
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuWeightRankQuestion = By.xpath(".//div[contains(text(),'Weighted Ranking')]");
				driver.findElement(menuWeightRankQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				//enable N/A option
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Weighted Ranking question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/*
				  Description: Add Numeric slider question
				*/
				
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuNumericSliderQuestion = By.xpath(".//div[contains(text(),'Numeric Slider')]");
				driver.findElement(menuNumericSliderQuestion).click();
					         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				//enable N/A option
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Numeric slider question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/*
				  Description: Add Label slider question
				 */
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuLabelSliderQuestion = By.xpath(".//div[contains(text(),'Label Slider')]");
				driver.findElement(menuLabelSliderQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				//enable N/A option
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Label slider question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/*
				  Description: Add NetPromoteScorer question
				*/
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuNetPromoteScorerrQuestion = By.xpath(".//div[contains(text(),'Net Promoter Score')]");
				driver.findElement(menuNetPromoteScorerrQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add NetPromoter slider question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/*
				  Description: Add Rating slider question
				*/
				
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuRatingSliderQuestion = By.xpath(".//div[contains(text(),'Rating Slider')]");
				driver.findElement(menuRatingSliderQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				//enable N/A option
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Rating slider question");
				
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				if (a<=list.size()){
					
				By txtMediaInstructionsbtnActionSteps = By.xpath(".//div/h4[contains(text(),'Item "+a+" of "+list.size()+"')]");
				System.out.println("list size = "+list.size());
				System.out.println("a  = "+a);

				/*
				  Description: scrolling to the particular element
				*/
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				driver.findElement(txtMediaInstructionsbtnActionSteps).click();	
				}						
								
					divno++;
				
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
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");

			
					
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
	
			
	//--------------------------------------Customer Email Discovery Missions--------------------------------------------
			
			
			/* 
			Description : This method is used to create Email - discovery missions for Customers
			              
		   	Parameters : 
		   	ListName: The name of the mail list (these list are created in ListPage)
			type: Email 
			MapPoints: Data table is used with following column
			           |Map Position|
			         Map position values should be the names of the available stages, touchpoints and actions
			         ex:     |1 - S1_Updated|
    						 |1.1 - S1-T1_Updated|
    						 |1.1.1 - S1-T1-A1_Updated|
			 
					*/	
						
			
			public void CustomerDistrbutionTypeEMAIL(String ListName,String type,DataTable MapPoints) {
				By radioDistribType = By.xpath(".//*[@id='distributionType" + type + "']");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				System.out.println("selectDistrbutionType");	
			
				//clickSaveMission
				By btnDiscoveryMissionSave = By.xpath(".//button[contains(text(),'Save')]");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(btnDiscoveryMissionSave).click();
				System.out.println("clickSaveMission");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				WebElement txtMsg = driver.findElement(By.xpath(".//h4[contains(text(),'Select one or more Stages, Touchpoints and/or Actions')]"));
				Assert.assertNull(txtMsg.getAttribute("disabled"));
			
				
				/* 
				  Description: select Map Points
				*/
				
				List<Map<String, String>> list = MapPoints.asMaps(String.class, String.class);
				for(int i=0; i<list.size(); i++) {
					
					/* 
					  Description: user can select many/one map points
					*/
					
					
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					
				By checkBoxChoosePoints = By.xpath(".//span[contains(text(),'"+list.get(i).get("Map Position")+"')]/..//input[@type='checkbox']");
				//wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxChooseAction));
				driver.findElement(checkBoxChoosePoints).click();
				System.out.println("selectMapPoints");
			}
				
				/* 
				  Description: User navigates to Step Two
				*/
				
				
				By stepTwo = By.xpath(".//*[@id='step-two']");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				driver.findElement(stepTwo).click();
				System.out.println("gotoStepTwo");
				
				
				WebElement lblParticpantInstruction = driver.findElement(By.xpath("//h4[@class='title' and contains(text(), 'Please write instructions for each item (stage, touchpoint and/or actions) in your Mission')]"));
				Assert.assertNull(lblParticpantInstruction.getAttribute("disabled"));
			

				/* 
				  Description: type Participant Instructions
				 */
				
				int divno=1;
				
				for(int a=2; a<=list.size()+1; a++) {
					
					
					
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
							
				
					
				By txtParticipantInstructions = By.xpath(".//div[@class='list-group-body show-hide ng-scope']//div[@placeholder='Enter detailed instructions for users']//div[@placeholder='Enter detailed instructions for users']");
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
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(txtMediaInstructions).sendKeys("Please upload media files with less than the size of 300Mb");
				System.out.println("typeMediaInstructions");
				
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				/* 
				  Description:  Adding questions
				*/
				
				
				By btnAddQuestions = By.xpath(".//div["+divno+"]/div[4]/aet-discovery-questions/div/button[1]");
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				WebElement panelQuestions = driver.findElement(By.xpath("//h4[@class='ng-binding']"));
				Assert.assertNull(panelQuestions.getAttribute("disabled"));
				
				/* 
				  Description: Add Free-text question
				*/
				
				By menuAddFreeTextQuestion = By.xpath(".//div[contains(text(),'Free Text')]");
				driver.findElement(menuAddFreeTextQuestion).click();
				
				         //make the question required
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By rbtnRequired = By.xpath("//input[@name='isRequired']");
				driver.findElement(rbtnRequired).click();
				
				By saveQuestion = By.xpath("//button[@class='btn btn-primary'][contains(text(),'Save')]");
				driver.findElement(saveQuestion).click();
				System.out.println("Add Free-text question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				//Adding multiple choice questions
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
							
				By menuAddmultiplechoiceQuestion = By.xpath(".//div[contains(text(),'Multiple Choice')]");
				driver.findElement(menuAddmultiplechoiceQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Adding multiple choice questions");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				//Add Yes/No question
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuYesNoQuestion = By.xpath(".//div[contains(text(),'Yes / No')]");
				driver.findElement(menuYesNoQuestion).click();
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
							         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
							
				
				driver.findElement(saveQuestion).click();
				System.out.println("Add Yes/No question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				//Add Rank question
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuRankQuestion = By.xpath(".//div[@class='question-types']//div[4]");
				driver.findElement(menuRankQuestion).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				//enable N/A option
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Rank question");
				
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				//Add Weighted Ranking question
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuWeightRankQuestion = By.xpath(".//div[contains(text(),'Weighted Ranking')]");
				driver.findElement(menuWeightRankQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				//enable N/A option
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Weighted Ranking question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				//Add Numeric slider question
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuNumericSliderQuestion = By.xpath(".//div[contains(text(),'Numeric Slider')]");
				driver.findElement(menuNumericSliderQuestion).click();
					         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				//enable N/A option
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Numeric slider question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				//Add Label slider question
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuLabelSliderQuestion = By.xpath(".//div[contains(text(),'Label Slider')]");
				driver.findElement(menuLabelSliderQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				//enable N/A option
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Label slider question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/* 
				  Description: Add NetPromoteScorer question
				*/
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuNetPromoteScorerrQuestion = By.xpath(".//div[contains(text(),'Net Promoter Score')]");
				driver.findElement(menuNetPromoteScorerrQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
					//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add NetPromoter slider question");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				/* 
				  Description: Add Rating slider question
				*/
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(btnAddQuestions).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				By menuRatingSliderQuestion = By.xpath(".//div[contains(text(),'Rating Slider')]");
				driver.findElement(menuRatingSliderQuestion).click();
				
				         
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				//make the question required
				driver.findElement(rbtnRequired).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				
				/* 
				  Description: enable N/A option
				*/
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				driver.findElement(saveQuestion).click();
				System.out.println("Add Rating slider question");
				
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-800)");
				
				if (a<=list.size()){
					
				By txtMediaInstructionsbtnActionSteps = By.xpath(".//div/h4[contains(text(),'Item "+a+" of "+list.size()+"')]");
				System.out.println("list size = "+list.size());
				System.out.println("a  = "+a);
				
				/*  			 
				  Description: scrolling to the particular element
				 */
					
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
				
				driver.findElement(txtMediaInstructionsbtnActionSteps).click();	
				}						
								
					divno++;
				
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
					Thread.sleep(9000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				By txtEmailSubject = By.xpath(".//input[@id='welcomeSubjectLine']");
				
				driver.findElement(txtEmailSubject).sendKeys("You are invited for a Discovery mission");
				
				By txtEmailbody = By.xpath("//fieldset/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div[3]");
				driver.findElement(txtEmailbody).sendKeys("We would like to see your preference on the product we newly introduced. Please answer the mission which you can reach from clicking the below given link");
			
				/*  			 
				  Description: Fill Terms and Conditions
				*/
				
				
				
				By btnFillTerms = By.xpath(".//div[@class='list-group-item ng-scope valid']//h4[contains(text(),'Message 2 of 4')]");
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
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				By btnSendMission = By.xpath(".//button[@class='btn btn-primary']/span[contains(text(),'Send')]");
								
				driver.findElement(btnSendMission).click();
				
				By btnSendMissionYES = By.xpath(".//button[contains(text(),'Yes')]");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(btnSendMissionYES).click(); 
				
				By btnSendMissionOK = By.xpath(".//button[contains(text(),'OK')]");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(btnSendMissionOK).click(); 
				
				
				
				System.out.println("clickSendMission");	
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}		
			/*  			 
			  Description: This method verifies whether the	mission is created and listed 
			  Parameter:
			    MissionType: Employees|Project Team|Customers
			    MissionName: The given name for the created mission
			  
			 */	
			public void verifyMissionCreation(String MissionType,String MissionName) {
				
				String URL = PropertyFile.readProperty("dahsboardURL");				
				driver.navigate().to(URL);
				
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
							
				clickLeftNavMissionListPage(MissionType);
				System.out.println("Navigated to mission list");	
				
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				WebElement MissionListedintheList = driver.findElement(By.xpath(".//span[contains(text(),'"+MissionName+"')]"));
				Assert.assertNull(MissionListedintheList.getAttribute("disabled"));	
				
			}
					
						
	}