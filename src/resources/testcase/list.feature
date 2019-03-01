#Author: thilani.m@aeturnum.com
Feature: Map CRUD

  @ProjectTeamListCreation
  Scenario: Creates project team List
    Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
    Then User select the default Client and Project
    Then User creates ProjectTeamList "Regression Project team" 
    | Team Member Name |
    | Lucas Graham |
    | Ann Brown |
    
  @ProjectTeamListUpdate
  Scenario: Updates project team List
    Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
    Then User select the default Client and Project
    Then User updates ProjectTeamList "Regression Project team" 
    | Team Member Name |
    | Jean Flower |
  
  
  @EmployeeTeamListCreation_CSV
 Scenario: Creates employee List
   Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
   Then User select the default Client and Project
   Then User creates EmployeeList "Regression Employee List" with list type "csv"
     |Employee first Name|Employee last Name|Employee email address|
     |Jenny|Smith|amelia.grace259@gmail.com|
     |Amelia|Grace|ameliag.race259@gmail.com|
     |Steve|Taylor|ameliagr.ace259@gmail.com|

    
  @EmployeeTeamListCreation_manuallyAdded
  Scenario: Creates employee List
   Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
   Then User select the default Client and Project
   Then User creates EmployeeList "Regression Employee List" with list type "manuallyAdded"
     |Employee first Name|Employee last Name|Employee email address|
     |Jenny|Smith|amelia.grace259@gmail.com|
     |Amelia|Grace|ameliag.race259@gmail.com|
     |Steve|Taylor|ameliagr.ace259@gmail.com|

  
   @EmployeeListUpdate_RemovesRandomUser
  Scenario: Updates Employee List
   Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
   Then User select the default Client and Project
   Then User updates Employee List "Regression Employee List" 
  
  
   @CustomerTeamListCreation_CSV
    Scenario: Creates customer List
   Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
   Then User select the default Client and Project
   Then User creates CustomerList "Regression Customer List" with list type "csv"
     |Customer first Name|Customer last Name|Customer email address|
     |Will|Trace|c.ustomercxworkout@gmail.com|
     |Lora|Alby|cu.stomercxworkout@gmail.com|
     |Clive|Lestor|cus.tomercxworkout@gmail.com|
     
     
 @CustomerTeamListCreation_manuallyAdded
   Scenario: Creates customer List
   Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
   Then User select the default Client and Project
   Then User creates CustomerList "Regression Customer List" with list type "manuallyAdded"
     |Customer first Name|Customer last Name|Customer email address|
     |Will|Trace|c.ustomercxworkout@gmail.com|
     |Lora|Alby|cu.stomercxworkout@gmail.com|
     |Clive|Lestor|cus.tomercxworkout@gmail.com|
     
       
   @CustomerListUpdate_RemovesRandomUser
   Scenario: Updates Customer List
   Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
   Then User select the default Client and Project
   Then User updates Customer List "Regression Customer List" 