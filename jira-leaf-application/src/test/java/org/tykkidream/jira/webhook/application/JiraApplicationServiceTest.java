package org.tykkidream.jira.webhook.application;

import org.junit.Before;
import org.junit.Test;
import org.tykkidream.jira.webhook.configuration.jackson.JacksonConfiguration;
import org.tykkidream.jira.webhook.dingding.DingDingWebHookService;
import org.tykkidream.jira.webhook.dingding.DingDingService;
import org.tykkidream.jira.webhook.template.FreeMarkerApplicationContext;
import org.tykkidream.jira.webhook.template.FreeMarkerService;

public class JiraApplicationServiceTest {

	public FreeMarkerApplicationContext freeMarkerApplicationContext;

	public FreeMarkerService freeMarkerService;

	public DingDingService dingDingService;

	public DingDingWebHookService dingDingWebHookService;

	public JiraApplicationService jiraApplicationService;

	@Before
	public void before() {
		freeMarkerApplicationContext = new FreeMarkerApplicationContext();
		freeMarkerApplicationContext.loadClasspath("/template");

		freeMarkerService = new FreeMarkerService();
		freeMarkerService.setFreeMarkerApplicationContext(freeMarkerApplicationContext);

		dingDingService = new DingDingService();

		dingDingWebHookService = new DingDingWebHookService();
		dingDingWebHookService.setDingDingService(dingDingService);
		dingDingWebHookService.setFreeMarkerService(freeMarkerService);

		jiraApplicationService = new JiraApplicationService();
		jiraApplicationService.setProviderWebHookService(dingDingWebHookService);

		JacksonConfiguration.registerModule();
	}

	@Test
	public void forwardMessage1() {
		String json = "{\n"
				+ "    \"timestamp\":1590323447801,\n"
				+ "    \"webhookEvent\":\"jira:issue_updated\",\n"
				+ "    \"issue_event_type_name\":\"issue_commented\",\n"
				+ "    \"user\":{\n"
				+ "        \"self\":\"http://192.168.100.98:8096/rest/api/2/user?username=user001\",\n"
				+ "        \"name\":\"user001\",\n"
				+ "        \"key\":\"JIRAUSER10101\",\n"
				+ "        \"emailAddress\":\"user001@veda.com\",\n"
				+ "        \"avatarUrls\":{\n"
				+ "            \"48x48\":\"http://192.168.100.98:8096/secure/useravatar?avatarId=10338\",\n"
				+ "            \"24x24\":\"http://192.168.100.98:8096/secure/useravatar?size=small&avatarId=10338\",\n"
				+ "            \"16x16\":\"http://192.168.100.98:8096/secure/useravatar?size=xsmall&avatarId=10338\",\n"
				+ "            \"32x32\":\"http://192.168.100.98:8096/secure/useravatar?size=medium&avatarId=10338\"\n"
				+ "        },\n"
				+ "        \"displayName\":\"user001 user001\",\n"
				+ "        \"active\":true,\n"
				+ "        \"timeZone\":\"GMT\"\n"
				+ "    },\n"
				+ "    \"issue\":{\n"
				+ "        \"id\":\"10000\",\n"
				+ "        \"self\":\"http://192.168.100.98:8096/rest/api/2/issue/10000\",\n"
				+ "        \"key\":\"YUNXIDEV-1\",\n"
				+ "        \"fields\":{\n"
				+ "            \"issuetype\":{\n"
				+ "                \"self\":\"http://192.168.100.98:8096/rest/api/2/issuetype/10001\",\n"
				+ "                \"id\":\"10001\",\n"
				+ "                \"description\":\"\",\n"
				+ "                \"iconUrl\":\"http://192.168.100.98:8096/images/icons/issuetypes/story.svg\",\n"
				+ "                \"name\":\"故事\",\n"
				+ "                \"subtask\":false\n"
				+ "            },\n"
				+ "            \"components\":[\n"
				+ "\n"
				+ "            ],\n"
				+ "            \"timespent\":null,\n"
				+ "            \"timeoriginalestimate\":null,\n"
				+ "            \"description\":\"第一个任务说明内容说明内容说明内容说明内容！\",\n"
				+ "            \"project\":{\n"
				+ "                \"self\":\"http://192.168.100.98:8096/rest/api/2/project/10000\",\n"
				+ "                \"id\":\"10000\",\n"
				+ "                \"key\":\"YUNXIDEV\",\n"
				+ "                \"name\":\"YunXi-Develop\",\n"
				+ "                \"projectTypeKey\":\"software\",\n"
				+ "                \"avatarUrls\":{\n"
				+ "                    \"48x48\":\"http://192.168.100.98:8096/secure/projectavatar?pid=10000&avatarId=10201\",\n"
				+ "                    \"24x24\":\"http://192.168.100.98:8096/secure/projectavatar?size=small&pid=10000&avatarId=10201\",\n"
				+ "                    \"16x16\":\"http://192.168.100.98:8096/secure/projectavatar?size=xsmall&pid=10000&avatarId=10201\",\n"
				+ "                    \"32x32\":\"http://192.168.100.98:8096/secure/projectavatar?size=medium&pid=10000&avatarId=10201\"\n"
				+ "                },\n"
				+ "                \"projectCategory\":{\n"
				+ "                    \"self\":\"http://192.168.100.98:8096/rest/api/2/projectCategory/10000\",\n"
				+ "                    \"id\":\"10000\",\n"
				+ "                    \"description\":\"系统开发，代码开始，项目迭代。\",\n"
				+ "                    \"name\":\"系统开发\"\n"
				+ "                }\n"
				+ "            },\n"
				+ "            \"summary\":\"第一个任务\",\n"
				+ "            \"lastViewed\":\"2020-05-24T11:57:20.579+0000\",\n"
				+ "            \"creator\":{\n"
				+ "                \"self\":\"http://192.168.100.98:8096/rest/api/2/user?username=admin\",\n"
				+ "                \"name\":\"admin\",\n"
				+ "                \"key\":\"JIRAUSER10000\",\n"
				+ "                \"emailAddress\":\"admin@veda.com\",\n"
				+ "                \"avatarUrls\":{\n"
				+ "                    \"48x48\":\"http://192.168.100.98:8096/secure/useravatar?avatarId=10341\",\n"
				+ "                    \"24x24\":\"http://192.168.100.98:8096/secure/useravatar?size=small&avatarId=10341\",\n"
				+ "                    \"16x16\":\"http://192.168.100.98:8096/secure/useravatar?size=xsmall&avatarId=10341\",\n"
				+ "                    \"32x32\":\"http://192.168.100.98:8096/secure/useravatar?size=medium&avatarId=10341\"\n"
				+ "                },\n"
				+ "                \"displayName\":\"admin\",\n"
				+ "                \"active\":true,\n"
				+ "                \"timeZone\":\"GMT\"\n"
				+ "            },\n"
				+ "            \"subtasks\":[\n"
				+ "\n"
				+ "            ],\n"
				+ "            \"created\":\"2020-05-24T07:06:30.000+0000\",\n"
				+ "            \"reporter\":{\n"
				+ "                \"self\":\"http://192.168.100.98:8096/rest/api/2/user?username=user001\",\n"
				+ "                \"name\":\"user001\",\n"
				+ "                \"key\":\"JIRAUSER10101\",\n"
				+ "                \"emailAddress\":\"user001@veda.com\",\n"
				+ "                \"avatarUrls\":{\n"
				+ "                    \"48x48\":\"http://192.168.100.98:8096/secure/useravatar?avatarId=10338\",\n"
				+ "                    \"24x24\":\"http://192.168.100.98:8096/secure/useravatar?size=small&avatarId=10338\",\n"
				+ "                    \"16x16\":\"http://192.168.100.98:8096/secure/useravatar?size=xsmall&avatarId=10338\",\n"
				+ "                    \"32x32\":\"http://192.168.100.98:8096/secure/useravatar?size=medium&avatarId=10338\"\n"
				+ "                },\n"
				+ "                \"displayName\":\"user001 user001\",\n"
				+ "                \"active\":true,\n"
				+ "                \"timeZone\":\"GMT\"\n"
				+ "            },\n"
				+ "            \"priority\":{\n"
				+ "                \"self\":\"http://192.168.100.98:8096/rest/api/2/priority/3\",\n"
				+ "                \"iconUrl\":\"http://192.168.100.98:8096/images/icons/priorities/medium.svg\",\n"
				+ "                \"name\":\"Medium\",\n"
				+ "                \"id\":\"3\"\n"
				+ "            },\n"
				+ "            \"votes\":{\n"
				+ "                \"self\":\"http://192.168.100.98:8096/rest/api/2/issue/YUNXIDEV-1/votes\",\n"
				+ "                \"votes\":0,\n"
				+ "                \"hasVoted\":false\n"
				+ "            },\n"
				+ "            \"assignee\":{\n"
				+ "                \"self\":\"http://192.168.100.98:8096/rest/api/2/user?username=user001\",\n"
				+ "                \"name\":\"user001\",\n"
				+ "                \"key\":\"JIRAUSER10101\",\n"
				+ "                \"emailAddress\":\"user001@veda.com\",\n"
				+ "                \"avatarUrls\":{\n"
				+ "                    \"48x48\":\"http://192.168.100.98:8096/secure/useravatar?avatarId=10338\",\n"
				+ "                    \"24x24\":\"http://192.168.100.98:8096/secure/useravatar?size=small&avatarId=10338\",\n"
				+ "                    \"16x16\":\"http://192.168.100.98:8096/secure/useravatar?size=xsmall&avatarId=10338\",\n"
				+ "                    \"32x32\":\"http://192.168.100.98:8096/secure/useravatar?size=medium&avatarId=10338\"\n"
				+ "                },\n"
				+ "                \"displayName\":\"user001 user001\",\n"
				+ "                \"active\":true,\n"
				+ "                \"timeZone\":\"GMT\"\n"
				+ "            },\n"
				+ "            \"updated\":\"2020-05-24T11:57:20.000+0000\",\n"
				+ "            \"status\":{\n"
				+ "                \"self\":\"http://192.168.100.98:8096/rest/api/2/status/10000\",\n"
				+ "                \"description\":\"\",\n"
				+ "                \"iconUrl\":\"http://192.168.100.98:8096/\",\n"
				+ "                \"name\":\"待办\",\n"
				+ "                \"id\":\"10000\",\n"
				+ "                \"statusCategory\":{\n"
				+ "                    \"self\":\"http://192.168.100.98:8096/rest/api/2/statuscategory/2\",\n"
				+ "                    \"id\":2,\n"
				+ "                    \"key\":\"new\",\n"
				+ "                    \"colorName\":\"blue-gray\",\n"
				+ "                    \"name\":\"待办\"\n"
				+ "                }\n"
				+ "            }\n"
				+ "        }\n"
				+ "    },\n"
				+ "    \"comment\":{\n"
				+ "        \"self\":\"http://192.168.100.98:8096/rest/api/2/issue/10000/comment/10005\",\n"
				+ "        \"id\":\"10005\",\n"
				+ "        \"author\":{\n"
				+ "            \"self\":\"http://192.168.100.98:8096/rest/api/2/user?username=user001\",\n"
				+ "            \"name\":\"user001\",\n"
				+ "            \"key\":\"JIRAUSER10101\",\n"
				+ "            \"emailAddress\":\"user001@veda.com\",\n"
				+ "            \"avatarUrls\":{\n"
				+ "                \"48x48\":\"http://192.168.100.98:8096/secure/useravatar?avatarId=10338\",\n"
				+ "                \"24x24\":\"http://192.168.100.98:8096/secure/useravatar?size=small&avatarId=10338\",\n"
				+ "                \"16x16\":\"http://192.168.100.98:8096/secure/useravatar?size=xsmall&avatarId=10338\",\n"
				+ "                \"32x32\":\"http://192.168.100.98:8096/secure/useravatar?size=medium&avatarId=10338\"\n"
				+ "            },\n"
				+ "            \"displayName\":\"user001 user001\",\n"
				+ "            \"active\":true,\n"
				+ "            \"timeZone\":\"GMT\"\n"
				+ "        },\n"
				+ "        \"body\":\"增收\",\n"
				+ "        \"updateAuthor\":{\n"
				+ "            \"self\":\"http://192.168.100.98:8096/rest/api/2/user?username=user001\",\n"
				+ "            \"name\":\"user001\",\n"
				+ "            \"key\":\"JIRAUSER10101\",\n"
				+ "            \"emailAddress\":\"user001@veda.com\",\n"
				+ "            \"avatarUrls\":{\n"
				+ "                \"48x48\":\"http://192.168.100.98:8096/secure/useravatar?avatarId=10338\",\n"
				+ "                \"24x24\":\"http://192.168.100.98:8096/secure/useravatar?size=small&avatarId=10338\",\n"
				+ "                \"16x16\":\"http://192.168.100.98:8096/secure/useravatar?size=xsmall&avatarId=10338\",\n"
				+ "                \"32x32\":\"http://192.168.100.98:8096/secure/useravatar?size=medium&avatarId=10338\"\n"
				+ "            },\n"
				+ "            \"displayName\":\"user001 user001\",\n"
				+ "            \"active\":true,\n"
				+ "            \"timeZone\":\"GMT\"\n"
				+ "        },\n"
				+ "        \"created\":\"2020-05-24T12:30:47.670+0000\",\n"
				+ "        \"updated\":\"2020-05-24T12:30:47.670+0000\"\n"
				+ "    }\n"
				+ "}";


		jiraApplicationService.forwardMessage(json);
	}

}
