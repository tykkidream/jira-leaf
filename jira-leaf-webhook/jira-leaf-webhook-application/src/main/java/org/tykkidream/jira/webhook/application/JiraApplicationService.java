package org.tykkidream.jira.webhook.application;

import org.springframework.stereotype.Service;
import org.tykkidream.jira.webhook.domain.model.WebHookEvent;
import org.tykkidream.jira.webhook.domain.model.WebHookMessage;
import org.tykkidream.jira.webhook.domain.model.comment.Comment;
import org.tykkidream.jira.webhook.domain.model.issue.Issue;
import org.tykkidream.jira.webhook.domain.model.issue.IssueEventType;
import org.tykkidream.jira.webhook.domain.model.issue.IssueFields;
import org.tykkidream.jira.webhook.domain.model.issue.IssueStatus;
import org.tykkidream.jira.webhook.domain.model.project.Project;
import org.tykkidream.jira.webhook.domain.model.AvatarUrls;
import org.tykkidream.jira.webhook.domain.model.user.User;
import org.tykkidream.jira.webhook.configuration.freemarker.FreeMarkerService;
import org.tykkidream.jira.webhook.util.JsonUtil;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JiraApplicationService {

	@Resource
	private FreeMarkerService freeMarkerService;

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

				Comment comment = webHookMessage.getComment();

				// 添加备注的用户
				User commentAuthor = comment.getUpdateAuthor();

				// 备注内容
				String commentBody = comment.getBody();

				// 问题
				Issue issue = webHookMessage.getIssue();

				IssueFields issueFields = issue.getFields();

				// 问题key
				String issueKey = issue.getKey();

				// 问题概要
				String issueSummary = issueFields.getSummary();

				List<String> issueLabels = issueFields.getLabels();

				IssueStatus issueStatus = issueFields.getStatus();

				// 项目
				Project project = issueFields.getProject();

				// 项目key
				String projectKey = project.getKey();

				// 项目名
				String projectName = project.getName();

				// 项目图标
				AvatarUrls projectAvatarUrls = project.getAvatarUrls();

				String authorDisplayName = commentAuthor.getDisplayName();

				AvatarUrls authorAvatarUrls = commentAuthor.getAvatarUrls();

				String commentString = freeMarkerService.comment(webHookMessage);

				System.out.println(commentString);
			}

		}

	}

	public void setFreeMarkerService(FreeMarkerService freeMarkerService) {
		if (freeMarkerService != null) {
			this.freeMarkerService = freeMarkerService;
		}
	}
}
