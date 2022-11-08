Feature: Main

  #https://staging.wellnessliving.com/login-home.html
  Scenario: Login as a BO
    Given Open the "Chrome" browser and go to "https://staging.wellnessliving.com/login-home.html"
    Then Verify "Sign In" heading is there
    Then Enter "2705staff-testing@mailinator.com" in Email
    Then Enter "2705staff-testing@mailinator.comA" in password
    When click on Sign In button

  Scenario: Dashboard [Daily Tracker] - verify BO can mark client as Attended in Appointment
    Given Verify the BO name will display
    #Given Open the "Chrome" browser and go to "https://staging.wellnessliving.com/login-home.html"
    Then Click on Dashboard
    #Then Scroll down to Daily tracker
    #Then Click on Setup button in the end of any appointment line http://screencast.com/t/oPQjJK8wf
    #Then Click on "Checked-in" option
    #Given A message should appear "Client marked as arrived."
    #Given Click on the client's name on ATTENDANCE column
    #Given Clients profile appears
    #Then Click on "Attendance History/Upcoming schedule (in accordance with time of booking)" on the side panel
    #Given Clients status for this appointment should be "Attended"

  Scenario: Dashboard [Daily Tracker] - verify BO can mark client as "No show" in Appointment
    #Given Click on Dashboard
    #Then Scroll down to Daily tracker
    #Then Click on Setup button in the end of any appointment line http://screencast.com/t/oPQjJK8wf
    #When Click on "No Show" option and confirm your choice
    #Then A message should appear "Client marked as no show" 
    #When Find clients profile
    #When Click on "Attendence History" on the side panel
    #Then Clients status for this appointment should be "No Show"
    
  Scenario: Dashboard  [Daily Tracker] - verify "Cancel Appointment" option
    Then Scroll down to Daily tracker
    Then Click on Setup button in the end of any appointment line http://screencast.com/t/oPQjJK8wf
    Then Click on "Cancel Appointment" option
    Then STEP 1 Confirmation
    When Click "YES" button
    Then STEP 2 Reason
    When Select reason and click "NEXT" button
    Then STEP 3 Notification
    Then "Send email to affected client" check box is checked and click on "COMPLETE" button
    Then The appointment should be successfully canceled
    Then A mail of "Appointment Cancelled By Staff" type should be sent to client(s)
