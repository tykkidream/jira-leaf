<font color=#FF1493 size=5 face="微软雅黑">任务已解决</font>

<font color=#000000 size=5 face="微软雅黑">${webHookMessage.issue.key} **[${webHookMessage.issue.fields.summary}](${issueUrl!})**</font>

<font color=#000000 size=3 face="微软雅黑">时间： ${webHookMessage.issue.fields.resolutionDate?string('yyyy-MM-dd HH:mm:ss')}</font>

<font color=#000000 size=3 face="微软雅黑">结果： </font><font color=#FF1493 size=3 face="微软雅黑">${webHookMessage.issue.fields.resolution.name}</font>

<#if (webHookMessage.comment.body)?? >
<font color=#000000 size=3 face="微软雅黑">说明： </font><font color=#FF1493 size=3 face="微软雅黑">${webHookMessage.comment.body}</font>
</#if>

<font color=#000000 size=3 face="微软雅黑">类型： ${webHookMessage.issue.fields.issueType.name}</font>

<#if (webHookMessage.issue.fields.labels?size> 0) >
<font color=#000000 size=3 face="微软雅黑">标签： <#list webHookMessage.issue.fields.labels as label>`${label}` </#list></font>
</#if>

<font color=#000000 size=3 face="微软雅黑">状态： ${webHookMessage.issue.fields.status.name}</font>

<font color=#000000 size=3 face="微软雅黑">级别： </font><font color=#FF0000 size=3 face="微软雅黑">${webHookMessage.issue.fields.priority.name}</font>

<font color=#000000 size=3 face="微软雅黑">项目： ${webHookMessage.issue.fields.project.key} **[${webHookMessage.issue.fields.project.name}](${projectUrl!})**</font>
