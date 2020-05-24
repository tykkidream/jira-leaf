package org.tykkidream.jira.webhook.domain.model;

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
}
