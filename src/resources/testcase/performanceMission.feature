#Author: thilani.m@aeturnum.com

Feature: Performance Mission CRUD 

 @createPerfMission_URL_for_Employee/ProjectTeam_URL
 Scenario: Create Performance Mission_URL
   Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
   Then User select the default Client and Project
   Then User Create "Project Team" mision with the name "Regression PT Performance Mission_URL" as "URL"
   |Action Position|
   |1.1.1|
   |2.1.1|


 @createPerfMission_EMAIL_for_Employee/ProjectTeam
  Scenario: Create Performance Mission_EMAIL
   Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
   Then User select the default Client and Project
   Then User Create "Project Team" mission with the name "Regression PT Performance Mission_Email" as "EMAIL" for list "Regression Project team_Updated"
    |Action Position|
    |1.1.2|
    |2.1.2|   

 @createPerfMission_URL_for_Customer
 Scenario: Create Performance Mission_Customer_URL
   Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
   Then User select the default Client and Project
   Then User Creates- "Customers" mision with the name "Regression Customer Performance Mission_URL" as "URL"
   |Action Position|
   |1.2.1|
   |2.2.1|


 @createPerfMission_EMAIL_for_Customer
  Scenario: Create Performance Mission_Customer_EMAIL
   Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
   Then User select the default Client and Project
   Then User Creates- "Customers" mission with the name "Regression Customer Performance Mission_Email" as "EMAIL" for list "Regression Customer List"
    |Action Position|
    |1.2.2|
    |2.2.2|
 



    
    
