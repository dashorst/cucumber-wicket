package org.apache.wicket.tester.matchers;

import org.apache.wicket.Component;
import org.apache.wicket.tester.ComponentMatcher;

public class ComponentTypeMatcher implements ComponentMatcher {
	private Class<? extends Component> componentType;

	public ComponentTypeMatcher(Class<? extends Component> componentType) {
		this.componentType = componentType;
	}

	@Override
	public boolean matches(Component component) {
		return componentType.isAssignableFrom(component.getClass());
	}
}
