Feature: Adobe End to End Flow

Scenario: Full Adobe User Journey

  Given user opens application
  When user logs in

  Then user clicks on All Tools
  Then user verifies Create PDF Space feature
  Then user navigates to PDF Spaces
  Then user opens curated section
  Then user validates curated pdf spaces
  Then user verifies profile email