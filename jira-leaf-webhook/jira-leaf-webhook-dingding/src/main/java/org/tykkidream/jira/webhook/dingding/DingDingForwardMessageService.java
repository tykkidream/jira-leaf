package org.tykkidream.jira.webhook.dingding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tykkidream.jira.webhook.domain.forward.ForwardMessageService;
import org.tykkidream.jira.webhook.domain.model.WebHookMessage;
import org.tykkidream.jira.webhook.domain.model.changelog.ChangeLog;
import org.tykkidream.jira.webhook.domain.model.changelog.ChangeLogItem;
import org.tykkidream.jira.webhook.domain.model.config.user.UserProfile;
import org.tykkidream.jira.webhook.domain.model.user.User;
import org.tykkidream.jira.webhook.domain.repository.CoinfigUserProfileRepository;
import org.tykkidream.jira.webhook.template.FreeMarkerService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DingDingForwardMessageService implements ForwardMessageService {
	private static final Logger logger = LoggerFactory.getLogger(DingDingForwardMessageService.class);

	@Resource
	private FreeMarkerService freeMarkerService;

	@Resource
	private DingDingService dingDingService;

	@Resource
	private CoinfigUserProfileRepository coinfigUserProfileRepository;


	private static final String ButtonName = "查看详情";

	public void comment(WebHookMessage webHookMessage) {
		String summary = webHookMessage.getIssue().getFields().getSummary();

		String issueUrl = buildIssueUrl(webHookMessage);

		String projectUrl = buildProjectUrl(webHookMessage);


		Map<String, Object> data = new HashMap<>(2);
		data.put("webHookMessage", webHookMessage);
		data.put("issueUrl", issueUrl);
		data.put("projectUrl", projectUrl);

		String content = freeMarkerService.comment("dingding/comment.ftl", data);

		if (logger.isDebugEnabled()) {
			logger.debug("推送钉钉消息：{}", content);
		}

		// dingDingService.sendMarkdown(summary, content, null);
		dingDingService.sendActionCard(summary, content, null, ButtonName, issueUrl);
	}

	@Override
	public void changeLog(WebHookMessage webHookMessage) {
		ChangeLog changeLog = webHookMessage.getChangeLog();

		List<ChangeLogItem> changeLogItems = changeLog.getItems();

		ChangeLogItem changeLogItem = changeLogItems.get(0);

		if (changeLogItem.isAssigneeChangeLog()) {
			String summary = webHookMessage.getIssue().getFields().getSummary();

			String issueUrl = buildIssueUrl(webHookMessage);

			String projectUrl = buildProjectUrl(webHookMessage);

			User assignee = webHookMessage.getIssue().getFields().getAssignee();

			UserProfile userProfile = coinfigUserProfileRepository.findUserProfileByUsername(assignee.getName());

			List<String> phones = new LinkedList<>();

			if (userProfile != null) {
				String phone = userProfile.getPhone();

				if (phone != null) {
					phones.add(phone);
				}
			}

			Map<String, Object> data = new HashMap<>(2);
			data.put("webHookMessage", webHookMessage);
			data.put("issueUrl", issueUrl);
			data.put("projectUrl", projectUrl);

			String content = freeMarkerService.comment("dingding/assignee.ftl", data);

			dingDingService.sendActionCard(summary, content, phones, ButtonName, issueUrl);
		}

	}

	@Override
	public void resolved(WebHookMessage webHookMessage) {
		String summary = webHookMessage.getIssue().getFields().getSummary();

		String issueUrl = buildIssueUrl(webHookMessage);

		String projectUrl = buildProjectUrl(webHookMessage);

		User assignee = webHookMessage.getIssue().getFields().getAssignee();

		UserProfile userProfile = coinfigUserProfileRepository.findUserProfileByUsername(assignee.getName());

		List<String> phones = new LinkedList<>();

		if (userProfile != null) {
			String phone = userProfile.getPhone();

			if (phone != null) {
				phones.add(phone);
			}
		}

		Map<String, Object> data = new HashMap<>(2);
		data.put("webHookMessage", webHookMessage);
		data.put("issueUrl", issueUrl);
		data.put("projectUrl", projectUrl);

		String content = freeMarkerService.comment("dingding/resolved.ftl", data);

		dingDingService.sendActionCard(summary, content, phones, ButtonName, issueUrl);
	}

	@Override
	public void closed(WebHookMessage webHookMessage) {
		String summary = webHookMessage.getIssue().getFields().getSummary();

		String issueUrl = buildIssueUrl(webHookMessage);

		String projectUrl = buildProjectUrl(webHookMessage);

		User assignee = webHookMessage.getIssue().getFields().getAssignee();

		UserProfile userProfile = coinfigUserProfileRepository.findUserProfileByUsername(assignee.getName());

		List<String> phones = new LinkedList<>();

		if (userProfile != null) {
			String phone = userProfile.getPhone();

			if (phone != null) {
				phones.add(phone);
			}
		}

		Map<String, Object> data = new HashMap<>(2);
		data.put("webHookMessage", webHookMessage);
		data.put("issueUrl", issueUrl);
		data.put("projectUrl", projectUrl);

		String content = freeMarkerService.comment("dingding/closed.ftl", data);

		dingDingService.sendActionCard(summary, content, phones, ButtonName, issueUrl);

	}

	@Override
	public void reopened(WebHookMessage webHookMessage) {
		String summary = webHookMessage.getIssue().getFields().getSummary();

		String issueUrl = buildIssueUrl(webHookMessage);

		String projectUrl = buildProjectUrl(webHookMessage);

		User assignee = webHookMessage.getIssue().getFields().getAssignee();

		UserProfile userProfile = coinfigUserProfileRepository.findUserProfileByUsername(assignee.getName());

		List<String> phones = new LinkedList<>();

		if (userProfile != null) {
			String phone = userProfile.getPhone();

			if (phone != null) {
				phones.add(phone);
			}
		}

		Map<String, Object> data = new HashMap<>(3);
		data.put("webHookMessage", webHookMessage);
		data.put("issueUrl", issueUrl);
		data.put("projectUrl", projectUrl);

		String content = freeMarkerService.comment("dingding/reopened.ftl", data);

		dingDingService.sendActionCard(summary, content, phones, ButtonName, issueUrl);
	}

	@Override
	public void generic(WebHookMessage webHookMessage) {
		ChangeLog changeLog = webHookMessage.getChangeLog();

		List<ChangeLogItem> changeLogItems = changeLog.getItems();

		for (ChangeLogItem changeLogItem : changeLogItems) {

			if (changeLogItem.isStatusChangeLog()) {
				if (changeLogItem.getToString().equals("Done")
				&& !changeLogItem.getFromString().equals("Done")) {
					String summary = webHookMessage.getIssue().getFields().getSummary();

					String issueUrl = buildIssueUrl(webHookMessage);

					String projectUrl = buildProjectUrl(webHookMessage);

					User assignee = webHookMessage.getIssue().getFields().getAssignee();

					UserProfile userProfile = coinfigUserProfileRepository.findUserProfileByUsername(assignee.getName());

					List<String> phones = new LinkedList<>();

					if (userProfile != null) {
						String phone = userProfile.getPhone();

						if (phone != null) {
							phones.add(phone);
						}
					}

					Map<String, Object> data = new HashMap<>(3);
					data.put("webHookMessage", webHookMessage);
					data.put("issueUrl", issueUrl);
					data.put("projectUrl", projectUrl);

					String content = freeMarkerService.comment("dingding/done.ftl", data);

					dingDingService.sendActionCard(summary, content, phones, ButtonName, issueUrl);
				}
			}
		}
	}

	private String buildIssueUrl(WebHookMessage webHookMessage) {
		String issueUrl;
		String self = webHookMessage.getIssue().getSelf();
		String key = webHookMessage.getIssue().getKey();

		issueUrl = self.substring(0, self.indexOf("rest")) + "browse/" + key;
		return issueUrl;
	}

	private String buildProjectUrl(WebHookMessage webHookMessage) {
		String projectUrl;
		String self = webHookMessage.getIssue().getFields().getProject().getSelf();
		String key = webHookMessage.getIssue().getFields().getProject().getKey();

		projectUrl = self.substring(0, self.indexOf("rest")) + "projects/" + key + "/summary";
		return projectUrl;
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
