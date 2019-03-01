package org.cxw.demo;

import org.cxw.pageobj.BusinessUserPage;
import cucumber.api.java.en.Then;
import org.cxw.setup.SetUp;
import cucumber.api.DataTable;

public class BusinessUserTest {

    private BusinessUserPage businessUserPage;

    public BusinessUserTest() {
        businessUserPage = new BusinessUserPage();
    }

    @Then("^User creates a business user with email \"([^\"]*)\"$")
    public void create_business_user(String email) {

        try {
            businessUserPage.CreateBusinessUser(email);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
                        }
    }
    
    @Then("^User creates a super admin with email \"([^\"]*)\"$")
    public void create_super_admin(String email) {

        try {
            businessUserPage.createSuperAdmin(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^User creates a partner admin with email \"([^\"]*)\"$")
    public void create_partner_admin(String email) {

        try {
            businessUserPage.createPartnerAdmin(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^User search a \"([^\"]*)\" with email \"([^\"]*)\"$")
    public void search_user(String userType, String email) {
        try {
            businessUserPage.searchUser(userType, email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^User update \"([^\"]*)\" 's first name$")
    public void update_first_name(String userType) {
        try {
            businessUserPage.editUsersFirstName(userType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^User edits business user Role$")
    public void edit_business_user_role() {

        try {
            businessUserPage.editBusinessUserRole();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Then("^User deletes a \"([^\"]*)\" user with \"([^\"]*)\"$")
    public void delete_user(String userType, String email) {

        try {
            businessUserPage.deleteUser(userType, email);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Then("^User quit the browser$")
    public void user_quit_the_browser() {
        try{
            SetUp.quitDriver();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Then("^User creates following business users$")
    public void create_business_users(DataTable businessUsers) {
    	try {
 		   // Firing create business users function.
    	   businessUserPage.createBusinessUsers(businessUsers);
 		   System.out.println("Business user creation process successful!");
 	   } catch (Exception e) {
 		   e.printStackTrace();
 	   }
    }
}
