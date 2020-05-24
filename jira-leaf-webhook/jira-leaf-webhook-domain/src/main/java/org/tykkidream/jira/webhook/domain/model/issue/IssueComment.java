package org.tykkidream.jira.webhook.domain.model.issue;

import org.tykkidream.jira.webhook.domain.model.comment.Comment;

import java.util.List;

/**
 * 问题备注信息
 */
public class IssueComment {
	/**
	 * 备注
	 */
	private List<Comment> comments;

	private Integer maxResults;

	/**
	 * 备注总数量
	 */
	private Integer total;

	/**
	 * 第一个起始部署（正序、反序）
	 */
	private Integer startAt;

}
