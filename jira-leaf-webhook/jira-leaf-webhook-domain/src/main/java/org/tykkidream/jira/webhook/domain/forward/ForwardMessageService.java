package org.tykkidream.jira.webhook.domain.forward;

import org.tykkidream.jira.core.domain.model.jira.WebHookMessage;

public interface ForwardMessageService {
	/**
	 * 新备注通知
	 * @param webHookMessage
	 */
	void comment(WebHookMessage webHookMessage);

	/**
	 *
	 * @param webHookMessage
	 */
	void changeLog(WebHookMessage webHookMessage);

	/**
	 * 问题解决通知
	 * @param webHookMessage
	 */
	void resolved(WebHookMessage webHookMessage);

	/**
	 * 问题关闭通知
	 * @param webHookMessage
	 */
	void closed(WebHookMessage webHookMessage);

	/**
	 * 问题重打开通知
	 * @param webHookMessage
	 */
	void reopened(WebHookMessage webHookMessage);

	void generic(WebHookMessage webHookMessage);
}
