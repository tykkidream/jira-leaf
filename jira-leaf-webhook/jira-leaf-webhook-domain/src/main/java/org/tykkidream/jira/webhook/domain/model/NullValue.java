package org.tykkidream.jira.webhook.domain.model;

import java.util.Date;

public interface NullValue {
    String EMPTY_STRING = "";

    Date NULL_DATE = new Date(0);

    Double NULL_DOUBLE = 0D;
}
