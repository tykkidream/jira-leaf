package org.tykkidream.jira.webhook.application;

import org.tykkidream.jira.webhook.configuration.MyConfiguration;
import org.tykkidream.jira.webhook.domain.forward.ForwardMessageService;
import org.tykkidream.jira.webhook.domain.model.WebHookEvent;
import org.tykkidream.jira.webhook.domain.model.WebHookMessage;
import org.tykkidream.jira.webhook.domain.model.issue.IssueEventType;
import org.tykkidream.jira.webhook.util.JsonUtil;

import javax.annotation.Resource;

public class JiraApplicationService {

	@Resource
	private ForwardMessageService forwardMessageService;

	@Resource
	private MyConfiguration myConfiguration;

	public WebHookMessage buildWebHookMessageFromJSONString(String jsongString) {
		WebHookMessage webHookMessage = JsonUtil.readValue(jsongString, WebHookMessage.class);
		return webHookMessage;
	}

	public void forwardMessage(String requestBody) {
		WebHookMessage webHookMessage = buildWebHookMessageFromJSONString(requestBody);

		WebHookEvent webhookEvent = webHookMessage.getWebhookEvent();

		if (webhookEvent.isNone()) {
			return;
		} else if (webhookEvent.isJiraIssueUpdated()) {

			IssueEventType issueEventType = webHookMessage.getIssueEventType();

			if (issueEventType.isNone()) {
				return;
			} else if (issueEventType.isIssueCommented()) {
				forwardMessageService.comment(webHookMessage);
			} else if (issueEventType.isIssueAssigned()) {
				forwardMessageService.changeLog(webHookMessage);
			} else if (issueEventType.isIssueUpdated()) {
				forwardMessageService.changeLog(webHookMessage);
			}

		}

	}

	public void setForwardMessageService(ForwardMessageService forwardMessageService) {
		if (forwardMessageService != null) {
			this.forwardMessageService = forwardMessageService;
		}
	}
}
