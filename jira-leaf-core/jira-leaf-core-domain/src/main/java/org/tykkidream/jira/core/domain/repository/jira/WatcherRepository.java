package org.tykkidream.jira.core.domain.repository.jira;

import org.tykkidream.jira.core.domain.model.jira.watches.Watches;

public interface WatcherRepository {

	Watches findWatches(Watches watches);

}
