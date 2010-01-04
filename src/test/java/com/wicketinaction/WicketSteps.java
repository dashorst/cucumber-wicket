package com.wicketinaction;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.WicketTester;

import cuke4duke.Given;
import cuke4duke.Then;

public class WicketSteps {
	private static WicketTester tester;

	public static void setApplication(WebApplication application) {
		tester = new WicketTester(application);
	}

	@Given("^I am viewing the (.*)$")
	public void iAmViewing(String arg1) {
		if ("home page".equalsIgnoreCase(arg1)) {
			tester.startPage(tester.getApplication().getHomePage());
		}
	}

	@Then("^I should see \"([^\"]*)\"$")
	public void iShouldSee(String arg1) {
		tester.assertContains(arg1);
	}
}
