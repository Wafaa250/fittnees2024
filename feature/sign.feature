Feature: login 


Scenario: valid loginn
Given I am not in system
When set username "haya" and pass "123"
Then login succeed




Scenario: invalid user name
Given I am not in system
When set invalid username "hayaw" and pass "123"
Then login failed



