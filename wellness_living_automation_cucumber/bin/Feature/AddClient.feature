Feature: Online appointment

  Scenario: Login as a BO
    Given Open the "Chrome" browser and go to "https://staging.wellnessliving.com/login-home.html"
    Then Verify "Sign In" heading is there
    Then Enter "2705staff-testing@mailinator.com" in Email
    Then Enter "2705staff-testing@mailinator.comA" in password
    When click on Sign In button
    Given Verify the BO name will display

  Scenario Outline: Add Client 1
    When Click on the Add client tab
    Given Verify "Add New Client" page is open
    Then Enter First Name <First Name>
    Then Enter Last Name <Last Name>
    Then Enter  <emailID> in the Email
    Then Click on Create Account

    Examples: 
      | First Name | Last Name | emailID                 |
      | a111         | r1        | a112s.1r1test@mailinator.com |
      | a22         | r2        | a23r2test@mailinator.com |


