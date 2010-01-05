package org.apache.wicket.tester.matchers;

import org.apache.wicket.Component;
import org.apache.wicket.tester.ComponentMatcher;

public class AndMatcher implements ComponentMatcher {
	private ComponentMatcher left;

	private ComponentMatcher right;

	public AndMatcher(ComponentMatcher left, ComponentMatcher right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean matches(Component component) {
		return left.matches(component) && right.matches(component);
	}
}
