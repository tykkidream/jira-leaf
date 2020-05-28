package org.tykkidream.jira.webhook.dingding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tykkidream.jira.webhook.domain.forward.ForwardMessageService;
import org.tykkidream.jira.webhook.domain.model.WebHookMessage;
import org.tykkidream.jira.webhook.domain.model.changelog.ChangeLog;
import org.tykkidream.jira.webhook.domain.model.changelog.ChangeLogItem;
import org.tykkidream.jira.webhook.template.FreeMarkerService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DingDingForwardMessageService implements ForwardMessageService {
	private static final Logger logger = LoggerFactory.getLogger(DingDingForwardMessageService.class);

	@Resource
	private FreeMarkerService freeMarkerService;

	@Resource
	private DingDingService dingDingService;

	public void comment(WebHookMessage webHookMessage) {
		String summary = webHookMessage.getIssue().getFields().getSummary();

		String buttonName = "查看详情";

		String issueUrl;

		String projectUrl;


		{

			String self = webHookMessage.getIssue().getSelf();
			String key = webHookMessage.getIssue().getKey();

			issueUrl = self.substring(0, self.indexOf("rest")) + "browse/" + key;
		}


		{
			String self = webHookMessage.getIssue().getFields().getProject().getSelf();
			String key = webHookMessage.getIssue().getFields().getProject().getKey();

			projectUrl = self.substring(0, self.indexOf("rest")) + "projects/" + key + "/summary";
		}




		Map<String, Object> data = new HashMap<>(2);
		data.put("webHookMessage", webHookMessage);
		data.put("issueUrl", issueUrl);
		data.put("projectUrl", projectUrl);

		String content = freeMarkerService.comment("dingding/comment.ftl", data);

		if (logger.isDebugEnabled()) {
			logger.debug("推送钉钉消息：{}", content);
		}

		// dingDingService.sendMarkdown(summary, content, null);
		dingDingService.sendActionCard(summary, content, null, buttonName, issueUrl);
	}

	@Override
	public void changeLog(WebHookMessage webHookMessage) {
		ChangeLog changeLog = webHookMessage.getChangeLog();

		List<ChangeLogItem> changeLogItems = changeLog.getItems();

		ChangeLogItem changeLogItem = changeLogItems.get(0);

		if (changeLogItem.isAssigneeChangeLog()) {
			String summary = webHookMessage.getIssue().getFields().getSummary();

			String buttonName = "查看详情";

			String issueUrl;

			String projectUrl;


			{

				String self = webHookMessage.getIssue().getSelf();
				String key = webHookMessage.getIssue().getKey();

				issueUrl = self.substring(0, self.indexOf("rest")) + "browse/" + key;
			}


			{
				String self = webHookMessage.getIssue().getFields().getProject().getSelf();
				String key = webHookMessage.getIssue().getFields().getProject().getKey();

				projectUrl = self.substring(0, self.indexOf("rest")) + "projects/" + key + "/summary";
			}

			Map<String, Object> data = new HashMap<>(2);
			data.put("webHookMessage", webHookMessage);
			data.put("issueUrl", issueUrl);
			data.put("projectUrl", projectUrl);


			String content = freeMarkerService.comment("dingding/assignee.ftl", data);

			dingDingService.sendActionCard(summary, content, null, buttonName, issueUrl);
		}

	}

	/* •••••••••••••••••••••••••••••••••••••••装••订••线••内••禁••止••作••答••否••则••记••零••分••••••••••••••••••••••••••••••••••••••• */

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
