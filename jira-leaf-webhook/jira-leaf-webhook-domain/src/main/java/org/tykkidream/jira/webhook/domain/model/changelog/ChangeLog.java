package org.tykkidream.jira.webhook.domain.model.changelog;

import java.util.List;

/**
 * 改动记录
 */
public class ChangeLog {

	private String id;

	private List<ChangeLogItem> items;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id != null) {
			this.id = id;
		}
	}

	public List<ChangeLogItem> getItems() {
		return items;
	}

	public void setItems(List<ChangeLogItem> items) {
		if (items != null) {
			this.items = items;
		}
	}
}
