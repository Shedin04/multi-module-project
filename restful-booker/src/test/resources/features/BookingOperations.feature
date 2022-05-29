@GetToken
Feature: Booking operations
  AS A user
  I WANT TO get and create the bookings.
  SO THAT I can do it.

  Scenario: Get all bookings
    Given the customer sends request to get all bookings
    Then total bookings size is more than 1000

  Scenario Outline: Get specific booking
    Given the customer sends request to get booking with <id> bookingid
    Then the booking first name is <FirstName>
    And the booking last name is <LastName>
    And the booking price is <price>
    Examples:
      | id   | FirstName | LastName | price |
      | 950  | Sally     | Brown    | 111   |