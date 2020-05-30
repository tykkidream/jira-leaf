package org.tykkidream.jira.webhook.domain.model.issue;

/**
 * 问题解决信息
 */
public class IssueResolution {

	private String self;

	private String id;

	private String description;

	private String name;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}
}
