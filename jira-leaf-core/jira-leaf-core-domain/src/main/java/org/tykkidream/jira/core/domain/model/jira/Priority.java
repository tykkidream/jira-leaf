package org.tykkidream.jira.core.domain.model.jira;

public class Priority {
	private String self;

	private String iconUrl;

	private String id;

	/**
	 * 优先级名称
	 * ===========================
	 *
	 * - Highest ： 最高
	 * - High    ： 高
	 * - Medium  ： 中
	 * - Low     ： 低
	 * - Lowest  ： 最低
	 *
	 */
	private String name;

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		if (self != null) {
			this.self = self;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id != null) {
			this.id = id;
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
