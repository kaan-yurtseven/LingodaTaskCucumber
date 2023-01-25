@Test
Feature: Lingoda

  Background:
    Given the user is on the website

  Scenario: BasePage is launched
    Then Website is opened as a "ToDoMVC"

  Scenario: Polymer Link is displayed
    When "JavaScript" is "clicked" with "text"
    Then "Polymer" is "displayed" with "text"

  Scenario: Polimer's Homepage is launched
    When "JavaScript" is "clicked" with "text"
    When "Polymer" is "clicked" with "text"
    Then Website is opened as a "Polymer • TodoMVC"

  Scenario: Add items to to do List
    When "JavaScript" is "clicked" with "text"
    And "Polymer" is "clicked" with "text"
    And "What needs to be done?" is "clicked" with "placeholder"
    And "What needs to be done? - This is a first test message!" is "writed" with "placeholder"
    And "What needs to be done?" is "clicked" with "placeholder"
    And "What needs to be done? - This is a second test message!" is "writed" with "placeholder"
    Then TodoList has 2 items

  Scenario: Edit the content of the second Todo item
    When "JavaScript" is "clicked" with "text"
    And "Polymer" is "clicked" with "text"
    And "What needs to be done?" is "clicked" with "placeholder"
    And "What needs to be done? - This is a first test message!" is "writed" with "placeholder"
    And "What needs to be done?" is "clicked" with "placeholder"
    And "What needs to be done? - This is a second test message!" is "writed" with "placeholder"
     And "This is a second test message! - Second test message is editted!" is "editted" with "text"
    And "Second test message is editted!" is "displayed" with "text"



