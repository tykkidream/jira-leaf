package org.tykkidream.jira.webhook.application;

import org.tykkidream.jira.webhook.domain.forward.ForwardMessageService;
import org.tykkidream.jira.webhook.domain.model.WebHookEvent;
import org.tykkidream.jira.webhook.domain.model.WebHookMessage;
import org.tykkidream.jira.webhook.domain.model.issue.IssueEventType;
import org.tykkidream.jira.webhook.util.JsonUtil;

import javax.annotation.Resource;

public class JiraApplicationService {

	@Resource
	private ForwardMessageService forwardMessageService;

	public WebHookMessage buildWebHookMessageFromJSONString(String jsongString) {
		WebHookMessage webHookMessage = JsonUtil.readValue(jsongString, WebHookMessage.class);
		return webHookMessage;
	}

	public void forwardMessage(String requestBody) {
		WebHookMessage webHookMessage = buildWebHookMessageFromJSONString(requestBody);

		WebHookEvent webhookEvent = webHookMessage.getWebhookEvent();

		if (webhookEvent.isJiraIssueUpdated()) {

			IssueEventType issueEventType = webHookMessage.getIssueEventType();

			if (issueEventType.isIssueCommented()) {
				forwardMessageService.comment(webHookMessage);
			}

		}

	}

	public void setForwardMessageService(ForwardMessageService forwardMessageService) {
		if (forwardMessageService != null) {
			this.forwardMessageService = forwardMessageService;
		}
	}
}
