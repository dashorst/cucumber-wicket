package com.wicketinaction.counting;

import com.wicketinaction.WicketSteps;
import cuke4duke.Before;

public class CountingSteps {
	@Before("@counting")
	public void setCountingApplication() {
		WicketSteps.setApplication(new CountingApplication());
	}
}
