package org.tykkidream.jira.webhook.configuration.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.tykkidream.jira.webhook.domain.model.WebHookEvent;

import java.io.IOException;

public class WebHookEventDeserializer extends JsonDeserializer<WebHookEvent> {
	@Override
	public WebHookEvent deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		String text = jsonParser.getText();
		return WebHookEvent.valueOfJSON(text);
	}
}
