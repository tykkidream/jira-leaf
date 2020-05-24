package org.tykkidream.jira.webhook.dingding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tykkidream.jira.webhook.domain.forward.ForwardMessageService;
import org.tykkidream.jira.webhook.domain.model.WebHookMessage;
import org.tykkidream.jira.webhook.template.FreeMarkerService;

import javax.annotation.Resource;

public class DingDingForwardMessageService implements ForwardMessageService {
	private static final Logger logger = LoggerFactory.getLogger(DingDingForwardMessageService.class);

	@Resource
	private FreeMarkerService freeMarkerService;

	@Resource
	private DingDingService dingDingService;

	public void pushMessage(WebHookMessage webHookMessage) {

	}

	public void comment(WebHookMessage webHookMessage) {
		String content = freeMarkerService.comment("dingding/comment.ftl", webHookMessage);

		if (logger.isDebugEnabled()) {
			logger.debug("推送钉钉消息：{}", content);
		}

		dingDingService.sendMarkdown(content, null);
	}

	public void setFreeMarkerService(FreeMarkerService freeMarkerService) {
		if (freeMarkerService != null) {
			this.freeMarkerService = freeMarkerService;
		}
	}

	public void setDingDingService(DingDingService dingDingService) {
		if (dingDingService != null) {
			this.dingDingService = dingDingService;
		}
	}
}
