Feature: Client CRUD

  @createClient
  Scenario: Creating a Client
    Given User log in as SuperAdmin
    When User select the default Client and Project
    Then User creates a "Sub Level 3" client named "DemoRegClient"
    Then Search the "DemoRegClient" Client

  @search_Search_and_Edit_Client
  Scenario: Search and Edit a Client
    Given User log in as SuperAdmin
    When User select the default Client and Project
    Then Search the "TestClient" Client
    Then Edit the Client

  @search_Search_and_Delete_Client
  Scenario: Search and Edit a Client
    Given User log in as SuperAdmin
    When User select the default Client and Project
    When Search the "TestClient" Client
    Then Delete the client
    #Then Verify zero results for "TestClient"
