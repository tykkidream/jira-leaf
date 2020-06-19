package org.tykkidream.jira.webhook.application;

import org.tykkidream.jira.core.domain.service.IssueEventTypeDomainService;
import org.tykkidream.jira.webhook.configuration.MyConfiguration;
import org.tykkidream.jira.core.domain.model.jira.WebHookEvent;
import org.tykkidream.jira.core.domain.model.jira.WebHookMessage;
import org.tykkidream.jira.core.domain.model.jira.issue.IssueEventType;
import org.tykkidream.jira.webhook.provider.ProviderWebHookService;
import org.tykkidream.jira.webhook.util.JsonUtil;

import javax.annotation.Resource;

public class JiraApplicationService {

	@Resource
	private ProviderWebHookService providerWebHookService;

	@Resource
	private IssueEventTypeDomainService issueEventTypeDomainService;

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
			IssueEventType issueEventType = issueEventTypeDomainService.analysis(webHookMessage);

			if (issueEventType.isNone()) {
				// 未知的问题事件
				return;
			} else if (issueEventType.isIssueCommented()) {
				// 添加备注
				providerWebHookService.comment(webHookMessage);
			} else if (issueEventType.isIssueAssigned()) {
				// 分配经办人
				providerWebHookService.changeLog(webHookMessage);
			} else if (issueEventType.isIssueUpdated()) {
				//
				providerWebHookService.changeLog(webHookMessage);
			} else if (issueEventType.isIssueResolved()) {
				// 问题被解决
				providerWebHookService.resolved(webHookMessage);
			} else if (issueEventType.isIssueClosed()) {
				// 问题被关闭
				providerWebHookService.closed(webHookMessage);
			} else if (issueEventType.isIssueReopened()) {
				// 问题被重打开
				providerWebHookService.reopened(webHookMessage);
			} else if (issueEventType.isIssueGeneric()) {
				// 问题被重打开
				providerWebHookService.generic(webHookMessage);
			}

		}

	}

	public void setProviderWebHookService(ProviderWebHookService providerWebHookService) {
		if (providerWebHookService != null) {
			this.providerWebHookService = providerWebHookService;
		}
	}
}
