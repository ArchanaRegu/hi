Feature: Verify given URL

  #@Login
  #Scenario: Verify Login with valid url # sample Test case - need to review
  #Given Admin launch the browser
  #When Admin gives the correct LMS portal URL
  #Then Admin should land on the login page
  @Login
  Scenario: Verify Admin is able to land on login page # TC#1
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page

  @Login
  Scenario: Verify Admin is able to land on home page with invalid URL # TC#2
    Given Admin launch the browser
    When Admin gives the invalid LMS portal URL
    Then Admin should recieve 404 page not found error

  @Login
  Scenario: Verify for broken link # TC#3
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then HTTP response >= 400. Then the link is broken

  @Login
  Scenario: Verify the text spelling in the page  # TC#4
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields
    
  @Login
  Scenario: Verify the company logo # TC#5
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see logo on the left  side

  @Login
  Scenario: Verify application name # TC#6
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see  LMS - Learning Management System

  @Login
  Scenario: Verify company name # TC#7
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see company name below the app name

@Login
  Scenario: Validate sign in content # TC#8
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see "Please login to LMS application"

  @Login
  Scenario: Verify text field is present # TC#9
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see 2 text field

  @Login
  Scenario: Verify text on the first text field # TC#10
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should "User" in the first text field

  @Login
  Scenario: Verify asterik next to Admin text # TC#11
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see field mandatory asterik symbol next to Admin text

  @Login
  Scenario: Verify text on the second text field # TC#12
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should "Password" in the second text field

  @Login
  Scenario: Verify asterik next to password text # TC#13
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see * symbol next to password text

  @Login
  Scenario: Verify the alignment input field for the login  # TC#14
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see input field on the centre of the page

    @Login
  Scenario: verify Login button is present # TC#15
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see login button

  @Login
  Scenario: Verify the alignment of the login button # TC#16
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see login button on the centre of the page

  @Login
  Scenario: Verify input descriptive test in Admin field # TC#17
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see Admin in gray color

  @Login
  Scenario: Verify input descriptive test in password field # TC#18
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see password in gray color