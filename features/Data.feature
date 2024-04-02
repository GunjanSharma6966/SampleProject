Feature: Launch Bank Website and test it

@tests
Scenario: To Login to Bank Website and register
Given the user opens Paras Bank Website $URL
Then user registers on website using $registerLink

@tests
Scenario: To login and perform a transaction
  Given the user opens Paras Bank Website $URL
  When user logs in using $username and $password
  Then user performs a txn for "1$"