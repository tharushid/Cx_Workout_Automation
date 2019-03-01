#Author: thilani.m@aeturnum.com


Feature: Log in to the system with created business user and creating projects
  

  @CreateBusinessUserAndPrjects
  Scenario: CRUD Business user creating Projects
    Given User log in as SuperAdmin
    When User select "RegAuto Client" Client
    When User creates a business user with email "regressionautobusinessuser@gmail.com"
    Then User logout
    Then User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
    Then User select the default Client and Project 
    Then User creates a project with templates and with curve type
    | Project Name | Template | Curve type |
    | Project_1 |  SPCI Template |Emotion|
    | Project_2 | SPCI Template | Value |
    | Project_3 | SPCI Template | Experience |
    | Project_4 | LBGUPS Template | Emotion |
    | Project_5 | LBGUPS Template |Value|
    | Project_6 | LBGUPS Template|Experience| 
    | Project_7 | CUSTOM Template | Emotion |    
    | Project_8 | CUSTOM Template|Value| 
    | Project_9 | CUSTOM Template|Experience| 
   
   