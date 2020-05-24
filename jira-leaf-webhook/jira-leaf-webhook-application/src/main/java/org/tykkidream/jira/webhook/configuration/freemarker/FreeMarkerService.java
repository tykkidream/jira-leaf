package org.tykkidream.jira.webhook.configuration.freemarker;

import org.springframework.stereotype.Component;
import org.tykkidream.jira.webhook.domain.model.WebHookMessage;

import javax.annotation.Resource;

@Component
public class FreeMarkerService {

	@Resource
	private FreeMarkerApplicationContext freeMarkerApplicationContext;

	public String comment(WebHookMessage webHookMessage) {
		String content = freeMarkerApplicationContext.processTemplate("dingding/comment.ftl", webHookMessage);
		return content;
	}

	public void setFreeMarkerApplicationContext(FreeMarkerApplicationContext freeMarkerApplicationContext) {
		if (freeMarkerApplicationContext != null) {
			this.freeMarkerApplicationContext = freeMarkerApplicationContext;
		}
	}
}
