Feature: Interview Test

@jm
Scenario: Test for interview
    Given the user has logged into the application
      And the air emissions module is selected
     When a new record is created
      And the record is deleted
     Then the deletion is verified and the user logs out