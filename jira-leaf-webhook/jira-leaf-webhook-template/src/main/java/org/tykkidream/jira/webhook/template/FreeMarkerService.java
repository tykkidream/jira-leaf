package org.tykkidream.jira.webhook.template;

import javax.annotation.Resource;

public class FreeMarkerService {

	@Resource
	private FreeMarkerApplicationContext freeMarkerApplicationContext;

	public String comment(String templateName , Object data) {
		String content = freeMarkerApplicationContext.processTemplate(templateName, data);
		return content;
	}

	public void setFreeMarkerApplicationContext(FreeMarkerApplicationContext freeMarkerApplicationContext) {
		if (freeMarkerApplicationContext != null) {
			this.freeMarkerApplicationContext = freeMarkerApplicationContext;
		}
	}
}
