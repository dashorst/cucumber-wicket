package com.wicketinaction.counting;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	private int clicks = 0;

	public HomePage(final PageParameters parameters) {
		add(new Label("clicks", new PropertyModel<Integer>(this, "clicks")));
		add(new Link<Void>("link") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				clicks++;
			}
		});
	}
}
