Feature: Online appointment

  Scenario: Client Profile - verify Italy, Iceland, Denmark and Thailand cities during adding CC
    Given Open the "Chrome" browser and go to "https://staging.wellnessliving.com/login-home.html"
    Then Verify "Sign In" heading is there
    Then Enter "2705staff-testing@mailinator.com" in Email
    Then Enter "2705staff-testing@mailinator.comA" in password
    When click on Sign In button
    Given Verify the BO name will display
    Then Open client profile
    And Go to Account -> Billing & Account Balance
    And Click on the Add credit card button
    And Open  Country dropdown
    Then There presented new options: Italy, Iceland,Denmark,Thailand

   
   
    Scenario: Client Profile - verify Advanced Filter on Purchases tab
    Given Open the "Chrome" browser and go to "https://staging.wellnessliving.com/login-home.html"
    Then Verify "Sign In" heading is there
    Then Enter "2705staff-testing@mailinator.com" in Email
    Then Enter "2705staff-testing@mailinator.comA" in password
    When click on Sign In button
    Given Verify the BO name will display 
    Then Open client profile
    And Click on Purchases tab on the side panel
    And Click on Advanced Filter -> Select any options
    Then It should display respective result
   

