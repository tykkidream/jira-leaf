package org.tykkidream.jira.core.repository;

import org.tykkidream.jira.core.domain.model.jira.watches.Watches;
import org.tykkidream.jira.core.domain.repository.jira.WatcherRepository;

import javax.annotation.Resource;

public class WatcherRepositoryImpl implements WatcherRepository {

	@Resource
	private HttpClientHelper httpClientHelper;

	@Override
	public Watches findWatches(Watches watches) {

		String data = httpClientHelper.get(watches.getSelf());

		if (data == null) {
			return null;
		}

		Watches result = JsonUtil.readValue(data, Watches.class);

		return result;
	}
}
