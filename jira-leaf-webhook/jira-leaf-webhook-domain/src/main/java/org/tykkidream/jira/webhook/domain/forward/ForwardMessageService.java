package org.tykkidream.jira.webhook.domain.forward;

import org.tykkidream.jira.webhook.domain.model.WebHookMessage;

public interface ForwardMessageService {
	void comment(WebHookMessage webHookMessage);
}
