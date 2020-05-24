package org.tykkidream.jira.webhook.port.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JiraController {

	private static final Logger logger = LoggerFactory.getLogger(JiraController.class);

	@PostMapping("/jira")
	public String jira(@RequestBody String requestBody) {

		if (logger.isInfoEnabled()) {
			logger.info(requestBody);
		}

		return "success";
	}
}
