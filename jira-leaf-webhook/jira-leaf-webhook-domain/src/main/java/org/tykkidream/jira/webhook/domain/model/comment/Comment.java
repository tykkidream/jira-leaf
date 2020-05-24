package org.tykkidream.jira.webhook.domain.model.comment;

import org.tykkidream.jira.webhook.domain.model.user.User;

import java.util.Date;

/**
 * 备注
 */
public class Comment {
	private String self;

	private String id;

	private User author;

	private String body;

	private User updateAuthor;

	private Date created;

	private Date updated;

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		if (self != null) {
			this.self = self;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id != null) {
			this.id = id;
		}
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		if (author != null) {
			this.author = author;
		}
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		if (body != null) {
			this.body = body;
		}
	}

	public User getUpdateAuthor() {
		return updateAuthor;
	}

	public void setUpdateAuthor(User updateAuthor) {
		if (updateAuthor != null) {
			this.updateAuthor = updateAuthor;
		}
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		if (created != null) {
			this.created = created;
		}
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		if (updated != null) {
			this.updated = updated;
		}
	}
}
