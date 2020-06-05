package org.tykkidream.jira.webhook.configuration.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Configuration;
import org.tykkidream.jira.webhook.configuration.jackson.deserializer.IssueEventTypeDeserializer;
import org.tykkidream.jira.webhook.configuration.jackson.deserializer.WebHookEventDeserializer;
import org.tykkidream.jira.core.domain.model.jira.WebHookEvent;
import org.tykkidream.jira.core.domain.model.jira.issue.IssueEventType;
import org.tykkidream.jira.webhook.util.JsonUtil;

import javax.annotation.PostConstruct;

@Configuration
public class JacksonConfiguration {

	@PostConstruct
	public static void registerModule() {
		ObjectMapper mapper = JsonUtil.getMapper();

		{
			SimpleModule module = new SimpleModule();

			module.addDeserializer(WebHookEvent.class, new WebHookEventDeserializer());
			module.addDeserializer(IssueEventType.class, new IssueEventTypeDeserializer());

			mapper.registerModule(module);
		}

		{
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		}
	}
}
