Feature: Verify login with bgd

  Background: 
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL


  @Loginb
  Scenario: Validate login with valid credentials # TC#19
    Given Admin is in login Page
    When Admin enter invalid credentials  and clicks login button
    Then Admin should land on dashboard page ( centre of the page will be empty , menu bar is present).
 
  @Loginb
  Scenario: Validate login with invalid credentials # TC#20
    Given Admin is in login Page
    When Admin enter invalid credentials  and clicks login button
    Then Error message please check Adminname/password

  @Loginb
  Scenario: Validate login credentials with null Adminname # TC#21
    Given Admin is in login Page
    When Admin enter value only in password and clicks login button
    Then Error message please check Adminname/password

  @Loginb
  Scenario: Validate login credentials with null password # TC#22
    Given Admin is in login Page
    When Admin enter value only in Adminname and clicks login button
    Then Error message please check Adminname/password

  @Loginb
  Scenario: verify login button action through keyboard # TC#23
    Given Admin is in login Page
    When Admin enter valid credentials  and clicks login button through keyboard
    Then Admin should land on dashboard page

  @Loginb
  Scenario: verify login button action through mouse # TC#24
    Given Admin is in login Page
    When Admin enter valid credentials  and clicks login button through mouse
    Then Admin should land on dashboard page
