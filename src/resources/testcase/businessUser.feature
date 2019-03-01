Feature: BusinessUser CRUD

  @createBSUser
  Scenario: Create Business user
  Given User log in as SuperAdmin
  When User select the default Client and Project
  When User creates a business user with email "spcicx@gmail.com"

  @searchBSUser
   Scenario: Search Business user
   Given User log in as SuperAdmin
   When User select the default Client and Project
   When User creates a business user with email "spcicx@gmail.com"
   Then User search a "Business User" with email "spcicx@gmail.com"

  @CRUD_BusinessUser
  Scenario: CRUD Business user
    Given User log in as SuperAdmin
    When User select the default Client and Project
    When User creates a business user with email "spcicx@gmail.com"
    Then User search a "Business User" with email "spcicx@gmail.com"
    Then User edits business user Role
    Then User deletes a "Business User" user with "spcicx@gmail.com"

  @CRUD_SuperAdmin
  Scenario: CRUD Super Admin user
    Given User log in as SuperAdmin
    When User select the default Client and Project
    Then User creates a super admin with email "ra.mesha.dilhani@gmail.com"
    Then User search a "Super Admin" with email "ra.mesha.dilhani@gmail.com"
    Then User update "Super Admin" 's first name
    Then User deletes a "Super Admin" user with "ra.mesha.dilhani@gmail.com"

  @CRUD_PartnerAdmin
  Scenario: CRUD Partner Admin user
    Given User log in as SuperAdmin
    When User select the default Client and Project
    Then User creates a partner admin with email "ra.m.esha.dilhani@gmail.com"
    Then User search a "Partner Admin" with email "ra.m.esha.dilhani@gmail.com"
    Then User update "Partner Admin" 's first name
    Then User deletes a "Partner Admin" user with "ra.m.esha.dilhani@gmail.com"