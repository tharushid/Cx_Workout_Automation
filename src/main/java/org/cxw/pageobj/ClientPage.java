package org.cxw.pageobj;

import org.apache.log4j.Logger;
import org.cxw.setup.Common;
import org.cxw.setup.PropertyFile;
import org.cxw.setup.SetUp;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientPage {

    private WebDriver driver = SetUp.setupDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 30);
    private Common cmn = new Common();
    final static Logger logger = Logger.getLogger(ClientPage.class);
    
    
    
    /* 
   	Description : This method selects Administration bar for Left Navigation
   	*/	

    public void clickLeftNavAdministration() {
        By leftNavAdministration = By.xpath(".//a[contains(text(),'Administration')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(leftNavAdministration));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(leftNavAdministration).click();
        System.out.println("clickLeftNavAdministration");
    }
    
    /* 
   	Description : This method navigates to Create Client Page
   	*/

    public void clickLeftNavClients() {
        By leftNavClients = By.xpath(".//a[contains(text(),'Clients')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(leftNavClients));
        driver.findElement(leftNavClients).click();
        System.out.println("clickLeftNavClients");
    }

    
    /* 
   	Description : This method Clicks on Create Client button
   	*/
    
    public void clickCreateNewClientBtn() {
        By btnCreateNewClient = By.xpath("//button[contains(text(),'Create New Client')]");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(btnCreateNewClient).click();
        System.out.println("clickCreateNewClientBtn");
        Assert.assertEquals(PropertyFile.readProperty("CreateClientURL"), driver.getCurrentUrl());
    }

    
    /* 
   	Description : This method fills Client details
   	Parameter:    	
   	    name: Any unique name for the client
   	*/
    public void fillClientDetails(String name) {
        String rand = cmn.generateUUID().toString().substring(0, 5);
        By txtClientName = By.xpath(".//*[@id='name']");
        //driver.findElement(txtClientName).sendKeys(name + rand);
        driver.findElement(txtClientName).sendKeys(name);
        //System.out.println("typeClientName: " + name + rand);

        By txtPendoName = By.xpath(".//*[@id='shortName']");
        driver.findElement(txtPendoName).sendKeys("T" + rand.substring(0, 3));
        System.out.println("typePendoName");

        By txtStreet1 = By.xpath(".//*[@id='streetAddress1']");
        driver.findElement(txtStreet1).sendKeys("19 Crosby");
        System.out.println("typeStreet1");

        By txtStreet2 = By.xpath(".//*[@id='streetAddress2']");
        driver.findElement(txtStreet2).sendKeys("Suite 160");
        System.out.println("typeStreet1");

        By txtCity = By.xpath(".//*[@id='city']");
        driver.findElement(txtCity).sendKeys("Medlind");
        System.out.println("typeCity");

        By dropDownState = By.xpath(".//*[@id='state']/div/span");
        driver.findElement(dropDownState).click();
        System.out.println("expandSateDropdown");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By state = By.xpath(".//*[@id='state']/ul");
        driver.findElement(state).click();
        System.out.println("selectSate");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By txtZipCode = By.xpath(".//*[@id='zipcode']");
        driver.findElement(txtZipCode).sendKeys("12345");
        System.out.println("typeZipCode");
    }
    
    /* 
   	Description : This method select the sub level of the client 
   	parameters: 
   	  level: Sub Level 1|Sub Level 2|Sub Level 3
   	*/

    public void selectClientSubLevel(String level) {
        By dropDownSubLevel = By.xpath(".//*[@id='subLevel']/div/span");
        driver.findElement(dropDownSubLevel).click();
        System.out.println("expandSubLevelDropdown");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By subLevel = By.xpath(".//*[contains(text(),'" + level + "')]");
        driver.findElement(subLevel).click();
        System.out.println("selectSubLevel");
    }
    
    /* 
   	Description : This method select the mission limit type of the client 
   	Parameters:
   	   type: CLIENT 
   	 
   	*/

    public void selectMissionLimitType(String type) {

        //TODO: Select Mission type based on the parameter

        By txtMissionsPurchased = By.xpath(".//*[@id='missionsPurchased']");
        driver.findElement(txtMissionsPurchased).sendKeys("10");
        System.out.println("typeMissionLimit");

        By txtUploadedMedia = By.xpath(".//*[@id='uploadedMediaPurchased']");
        driver.findElement(txtUploadedMedia).sendKeys("125");
        System.out.println("typeMediaFilesLimit");

        By txtMediaRetention = By.xpath(".//*[@id='mediaRetention']");
        driver.findElement(txtMediaRetention).sendKeys("320");
        System.out.println("typeMediaRetentionLimit");
    }

    /* 
   	Description : This method enters terms and conditions for client    	 
  	*/
    
    public void typeTermsAndRules() {
        By txtTerms = By.xpath(".//*[@id='texteditor']//div[contains(@id,'taTextElement')]");
        driver.findElement(txtTerms).sendKeys("Test Terms ans Conditions");
        System.out.println("typeTermsCondition");

        By txtRules = By.xpath(".//*[@id='rulescond']");
        //TODO: Add any text to the default Rules of Conduct
    }

    /* 
   	Description : This method saves the created client    	 
  	*/
    
    public void clickSaveClient() {
        By btnSaveClient = By.xpath(".//button[contains(text(),'Save')]");
        driver.findElement(btnSaveClient).click();
        System.out.println("clickSaveClient");
    }

    /* 
   	Description : This method search created client    	 
  	*/
    public void searchClient(String name) {

        // navigate to Client List Page
        clickLeftNavAdministration();
        clickLeftNavClients();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By txtSearchClient = By.xpath(".//input[@placeholder='Search Clients']");
        driver.findElement(txtSearchClient).sendKeys(name);
        System.out.println("typeSearchClient");

        By btnSearch = By.xpath(".//button[@type='button' and @ng-click='searchManager.search()']");
        driver.findElement(btnSearch).click();
        System.out.println("clickSearch");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }
  
    /* 
   	Description : This method updates created client    	 
   	since it edits first client record from Client the list, "Search client" must have done before calling this method.
   	*/
    
    
    public void editClientName() {

        
        By btnEditClient = By.xpath(".//tr[@class='search-result ng-scope'][1]//span[@class='icon-cx-workout-icons-cx-edit']");
        driver.findElement(btnEditClient).click();
        System.out.println("clickEdit");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        By txtClientName = By.xpath(".//*[@id='name']");
        driver.findElement(txtClientName).sendKeys(" Updated");

        clickSaveClient();
    }
    
    /* 
   	Description : This method deletes the created client    	 
   	since it edits deletes client record from Client the list, "Search client" must have done before calling this method.
   	*/
    public void deleteClient() {
       
        By btnDeleteClient = By.xpath(".//tr[@class='search-result ng-scope'][1]//span[@class='icon-cx-workout-icons-cx-remove']");
        driver.findElement(btnDeleteClient).click();
        System.out.println("clickDelete");

        By btnConfirmDelete = By.xpath(".//button[contains(text(),'Delete')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnConfirmDelete));
        driver.findElement(btnConfirmDelete).click();
        System.out.println("clickConfirmDelete");
    }

    /* 
   	Description : This method verifies ZeroResults 
   	*/
    
    public void verifyZeroResults(String search) {
        searchClient(search);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        By zeroResults = By.xpath(".//span[contains(@class,'search-count') and contains(text(),'0 Results')]");
        Assert.assertEquals("0 Results", driver.findElement(zeroResults).getText());
    }

	
}
