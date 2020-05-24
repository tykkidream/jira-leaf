package org.tykkidream.jira.webhook.domain.model.user;

/**
 * 用户
 */
public class User {
	private String self;

	private String name;

	private String key;

	private String emailAddress;

	private AvatarUrls avatarUrls;

	private String displayName;

	private Boolean active;

	private String timeZone;

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		if (self != null) {
			this.self = self;
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		if (key != null) {
			this.key = key;
		}
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		if (emailAddress != null) {
			this.emailAddress = emailAddress;
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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		if (displayName != null) {
			this.displayName = displayName;
		}
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		if (active != null) {
			this.active = active;
		}
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		if (timeZone != null) {
			this.timeZone = timeZone;
		}
	}
}
