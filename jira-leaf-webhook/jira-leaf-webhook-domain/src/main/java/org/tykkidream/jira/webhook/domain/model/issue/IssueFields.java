package org.tykkidream.jira.webhook.domain.model.issue;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.tykkidream.jira.webhook.domain.model.Priority;
import org.tykkidream.jira.webhook.domain.model.project.Project;
import org.tykkidream.jira.webhook.domain.model.user.User;
import org.tykkidream.jira.webhook.domain.model.watches.Watches;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class IssueFields {
	@JsonProperty("issuetype")
	@JsonAlias("issueType")
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

	/**
	 * 项目
	 */
	private Project project;

	private List<String> fixVersions;

	private String aggregatetimespent;

	private IssueResolution resolution;

	private Map timetracking;

	private List<String> customfield_10105;

	private String customfield_10106;

	private List<String> attachment;

	private String aggregatetimeestimate;

	@JsonProperty("resolutiondate")
	@JsonAlias("resolutionDate")
	private Date resolutionDate;

	private Integer workratio;

	/**
	 * 概要（标题）
	 */
	private String summary;

	private Date lastViewed;

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

	private Map aggregateprogress;

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

	/**
	 * 截止时间
	 */
	@JsonProperty("duedate")
	@JsonAlias("dueDate")
	private String dueDate;

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

	public IssueType getIssueType() {
		return issueType;
	}

	public void setIssueType(IssueType issueType) {
		if (issueType != null) {
			this.issueType = issueType;
		}
	}

	public List<String> getComponents() {
		return components;
	}

	public void setComponents(List<String> components) {
		if (components != null) {
			this.components = components;
		}
	}

	public String getTimespent() {
		return timespent;
	}

	public void setTimespent(String timespent) {
		if (timespent != null) {
			this.timespent = timespent;
		}
	}

	public String getTimeoriginalestimate() {
		return timeoriginalestimate;
	}

	public void setTimeoriginalestimate(String timeoriginalestimate) {
		if (timeoriginalestimate != null) {
			this.timeoriginalestimate = timeoriginalestimate;
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description != null) {
			this.description = description;
		}
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		if (project != null) {
			this.project = project;
		}
	}

	public List<String> getFixVersions() {
		return fixVersions;
	}

	public void setFixVersions(List<String> fixVersions) {
		if (fixVersions != null) {
			this.fixVersions = fixVersions;
		}
	}

	public String getAggregatetimespent() {
		return aggregatetimespent;
	}

	public void setAggregatetimespent(String aggregatetimespent) {
		if (aggregatetimespent != null) {
			this.aggregatetimespent = aggregatetimespent;
		}
	}

	public IssueResolution getResolution() {
		return resolution;
	}

	public void setResolution(IssueResolution resolution) {
		if (resolution != null) {
			this.resolution = resolution;
		}
	}

	public Map getTimetracking() {
		return timetracking;
	}

	public void setTimetracking(Map timetracking) {
		if (timetracking != null) {
			this.timetracking = timetracking;
		}
	}

	public List<String> getCustomfield_10105() {
		return customfield_10105;
	}

	public void setCustomfield_10105(List<String> customfield_10105) {
		if (customfield_10105 != null) {
			this.customfield_10105 = customfield_10105;
		}
	}

	public String getCustomfield_10106() {
		return customfield_10106;
	}

	public void setCustomfield_10106(String customfield_10106) {
		if (customfield_10106 != null) {
			this.customfield_10106 = customfield_10106;
		}
	}

	public List<String> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<String> attachment) {
		if (attachment != null) {
			this.attachment = attachment;
		}
	}

	public String getAggregatetimeestimate() {
		return aggregatetimeestimate;
	}

	public void setAggregatetimeestimate(String aggregatetimeestimate) {
		if (aggregatetimeestimate != null) {
			this.aggregatetimeestimate = aggregatetimeestimate;
		}
	}

	public Date getResolutionDate() {
		return resolutionDate;
	}

	public void setResolutionDate(Date resolutionDate) {
		if (resolutionDate != null) {
			this.resolutionDate = resolutionDate;
		}
	}

	public Integer getWorkratio() {
		return workratio;
	}

	public void setWorkratio(Integer workratio) {
		if (workratio != null) {
			this.workratio = workratio;
		}
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		if (summary != null) {
			this.summary = summary;
		}
	}

	public Date getLastViewed() {
		return lastViewed;
	}

	public void setLastViewed(Date lastViewed) {
		if (lastViewed != null) {
			this.lastViewed = lastViewed;
		}
	}

	public Watches getWatches() {
		return watches;
	}

	public void setWatches(Watches watches) {
		if (watches != null) {
			this.watches = watches;
		}
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		if (creator != null) {
			this.creator = creator;
		}
	}

	public List<String> getSubtasks() {
		return subtasks;
	}

	public void setSubtasks(List<String> subtasks) {
		if (subtasks != null) {
			this.subtasks = subtasks;
		}
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		if (created != null) {
			this.created = created;
		}
	}

	public User getReporter() {
		return reporter;
	}

	public void setReporter(User reporter) {
		if (reporter != null) {
			this.reporter = reporter;
		}
	}

	public String getCustomfield_10000() {
		return customfield_10000;
	}

	public void setCustomfield_10000(String customfield_10000) {
		if (customfield_10000 != null) {
			this.customfield_10000 = customfield_10000;
		}
	}

	public Map getAggregateprogress() {
		return aggregateprogress;
	}

	public void setAggregateprogress(Map aggregateprogress) {
		if (aggregateprogress != null) {
			this.aggregateprogress = aggregateprogress;
		}
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		if (priority != null) {
			this.priority = priority;
		}
	}

	public String getCustomfield_10100() {
		return customfield_10100;
	}

	public void setCustomfield_10100(String customfield_10100) {
		if (customfield_10100 != null) {
			this.customfield_10100 = customfield_10100;
		}
	}

	public String getCustomfield_10101() {
		return customfield_10101;
	}

	public void setCustomfield_10101(String customfield_10101) {
		if (customfield_10101 != null) {
			this.customfield_10101 = customfield_10101;
		}
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		if (labels != null) {
			this.labels = labels;
		}
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		if (environment != null) {
			this.environment = environment;
		}
	}

	public String getTimeestimate() {
		return timeestimate;
	}

	public void setTimeestimate(String timeestimate) {
		if (timeestimate != null) {
			this.timeestimate = timeestimate;
		}
	}

	public String getAggregatetimeoriginalestimate() {
		return aggregatetimeoriginalestimate;
	}

	public void setAggregatetimeoriginalestimate(String aggregatetimeoriginalestimate) {
		if (aggregatetimeoriginalestimate != null) {
			this.aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;
		}
	}

	public List<String> getVersions() {
		return versions;
	}

	public void setVersions(List<String> versions) {
		if (versions != null) {
			this.versions = versions;
		}
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		if (dueDate != null) {
			this.dueDate = dueDate;
		}
	}

	public IssueProgress getProgress() {
		return progress;
	}

	public void setProgress(IssueProgress progress) {
		if (progress != null) {
			this.progress = progress;
		}
	}

	public IssueComment getComment() {
		return comment;
	}

	public void setComment(IssueComment comment) {
		if (comment != null) {
			this.comment = comment;
		}
	}

	public List<String> getIssueLinks() {
		return issueLinks;
	}

	public void setIssueLinks(List<String> issueLinks) {
		if (issueLinks != null) {
			this.issueLinks = issueLinks;
		}
	}

	public IssueVotes getVotes() {
		return votes;
	}

	public void setVotes(IssueVotes votes) {
		if (votes != null) {
			this.votes = votes;
		}
	}

	public IssueWorkLog getWorkLog() {
		return workLog;
	}

	public void setWorkLog(IssueWorkLog workLog) {
		if (workLog != null) {
			this.workLog = workLog;
		}
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		if (assignee != null) {
			this.assignee = assignee;
		}
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		if (updated != null) {
			this.updated = updated;
		}
	}

	public IssueStatus getStatus() {
		return status;
	}

	public void setStatus(IssueStatus status) {
		if (status != null) {
			this.status = status;
		}
	}
}
