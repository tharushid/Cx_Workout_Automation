#Author: thilani.m@aeturnum.com


Feature: Log in to the system with created business user and creating projects
  

  @CreateBusinessUserAndPrjects
  Scenario: CRUD Business user creating Projects
    Given User log in as SuperAdmin
    When User select "RegAuto Client" Client
    When User creates a business user with email "regressionautobusinessuser@gmail.com"
    Then User logout
    
   
   