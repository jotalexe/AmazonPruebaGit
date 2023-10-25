Feature: Find Item on Amazon

  @SmokeTest

  Scenario Outline: Select an article and validate name

    Given I am on the amazon
    When I am on the Amazon page and I'm looking for a random item <Search>
    Then I will validate the name of  the article

    Examples:

      | Search           |
      | Shop by Category |