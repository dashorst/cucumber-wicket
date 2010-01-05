package org.apache.wicket.tester.matchers;

import org.apache.wicket.Component;
import org.apache.wicket.tester.ComponentMatcher;

public class ComponentIdMatcher implements ComponentMatcher {
	private final String id;

	public ComponentIdMatcher(String id) {
		this.id = id;
	}

	@Override
	public boolean matches(Component component) {
		return component.getId().equals(id);
	}
}
