Feature: Login

  @loginAsSuperAdmin_DefaultClient
  Scenario: Login as Super admin with default client and project
    Given User log in as SuperAdmin
    Then User select the default Client and Project

  @loginAsSuperAdmin_SpecificClient
  Scenario: Login as Super admin with specific client
    Given User log in as SuperAdmin
    Then User select "Adhoc" Client

  @loginAsSuperAdmin_SpecificClientProject
  Scenario: Login as Super admin with specific client and project
    Given User log in as SuperAdmin
    Then User select "Bubbles" Client and "Bubble Project1" Project