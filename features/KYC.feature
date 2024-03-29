@kycfeature
Feature: Launch KYC application

  @loginusingmaker
  Scenario: Maker tries to login
    Given the user launches kyc application using maker
    Then the user logs off

  @testkyc
  Scenario: Maker retries and submits app
    Given the user launches kyc application using maker
    When user waits
    When the user clicks on an application id
    When the user performs retry
    When user waits
    When the maker submits a doc for verification
    When user waits
    When close app detail window
    Then the user logs off

  @incorrectlogincred
  Scenario: User tries to login using incorrect login cred
    Given the user launches kyc application using incorrect login cred
    Then application throws error message

  @checker
  Scenario: Checker approves and rejects kyc request
    Given the user launches kyc application using checker
    When user waits
    When the user clicks on an application id
    When user waits
    When the user approves kyc request
    When user waits
    When the user rejects kyc request
    When user waits
    When close app detail window
    Then the user logs off

  @doc
  Scenario: User opens KYC Doc
    Given the user launches kyc application using checker
    When user waits
    When the user clicks on an application id
    When user waits
    When the user opens kyc doc
    When user waits
    When close app detail window
    Then the user logs off

  @appanalytics
  Scenario: User opens app analytics
    Given the user launches kyc application using checker
    When user waits
    When the user opens app analytics and closes app






