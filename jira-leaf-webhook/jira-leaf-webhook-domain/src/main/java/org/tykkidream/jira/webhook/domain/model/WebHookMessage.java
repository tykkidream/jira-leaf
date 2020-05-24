package org.tykkidream.jira.webhook.domain.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.tykkidream.jira.webhook.domain.model.changelog.ChangeLog;
import org.tykkidream.jira.webhook.domain.model.comment.Comment;
import org.tykkidream.jira.webhook.domain.model.issue.Issue;
import org.tykkidream.jira.webhook.domain.model.issue.IssueEventType;
import org.tykkidream.jira.webhook.domain.model.user.User;

import java.util.Date;

/**
 * Web Hook 推送的消息
 */
public class WebHookMessage {
	private Date timestamp;

	/**
	 * 事件
	 */
	private WebHookEvent webhookEvent;

	@JsonProperty("issueEventType")
	@JsonAlias("issue_event_type_name")
	private IssueEventType issueEventType;

	private User user;

	/**
	 * 问题
	 */
	private Issue issue;

	/**
	 * 备注
	 */
	private Comment comment;

	/**
	 * 改动记录
	 */
	private ChangeLog changeLog;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		if (timestamp != null) {
			this.timestamp = timestamp;
		}
	}

	public WebHookEvent getWebhookEvent() {
		return webhookEvent;
	}

	public void setWebhookEvent(WebHookEvent webhookEvent) {
		if (webhookEvent != null) {
			this.webhookEvent = webhookEvent;
		}
	}

	public IssueEventType getIssueEventType() {
		return issueEventType;
	}

	public void setIssueEventType(IssueEventType issueEventType) {
		if (issueEventType != null) {
			this.issueEventType = issueEventType;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		if (user != null) {
			this.user = user;
		}
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		if (issue != null) {
			this.issue = issue;
		}
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		if (comment != null) {
			this.comment = comment;
		}
	}

	public ChangeLog getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(ChangeLog changeLog) {
		if (changeLog != null) {
			this.changeLog = changeLog;
		}
	}
}
