package com.wicketinaction.helloworld;

import org.apache.wicket.Application;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see com.wicketinaction.Start#main(String[])
 */
public class HelloWorldApplication extends WebApplication {
	/**
	 * Constructor
	 */
	public HelloWorldApplication() {
	}

	@Override
	public String getConfigurationType() {
		return Application.DEPLOYMENT;
	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

}
