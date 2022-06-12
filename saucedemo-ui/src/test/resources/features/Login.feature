@Smoke
Feature: Login page
  AS A user
  I WANT TO login to account.
  SO THAT I can do it.

  @Positive
  Scenario Outline: Login page, positive flow
    Given the customer opens the 'Home' page
    And the customer 'is' on the 'Home' page
    And the login fragment is displayed
    When the customer inputs '<login>' and 'secret_sauce' in the login input form
    And the customer clicks the 'login' button
    Then the customer 'is not' on the 'Home' page
    And the 'Products' page is opened
    And the customer sees products containers

    Examples:
      | login         |
      | standard_user |
      | problem_user  |

  @Negative
  Scenario Outline: Login page, negative flow
    Given the guest opens the 'Home' page
    And the customer 'is' on the 'Home' page
    And the login fragment is displayed
    When the customer inputs '<login>' and '<password>' in the login input form
    And the customer clicks the 'login' button
    Then the '<alertMessage>' alert message is displayed
    And the customer 'is' on the 'Home' page

    Examples:
      | login           | password         | alertMessage                                                              |
      |                 | password         | Epic sadface: Username is required                                        |
      | user            |                  | Epic sadface: Password is required                                        |
      | locked_out_user | secret_sauce     | Epic sadface: Sorry, this user has been locked out.                       |
      | standard_user   | invalid_password | Epic sadface: Username and password do not match any user in this service |