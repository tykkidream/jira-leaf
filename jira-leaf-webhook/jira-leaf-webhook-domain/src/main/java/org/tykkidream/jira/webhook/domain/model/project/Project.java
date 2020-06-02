package org.tykkidream.jira.webhook.domain.model.project;

import org.tykkidream.jira.core.domain.model.jira.AvatarUrls;

/**
 * 项目
 */
public class Project {
	private String self;

	private String id;

	/**
	 * 项目关键字
	 */
	private String key;

	/**
	 * 项目名称
	 */
	private String name;

	private String projectTypeKey;

	/**
	 * 项目图标
	 */
	private AvatarUrls avatarUrls;

	/**
	 * 项目分类
	 */
	private ProjectCategory projectCategory;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	public String getProjectTypeKey() {
		return projectTypeKey;
	}

	public void setProjectTypeKey(String projectTypeKey) {
		if (projectTypeKey != null) {
			this.projectTypeKey = projectTypeKey;
		}
	}

	public AvatarUrls getAvatarUrls() {
		return avatarUrls;
	}

	public void setAvatarUrls(AvatarUrls avatarUrls) {
		if (avatarUrls != null) {
			this.avatarUrls = avatarUrls;
		}
	}

	public ProjectCategory getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(ProjectCategory projectCategory) {
		if (projectCategory != null) {
			this.projectCategory = projectCategory;
		}
	}
}
