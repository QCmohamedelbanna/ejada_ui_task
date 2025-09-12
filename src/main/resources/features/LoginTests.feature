Feature: Login Test with Valid and Invalid Scenarios

  Scenario: Users login successfully with valid username and password
    Given Users hit the Base URL
    When Users enter a username "standard_user" and a password "secret_sauce"
    When Users click on Login Button
    Then Users Login Successfully

  Scenario: Users shouldn't be able to login with Invalid username and Valid Password
    Given Users hit the Base URL
    When Users enter a username "mohamed_elbanna" and a password "secret_sauce"
    When Users click on Login Button
    Then Validation message with error is displayed "Epic sadface: Username and password do not match any user in this service"

  Scenario: Users shouldn't be able to login with Valid username and Invalid Password
    Given Users hit the Base URL
    When Users enter a username "standard_user" and a password "P@ssW0rd"
    When Users click on Login Button
    Then Validation message with error is displayed "Epic sadface: Username and password do not match any user in this service"

  Scenario: Users shouldn't be able to login with Invalid username and Invalid Password
    Given Users hit the Base URL
    When Users enter a username "mo_elbanna" and a password "P@ssW0rd"
    When Users click on Login Button
    Then Validation message with error is displayed "Epic sadface: Username and password do not match any user in this service"

  Scenario: Locked Users shouldn't be able to access the app
    Given Users hit the Base URL
    When Users enter a username "locked_out_user" and a password "secret_sauce"
    When Users click on Login Button
    Then Validation message with error is displayed "Epic sadface: Sorry, this user has been locked out."