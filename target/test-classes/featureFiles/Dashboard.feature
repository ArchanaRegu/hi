Feature: Verify DashBoard

  Background: 
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL

  @Dashboard
  Scenario: Verify after login Admin lands on dashboard page
    Given Admin is in login Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see dashboard

  @Dashboard
  Scenario: Verify the response time
    Given Admin is in login Page
    When Admin enter valid credentials and clicks login button
    Then Maximum navigation time in milliseconds, defaults to 30 seconds

  @Dashboard
  Scenario: Verify broken link
    Given Admin is in login Page
    When Admin enter valid credentials and clicks login button
    Then HTTP response >= 400. Then the link is broken

  @Dashboard
  Scenario: Verify LMS title
    Given Admin is in login Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see LMS -Learning management system as title

  @Dashboard
  Scenario: Verify LMS title alignment
    Given Admin is in login Page
    When Admin enter valid credentials and clicks login button
    Then LMS title should be on the top left corner of page

  @Dashboard
  Scenario: Validate navigation bar text
    Given Admin is in login Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see correct spelling in navigation bar text

  @Dashboard
  Scenario: Validate LMS title has correct spelling and space
    Given Admin is in login Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see correct spelling and space in LMS title

  @Dashboard
  Scenario: Validate alignment for navigation bar
    Given Admin is in login Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see the navigation bar text on the top right side

  @Dashboard
  Scenario: Validate navigation bar order 1st home
    Given Admin is in login Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see Home in the 1st place

  @Dashboard
  Scenario: Validate navigation bar order 2nd program
    Given Admin is in login Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see program in the 2nd place

  @Dashboard
  Scenario: Validate navigation bar order 3rd batch
    Given Admin is in login Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see batch in the 3rd place

  @Dashboard
  Scenario: Validate navigation bar order 4th class
    Given Admin is in login Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see class in the 4th place

  @Dashboard
  Scenario: validate navigation bar order 5 th logout
    Given Admin is in login Page
    When Admin enter valid credentials and clicks login button
    Then Admin should see logout in the 5th place
