package org.tykkidream.jira.webhook.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJSONString(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (Throwable throwable) {
            if (logger.isErrorEnabled()) {
                logger.error("序列化 JSON 异常：{}", throwable.getMessage(), throwable);
            }
        }
        return null;
    }

    public static <T> T readValue(String jsonString, Class<T> dataClass) {
        try {
            return mapper.readValue(jsonString, dataClass);
        } catch (Throwable throwable) {
            if (logger.isErrorEnabled()) {
                logger.error("反序列化 JSON 异常：{}", throwable.getMessage(), throwable);
            }
        }
        return null;
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }
}
