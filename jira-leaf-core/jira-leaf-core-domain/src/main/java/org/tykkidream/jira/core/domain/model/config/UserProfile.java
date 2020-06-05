package org.tykkidream.jira.core.domain.model.config;

public class UserProfile {

	/**
	 * jira账号
	 */
	private String username;

	/**
	 * 姓名
	 */
	private String fullname;

	/**
	 * 手机号
	 */
	private String phone;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (username != null) {
			this.username = username;
		}
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		if (fullname != null) {
			this.fullname = fullname;
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
