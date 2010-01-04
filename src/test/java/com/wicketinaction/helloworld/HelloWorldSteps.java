package com.wicketinaction.helloworld;

import com.wicketinaction.WicketSteps;
import cuke4duke.Before;

public class HelloWorldSteps {
	@Before("@helloworld")
	public void setHelloWorldApplication() {
		WicketSteps.setApplication(new HelloWorldApplication());
	}
}
