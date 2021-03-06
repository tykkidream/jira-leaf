package org.tykkidream.jira.core.domain.model.jira;

/**
 * 事件
 */
public enum WebHookEvent {
	None {
		@Override
		public boolean isNone() {
			return true;
		}
	},

	/**
	 * 新的备注事件
	 */
	CommentCreated {
		@Override
		public boolean isCommentCreated() {
			return true;
		}
	},

	/**
	 * 问题被修改事件
	 */
	JiraIssueUpdated {
		@Override
		public boolean isJiraIssueUpdated() {
			return true;
		}
	},

	;

	public static WebHookEvent valueOfJSON(String text) {
		switch (text) {
			case "comment_created":
				return CommentCreated;
			case "jira:issue_updated":
				return JiraIssueUpdated;
		}

		return None;
	}

	public boolean isNone() {
		return false;
	}


	public boolean isCommentCreated() {
		return false;
	}

	public boolean isJiraIssueUpdated() {
		return false;
	}
}
