package org.apache.wicket.tester;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;

public class CollectingVisitor<T extends Component, X extends Component>
		implements Component.IVisitor<T> {
	private ComponentMatcher matcher;

	private boolean findFirst = false;

	private List<X> matchedComponents = new ArrayList<X>();

	public CollectingVisitor(ComponentMatcher matcher) {
		this.matcher = matcher;
	}

	public CollectingVisitor(ComponentMatcher matcher, boolean findFirst) {
		this.matcher = matcher;
		this.findFirst = findFirst;
	}

	public List<X> getMatchedComponents() {
		return matchedComponents;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object component(T component) {
		if (matcher.matches(component)) {
			matchedComponents.add((X) component);
			return findFirst ? Component.IVisitor.STOP_TRAVERSAL
					: Component.IVisitor.CONTINUE_TRAVERSAL;
		}
		return Component.IVisitor.CONTINUE_TRAVERSAL;
	}
}
