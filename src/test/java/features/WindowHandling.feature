Feature: Handling the windows

  Background: The Login Page should be open
    Given browser is open and navigate to the Base URL

    Scenario: TC-343 Validate that user handles multiple windows properly
#     Given User is in the practice page
      When user click on the Open Window
      Then Validate that User can switch to the second window
      Then Validate that User can switch to the first window
