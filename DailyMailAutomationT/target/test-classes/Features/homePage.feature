Feature: DailyMail Home Page

  Scenario: Verify the webpage displays current date and time
    Given I am on DailyMail website home page
    When I check Date and Time
    Then I validate the current Date and Time displayed
