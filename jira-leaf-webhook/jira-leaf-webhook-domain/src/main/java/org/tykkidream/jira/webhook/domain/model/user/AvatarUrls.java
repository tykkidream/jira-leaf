package org.tykkidream.jira.webhook.domain.model.user;

import org.tykkidream.jira.webhook.domain.model.NullValue;

/**
 * 头像地址
 */
public class AvatarUrls {
	private String _48x48;
	private String _32x32;
	private String _24x24;
	private String _16x16;

	public AvatarUrls() {
		set_16x16(NullValue.EMPTY_STRING);
		set_24x24(NullValue.EMPTY_STRING);
		set_16x16(NullValue.EMPTY_STRING);
		set_32x32(NullValue.EMPTY_STRING);
	}

	public String get_48x48() {
		return _48x48;
	}

	public void set_48x48(String _48x48) {
		if (_48x48 != null) {
			this._48x48 = _48x48;
		}
	}

	public String get_32x32() {
		return _32x32;
	}

	public void set_32x32(String _32x32) {
		if (_32x32 != null) {
			this._32x32 = _32x32;
		}
	}

	public String get_24x24() {
		return _24x24;
	}

	public void set_24x24(String _24x24) {
		if (_24x24 != null) {
			this._24x24 = _24x24;
		}
	}

	public String get_16x16() {
		return _16x16;
	}

	public void set_16x16(String _16x16) {
		if (_16x16 != null) {
			this._16x16 = _16x16;
		}
	}
}
