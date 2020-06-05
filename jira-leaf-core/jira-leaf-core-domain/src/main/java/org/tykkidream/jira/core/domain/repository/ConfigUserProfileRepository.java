package org.tykkidream.jira.core.domain.repository;

import org.tykkidream.jira.core.domain.model.config.UserProfile;

public interface ConfigUserProfileRepository {
	UserProfile findUserProfileByUsername(String username);
}
