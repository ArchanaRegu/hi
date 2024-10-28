Feature: Validation on Logout button

  Background: 
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL and login with correct credentials.
    @Logout
  Scenario: Verify logout function
    Given Admin is in dashboard page
    When Admin clicks on the logout in the menu bar
    Then Admin should be redirected to login page 
  