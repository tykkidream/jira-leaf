package org.tykkidream.jira.webhook.configuration.freemarker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tykkidream.jira.webhook.template.FreeMarkerApplicationContext;
import org.tykkidream.jira.webhook.template.FreeMarkerService;

@Configuration
public class FreemarkerConfiguration {

	@Bean
	public FreeMarkerApplicationContext FreeMarkerApplicationContext() {
		FreeMarkerApplicationContext context = new FreeMarkerApplicationContext();

		context.loadClasspath("/META-INF/freemarker");

		return context;
	}

	@Bean
	public FreeMarkerService freeMarkerService() {
		FreeMarkerService freeMarkerService = new FreeMarkerService();

		return freeMarkerService;
	}

}
