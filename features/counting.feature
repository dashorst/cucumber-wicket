@counting
Feature: Counting
  In order to count the number of clicks on a link
  As a user
  I want to see a number increase with each click on a link.

	Scenario: number is zero without any clicks
	  Given I am viewing the home page
	  Then I should see "Number of clicks 0"
	  And I should see a link with text "Click me"

	Scenario: number is one after a click
	  Given I am viewing the home page
	  When I click the link with text "Click me"
	  Then I should see "Number of clicks 1"

	
	
