package org.tykkidream.jira.core.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJSONString(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> T readValue(String jsonString, Class<T> dataClass) {
        try {
            return mapper.readValue(jsonString, dataClass);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
