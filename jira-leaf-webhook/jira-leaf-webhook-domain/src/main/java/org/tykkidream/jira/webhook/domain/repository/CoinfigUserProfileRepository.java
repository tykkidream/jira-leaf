package org.tykkidream.jira.webhook.domain.repository;

import org.tykkidream.jira.webhook.domain.model.config.user.UserProfile;

public interface CoinfigUserProfileRepository {
	UserProfile findUserProfileByUsername(String username);
}
