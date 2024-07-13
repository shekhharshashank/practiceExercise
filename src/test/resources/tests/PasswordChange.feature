Feature: The user can change their own password
  Rule: As a user
  I want to be able to change my own password within the guidelines of password policy
  So that the integrity of my account security requirements are met.

    Scenario: User Changes it's password
    Given User authenticates with "Username" and "Password"
    When  User initiates password change
    Then Enters new password 
    And  Confirms the new Password
    
    