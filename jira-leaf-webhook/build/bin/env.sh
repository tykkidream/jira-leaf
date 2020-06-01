#
# 服务名
#
SERVICE_NAME=jira-leaf-webhook-service

JAVA_OPTS="-Xmx200M -XX:MaxMetaspaceSize=100M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/app/error/${SERVICE_NAME}/ -XX:ErrorFile=/app/error/${SERVICE_NAME}/hs_error%p.log"

#
# 启动主类
#
SERVICE_MAIN_CLASS=org.tykkidream.jira.webhook.JiraLeafWebHookApplication
