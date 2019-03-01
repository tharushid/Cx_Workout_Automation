package org.cxw.demo;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.cxw.pageobj.LoginPage;

public class LoginTest {

    private LoginPage loginPage;

    public LoginTest() {
        loginPage = new LoginPage();
    }

    @Before
    public void user_launch_the_web_browser() {
        try{
        loginPage.launchBrowser();
        System.out.println("Launch Web browser in @Before\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("^User log in as SuperAdmin$")
    public void user_login_as_super_admin() {
        try {
            loginPage.superAdminLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO
    @Given("^User log in as a business user with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_login_as_business_user(String username, String pwd) {
    	    	try {
            loginPage.businessUserLogin(username,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^User select the default Client and Project$")
    public void user_select_default_client_and_project() {

        try {
            loginPage.loginWithDefaultClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^User select \"([^\"]*)\" Client$")
    public void user_select_specific_client(String client) {

        try {
            loginPage.loginWithSpecificClient(client);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Then("^User select \"([^\"]*)\" Client and \"([^\"]*)\" Project$")
    public void user_select_specific_client_and_project(String client, String project) {
        try {
            loginPage.loginWithSpecificClientProject(client, project);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Then("^User does not have to select client or projcet$")
    public void loginWhenSingleClientProject() {

        try {
            loginPage.loginWhenSingleClientProject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^User logout$")
    public void user_log_out() {
        try {
            loginPage.logout();
            System.out.println("Logout in @After\n");
        } catch (Exception e) {
            loginPage.quitBrowser();
            e.printStackTrace();
            System.out.println("Quit browser in @After\n");
        }
    }
    
    @After
    public void user_logout() {
        try {
            loginPage.logout();
            System.out.println("Logout in @After\n");
        } catch (Exception e) {
            loginPage.quitBrowser();
            e.printStackTrace();
            System.out.println("Quit browser in @After\n");
        }
    }
}