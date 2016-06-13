/*
 * Copyright 2000-2014 Namics AG. All rights reserved.
 */

package com.namics.samples.docker;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.inject.Inject;

/**
 * TomcatConfig.
 *
 * @author bhelfenberger, Namics AG
 * @since 31.03.2015
 */
@Configuration
public class TomcatConfig {
	@Inject
	Environment environment;

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		int httpPort = environment.getProperty("httpPort", int.class, 8080);
		int ajpPort = environment.getProperty("ajpPort", int.class, 8009);
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory(httpPort);
		tomcat.addAdditionalTomcatConnectors(createAjpConnector(ajpPort));
		return tomcat;
	}

	private Connector createAjpConnector(int port) {
		Connector connector = new Connector("org.apache.coyote.ajp.AjpProtocol");
		connector.setPort(port);
		connector.setScheme("ajp");
		return connector;
	}
}
