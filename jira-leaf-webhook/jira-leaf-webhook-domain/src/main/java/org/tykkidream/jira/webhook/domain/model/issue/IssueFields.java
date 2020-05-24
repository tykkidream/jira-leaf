package org.tykkidream.jira.webhook.domain.model.issue;

import org.tykkidream.jira.webhook.domain.model.Priority;
import org.tykkidream.jira.webhook.domain.model.project.Project;
import org.tykkidream.jira.webhook.domain.model.user.User;
import org.tykkidream.jira.webhook.domain.model.watches.Watches;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class IssueFields {
	private IssueType issueType;

	// todo
	private List<String> components;

	// todo
	private String timespent;

	// todo
	private String timeoriginalestimate;

	/**
	 * 描述
	 */
	private String description;

	private Project project;

	private List<String> fixVersions;

	private String aggregatetimespent;

	private String resolution;

	private List<String> timetracking;

	private String customfield_10105;

	private String customfield_10106;

	private List<String> attachment;

	private String aggregatetimeestimate;

	private String resolutiondate;

	private Integer workratio;

	/**
	 * 概要（标题）
	 */
	private String summary;

	private Data lastViewed;

	private Watches watches;

	/**
	 * 创建人
	 */
	private User creator;

	private List<String> subtasks;

	/**
	 * 创建时间
	 */
	private Date created;

	/**
	 * 报告人
	 */
	private User reporter;

	private String customfield_10000;

	private String aggregateprogress;

	/**
	 * 优先级
	 */
	private Priority priority;

	private String customfield_10100;

	private String customfield_10101;

	/**
	 * 标签
	 */
	private List<String> labels;

	private String environment;

	private String timeestimate;

	private String aggregatetimeoriginalestimate;

	private List<String> versions;

	private String duedate;

	private IssueProgress progress;

	/**
	 * 备注
	 */
	private IssueComment comment;

	private List<String> issueLinks;

	/**
	 * 票数
	 */
	private IssueVotes votes;

	private IssueWorkLog workLog;

	/**
	 * 经办人
	 *
	 * 负责完成任务的人
	 */
	private User assignee;

	/**
	 * 修改时间
	 */
	private Date updated;

	/**
	 * 状态
	 */
	private IssueStatus status;

}
