package org.cxw.demo;

import cucumber.api.java.en.Then;
import org.cxw.pageobj.ClientPage;

public class ClientTest {

    private ClientPage clientPage;

    public ClientTest() {
        clientPage = new ClientPage();
    }

    @Then("^User creates a \"([^\"]*)\" client named \"([^\"]*)\"$")
    public void create_business_user(String subLevel, String name) {

        try {
            clientPage.clickLeftNavAdministration();
            clientPage.clickLeftNavClients();
            clientPage.clickCreateNewClientBtn();
            clientPage.fillClientDetails(name);
            clientPage.selectClientSubLevel(subLevel);
            clientPage.selectMissionLimitType("CLIENT"); 
            clientPage.typeTermsAndRules();
            clientPage.clickSaveClient();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Then("^Search the \"([^\"]*)\" Client$")
    public void search_the_Client(String client) {
        try {
            clientPage.searchClient(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^Edit the Client$")
    public void edit_the_Client() {
        try {
            clientPage.editClientName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^Delete the client$")
    public void delete_the_Client() {
        try {
            clientPage.deleteClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^Verify zero results for \"([^\"]*)\"$")
    public void verify_zero_results(String search) {
        try {
            clientPage.verifyZeroResults(search);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
