package org.tykkidream.jira.webhook.dingding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tykkidream.jira.core.domain.model.config.UserProfile;
import org.tykkidream.jira.core.domain.model.jira.WebHookMessage;
import org.tykkidream.jira.core.domain.model.jira.changelog.ChangeLogItem;
import org.tykkidream.jira.core.domain.model.jira.user.User;
import org.tykkidream.jira.core.domain.model.jira.watches.Watches;
import org.tykkidream.jira.core.domain.repository.ConfigUserProfileRepository;
import org.tykkidream.jira.core.domain.repository.jira.WatcherRepository;
import org.tykkidream.jira.webhook.provider.ProviderWebHookService;
import org.tykkidream.jira.webhook.template.FreeMarkerService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DingDingWebHookService implements ProviderWebHookService {
	private static final Logger logger = LoggerFactory.getLogger(DingDingWebHookService.class);

	@Resource
	private FreeMarkerService freeMarkerService;

	@Resource
	private DingDingService dingDingService;

	@Resource
	private ConfigUserProfileRepository configUserProfileRepository;

	@Resource
	private WatcherRepository watcherRepository;

	private static final String ButtonName = "查看详情";

	@Override
	public void comment(WebHookMessage webHookMessage) {
		sendActionCard(webHookMessage, "dingding/comment.ftl", true);
	}

	@Override
	public void changeLog(WebHookMessage webHookMessage) {
		generic(webHookMessage);
	}

	private void changeLog(WebHookMessage webHookMessage, ChangeLogItem changeLogItem) {
		if (changeLogItem.isAssigneeChangeLog()) {
			sendActionCard(webHookMessage, "dingding/assignee.ftl", false);
		}

		if (changeLogItem.isStatusChangeLog()) {
			if (changeLogItem.isStatusChangeToDone()) {
				sendActionCard(webHookMessage, "dingding/done.ftl", true);
			}
			if (changeLogItem.isStatusChangeToResolved()) {
				sendActionCard(webHookMessage, "dingding/resolved.ftl", true);
			}
			if (changeLogItem.isStatusChangeToClosed()) {
				sendActionCard(webHookMessage, "dingding/closed.ftl", true);
			}
			if (changeLogItem.isStatusChangeToReopened()) {
				sendActionCard(webHookMessage, "dingding/reopened.ftl", true);
			}
		}
	}

	@Override
	public void resolved(WebHookMessage webHookMessage) {
		sendActionCard(webHookMessage, "dingding/resolved.ftl", true);
	}

	@Override
	public void closed(WebHookMessage webHookMessage) {
		sendActionCard(webHookMessage, "dingding/closed.ftl", true);
	}

	@Override
	public void reopened(WebHookMessage webHookMessage) {
		sendActionCard(webHookMessage, "dingding/reopened.ftl", false);
	}

	@Override
	public void generic(WebHookMessage webHookMessage) {
		List<ChangeLogItem> changeLogItems = webHookMessage.getChangeLog().getItems();

		for (ChangeLogItem changeLogItem : changeLogItems) {
			changeLog(webHookMessage, changeLogItem);
		}
	}

	/**
	 * 通用的发送 ActionCard 类型消息
	 *
	 * @param webHookMessage
	 * @param templateName
	 * @param notifyAllUser
	 */
	private void sendActionCard(WebHookMessage webHookMessage, String templateName, boolean notifyAllUser) {
		String summary = webHookMessage.getIssue().getFields().getSummary();



		Map<String, Object> data = new HashMap<>();

		String issueUrl = buildIssueUrlAndOther(data, webHookMessage);

		String content = freeMarkerService.comment(templateName, data);



		List<String> phones;

		if (notifyAllUser) {
			phones = buildAllPhones(webHookMessage);
		} else {
			phones = buildAssigneePhones(webHookMessage);
		}

		dingDingService.sendActionCard(summary, content, phones, ButtonName, issueUrl);

		if (logger.isDebugEnabled()) {
			logger.debug("推送钉钉的内容：{}", content);
		}
	}

	private String buildIssueUrlAndOther(Map<String, Object> data, WebHookMessage webHookMessage) {
		String issueUrl = buildIssueUrl(webHookMessage);

		String projectUrl = buildProjectUrl(webHookMessage);

		data.put("webHookMessage", webHookMessage);
		data.put("issueUrl", issueUrl);
		data.put("projectUrl", projectUrl);

		return issueUrl;
	}

	/**
	 * 构建问题访问地址
	 *
	 * @param webHookMessage
	 * @return
	 */
	private String buildIssueUrl(WebHookMessage webHookMessage) {
		String issueUrl;
		String self = webHookMessage.getIssue().getSelf();
		String key = webHookMessage.getIssue().getKey();

		issueUrl = self.substring(0, self.indexOf("rest")) + "browse/" + key;
		return issueUrl;
	}

	/**
	 * 构建项目访问地址
	 *
	 * @param webHookMessage
	 * @return
	 */
	private String buildProjectUrl(WebHookMessage webHookMessage) {
		String projectUrl;
		String self = webHookMessage.getIssue().getFields().getProject().getSelf();
		String key = webHookMessage.getIssue().getFields().getProject().getKey();

		projectUrl = self.substring(0, self.indexOf("rest")) + "projects/" + key + "/summary";
		return projectUrl;
	}

	/**
	 * 构建补 At 人，关注人的手机号
	 *
	 * @param webHookMessage
	 * @return
	 */
	private List<String> buildAllPhones(WebHookMessage webHookMessage) {
		Watches watches = watcherRepository.findWatches(webHookMessage.getIssue().getFields().getWatches());

		List<String> phones = new LinkedList<>();

		if (watches != null && watches.getIsWatching()) {

			List<User> watchers = watches.getWatchers();

			for (User watcher : watchers) {
				UserProfile userProfile = configUserProfileRepository.findUserProfileByUsername(watcher.getName());

				if (userProfile != null) {
					String phone = userProfile.getPhone();

					if (phone != null) {
						phones.add(phone);
					}
				}
			}
		}
		return phones;
	}

	/**
	 * 构建补 At 人，分配人的手机号
	 * @param webHookMessage
	 * @return
	 */
	private List<String> buildAssigneePhones(WebHookMessage webHookMessage) {
		User assignee = webHookMessage.getIssue().getFields().getAssignee();

		UserProfile userProfile = configUserProfileRepository.findUserProfileByUsername(assignee.getName());

		List<String> phones = new LinkedList<>();

		if (userProfile != null) {
			String phone = userProfile.getPhone();

			if (phone != null) {
				phones.add(phone);
			}
		}
		return phones;
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
