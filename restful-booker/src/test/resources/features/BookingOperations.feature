@GetToken
Feature: Booking operations
  AS A user
  I WANT TO get and create the bookings.
  SO THAT I can do it.

  Scenario: Get all bookings
    Given the customer sends request to get all bookings
    Then total bookings size is more than 1000

  Scenario: Get specific booking
    Given the customer sends request to get booking with 1000 bookingid
    Then the booking first name is Sally
    And the booking last name is Brown
    And the booking price is 111

  Scenario: Create a new booking
    Given the customer successfully creates default booking for person:
      | firstName | Ivan   |
      | lastName  | Petrov |
    When the customer tries to get new-created bookingid
    Then the booking first name is Ivan
    And the booking last name is Petrov
    And the booking price is 228