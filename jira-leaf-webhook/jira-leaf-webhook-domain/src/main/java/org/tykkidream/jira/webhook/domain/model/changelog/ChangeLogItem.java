package org.tykkidream.jira.webhook.domain.model.changelog;

public class ChangeLogItem {
	/**
	 * 改动的字段名
	 */
	private String field;

	private String fieldType;

	/**
	 * 改动前的值的key ， 比如用户key，可以唯一指向一个数据
	 */
	private String from;

	/**
	 * 改动前的值
	 */
	private String fromString;

	/**
	 * 改动后的值的key ， 比如用户key，可以唯一指向一个数据
	 */
	private String to;

	/**
	 * 改动后的值
	 */
	private String toString;

	public boolean isAssigneeChangeLog() {
		return field.equals("assignee");
	}


	/* •••••••••••••••••••••••••••••••••••••••装••订••线••内••禁••止••作••答••否••则••记••零••分••••••••••••••••••••••••••••••••••••••• */

	public String getField() {
		return field;
	}

	public void setField(String field) {
		if (field != null) {
			this.field = field;
		}
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		if (fieldType != null) {
			this.fieldType = fieldType;
		}
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		if (from != null) {
			this.from = from;
		}
	}

	public String getFromString() {
		return fromString;
	}

	public void setFromString(String fromString) {
		if (fromString != null) {
			this.fromString = fromString;
		}
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		if (to != null) {
			this.to = to;
		}
	}

	public String getToString() {
		return toString;
	}

	public void setToString(String toString) {
		if (toString != null) {
			this.toString = toString;
		}
	}
}
