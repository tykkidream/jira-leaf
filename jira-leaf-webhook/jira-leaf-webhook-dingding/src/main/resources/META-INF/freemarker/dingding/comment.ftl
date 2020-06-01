<font color=#000000 size=5 face="微软雅黑">${(webHookMessage.comment.updateAuthor.displayName)!} 添加了备注</font>

---

<font color=#000000 size=5 face="微软雅黑">${webHookMessage.issue.key} ： **[${webHookMessage.issue.fields.summary}](${issueUrl!})**</font>

---

${webHookMessage.comment.body}

---
<font color=#000000 size=3 face="微软雅黑">时间： ${webHookMessage.comment.updated?string('yyyy-MM-dd HH:mm:ss')}</font>

<font color=#000000 size=3 face="微软雅黑">类型： ${webHookMessage.issue.fields.issueType.name}</font>

<#if (webHookMessage.issue.fields.labels?size> 0) >
<font color=#000000 size=3 face="微软雅黑">标签： <#list webHookMessage.issue.fields.labels as label>`${label}` </#list></font>
</#if>


<font color=#000000 size=3 face="微软雅黑">状态： ${webHookMessage.issue.fields.status.name}</font>

<font color=#000000 size=3 face="微软雅黑">级别： </font><font color=#FF0000 size=3 face="微软雅黑">${webHookMessage.issue.fields.priority.name}</font>

<font color=#000000 size=3 face="微软雅黑">项目： ${webHookMessage.issue.fields.project.key} **[${webHookMessage.issue.fields.project.name}](${projectUrl!})**</font>

