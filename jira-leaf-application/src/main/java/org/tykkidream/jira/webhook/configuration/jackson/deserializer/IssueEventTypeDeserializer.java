package org.tykkidream.jira.webhook.configuration.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.tykkidream.jira.core.domain.model.jira.issue.IssueEventType;

import java.io.IOException;

public class IssueEventTypeDeserializer extends JsonDeserializer<IssueEventType> {
	@Override
	public IssueEventType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		String text = jsonParser.getText();
		return IssueEventType.valueOfJSON(text);
	}
}
