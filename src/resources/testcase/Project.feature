# Author: thilani.m@aeturnum.com Project Create)a and 

Feature: Project CRUD
 @create_project  
   Scenario: User creates Projects with templates and curve types
    Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
    Then User select the default Client and Project 
    Then User creates a project with templates and with curve type
    | Project Name | Template | Curve type |
    | Project_1 | SPCI Template | Emotion |
  #  | Project_2 | SPCI Template | Value |
  #  | Project_3 | SPCI Template | Experience |
   # | Project_4 | LBGUPS Template | Emotion |
  #  | Project_5 | LBGUPS Template |Value|
  #  | Project_6 | LBGUPS Template|Experience| 
  #  | Project_7 | CUSTOM Template |Emotion|
  #  | Project_8 | CUSTOM Template|Value| 
  #  | Project_9 | CUSTOM Template|Experience| 
 
 
 @edit_project
   Scenario: User edits projects 
     Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
     Then User select the default Client and Project 
     Then User edits projects with following details
     | Project Name | Description | End date | Channel |
     | Project_1 | This is project_1 | 2019-02-02  | Social |
  #  | Project_2 | This is project_2 | 2020-01-20 | Social |
  #   | Project_3 | This is project_3 | 2019-07-16 | Mobile |
  #   | Project_4 | This is project_4 | 2022-12-06 | Store |
  #   | Project_5 | This is project_5 | 2019-09-02 | Catalog |
  #   | Project_6 | This is project_6 | 2020-03-27 | In Person |
  #   | Project_7 | This is project_7 | 2019-02-28 | Other |
  #   | Project_8 | This is project_8 | 2019-09-09 |  Social |
  #   | Project_9 | This is project_9 | 2020-01-01 | Mobile |  
     
 
 @delete_project  
    Scenario: User creates Projects with templates and curve types
    Given User log in as a business user with "regressionautobusinessuser@gmail.com" and "Asdf123$"
    Then User select the default Client and Project 
    Then User deletes the projects with following names
    | Project Name | 
    | Project_1 | 
  # | Project_2 | 
  #  | Project_3 | 
  #  | Project_4 | 
  #  | Project_5 | 
  #  | Project_6 | 
  #  | Project_7 | 
  #  | Project_8 | 
  #  | Project_9 | 