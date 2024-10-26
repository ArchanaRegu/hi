Feature: Verify login with bgd

  Background: 
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL

  Scenario: Validate login with invalid credentials
    Given Admin is in login Page
    When Admin enter invalid credentials  and clicks login button
    Then Error message please check Adminname/password

  Scenario: Validate login credentials with null Adminname
    Given Admin is in login Page
    When Admin enter value only in password and clicks login button
    Then Error message please check Adminname/password

  Scenario: Validate login credentials with null password
    Given Admin is in login Page
    When Admin enter value only in Adminname and clicks login button
    Then Error message please check Adminname/password

  Scenario: verify login button action through keyboard
    Given Admin is in login Page
    When Admin enter valid credentials  and clicks login button through keyboard
    Then Admin should land on dashboard page

  Scenario: verify login button action through mouse
    Given Admin is in login Page
    When Admin enter valid credentials  and clicks login button through mouse
    Then Admin should land on dashboard page
