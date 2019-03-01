package org.cxw.pageobj;

import org.cxw.setup.SetUp;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.cxw.setup.DBConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;

public class BusinessUserPage {

    private WebDriver driver = SetUp.setupDriver();
    
   
    /* 
	Description : This method navigates to Main Menu >> Administration
	*/	 
    
    public void clickLeftNavAdministration() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
        }

        WebElement administrationMenuItem = driver.findElement(By.xpath(".//div[1]/aside/div/ul/li[2]/a"));
        administrationMenuItem.click();
    }

    /* 
	Description : This method selects super admin from the menu
	*/	
    
    public void clickLeftNavSuperAdmins() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        
        By superAdminSubmenu = By.xpath(".//a[contains(text(),'Super Admins')]");
        driver.findElement(superAdminSubmenu).click();
    }
    /* 
	Description : This method selects partner admin from the menu
	*/
    public void clickLeftNavPartnerAdmins() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        
        WebElement partnerAdminSubmenu = driver.findElement(By.xpath(".//a[contains(text(),'Partner Admins')]"));
        partnerAdminSubmenu.click();
    }

    /* 
	Description : This method selects business user tab from the menu
	*/
    public void clickLeftNavBusinessUsers() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        
        WebElement BusinessUserSubmenu = driver.findElement(By.xpath("//a[contains(text(),'Business Users')]"));
        BusinessUserSubmenu.click();
    }
    /* 
	Description : This method clicks on create super admin button
	*/
    private void clickCreateSuperAdmin() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
       
        By btnCreateSuperAdmin = By.xpath("//button[contains(text(),' Create New Super Admin')]");
        driver.findElement(btnCreateSuperAdmin).click();
    }
    /* 
	Description : This method  clicks on create partner admin button
	*/
    public void clickCreatePartnerAdmin(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        
        By btnCreateSuperAdmin = By.xpath("//button[contains(text(),' Create New Partner Admin')]");
        driver.findElement(btnCreateSuperAdmin).click();
    }
    /* 
	Description : This method selects clicks on create super admin button
	*/
    public void clickCreateBusinessUser() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
       
        WebElement CreateBusinessUserButton = driver.findElement(By.xpath("//button[contains(text(),'Create New Business User')]"));
        CreateBusinessUserButton.click();
    }

    /* 
	Description :This method can be used to fill details of all Three types of users. (BU, Partner Admin, Admin)
    Parameters: 
     Email : Any email id that you want to use as the business user's email             
   */
      
      public void fillUserDetails(String email) {
     
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        WebElement BUTitle = driver.findElement(By.xpath("//*[@id='title' and @placeholder='Enter Title ...']"));
        BUTitle.sendKeys("Ms");

        WebElement BUFirstName = driver.findElement(By.xpath("//*[@id='firstName' and @placeholder='Enter First Name ...']"));
        BUFirstName.sendKeys("Ann");

        WebElement BULastName = driver.findElement(By.xpath("//*[@id='lastName' and @placeholder='Enter Last Name ...']"));
        BULastName.sendKeys("Brown");

        WebElement BUEmail = driver.findElement(By.xpath("//*[@id='email' and @name='email']"));
        BUEmail.sendKeys(email);
    }
      
      /* 
  	Description :This method selects the business user role            
     */
  
    public void selectBURole() {
        WebElement BURole = driver.findElement(By.xpath("//div[@id='role' and @name='role']"));
        BURole.click();

        WebElement BURoleSelect = driver.findElement(By.xpath("//span[contains(text(),'Client Admin')]"));
        BURoleSelect.click();
    }

    
    /* 
   	Description :In this method, all the methods required to make a super admin are invoked 
      */
    public void createSuperAdmin(String email) {
        clickLeftNavAdministration();
        clickLeftNavSuperAdmins();
        clickCreateSuperAdmin();
        fillUserDetails(email);
        clickSaveUser();
    }
    
    /* 
   	Description :In this method, all the methods required to make a PartnerAdmin are invoked 
      */
    public void createPartnerAdmin(String email) {
        clickLeftNavAdministration();
        clickLeftNavPartnerAdmins();
        clickCreatePartnerAdmin();
        fillUserDetails(email);
        clickSaveUser();
    }

    
    /* 
   	Description :In this method, all the methods required to make a BusinessUser are invoked 
      */
    public void CreateBusinessUser(String email) {
        clickLeftNavAdministration();
        clickLeftNavBusinessUsers();
        clickCreateBusinessUser();
        fillUserDetails(email);
        selectBURole();
        clickSaveUser();
    }
    
    /* 
	Description : This method can be used to save all Three types of users. (BU, Partner Admin, Admin)
	*/ 
    public void clickSaveUser() {
        WebElement SaveBUButton = driver.findElement(By.xpath("//button[@class='btn btn-primary' and contains(text(),'Save')]"));
        SaveBUButton.click();
        DBConnection.DBConnect();
        System.out.println("CreateBusinessUser");
    }

    /* 
   	Description : This method can be used to search the created users
   	Parameters: 
   	 	userType    :Super Admin|Business User|Partner Admin
   	 	String email: Email address of the relevant user
   	*/ 
    public void searchUser(String userType, String email) {
        clickLeftNavAdministration();
        By txtSearch;

        if (userType.equals("Super Admin")) {
            clickLeftNavSuperAdmins();
            txtSearch = By.xpath(".//input[@placeholder='Search Super Admins']");
            driver.findElement(txtSearch).sendKeys(email);
        } else if (userType.equals("Business User")) {
            clickLeftNavBusinessUsers();
            txtSearch = By.xpath(".//input[@placeholder='Search Business Users']");
            driver.findElement(txtSearch).sendKeys(email);
        } else if (userType.equals("Partner Admin")) {
            clickLeftNavPartnerAdmins();
            txtSearch = By.xpath(".//input[@placeholder='Search Partner Admins']");
            driver.findElement(txtSearch).sendKeys(email);
        } else {
            System.out.println("Invalid User Type");
        }

        By btnSearchAdmin = By.xpath(".//button[@type='button' and @ng-click='searchManager.search()']");
        driver.findElement(btnSearchAdmin).click();
    }


    /* 
   	Description : This method can be used to update the details of the created users
   	*/ 
    public void editBusinessUserRole() {

        By btnEditBU = By.xpath("//a[@aet-has-permission='EDIT_BUSINESS_USER' and @title='edit']");
        driver.findElement(btnEditBU).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        //Change the user role from Admin to General
        By drpdwnBURole = By.xpath("//div[@id='role' and @name='role']");
        driver.findElement(drpdwnBURole).click();

        By SelectBURole = By.xpath("//span[contains(text(),'General User')]");
        driver.findElement(SelectBURole).click();

        clickSaveUser();
        
        /*After an update, it doesn't auto redirect to the BU list page, instead stay on the edit screen.
          Administration Left nav remain expanded. Therefore it needs to force navigate and collapse the Admin Left Nav.*/
        
        clickLeftNavBusinessUsers();
        clickLeftNavAdministration();
    }
    

    /* 
   	Description : This method can be used to update first name of all Three types of users. (BU, Partner Admin, Admin)
   	              "Search User" must have done before calling this method.
   	Parameters: 
   	 	userType    :Super Admin|Business User|Partner Admin
   	 	 
   	*/
    
    public void editUsersFirstName(String userType) {

     
        By btnEditUser = By.xpath(".//tr[@class='search-result ng-scope'][1]//span[@class='icon-cx-workout-icons-cx-edit']");
        driver.findElement(btnEditUser).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

       
        By txtFirstName = By.xpath("//*[@id='firstName' and @placeholder='Enter First Name ...']");
        driver.findElement(txtFirstName).sendKeys(" Updated");

        clickSaveUser();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        /*After an update, it doesn't auto redirect to the User list page, instead stay on the edit screen.
          Administration Left nav remain expanded. Therefore it needs to force navigate and collapse the Admin Left Nav. */

        if (userType.equals("Super Admin")) {
            clickLeftNavSuperAdmins();
        } else if (userType.equals("Business User")) {
            clickLeftNavBusinessUsers();
        } else if (userType.equals("Partner Admin")) {
            clickLeftNavPartnerAdmins();
        } else {
            System.out.println("Invalid User Type");
        }

        clickLeftNavAdministration();
    }

    /* 
      Description :This method can be used to delete all Three types of users. (BU, Partner Admin, Admin)
                   (Click the Delete button of the first user from the List. Therefore a Search must have done before this.)
      Parameters: 
   	 	userType    :Super Admin|Business User|Partner Admin
   	 	String email: Email address of the relevant user
   	 
    */
      public void deleteUser(String userType, String email) {
     

        searchUser(userType, email);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

      
        By btnDeleteBU = By.xpath(".//tr[@class='search-result ng-scope'][1]//span[@class='icon-cx-workout-icons-cx-remove']");
        driver.findElement(btnDeleteBU).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        By popupDeleteBU = By.xpath("//button[@class='btn btn-default btn-danger' and contains(text(), 'Delete')]");
        driver.findElement(popupDeleteBU).click();
    }
      
      /* 
      Description : This method Fill details of any user 
      Parameters:
      title: Any user title ex: Mr|Ms
      fname: Any First name
      lname: Any Last Name
      email: Any unique email
       */
      
    public void fillUserDetails(String title, String fname, String lname, String email) {
    	try {
	           Thread.sleep(5000);
	    	} catch (InterruptedException e) {}

        WebElement buTitle = driver.findElement(By.xpath("//*[@id='title' and @placeholder='Enter Title ...']"));
        buTitle.sendKeys(title);
        System.out.println();
        System.out.println("Title entered.");
        try {
	           Thread.sleep(1000);
	    	} catch (InterruptedException e) {}

        WebElement buFirstName = driver.findElement(By.xpath("//*[@id='firstName' and @placeholder='Enter First Name ...']"));
        buFirstName.sendKeys(fname);
        System.out.println("First name entered.");
		try {
	           Thread.sleep(1000);
	        } catch (InterruptedException e) {}

        WebElement buLastName = driver.findElement(By.xpath("//*[@id='lastName' and @placeholder='Enter Last Name ...']"));
        buLastName.sendKeys(lname);
        System.out.println("Last name entered.");
		try {
	           Thread.sleep(1000);
	        } catch (InterruptedException e) {}

        WebElement buEmail = driver.findElement(By.xpath("//*[@id='email' and @name='email']"));
        buEmail.sendKeys(email);
        System.out.println("Email entered.");
		try {
	           Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
    }
    
    
    /* 
    Description : This method is designed to create many business users with different USER ROLES
    Parameters:
       businessUsers: Parameter values are passed in this data table which has 5 columns for
                     |Title|First Name|Last Name |Email|Role|
       
      Title: Any user title ex: Mr|Ms
      First Name: Any First name
      Last Name: Any Last Name
      Email: Any unique email
      Role : General User | Super Admin | Client Admin |SME
    
    */
    
    public void createBusinessUsers(DataTable businessUsers) {
    	// Taking data table elements into a list.
    	List<Map<String, String>> buList = businessUsers.asMaps(String.class, String.class);
    	clickLeftNavAdministration();
		clickLeftNavBusinessUsers();
    	// Iterating through the business users list.
    	for(int i=0; i< buList.size(); i++) {
    		clickCreateBusinessUser();
  
    		// Getting details of a specific row of the data table.
    		String title = buList.get(i).get("Title");
    		String fname = buList.get(i).get("First Name");
    		String lname = buList.get(i).get("Last Name");
    		String email = buList.get(i).get("Email");
    		String role = buList.get(i).get("Role");    		
    		
    		// Fill business user details.
    		fillUserDetails(title,fname,lname,email);
            
    		// Click the role drop down.
    		By drpdwnBuRole = By.xpath("//div[@id='role' and @name='role']");
            driver.findElement(drpdwnBuRole).click();
            // Select the role from drop down.
            By SelectBuRole = By.xpath("//span[contains(text(),'" + role + "')]");
            driver.findElement(SelectBuRole).click();

            clickSaveUser();
    		
    		
    	}
    }
}
