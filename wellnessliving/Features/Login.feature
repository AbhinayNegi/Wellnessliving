Feature: Login functionality

  Scenario: Business owner is able to login
    Given Log in as BO
    Then Click on Dashboard
    And Click on Setup button in the and of any appointmen line
    And Click on "No Show" option and confirm your choice
    And A message should appear "Client marked as no show" https://monosnap.com/file/2NfIqlWof9CssXGzoT5YGxJ928gY0O
    And Find client's profile
    And Click on "Attendence History" on the side panel
    Then Client's status for this appointment should be "No Show"
