package org.tykkidream.jira.core.domain.model.jira.watches;

import org.tykkidream.jira.core.domain.model.jira.user.User;

import java.util.List;

/**
 * 问题关注人信息
 */
public class Watches {
	/**
	 * 关注人信息获取地址
	 */
	private String self;

	/**
	 * 关注人数
	 */
	private Integer watchCount;

	private Boolean isWatching;

	/**
	 * 关注人信息
	 */
	private List<User> watchers;

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		if (self != null) {
			this.self = self;
		}
	}

	public Integer getWatchCount() {
		return watchCount;
	}

	public void setWatchCount(Integer watchCount) {
		if (watchCount != null) {
			this.watchCount = watchCount;
		}
	}

	public Boolean getWatching() {
		return isWatching;
	}

	public void setWatching(Boolean watching) {
		if (watching != null) {
			isWatching = watching;
		}
	}

	public List<User> getWatchers() {
		return watchers;
	}

	public void setWatchers(List<User> watchers) {
		if (watchers != null) {
			this.watchers = watchers;
		}
	}
}
