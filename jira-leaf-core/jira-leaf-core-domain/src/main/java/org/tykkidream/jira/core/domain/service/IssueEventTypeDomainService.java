package org.tykkidream.jira.core.domain.service;

import org.tykkidream.jira.core.domain.model.jira.WebHookMessage;
import org.tykkidream.jira.core.domain.model.jira.changelog.ChangeLog;
import org.tykkidream.jira.core.domain.model.jira.issue.IssueEventType;

public class IssueEventTypeDomainService {

    public IssueEventType analysis(WebHookMessage webHookMessage) {
        IssueEventType issueEventType = webHookMessage.getIssueEventType();

        if (issueEventType != null) {
            return issueEventType;
        }

        issueEventType = analysisForOldJIRA(webHookMessage);

        webHookMessage.setIssueEventType(issueEventType);

        return issueEventType;
    }

    private IssueEventType analysisForOldJIRA(WebHookMessage webHookMessage) {
        ChangeLog changeLog = webHookMessage.getChangeLog();

        if (changeLog != null) {
            return IssueEventType.IssueUpdated;
        }

        if (webHookMessage.getComment() != null) {
            return IssueEventType.IssueCommented;
        }

        return IssueEventType.IssueGeneric;
    }
}
