#Author: thilani.m@aeturnum.com

Feature: Discovery Mission CRUD


@createDiscoveryMission_URL
  Scenario: Create Discovery Mission
    Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
    Then User select the default Client and Project
    Then User Create "Employees" Discovery mision with the name "Regression Employee Discovery Mission_URL" as "URL"
    |Map Position|
    |1 - S1_Updated|
    |1.1 - S1-T1_Updated|
    |1.1.1 - S1-T1-A1_Updated|

@createDiscoveryMission_Email
Scenario: Create Discovery Mission
Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
Then User select the default Client and Project
Then User Create "Employees" Discovery mision with the name "Regression Employee Discovery Mission_EMAIL" for "Regression Employee List_Updated" as "EMAIL"
 |Map Position|
 |1 - S1_Updated|
 |1.2 - S1-T2_Updated| 
 |1.1.2 - S1-T1-A2_Updated|


@createCustomerDiscoveryMission_URL
  Scenario: Create Customer Discovery Mission
    Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
    Then User select the default Client and Project
    Then User Create "Customers" Discovery_C mision with the name "Regression Customers Discovery Mission_URL" as "URL"
    |Map Position|
    |1 - S1_Updated|
    |1.1 - S1-T1_Updated|
    |1.1.1 - S1-T1-A1_Updated|

@createCustomerDiscoveryMission_Email
Scenario: Create Discovery Mission
Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
Then User select the default Client and Project
Then User Create "Customers" Discovery_C mission with the name "Regression Customer Discovery Mission_EMAIL" for "Regression Customer List" as "EMAIL"
 |Map Position|
 |1 - S1 |
 |1.2 - S1-T2 | 
 |1.1.2 - S1-T1-A2 |
 Then User verify "Customers" Discovery_C mision is created as "Regression Customer Discovery Mission_EMAIL"

    