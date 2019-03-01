#Author: thilani.m@aeturnum.com

Feature: CreateBusinessUsers
@createBuinessUsers
Scenario: Create Business Users
Given User log in as SuperAdmin
When User select "DemoRegClient" Client
Then User creates following business users
| Title | First Name | Last Name | Email | Role |
| Ms | Ann | Brown | regressionautobusinessuser@gmail.com | Client Admin |
| Mr | Lucas | Graham | reg.ressionautobusinessuser@gmail.com | General User |
| Ms | Jean | Flower | regression.autobusinessuser@gmail.com | General User |
| Mr | Sean | Carl | regressionauto.businessuser@gmail.com | SME |
