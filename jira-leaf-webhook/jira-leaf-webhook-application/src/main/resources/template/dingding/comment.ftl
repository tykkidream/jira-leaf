---

# **${(webHookMessage.comment.updateAuthor.displayName)!} 添加了评论**

---

${webHookMessage.comment.body}

---

##### 时间： ${webHookMessage.comment.updated?string('yyyy-MM-dd HH:mm:ss')}

##### 任务： ${webHookMessage.issue.key} **[${webHookMessage.issue.fields.summary}](${issueUrl!})**

<#if webHookMessage.issue.fields.labels?? >
##### 标签： <#list webHookMessage.issue.fields.labels as label>`${label}` </#list></#if>

##### 状态： ${webHookMessage.issue.fields.status.name}

##### 级别： ${webHookMessage.issue.fields.priority.name}

##### 项目： ${webHookMessage.issue.fields.project.key} **[${webHookMessage.issue.fields.project.name}](${projectUrl!})**


