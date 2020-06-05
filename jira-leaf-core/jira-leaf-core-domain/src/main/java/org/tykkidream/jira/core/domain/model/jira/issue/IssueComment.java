package org.tykkidream.jira.core.domain.model.jira.issue;

import org.tykkidream.jira.core.domain.model.jira.comment.Comment;

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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		if (comments != null) {
			this.comments = comments;
		}
	}

	public Integer getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(Integer maxResults) {
		if (maxResults != null) {
			this.maxResults = maxResults;
		}
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		if (total != null) {
			this.total = total;
		}
	}

	public Integer getStartAt() {
		return startAt;
	}

	public void setStartAt(Integer startAt) {
		if (startAt != null) {
			this.startAt = startAt;
		}
	}
}
