@Login
Feature: Validating Adactin Hotel page

  Scenario Outline: Verifying Adactin Hotel Login Page with Valid Credential
    Given User is on Adactin Hotel Login Page
    When User Should Perform the "<username>","<password>"
    And User Should verify the success messsge as "Hello praveen1627!"

    Examples: 
      | username    | password |
      | praveen1627 | 48A543   |
      | praveen1627 | 48A543   |

  Scenario Outline: Verifying Adactin Hotel Login Page with InValid Credential
    Given User is on Adactin Hotel Login Page
    When User Should Perform the "<username>","<password>"
    And User Should verify the Error messsge as "Invalid Login details or Your Password might have expired."

    Examples: 
      | username    | password |
      | praveen1627 | 545D446  |
