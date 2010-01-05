package com.wicketinaction;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.tester.CollectingVisitor;
import org.apache.wicket.tester.ComponentMatcher;
import org.apache.wicket.tester.matchers.ComponentTypeMatcher;
import org.apache.wicket.util.tester.TagTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Assert;

import cuke4duke.Given;
import cuke4duke.Then;
import cuke4duke.When;

public class WicketSteps {
	private static WicketTester tester;

	public static void setApplication(WebApplication application) {
		tester = new WicketTester(application);
		tester.getApplication().getMarkupSettings().setStripWicketTags(false);
	}

	@Given("^I am viewing the (.*)$")
	public void iAmViewing(String arg1) {
		if ("home page".equalsIgnoreCase(arg1)) {
			tester.startPage(tester.getApplication().getHomePage());
		}
	}

	@Then("^I should see \"([^\"]*)\"$")
	public void iShouldSee(String arg1) {
		String document = tester.getServletResponse().getDocument();
		String noHTMLString = document.replaceAll("\\<.*?\\>", "");
		Assert.assertTrue("Unable to find " + arg1 + " in the document",
				noHTMLString.indexOf(arg1) >= 0);
	}

	@Then("^I should see a (.*) with text \"([^\"]*)\"$")
	public void iShouldSeeAComponent(String componentType, String text) {
		if ("link".equalsIgnoreCase(componentType)) {
			Assert.assertNotNull(componentWithText(Link.class, text));
		}
	}

	@When("^I click the link with text \"([^\"]*)\"$")
	public void iClickTheLink(String arg1) {
		Link<?> link = componentWithText(Link.class, arg1);
		if (link != null) {
			tester.clickLink(link.getPageRelativePath());
			return;
		}
		Assert.fail("Unable to find link with text " + arg1);
	}

	private <T extends Component> T componentWithText(Class<T> componentClass,
			String text) {
		List<T> components = all(tester.getLastRenderedPage(),
				new ComponentTypeMatcher(componentClass));
		for (T component : components) {
			String id = component.getId();
			TagTester tag = tester.getTagByWicketId(id);

			String value = tag.getValue();
			if (text.equalsIgnoreCase(value)) {
				return component;
			}
		}
		return null;
	}

	private <T extends Component, X extends Component> X first(
			final MarkupContainer root, ComponentMatcher matcher) {
		CollectingVisitor<T, X> visitor = new CollectingVisitor<T, X>(matcher,
				true);
		root.visitChildren(null, visitor);
		return visitor.getMatchedComponents().isEmpty() ? null : visitor
				.getMatchedComponents().get(0);
	}

	private <T extends Component, X extends Component> List<X> all(
			final MarkupContainer root, ComponentMatcher matcher) {
		CollectingVisitor<T, X> visitor = new CollectingVisitor<T, X>(matcher);
		root.visitChildren(null, visitor);
		return visitor.getMatchedComponents();
	}

	private <T extends Component, X extends Component> X first(
			final MarkupContainer root, Class<T> componentType) {
		CollectingVisitor<T, X> visitor = new CollectingVisitor<T, X>(
				new ComponentTypeMatcher(componentType), true);
		root.visitChildren(null, visitor);
		return visitor.getMatchedComponents().get(0);
	}

	private <T extends Component, X extends Component> List<X> all(
			MarkupContainer root, Class<T> componentType) {
		ComponentMatcher matcher = new ComponentTypeMatcher(componentType);
		CollectingVisitor<T, X> visitor = new CollectingVisitor<T, X>(matcher);
		root.visitChildren(componentType, visitor);
		return visitor.getMatchedComponents();
	}
}
