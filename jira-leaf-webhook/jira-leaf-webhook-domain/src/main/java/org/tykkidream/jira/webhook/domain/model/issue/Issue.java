package org.tykkidream.jira.webhook.domain.model.issue;

/**
 * 问题
 */
public class Issue {

	private String id;

	private String self;

	/**
	 * 问题的唯一标识
	 */
	private String key;

	/**
	 * 问题的详细字段
	 */
	private IssueFields fields;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id != null) {
			this.id = id;
		}
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		if (self != null) {
			this.self = self;
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

	public IssueFields getFields() {
		return fields;
	}

	public void setFields(IssueFields fields) {
		if (fields != null) {
			this.fields = fields;
		}
	}
}
