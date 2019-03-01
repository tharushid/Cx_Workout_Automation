$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Project.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# Author: thilani.m@aeturnum.com Project Create)a and"
    }
  ],
  "line": 3,
  "name": "Project CRUD",
  "description": "",
  "id": "project-crud",
  "keyword": "Feature"
});
formatter.before({
  "duration": 13565483330,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 28,
      "value": "#  | Project_2 | This is project_2 | 2020-01-20 | Social |"
    },
    {
      "line": 29,
      "value": "#   | Project_3 | This is project_3 | 2019-07-16 | Mobile |"
    },
    {
      "line": 30,
      "value": "#   | Project_4 | This is project_4 | 2022-12-06 | Store |"
    },
    {
      "line": 31,
      "value": "#   | Project_5 | This is project_5 | 2019-09-02 | Catalog |"
    },
    {
      "line": 32,
      "value": "#   | Project_6 | This is project_6 | 2020-03-27 | In Person |"
    },
    {
      "line": 33,
      "value": "#   | Project_7 | This is project_7 | 2019-02-28 | Other |"
    },
    {
      "line": 34,
      "value": "#   | Project_8 | This is project_8 | 2019-09-09 |  Social |"
    },
    {
      "line": 35,
      "value": "#   | Project_9 | This is project_9 | 2020-01-01 | Mobile |"
    }
  ],
  "line": 39,
  "name": "User creates Projects with templates and curve types",
  "description": "",
  "id": "project-crud;user-creates-projects-with-templates-and-curve-types",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 38,
      "name": "@delete_project"
    }
  ]
});
formatter.step({
  "line": 40,
  "name": "User log in as a business user with \"regressionautobusinessuser@gmail.com\" and \"Asdf123$\"",
  "keyword": "Given "
});
formatter.step({
  "line": 41,
  "name": "User select the default Client and Project",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "User deletes the projects with following names",
  "rows": [
    {
      "cells": [
        "Project Name"
      ],
      "line": 43
    },
    {
      "cells": [
        "Project_1"
      ],
      "line": 44
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "regressionautobusinessuser@gmail.com",
      "offset": 37
    },
    {
      "val": "Asdf123$",
      "offset": 80
    }
  ],
  "location": "LoginTest.user_login_as_business_user(String,String)"
});
formatter.result({
  "duration": 486102995,
  "status": "passed"
});
formatter.match({
  "location": "LoginTest.user_select_default_client_and_project()"
});
formatter.result({
  "duration": 6750472692,
  "status": "passed"
});
formatter.match({
  "location": "ProjectTest.delete_project(DataTable)"
});
formatter.result({
  "duration": 20650640910,
  "status": "passed"
});
