Cucumber Wicket
===============

This is an example project for integrating [Cucumber](http://cukes.info)
with [Apache Wicket](http://wicket.apache.org). This way it is possible
to write your integration tests using
[Gherkin](http://wiki.github.com/aslakhellesoy/cucumber/gherkin).

Example Cucumber scripts:

	Feature: Helloworld
  		In order to greet the world
  		As a user
  		I want to see the text Hello World in a browser window.
	
		Scenario: Hello World
	  	Given I am viewing the home page
	  	Then I should see "Hello World"

	Feature: Counting
		In order to count the number of clicks on a link
		As a bean counter
		I want to see a number increase with each click on a link.

		Scenario: number is zero without any clicks
		Given I am viewing the home page
		Then I should see "Number of clicks 0"
		And I should see a link with text "Click me"

		Scenario: number is one after a click
		Given I am viewing the home page
		When I click the link with text "Click me"
		Then I should see "Number of clicks 1"

This project makes use of
[Cuke4Duke](http://wiki.github.com/aslakhellesoy/cuke4duke)'s Maven
plugin to run the features.

Running the examples:

* follow the cuke4duke [installation instructions](http://wiki.github.com/aslakhellesoy/cuke4duke/maven)
* run `mvn integration-test` in the project folder

