package org.tykkidream.jira.webhook.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.tykkidream.jira.core.domain.model.config.UserProfile;
import org.tykkidream.jira.core.domain.repository.ConfigUserProfileRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties
@PropertySource(value = "config.yml", factory = YamlPropertyResourceFactory.class)
public class MyConfiguration implements ConfigUserProfileRepository {

	private List<UserProfile> users;

	private Map<String, UserProfile> userMaps;

	public List<UserProfile> getUsers() {
		return users;
	}

	public void setUsers(List<UserProfile> users) {
		if (users != null) {
			this.users = users;
		}
	}

	@Override
	public UserProfile findUserProfileByUsername(String username) {
		if (userMaps == null) {
			userMaps = new HashMap<>(users.size());

			for (UserProfile userProfile : users) {
				userMaps.put(userProfile.getUsername(), userProfile);
			}
		}

		return userMaps.get(username);
	}
}
