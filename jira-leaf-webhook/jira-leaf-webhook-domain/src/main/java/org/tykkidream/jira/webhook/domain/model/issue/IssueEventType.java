package org.tykkidream.jira.webhook.domain.model.issue;

public enum  IssueEventType {
	/**
	 * 此枚举未定义的其它事件类型
	 */
	None {
		@Override
		public boolean isNone() {
			return true;
		}
	},

	/**
	 * 问题的信息（字段）被更新
	 */
	IssueUpdated {
		@Override
		public boolean isIssueUpdated() {
			return true;
		}
	},

	/**
	 * 添加新的备注给问题
	 */
	IssueCommented {
		@Override
		public boolean isIssueCommented() {
			return true;
		}
	},

	/**
	 * 问题被分配经办人
	 */
	IssueAssigned {
		@Override
		public boolean isIssueAssigned() {
			return true;
		}
	},

	/**
	 * 问题解决完成
	 */
	IssueResolved {
		@Override
		public boolean isIssueResolved() {
			return true;
		}
	},

	/**
	 * 问题关闭
	 */
	IssueClosed {
		@Override
		public boolean isIssueClosed() {
			return true;
		}
	},

	;

	public static IssueEventType valueOfJSON(String text) {
		switch (text) {
		case "issue_updated":
			return IssueUpdated;
		case "issue_commented":
			return IssueCommented;
		case "issue_assigned":
			return IssueAssigned;
		case "issue_resolved":
			return IssueResolved;
		case "issue_closed":
			return IssueClosed;
		}

		return None;
	}

	public boolean isNone() {
		return false;
	}

	public boolean isIssueUpdated() {
		return false;
	}

	public boolean isIssueCommented() {
		return false;
	}

	public boolean isIssueAssigned() {
		return false;
	}

	public boolean isIssueResolved() {
		return false;
	}

	public boolean isIssueClosed() {
		return false;
	}
}
