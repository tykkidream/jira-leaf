package org.tykkidream.jira.core.domain.model.jira.issue;

public class IssueType {

	private String self;

	private String id;

	private String description;

	private String iconUrl;

	/**
	 * 类型名称，如故事
	 */
	private String name;

	private Boolean subtask;

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

	public Boolean getSubtask() {
		return subtask;
	}

	public void setSubtask(Boolean subtask) {
		if (subtask != null) {
			this.subtask = subtask;
		}
	}
}
