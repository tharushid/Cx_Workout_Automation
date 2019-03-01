#Author: thilani.m@aeturnum.com
Feature: Map CRUD

 @MapCreate
  Scenario: Create Stage, touchpoint and Action
   Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
   Then User select the default Client and Project
   Then User creates map
   | Stage Name | Touchpoint Name | Action Name | 
   | S1 | T1 | A1 | 
   | S2 | T2 | A2 | 
   
  
     
 @MapUpdate
  Scenario: Update Stage, touchpoint and Action
   Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
   Then User select the default Client and Project
   Then User updates map
   | Stage Name |Updated Stage Name | Touchpoint Name | Updated Touchpoint Name  |Action Name | Updated Action Name |
   | S1 | _Updated | T1 | _Updated | A1 | _Updated |
   | S2 | _Updated | T2 | _Updated | A2 | _Updated |
   
 
 
   