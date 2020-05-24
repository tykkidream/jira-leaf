package org.tykkidream.jira.webhook.configuration.freemarker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FreemarkerConfiguration {

	@Bean
	public FreeMarkerApplicationContext FreeMarkerApplicationContext() {
		FreeMarkerApplicationContext context = new FreeMarkerApplicationContext();

		context.loadDirectory("template");

		return context;
	}

}
