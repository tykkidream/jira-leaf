package org.tykkidream.jira.webhook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JiraLeafWebHookApplication extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(JiraLeafWebHookApplication.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(JiraLeafWebHookApplication.class, args);

            if (logger.isErrorEnabled()) {
                logger.info("启动成功！");
            }
        } catch (Throwable throwable) {
            if (logger.isErrorEnabled()) {
                logger.error("启动异常！ {}" , throwable.getMessage(), throwable);
            }

            throwable.printStackTrace();
        }
    }

}