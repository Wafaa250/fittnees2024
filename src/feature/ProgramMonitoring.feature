Feature: Program Monitoring
  As an admin,
  I want to monitor various aspects of fitness programs,
  So that I can optimize and report on program performance.

  Scenario: View popular programs by enrollment
    Given I am logged in as an admin for program monitoring
    When I access the program statistics section
    Then I should see a list of programs sorted by their popularity based on enrollment

  Scenario: Generate revenue reports
    Given I am logged in as an admin for program monitoring
    When I select to generate a revenue report
    Then I should receive a detailed report on revenue sorted by program

  Scenario: Monitor attendance in programs
    Given I am logged in as an admin for program monitoring
    When I access the attendance tracking section
    Then I should see attendance statistics for each program

  Scenario: Generate client progress reports
    Given I am logged in as an admin for program monitoring
    When I choose to generate a progress report for clients
    Then I should receive a report detailing client progress in various programs

  Scenario: Track active and completed programs
    Given I am logged in as an admin for program monitoring
    When I look at the current program roster
    Then I should see lists differentiating active from completed programs
