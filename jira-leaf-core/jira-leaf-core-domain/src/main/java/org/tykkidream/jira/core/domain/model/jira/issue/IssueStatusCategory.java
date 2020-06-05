package org.tykkidream.jira.core.domain.model.jira.issue;

public class IssueStatusCategory {
	private String self;

	private String id;

	private String key;

	private String colorName;

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		if (key != null) {
			this.key = key;
		}
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		if (colorName != null) {
			this.colorName = colorName;
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
