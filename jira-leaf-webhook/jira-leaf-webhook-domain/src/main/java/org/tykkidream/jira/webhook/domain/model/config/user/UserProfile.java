package org.tykkidream.jira.webhook.domain.model.config.user;

public class UserProfile {

	private String username;

	private String phone;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (username != null) {
			this.username = username;
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone != null) {
			this.phone = phone;
		}
	}
}
