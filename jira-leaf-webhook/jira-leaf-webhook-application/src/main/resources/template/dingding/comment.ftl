<#if comment.updateAuthor.avatarUrls.s16x16?? >![](${comment.updateAuthor.avatarUrls.s16x16})  </#if>${comment.updateAuthor.displayName} 添加了评论
====================================================================================================

>
> ${comment.body}
>

时间： ${comment.updated?string('yyyy-MM-dd HH:mm:ss')}

任务： ${issue.key} ${issue.fields.summary}
----------------------------------------------------------------------------------------------------
<#if issue.fields.labels?? >
标签： <#list issue.fields.labels as label>`${label}` </#list>

</#if>状态： ${issue.fields.status.name}     优先级： ${issue.fields.priority.name}

项目： <#if issue.fields.project.avatarUrls.s16x16?? >![](${issue.fields.project.avatarUrls.s16x16}) </#if>${issue.fields.project.name}


