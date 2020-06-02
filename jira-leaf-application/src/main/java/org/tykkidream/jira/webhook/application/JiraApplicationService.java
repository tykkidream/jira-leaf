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
			// 未知的事件
			return;
		} else if (webhookEvent.isJiraIssueUpdated()) {
			// 问题相关事件

			IssueEventType issueEventType = webHookMessage.getIssueEventType();

			if (issueEventType.isNone()) {
				// 未知的问题事件
				return;
			} else if (issueEventType.isIssueCommented()) {
				// 添加备注
				forwardMessageService.comment(webHookMessage);
			} else if (issueEventType.isIssueAssigned()) {
				// 分配经办人
				forwardMessageService.changeLog(webHookMessage);
			} else if (issueEventType.isIssueUpdated()) {
				//
				forwardMessageService.changeLog(webHookMessage);
			} else if (issueEventType.isIssueResolved()) {
				// 问题被解决
				forwardMessageService.resolved(webHookMessage);
			} else if (issueEventType.isIssueClosed()) {
				// 问题被关闭
				forwardMessageService.closed(webHookMessage);
			} else if (issueEventType.isIssueReopened()) {
				// 问题被重打开
				forwardMessageService.reopened(webHookMessage);
			} else if (issueEventType.isIssueGeneric()) {
				// 问题被重打开
				forwardMessageService.generic(webHookMessage);
			}

		}

	}

	public void setForwardMessageService(ForwardMessageService forwardMessageService) {
		if (forwardMessageService != null) {
			this.forwardMessageService = forwardMessageService;
		}
	}
}
