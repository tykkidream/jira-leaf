package org.tykkidream.jira.webhook.domain.model.issue;

public class IssueStatus {
	private String self;

	private String id;

	private String description;

	private String iconUrl;

	private String name;

	private IssueStatusCategory statusCategory;

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		if (self != null) {
			this.self = self;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id != null) {
			this.id = id;
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description != null) {
			this.description = description;
		}
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		if (iconUrl != null) {
			this.iconUrl = iconUrl;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	public IssueStatusCategory getStatusCategory() {
		return statusCategory;
	}

	public void setStatusCategory(IssueStatusCategory statusCategory) {
		if (statusCategory != null) {
			this.statusCategory = statusCategory;
		}
	}
}
