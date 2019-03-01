package org.cxw.pageobj;

import org.apache.log4j.Logger;
import org.cxw.setup.PropertyFile;
import org.cxw.setup.SetUp;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    //final static Logger logger = Logger.getLogger(LoginPage.class);
    
    /*
      Description : This method loads the browser
     */

    public void launchBrowser() {
        try {
        	
            driver = SetUp.setupDriver();
            //maximum time it will wait will be 30 Seconds
            wait = new WebDriverWait(driver, 30);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
      
    /*
    Description : This method quits the browser
   */
    public void quitBrowser() {
        SetUp.quitDriver();
    }

    /*
    Description : This method reads user name and password for Super Admin from config file and log in
   */
    public void superAdminLogin() {
        String adminUsername = PropertyFile.readProperty("username");
        String adminPwd = PropertyFile.readProperty("password");

        typeUsername(adminUsername);
        typePassword(adminPwd);
        clickLoginButton();
    }
  
    /*
    Description : This method reads user name and password for Business User  from config file and log in    
   */
    public void businessUserLogin(String username, String pwd) {
        typeUsername(username);
        typePassword(pwd);
        clickLoginButton();
    }
    
    /*
    Description : This method types username 
    Parameter: 
      username: Any email as a username
      */
    
    public void typeUsername(String username) {
        By txtUserName = By.xpath(".//*[@id='username']");
        driver.findElement(txtUserName).sendKeys(username);
        System.out.println(driver);
        System.out.println("typeUsername");
    }
    
    /*
    Description : This method types password 
    Parameter: 
      username: Password which matches the username
      */
    public void typePassword(String pwd) {
        By txtPassword = By.xpath(".//*[@id='password']");
        driver.findElement(txtPassword).sendKeys(pwd);
        System.out.println("typePassword");
    }
     
    /*
    Description : This method clicks on login button
    */
    
    public void clickLoginButton() {
        By btnLogin = By.xpath(".//*[text()='Login']");
        driver.findElement(btnLogin).click();
        System.out.println("clickLoginButton");
     }
    
    /*
    Description : This method login to system with default client
    */
    public void loginWithDefaultClient() {
        By popUpWelcome = By.xpath("//div[@class='modal-body ng-scope']");
        By btnOk = By.xpath("//div[@class='modal-body ng-scope']//div[@class='modal-footer']//button[@class='btn btn-primary']");
        wait.until(ExpectedConditions.presenceOfElementLocated(popUpWelcome));
        wait.until(ExpectedConditions.elementToBeClickable(btnOk));

        driver.findElement(btnOk).click();
        System.out.println("selectDefaultClient");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(PropertyFile.readProperty("dahsboardURL"), driver.getCurrentUrl());
    }
     
    /*
    Description : This method login to system with specific client
    */
    public void loginWithSpecificClient(String client) {

    	/* 
    	  Description : wait and expand the Client drop down
    	 */
        By dropDownClient = By.xpath(".//span[@class='icon-cx-workout-icons-cx-caret-down' and contains(@ng-hide,'clientDetails')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(dropDownClient));
        driver.findElement(dropDownClient).click();
        System.out.println("expandClientDropDown");

        /* 
          Description :Select specific Client
         */
        By clientName = By.xpath(".//a[contains(text(),'" + client + "')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(clientName));
        driver.findElement(clientName).click();
        System.out.println("selectSpecificClient");

        /*
          Description: Click OK button
         */
        By btnOk = By.xpath("//div[@class='modal-body ng-scope']//div[@class='modal-footer']//button[@class='btn btn-primary']");
        wait.until(ExpectedConditions.elementToBeClickable(btnOk));
        driver.findElement(btnOk).click();
        System.out.println("loginWithSpecificClientProject");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(PropertyFile.readProperty("dahsboardURL"), driver.getCurrentUrl());
    }
     
       /* 
         Description: This method login to system with specific client and Project
        */
    public void loginWithSpecificClientProject(String client, String project) {

        /*
         Description:  wait and expand the Client drop down
         */
        By dropDownClient = By.xpath(".//span[@class='icon-cx-workout-icons-cx-caret-down' and contains(@ng-hide,'clientDetails')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(dropDownClient));
        driver.findElement(dropDownClient).click();
        System.out.println("expandClientDropDown");

        /* 
         Description: Select specific Client
         */
        By clientName = By.xpath(".//a[contains(text(),'" + client + "')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(clientName));
        driver.findElement(clientName).click();
        System.out.println("selectSpecificClient");

        /*
         Description:  wait and expand the Project drop down
         */
        By dropDownProject = By.xpath(".//span[@class='icon-cx-workout-icons-cx-caret-down' and contains(@ng-hide,'projects')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(dropDownProject));
        driver.findElement(dropDownProject).click();
        System.out.println("expandProjectDropDown");

        /*
         Description: Select specific Project
         */
        By projectName = By.xpath(".//a[contains(text(),'" + project + "')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(projectName));
        driver.findElement(projectName).click();
        System.out.println("selectSpecificProject");

        /* 
          Description: Click OK button
         */
        By btnOk = By.xpath("//div[@class='modal-body ng-scope']//div[@class='modal-footer']//button[@class='btn btn-primary']");
        wait.until(ExpectedConditions.elementToBeClickable(btnOk));
        driver.findElement(btnOk).click();
        System.out.println("loginWithSpecificClientProject");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(PropertyFile.readProperty("dahsboardURL"), driver.getCurrentUrl());
    }
    
    /*
     Description: This method login to system when the user is only assigned to one client and Project
     */
    public void loginWhenSingleClientProject() {

        //Click OK button
        By btnOk = By.xpath("//div[@class='modal-body ng-scope']//div[@class='modal-footer']//button[@class='btn btn-primary']");
        wait.until(ExpectedConditions.elementToBeClickable(btnOk));
        driver.findElement(btnOk).click();
        System.out.println("loginWhenSingleClientProject");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(PropertyFile.readProperty("dahsboardURL"), driver.getCurrentUrl());
    }

    /*
    Description: This method use to log out from the system
    */
    
    public void logout() {
        By dropDownLogout = By.xpath(".//*[@id='nav-bar']/div/ul[2]/li/a");
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(dropDownLogout).click();
        System.out.println("expandLogoutdropdown");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By Logout = By.xpath(".//*[@id='nav-bar']/div/ul[2]/li/ul/li[3]/a");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(Logout).click();
        System.out.println("selectLogOut");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(PropertyFile.readProperty("loginURL"), driver.getCurrentUrl());
    }
}
