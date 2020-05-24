package org.tykkidream.jira.webhook.port.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tykkidream.jira.webhook.application.JiraApplicationService;

import javax.annotation.Resource;

@RestController
public class JiraController {

	private static final Logger logger = LoggerFactory.getLogger(JiraController.class);

	@Resource
	private JiraApplicationService jiraApplicationService;

	@PostMapping("/jira")
	public String jira(@RequestBody String requestBody) {

		if (logger.isInfoEnabled()) {
			logger.info("收到 JIRA 新消息： {}", requestBody);
		}

		jiraApplicationService.forwardMessage(requestBody);

		return "success";
	}
}
