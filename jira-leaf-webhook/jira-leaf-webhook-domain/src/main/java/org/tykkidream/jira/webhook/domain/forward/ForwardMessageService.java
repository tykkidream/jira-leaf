package org.tykkidream.jira.webhook.domain.forward;

import org.tykkidream.jira.webhook.domain.model.WebHookMessage;

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
}
