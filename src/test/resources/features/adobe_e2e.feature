Feature: Adobe End to End Flow

Scenario: Validate Adobe user journey from login to PDF Spaces

  Given user opens application
  When user logs in

  Then user clicks on All Tools
  Then user verifies Create PDF Space feature
  Then user opens curated section
  Then user validates curated pdf spaces
  Then user verifies profile email