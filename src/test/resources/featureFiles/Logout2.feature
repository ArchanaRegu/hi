@runBeforeHook
Feature: Validation on Logout button

  @Logout
  Scenario: Verify logout function
    Given Admin is in login page
    When Admin clicks  browser back button
    Then Admin should receive error message
