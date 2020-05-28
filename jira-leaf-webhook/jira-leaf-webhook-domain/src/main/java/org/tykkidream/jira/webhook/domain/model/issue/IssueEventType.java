package org.tykkidream.jira.webhook.domain.model.issue;

public enum  IssueEventType {

	IssueUpdated {
		@Override
		public boolean isIssueUpdated() {
			return true;
		}
	},

	IssueCommented {
		@Override
		public boolean isIssueCommented() {
			return true;
		}
	},

	IssueAssigned {
		@Override
		public boolean isIssueAssigned() {
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
		}

		return null;
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
}
