package org.apache.wicket.tester;

import org.apache.wicket.Component;

public interface ComponentMatcher {
	public boolean matches(Component component);
}
